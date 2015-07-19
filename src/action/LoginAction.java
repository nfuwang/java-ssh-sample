package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import service.serviceImpl.UserServiceImpl;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	private String userName;
	private String passWord;
    private UserServiceImpl userServiceImpl;
    
    private Map session;  
    public void setSession(Map session) {  
        this.session = session;  
    }    
	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	//ÓÃ»§µÇÂ¼
	public String execute() throws Exception {
		
		if ( userServiceImpl.userLogin(userName,passWord)) {
			session.put("username",userName);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}