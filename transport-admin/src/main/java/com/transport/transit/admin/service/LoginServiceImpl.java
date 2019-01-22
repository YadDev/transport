package com.transport.transit.admin.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.beans.admin.BaseResponse;
import com.transport.transit.persistence.entity.UserCredential;
import com.transport.transit.persistence.repostiory.LoginRepository;
import com.transport.util.commons.CommonUtils;
import com.transport.util.commons.StringsUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	HttpSession session = null;

	private BaseResponse response = null;

	@Autowired
	private LoginRepository loginRepo;

	@Override
	public UserCredential findByUserName(String userName) {
		return loginRepo.findByUserName(userName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BaseResponse authenticateUser(UserCredential userCredential, HttpServletRequest request) throws Exception {
		logger.info("*********Service Authenticate User Method Start**************");
		response = new BaseResponse();
		String jwtToken = "";

		session = request.getSession();
		if (userCredential.getUserName() == null || userCredential.getPassword() == null) {
			throw new Exception("Please fill in username and password");
		}

		String userName = userCredential.getUserName();
		String password = userCredential.getPassword();

		UserCredential user = loginRepo.findByUserName(userName);
		String loginFrom = "SingleLogin";
		if (user == null) {
			throw new Exception("User Name not found.");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		String encPwd = CommonUtils.getHashed(pwd, userName);

		session.setAttribute("userName", userName);
		session.setAttribute("encPassword", pwd);
		session.setAttribute("encPasswordNew", encPwd);

		ServletContext sc = session.getServletContext();

		if (sc.getAttribute("hMap") != null) {
			HashMap<String, String> application = (HashMap<String, String>) sc.getAttribute("hMap");
			System.out.println("login user Name====" + userName);
			Set<String> keys = application.keySet();
			System.out.println("keys====" + keys.size());
			for (String key : keys) {
				System.out.println("user Name====" + key);

				if (key.equals(userName)) {
					if (session.getAttribute("SessionUserName") != null) {
						session.removeAttribute("SessionUserName");
					}
					session.setAttribute("SessionUserName", userName);
					loginFrom = "multiLogin";
					break;
				} else {
					loginFrom = "SingleLogin";
				}
			}
		}

		boolean setSession = true;// userService.getUserDetail(session, userName, pwd);

		if (loginFrom.equals("SingleLogin")) {
			Map<String, String> map;
			Map<String, HttpSession> sessionMap;

			if ((HashMap<String, String>) sc.getAttribute("hMap") != null) {
				map = (HashMap<String, String>) sc.getAttribute("hMap");
				sessionMap = (HashMap<String, HttpSession>) sc.getAttribute("OldSession");
			} else {
				map = new HashMap<String, String>();
				sessionMap = new HashMap<String, HttpSession>();
			}

			sessionMap.put(session.getId(), session);
			// add attributes to the SessionMap

			map.put(userName, request.getSession().getId());
			System.out.println("Session Id in Controller " + userName + " : " + map.get(userName));
			sc.setAttribute("hMap", map);
			sc.setAttribute("OldSession", sessionMap);
			if (setSession) {
//				SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(new Date());
//				cal.add(Calendar.MINUTE, 1);

				jwtToken = Jwts.builder().setIssuer("" + user.getUserId())
						/* .setExpiration(cal.getTime()) */.setSubject(request.getSession().getId())
						.claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretKey")
						.compact(); // HMAC SHA 256 Algorithm Used.
				response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
				response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
				response.setRespData(jwtToken);

			} else {
				response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
				response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
				response.setRespData("Token Generation Failed");

			}

		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData(
					"Already Logged in from other device. Please logout from other device and try again later.");

		}
		logger.info("*********Service Authenticate User Method End**************");
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BaseResponse loggoffUser(String userName) throws Exception {
		logger.info("*********Service loggoffUser Method Start**************");
		response = new BaseResponse();
		ServletContext sc = session.getServletContext();
		if (sc.getAttribute("hMap") != null) {
			HashMap<String, String> application = (HashMap<String, String>) sc.getAttribute("hMap");
			Map<String, HttpSession> sessionMap = (HashMap<String, HttpSession>) sc.getAttribute("OldSession");
			String sessionId = application.get(userName);
			application.remove(userName);
			UserCredential user = loginRepo.findByUserName(userName);
			if (sessionId != null) {
				HttpSession oldSession = sessionMap.get(sessionId);
				if (session.getAttribute("" + user.getUserId()) != null) {
					session.removeAttribute("" + user.getUserId());
				}
				if (oldSession != null) {
					oldSession.invalidate();
					sessionMap.remove(sessionId);
					response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
					response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
					response.setRespData("Logged off Succesfully!");

				} else {
					response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
					response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
					response.setRespData("Already Logged Out.");

				}

				response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
				response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
				response.setRespData("Logged Out Successfully.");
			} else {
				response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
				response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
				response.setRespData("Already Logged Out");

			}
		}
		logger.info("*********Service loggoffUser Method End**************");
		return response;
	}

}
