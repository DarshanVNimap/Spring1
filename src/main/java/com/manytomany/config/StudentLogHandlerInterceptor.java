package com.manytomany.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentLogHandlerInterceptor implements HandlerInterceptor {
	
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	

	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler)
			throws Exception {
		
		log.info("LogHandlerInterceptor::preHandler()::student");
		
//		log.info(request.getServerPort());
		
		// TODO Auto-generated method stub
//		String authHeader  = request.getHeader("Authorization");
//		if(authHeader != null && 	StringUtils.hasText("Authorization") && authHeader.startsWith("Basic ") ) {
//			String token = authHeader.substring("Basic ".length());
//			byte[] cred = Base64.getDecoder().decode(token);
//			String getCred  = new String(cred);
//			String[] credantial = getCred.split(":");
//			
//			if(USERNAME.equals(credantial[0]) && PASSWORD.equals(credantial[1])) {
//				log.info("authenticated");
//				return true;
//			}
//
//		}
//		
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED ,"Unauthorized");
//		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.info("LogHandlerInterceptor::postHandler::student");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("LogHandlerInterceptor::afterCompletion::student");
	}
	
}
