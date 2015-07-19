package dao.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.User;

import dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

 
	@Override
	public String findPasswdByName(String username) {
		if(username == null || username == ""){
			return null;
		}
		List users = (List) this.getHibernateTemplate().find("from User where username = '"+username+"'"); 
		if(users == null){
			return null;
		}else{
			return ((User)users.get(0)).getPassword();
		}
		
	}

}
