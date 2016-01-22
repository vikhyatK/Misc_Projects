package action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.EmployeeDao;
import pojo.Employee;
import pojo.Login;

public class EditEmployeeDetails extends ActionSupport implements ModelDriven<Employee>,SessionAware
{
	long eid;
	private Employee emp=new Employee();
	private EmployeeDao dao;
	private Employee oldE;
	private Map map;
	public EditEmployeeDetails()
	{
		
	}
	
	@Override
	public String execute() throws Exception 
	{
		System.out.println("in executes");
		dao=new EmployeeDao();
		System.out.println("befor updates");
		eid=Long.parseLong((String)map.get("eid"));
		//roles=(String)map.get("role");
		System.out.println(eid);
		System.out.println("sfsw"+emp.toString());
		oldE=dao.getEmp(eid);
		emp.setEmpid(eid);
		emp.setDeptid(oldE.getDeptid());
		emp.setJoiningdate(oldE.getJoiningdate());
		dao.edit(emp);
		System.out.println("after edit");
		//System.out.println("after update & role is"+emp.getLogin()roles);
		//return emp.getRole();
		//System.out.println(emp.getLogin().getRole());
		//System.out.println(oldE.getLogin().getRole());
		return oldE.getLogin().getRole();
	}
	

	@Override
	public void setSession(Map<String, Object> arg0) 
	{	
			map=arg0;
		
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return emp;
	}
	
	@Override
	public void validate()
	{
		if ( (emp.getFname() == null ) || (emp.getFname().length() == 0) ) {
			this.addFieldError("fname", "Fname cannot be blank");
		}
		int count=0;
		for(int i=0;i<=emp.getFname().length()-1;i++){		
			if(!(Character.isAlphabetic((emp.getFname().charAt(i))))){
				count++;
				break;
			}
		}
		if(count>=1)
			addFieldError("fname","Enter alphabetic value");
		
		
		if ( (emp.getMname() == null ) || (emp.getMname().length() == 0) ) {
			this.addFieldError("mname", "Mname cannot be blank");
		}
		int count1=0;
		for(int i=0;i<=emp.getMname().length()-1;i++){		
			if(!(Character.isAlphabetic((emp.getMname().charAt(i))))){
				count1++;
				break;
			}
		}
		if(count1>=1)
			addFieldError("mname","Enter alphabetic value");
		
		
		if ( (emp.getLname() == null ) || (emp.getLname().length() == 0) ) {
			this.addFieldError("lname", "Lname cannot be blank");
		}
		int count2=0;
		for(int i=0;i<=emp.getLname().length()-1;i++){		
			if(!(Character.isAlphabetic((emp.getLname().charAt(i))))){
				count2++;
				break;
			}
		}
		if(count2>=1)
			addFieldError("lname","Enter alphabetic value");
		
		
	
		if(emp.getEmail().equals("")){
            addFieldError("email","The Email can't be empty");
        }else{
            String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
               CharSequence inputStr = emp.getEmail();
               Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
               Matcher matcher = pattern.matcher(inputStr);
               if(!matcher.matches())
                   addFieldError("email","Invalid email address");
        }
		
		 
		/*try{  
		if((emp.getEmob()==null) ||(emp.getEmob().toString().length()==0))
		{
			this.addFieldError("emob",getText("mob no cant be empty"));
		}int count4=0;
		for(int i=0;i<=emp.getEmob().toString().length()-1;i++){		
			if(!(Character.isDigit(emp.getEmob().toString().charAt(i)))){
				count4++;
				break;
			}
		}
		if(count4>=1)
			addFieldError("emob","Enter Numeric value");
		}catch (Exception e) {
			addFieldError("emob","Enter 10 digit mobile number");
		}
		*/
		
	}
	
}
	

