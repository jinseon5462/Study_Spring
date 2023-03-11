package com.springboot.myapp2.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.myapp2.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails{
	
	private UserDTO user;
	
	public UserDetailsImpl(UserDTO user) {
		this.user = user;
	}
	//계정이 가지고 있는 권한 목록 저장하여 반환한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//권한목록
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		
		roleList.add(new GrantedAuthority(){
			@Override
			public String getAuthority() {
				return "ROLE_" + user.getRole();
			}
		});
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getId();
	}

	//계정이 만료되지 않았는지 반환한다.
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정이 잠겨있는지 반환한다.
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//비밀번호가 만료되지 않았는지 반환한다.
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//계정이 활성화되었는지 반환한다.
	@Override
	public boolean isEnabled() {
		return true;
	}
}
