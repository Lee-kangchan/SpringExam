package com.springbook.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	@Override
	public UserVO getUser(UserVO vo) {
		return getUser(vo);
	}

}
