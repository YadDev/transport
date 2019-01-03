package com.transport.util.commons;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


public class CommonUtils {

	public static ResponseEntity<Object> getResponse(Object response, MediaType mediaType) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Content-Type-Options", "nosniff");
		headers.add("X-Frame-Options", "deny");
		headers.add("Cache-Control","no-cache, no-store");
		headers.add("Expires","0");
		headers.add("Pragma","no-cache");
		headers.setContentType(mediaType);
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	public static String getRandomPwd() {
		String[] symbols = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "*", "$", "!", "@",
				"z", "b", "n", "p", "t", "v", "k", "l", "i", "g", "c", "x", "u", "r", "e", "h", "y" };
		int length = 8;
		Random random = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int indexRandom = random.nextInt(symbols.length);
			sb.append(symbols[indexRandom]);
		}
		return sb.toString();
	}

	
	// Generate password
	public static String getHashed(String rawData, String randomSalt) {
		byte[] plainText = rawData.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");

		} catch (Exception e) {
			e.printStackTrace();
		}

		md.reset();
		md.update(plainText);
		byte[] encodedPassword = md.digest(randomSalt.getBytes());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				sb.append("0");
			}

			sb.append(Long.toString(encodedPassword[i] & 0xff, 20));
		}

		return sb.toString();
	}
	
//	public static boolean validateUserHeader(LoginServiceImpl userService,HttpServletRequest request) {
//		boolean response=false;
//		try {
//			HttpSession session=request.getSession();
//			ServletContext sc = session.getServletContext();
//			if(sc.getAttribute("hMap")!=null) {
//				@SuppressWarnings("unchecked")
//				HashMap<String, String> application = (HashMap<String, String>) sc.getAttribute("hMap");
//				if(request.getParameter("SessionUserName")!=null) {
//					String userName=request.getParameter("SessionUserName").toString();
//					String sessionID=application.get(userName);
//					UserCredential user=userService.findByUserName(userName);
//					
//					if(session.getAttribute(""+user.getUserId())!=null && sessionID.equals(session.getAttribute(""+user.getUserId()).toString())) {
//						response=true;
//					}
//					else {
//					
//						response=true;
//					}
//				}else {
//					response=false;
//				}
//				
//			}
//		}catch (Exception e) {
//			response=false;
//		}
//		return response;
//	}

}
