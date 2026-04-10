package com.symplifica.clients_message.componentauth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.symplifica.clients_message.serviceauth.JwtService;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private final JwtService jwtService;

	public JwtFilter(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String path = request.getServletPath();

		if (path.equals("/auth/login")) {
			filterChain.doFilter(request, response);
			return;
		}

		String authHeader = request.getHeader("Authorization");
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Token missing");
			return;
		}

		try {
			String token = authHeader.replace("Bearer ", "");
			
			jwtService.validateToken(token);
			
			String username = jwtService.extractUsername(token);
			
			UsernamePasswordAuthenticationToken auth =
			        new UsernamePasswordAuthenticationToken(
			                username,
			                null,
			                List.of()
			        );
			SecurityContextHolder.getContext().setAuthentication(auth);
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Invalid token");
		}
	}
}