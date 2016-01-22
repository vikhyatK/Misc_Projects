package action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Applicant;
import pojo.Employee;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ApplicantDao;
import dao.EmployeeDao;

public class AppUpdateProfile extends ActionSupport implements ModelDriven<Applicant>,SessionAware
{
	long appid;
	private Applicant app=new Applicant();
	private ApplicantDao dao;
	private Applicant oldA;
	private Map map;
	
	@Override
	public String execute() throws Exception 
	{
		System.out.println("in executes");
		dao=new ApplicantDao();
		System.out.println("befor updates");
		appid=Long.parseLong((String)map.get("eid"));
		//roles=(String)map.get("role");
		System.out.println(appid);
		System.out.println("sfsw"+app);
		oldA=dao.viewapplicant(appid);
		app.setAppid(appid);
		app.setStatus(oldA.getStatus());
	//	emp.setDeptid(oldE.getDeptid());
	//	emp.setJoiningdate(oldE.getJoiningdate());
		dao.UpdateProfile(app);
		System.out.println("after edit");
		//System.out.println("after update & role is"+emp.getLogin()roles);
		//return emp.getRole();
		//System.out.println(emp.getLogin().getRole());
		//System.out.println(oldE.getLogin().getRole());
		return SUCCESS;
	}
	

	@Override
	public void setSession(Map<String, Object> arg0) 
	{	
			map=arg0;
		
	}

	@Override
	public Applicant getModel() {
		// TODO Auto-generated method stub
		return app;
	}
	
	
	@Override
	public void validate()
	{
		if ( (app.getFname() == null ) || (app.getFname().length() == 0) ) {
			this.addFieldError("fname", "Fname cannot be blank");
		}
		int count=0;
		for(int i=0;i<=app.getFname().length()-1;i++){		
			if(!(Character.isAlphabetic((app.getFname().charAt(i))))){
				count++;
				break;
			}
		}
		if(count>=1)
			addFieldError("fname","Enter alphabetic value");
		
		
		if ( (app.getMname() == null ) || (app.getMname().length() == 0) ) {
			this.addFieldError("mname", "Mname cannot be blank");
		}
		int count1=0;
		for(int i=0;i<=app.getMname().length()-1;i++){		
			if(!(Character.isAlphabetic((app.getMname().charAt(i))))){
				count1++;
				break;
			}
		}
		if(count1>=1)
			addFieldError("mname","Enter alphabetic value");
		
		
		if ( (app.getLname() == null ) || (app.getLname().length() == 0) ) {
			this.addFieldError("lname", "Lname cannot be blank");
		}
		int count2=0;
		for(int i=0;i<=app.getLname().length()-1;i++){		
			if(!(Character.isAlphabetic((app.getLname().charAt(i))))){
				count2++;
				break;
			}
		}
		if(count2>=1)
			addFieldError("lname","Enter alphabetic value");
		
		
		

		if ( (app.getFathersname() == null ) || (app.getFathersname().length() == 0) ) {
			this.addFieldError("fathersname", "Father's name cannot be blank");
		}
		int count3=0;
		for(int i=0;i<=app.getFathersname().length()-1;i++){		
			if(!(Character.isAlphabetic((app.getFathersname().charAt(i))))){
				count3++;
				break;
			}
		}
		if(count3>=1)
			addFieldError("fathersname","Enter alphabetic value");
	
		if(app.getEmail().equals("")){
            addFieldError("email","The Email can't be empty");
        }else{
            String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
               CharSequence inputStr = app.getEmail();
               Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
               Matcher matcher = pattern.matcher(inputStr);
               if(!matcher.matches())
                   addFieldError("email","Invalid email address");
        }
		
		
		
		if((app.getMobno()==null) ||(app.getMobno().length()==0))
		{
			this.addFieldError("mobno",getText("mob no cant be empty"));
		}int count4=0;
		for(int i=0;i<=app.getMobno().length()-1;i++){		
			if(!(Character.isDigit(app.getMobno().charAt(i)))){
				count4++;
				break;
			}
		}
		if(count4>=1)
			addFieldError("mobno","Enter Numeric value");
		
		if((app.getHighschool()==null) ||(app.getHighschool().length()==0))
		{
			this.addFieldError("highschool",getText("Enter Percentage"));
		}int count5=0;
		for(int i=0;i<=app.getHighschool().length()-1;i++){		
			if(!(Character.isDigit(app.getHighschool().charAt(i)))){
				count5++;
				break;
	}}
			if((app.getIntermediate()==null) ||(app.getIntermediate().length()==0))
			{
				this.addFieldError("intermediate",getText("Enter Percentage"));
			}int count6=0;
			for(int j=0;j<=app.getIntermediate().length()-1;j++){		
				if(!(Character.isDigit(app.getIntermediate().charAt(j)))){
					count6++;
					break;
				}
			}
			if(count6>=1)
				addFieldError("intermediate","Enter Numeric value");
			
			
			 if(app.getYearofpassing().equals("")){
		            addFieldError("yearofpassing","Enter Passing Year");
		        }else if(app.getYearofpassing().length()!=4){
		            addFieldError("yearofpassing","Enter year in yyyy format");
		        }
			
}}