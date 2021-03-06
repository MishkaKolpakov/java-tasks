package model.service.impl;

import java.util.Optional;

import dao.DaoFactory;
import dao.UserDao;
import model.entity.User;
import model.service.Loginable;

public class LoginService implements Loginable {

	private DaoFactory daoFactory;

	public LoginService(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	public LoginService() {
		this.daoFactory = DaoFactory.getInstance();
	}

	private static class Holder {
		static final LoginService INSTANCE = new LoginService();
	}

	public static LoginService getInstance() {
		return Holder.INSTANCE;
	}

	@Override
	public Optional<User> login(String email, String password) {
		try (UserDao userDao = daoFactory.createUserDao()) {
			return userDao.getUserByEmail(email).filter(user -> password.equals(user.getPassword()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
