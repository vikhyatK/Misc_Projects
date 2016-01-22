package action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import pojo.Employee;
import pojo.Login;
import pojo.Vacancy;
import dao.EmployeeDao;
import dao.VacancyDao;

public class CreateEmployee extends ActionSupport implements ModelDriven<Login>,SessionAware
{
	private String fname;
	private String lname;
	private Date joiningdate;
	private BigDecimal deptid;
	private Employee emps=new Employee();
	private Login login=new Login();
	private EmployeeDao dao;
	private Map map;
	
	@Override
	public Login getModel()
	{
		return login;
	}

	@Override
	public String execute() throws Exception
	{
		//System.out.println(emps.getPassword());
		//login.setPassword(emps.getPassword());
		//login.setRole(emps.getRole());
		/*login.setPassword(password);
		login.setRole(role);*/
		emps.setFname(fname);
		emps.setLname(lname);
		emps.setJoiningdate(joiningdate);
		emps.setDeptid(deptid);
		login.setEmployee(emps);
		emps.setLogin(login);
		System.out.println(login.getRole());
		dao=new EmployeeDao();
		dao.createEmployee(login);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		map=arg0;
		
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public BigDecimal getDeptid() {
		return deptid;
	}

	public void setDeptid(BigDecimal deptid) {
		this.deptid = deptid;
	}
	
	
	@Override
	public void validate()
	{
	if ( (fname == null ) || (fname.length() == 0) ) {
		this.addFieldError("fname", "Fname cannot be blank");
	}
	int count=0;
	for(int i=0;i<=fname.length()-1;i++){		
		if(!(Character.isAlphabetic((fname.charAt(i))))){
			count++;
			break;
		}
	}
	if(count>=1)
		addFieldError("fname","Enter alphabetic value");
	
	
	
	
	if ( (lname == null ) || (lname.length() == 0) ) {
		this.addFieldError("lname", "Lname cannot be blank");
	}
	int count2=0;
	for(int i=0;i<=lname.length()-1;i++){		
		if(!(Character.isAlphabetic((lname.charAt(i))))){
			count2++;
			break;
		}
	}
	if(count2>=1)
		addFieldError("lname","Enter alphabetic value");
	
	
	  if(login.getPassword().equals("")){
          this.addFieldError("password","The Password can't be empty");
      }else if(login.getPassword().length()<8){
          this.addFieldError("password","Password must be minimum of 8 characters");
      }
	  
	
	}
}
