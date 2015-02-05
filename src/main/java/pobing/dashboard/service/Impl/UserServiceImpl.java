package pobing.dashboard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pobing.dashboard.dao.UserSupport;
import pobing.dashboard.model.User;
import pobing.dashboard.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserSupport userSupport;
	
	public User selectUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
