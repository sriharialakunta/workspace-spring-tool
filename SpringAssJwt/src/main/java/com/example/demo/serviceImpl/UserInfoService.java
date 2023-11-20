package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.config.UserInfoUserDetails;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

@Component
public class UserInfoService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userinfo= userRepo.findByuName(username);

		return userinfo.map(UserInfoUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("userNotFound"+username));
	}

}
