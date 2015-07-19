import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map session = ai.getInvocationContext().getSession();  
        String  username = (String) session.get("username");  
        System.out.println("name==========="+username);
        if (null != username) {  
            return ai.invoke();  
        } else {  
            return Action.LOGIN;  
        }  
	}

}
