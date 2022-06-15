package com.kb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kb.domain.CustomUser;
import com.kb.domain.MemberVO;
import com.kb.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Load User BY UserName: " + username);
		
		MemberVO vo = memberMapper.readLogin(username);
		
		return vo == null?null:new CustomUser(vo);
	}
	
}

//return vo == null?null:new CustomUser(vo);   = > vo가 null 이면 null값을 넘겨주고 null이 아니면 vo 값을 넘겨준다.
