/**
 * 
 */
package com.proginn.security.browser.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

/**
 * @author zhailiang
 *
 */
public interface AuthenticationSuccessCallback {
	
	void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication);

}
