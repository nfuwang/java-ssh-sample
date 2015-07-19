package service.serviceImpl;

import dao.daoImpl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
	private UserDaoImpl dao;
	

	public UserDaoImpl getDao() {
		return dao;
	}


	public void setDao(UserDaoImpl dao) {
		this.dao = dao;
	}


	@Override
	public boolean userLogin(String username, String password) {
		String passwordDB = dao.findPasswdByName(username);
		if(passwordDB !=null && passwordDB.equals(password)){
			return true;
		}else{
			return false;
		}
		
	}

}
