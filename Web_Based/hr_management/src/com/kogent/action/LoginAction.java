package com.kogent.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	String loginid;
	String password;
	String type;
	
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String execute() throws Exception {
		
		if(loginid.equals(password)){
			if("manager".equals(type)){
				return "manager";
			}else{
				return "clerk";
			}			
			
		}else{
			this.addActionError(getText("app.invalid"));
			return ERROR;
		}
	}
	public void validate() {
		if ( (loginid == null ) || (loginid.length() == 0) ) {
			this.addFieldError("loginid", getText("app.loginid.blank"));
		}
		if ( (password == null ) || (password.length() == 0) ) {
			this.addFieldError("password", getText("app.password.blank"));
		}
	}	
}
