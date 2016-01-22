package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Employee;
import pojo.Login;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDao;


public class LoginStruts extends ActionSupport implements SessionAware{

	String eid;
	String epassword;
	LoginDao dao=null;
	
	private Map map;
	
	
	@Override
	public String execute() throws Exception {
		dao=new LoginDao();
		System.out.println(eid+" "+epassword);
		Login login=dao.checklogin(Integer.parseInt(eid),epassword);
		//Employee emp=dao.checklogin(Integer.parseInt(eid),epassword);
		if(login!=null)
		{
			System.out.println("correct");
			map.put("eid", eid);
			//map.put("password", login.getPassword());
			//map.put("userid", login.getUserid());
			map.put("role", login.getRole());
			//return emp.getRole();
			return login.getRole() ;
		}
		else 
			{
			this.addFieldError("epassword", getText("app.invalid"));
			return INPUT;
			}
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	@Override
	public void setSession(Map arg0) {
		map=arg0;
	}
	
	@Override
	public void validate() {
		if ( (eid == null ) || (eid.length() == 0) ) {
			this.addFieldError("eid", getText("app.loginid.blank"));
		}
		int count=0;
		for(int i=0;i<=eid.length()-1;i++){		
			if(!(Character.isDigit(eid.charAt(i)))){
				count++;
				break;
			}
		}
		if(count>=1)
			addFieldError("eid","Enter Numeric value");
		
		/*if ( (epassword == null ) || (epassword.length() == 0) ) {
			this.addFieldError("epassword", getText("app.password.blank"));
		}*/
		 if(epassword.equals("")){
	            addFieldError("epassword","The Password can't be empty");
	        }else if(epassword.length()<8){
	            addFieldError("epassword","Password must be minimum of 8 characters");
	        }
	}	
}
