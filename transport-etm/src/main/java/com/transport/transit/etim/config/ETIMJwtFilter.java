package com.transport.transit.etim.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class ETIMJwtFilter extends GenericFilterBean {
	String secretKeyENC;

	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		final String authHeader = request.getHeader("authorization");

		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);

			chain.doFilter(req, res);
		} else {

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}

			final String token = authHeader.substring(7);

			try {
				secretKeyENC ="secretKey" /*Constant.Key_Security.APP_SECRET_KEY*/;
				// System.out.println("Secret Key for the Token: "+secretKeyENC);
				final Claims claims = Jwts.parser().setSigningKey(secretKeyENC).parseClaimsJws(token).getBody();
				String issuerId = claims.getIssuer();
				if (issuerId != null) {
					String checkSession = claims.getSubject();
					System.out.println("Session id " + checkSession);
					HttpSession session = request.getSession();
					if (session != null) {
						session.setAttribute(issuerId, checkSession);
					} else {
						throw new ServletException("Not a valid User Session exist");
					}
				} else {
					throw new ServletException("User Already Logged out");
				}
			} catch (final SignatureException e) {
				throw new ServletException("Invalid token");
			}

			chain.doFilter(req, res);
		}
	}

}