package com.niit.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UsersDao;
import com.niit.model.Users;

@Service("userDetailsService")
public class UserDetailsServerIMp implements UserDetailsService
{
	@Autowired
	UsersDao usersDAO;

    @Transactional(readOnly = true)
	  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	Users user=new Users();
    	user.setUsername(username);
	    Users user1 =  usersDAO.displayUserByUserName(user);
	    UserBuilder builder = null;
	    if (user1 != null) {
	      
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.disabled(!user1.isEnabled());
	      builder.password(user1.getPassword());
	      String[] authorities = new String[]{user1.getAuthority()} ;

	      builder.authorities(authorities);
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }
	    return builder.build();
	  }
}
