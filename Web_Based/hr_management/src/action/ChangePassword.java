package action;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import dao.ChangePasswordDao;

public class ChangePassword extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String oldpass;
	private String newpass;
	private ChangePasswordDao dao=null;
	private Map map;
	
	public ChangePassword()
	{
		
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setOldpass(String oldpass)
	{
		this.oldpass = oldpass;
	}


	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	@Override
	public String execute() throws Exception 
	{
		//System.out.println(newpass+" "+oldpass+" "+password);
		dao=new ChangePasswordDao();
		//System.out.println("uid is"+(Long.parseLong((String)map.get("eid"))));
		String role=dao.changeOldPass(Long.parseLong((String)map.get("eid")),oldpass,password);
		if(role!=null)
		{
			map.put("msg", "Password Change Sucessfully");
			return role;
		}
		else
		{
			this.addFieldError("password", getText("app.pass.match"));
			return INPUT;
		}
	}
	
	@Override
	public void validate() {
		/*if ( (password == null ) || (password.length() == 0) ) {
			this.addFieldError("password", getText("app.confirmpassword.blank"));
		}*/
		
		if ( (oldpass == null ) || (oldpass.length() == 0) ) {
			this.addFieldError("oldpass", getText("app.oldpassword.blank"));
		}
		
		 
		/*if ( (newpass == null ) || (newpass.length() == 0) ) {
			this.addFieldError("newpass", getText("app.newpassword.blank"));
		}
		if ( !(newpass.equals(password)))  {
			this.addFieldError("password", getText("app.password.match"));
		}*/
		 if(newpass.equals("")){
	            addFieldError("newpass","The Password can't be empty");
	        }else if(newpass.length()<8){
	            addFieldError("newpass","Password must be minimum of 8 characters");
	        }
		 
		 if(password.equals("")){
	            addFieldError("password","The Password can't be empty");
	        }else if(!(newpass.equals(password))){
	        	this.addFieldError("password", getText("app.password.match"));
	        }
		
	}	
	
	@Override
	public void setSession(Map<String, Object> arg0) 
	{	
			map=arg0;
		
	}
}
