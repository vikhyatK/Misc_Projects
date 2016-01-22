package action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javassist.expr.NewArray;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Applicant;
import pojo.Login;
import pojo.Vacancy;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.ValidationException;

import dao.ApplicantDao;
import dao.VacancyDao;

public class CreateApplicant extends ActionSupport implements ModelDriven<Applicant>,SessionAware
{
	private String password;
	private String repassword;
	
	private Applicant user=new Applicant();
	private Login lg=new Login();
	private ApplicantDao dao;
	private Map map;
	
	
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		dao=new ApplicantDao();
		user.setStatus("not in process");
		lg.setPassword(password);
		lg.setRole("app");
		long userid=dao.create(user,lg);
		map.put("eid",userid);
		return SUCCESS;
	}
	@Override
	public void validate()
	{
		if ( (user.getFname() == null ) || (user.getFname().length() == 0) ) {
			this.addFieldError("fname", "Fname cannot be blank");
		}
		int count=0;
		for(int i=0;i<=user.getFname().length()-1;i++){		
			if(!(Character.isAlphabetic((user.getFname().charAt(i))))){
				count++;
				break;
			}
		}
		if(count>=1)
			addFieldError("fname","Enter alphabetic value");
		
		
		if ( (user.getMname() == null ) || (user.getMname().length() == 0) ) {
			this.addFieldError("mname", "Mname cannot be blank");
		}
		int count1=0;
		for(int i=0;i<=user.getMname().length()-1;i++){		
			if(!(Character.isAlphabetic((user.getMname().charAt(i))))){
				count1++;
				break;
			}
		}
		if(count1>=1)
			addFieldError("mname","Enter alphabetic value");
		
		
		if ( (user.getLname() == null ) || (user.getLname().length() == 0) ) {
			this.addFieldError("lname", "Lname cannot be blank");
		}
		int count2=0;
		for(int i=0;i<=user.getLname().length()-1;i++){		
			if(!(Character.isAlphabetic((user.getLname().charAt(i))))){
				count2++;
				break;
			}
		}
		if(count2>=1)
			addFieldError("lname","Enter alphabetic value");
		
		
		if ( (user.getFathersname() == null ) || (user.getFathersname().length() == 0) ) {
			this.addFieldError("fathersname", "Father's name cannot be blank");
		}
		int count3=0;
		for(int i=0;i<=user.getFathersname().length()-1;i++){		
			if(!(Character.isAlphabetic((user.getFathersname().charAt(i))))){
				count3++;
				break;
			}
		}
		if(count3>=1)
			addFieldError("fathersname","Enter alphabetic value");
		
		
		if(user.getEmail().equals("")){
            addFieldError("email","The Email can't be empty");
        }else{
            String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
               CharSequence inputStr = user.getEmail();
               Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
               Matcher matcher = pattern.matcher(inputStr);
               if(!matcher.matches())
                   addFieldError("email","Invalid email address");
        }
		
		  if(password.equals("")){
	            this.addFieldError("password","The Password can't be empty");
	        }else if(password.length()<8){
	            this.addFieldError("password","Password must be minimum of 8 characters");
	        }
		  
		if((user.getMobno()==null) ||(user.getMobno().length()==0))
		{
			this.addFieldError("mobno",getText("mob no cant be empty"));
		}int count4=0;
		for(int i=0;i<=user.getMobno().length()-1;i++){		
			if(!(Character.isDigit(user.getMobno().charAt(i)))){
				count4++;
				break;
			}
		}
		if(count4>=1)
			addFieldError("mobno","Enter Numeric value");
		
		if((user.getHighschool()==null) ||(user.getHighschool().length()==0))
		{
			this.addFieldError("highschool",getText("Enter Percentage"));
		}int count5=0;
		for(int i=0;i<=user.getHighschool().length()-1;i++){		
			if(!(Character.isDigit(user.getHighschool().charAt(i)))){
				count5++;
				break;
			}
		}
		if(count5>=1)
			addFieldError("highschool","Enter Numeric value");
		
		
		if((user.getIntermediate()==null) ||(user.getIntermediate().length()==0))
		{
			this.addFieldError("intermediate",getText("Enter Percentage"));
		}int count6=0;
		for(int i=0;i<=user.getIntermediate().length()-1;i++){		
			if(!(Character.isDigit(user.getIntermediate().charAt(i)))){
				count6++;
				break;
			}
		}
		if(count6>=1)
			addFieldError("intermediate","Enter Numeric value");
		
		
		 if(user.getYearofpassing().equals("")){
	            addFieldError("yearofpassing","Enter Passing Year");
	        }else if(user.getYearofpassing().length()!=4){
	            addFieldError("yearofpassing","Enter year in yyyy format");
	        }
		if((repassword==null) ||(repassword.length()==0))
		{
			this.addFieldError("repassword",getText("repassword cant be empty"));
		}
		else if(!(password.equals(repassword)))
		{
			this.addFieldError("repassword",getText("Both password should be match"));
		}
		if(!(user.isStatusoflicense()))
		{
			this.addFieldError("statusoflicense",getText("agree with terms and conditions"));
		}
		
	}

	@Override
	public void setSession(Map arg0) {
		map=arg0;
	}

   @Override
	public Applicant getModel() {
		return user;
	}
	
}
