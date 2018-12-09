package com.transport.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transport.admin.service.LoginService;
import com.transport.beans.admin.RespResult;
import com.transport.beans.admin.UserCredential;
import com.transport.util.CommonUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	private RespResult response = null;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	HttpSession session = null;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody UserCredential userCredential, HttpServletRequest request)
			throws Exception {
		logger.info("********************Login Controller Login Method******************");
		response = new RespResult();
		String jwtToken = "";

		session = request.getSession();
		if (userCredential.getUserName() == null || userCredential.getPassword() == null) {
			throw new Exception("Please fill in username and password");
		}

		String userName = userCredential.getUserName();
		String password = userCredential.getPassword();

		UserCredential user = loginService.findByUserName(userName);
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
			@SuppressWarnings("unchecked")
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

		boolean setSession = true;//userService.getUserDetail(session, userName, pwd);

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
				SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.MINUTE, 1);
				
				jwtToken = Jwts.builder().setIssuer("" + user.getGetUserId())
						/* .setExpiration(cal.getTime()) */.setSubject(request.getSession().getId())
						.claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretKey")
						.compact(); // HMAC SHA 256 Algorithm Used.
				response.setRespCode("00");
				response.setRespData(jwtToken);
				
			} else {
				response.setRespCode("01");
				response.setRespData("Token Generation Failed");
			//	jwtToken = "";
				
			}

		} else {
			response.setRespCode("01");
			response.setRespData("Already Logged in from other device. Please logout from other device and try again later.");
			
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Object> loggoff(HttpServletRequest request) throws ServletException {
		response = new RespResult();
		String userName = null;
		System.out.println("loggoff " + request.getParameter("SessionUserName"));
		userName = request.getParameter("SessionUserName");
		ServletContext sc = session.getServletContext();
		if (sc.getAttribute("hMap") != null) {
			@SuppressWarnings("unchecked")
			HashMap<String, String> application = (HashMap<String, String>) sc.getAttribute("hMap");
			Map<String, HttpSession> sessionMap = (HashMap<String, HttpSession>) sc.getAttribute("OldSession");
			String sessionId = application.get(userName);
			application.remove(userName);
			UserCredential user = loginService.findByUserName(userName);
			if (sessionId != null) {
				HttpSession oldSession = sessionMap.get(sessionId);
				if (session.getAttribute("" + user.getGetUserId()) != null) {
					session.removeAttribute("" + user.getGetUserId());
				}
				if (oldSession != null) {
					oldSession.invalidate();
					sessionMap.remove(sessionId);
					response.setRespCode("01");
					response.setRespData("Logged off Succesfully!");

				} else {
					response.setRespCode("02");
					response.setRespData("Already Logged Out.");

				}

				response.setRespCode("01");
				response.setRespData("Logged Out Successfully.");
			} else {
				response.setRespCode("02");
				response.setRespData("Already Logged Out");

			}
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

}
