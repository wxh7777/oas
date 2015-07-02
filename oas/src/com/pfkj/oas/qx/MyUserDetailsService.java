package com.pfkj.oas.qx;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MyUserDetailsService extends UserDetailsService {

	public UserDetails loadUserByUsername(String username);
}
