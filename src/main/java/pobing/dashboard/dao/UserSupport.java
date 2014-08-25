package pobing.dashboard.dao;

import pobing.dashboard.model.User;


public interface UserSupport {
	public User selectUserByID(int id);
}
