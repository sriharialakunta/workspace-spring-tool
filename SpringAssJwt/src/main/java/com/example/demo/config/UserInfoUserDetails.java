package com.example.demo.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.UserInfo;

public class UserInfoUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uName;
	private String uPassword;
	private List<GrantedAuthority> auth;
	

	public UserInfoUserDetails(UserInfo userInfo) {
		super();
		this.uName = userInfo.getuName();
		this.uPassword = userInfo.getuPassword();
		this.auth = Arrays.stream(userInfo.getuRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return uPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return uName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
