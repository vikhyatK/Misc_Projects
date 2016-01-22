package action;

import java.math.BigDecimal;

import java.util.GregorianCalendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.VacancyDao;
import pojo.Employee;
import pojo.Vacancy;

public class CreateVacancyStruts extends ActionSupport implements ModelDriven<Vacancy>,SessionAware
{
	private Vacancy user=new Vacancy();
	private VacancyDao dao;
	private Map map;
	
	@Override
	public Vacancy getModel()
	{
		return user;
	}
	
	@Override
	public String execute() throws Exception
	{
		GregorianCalendar gc=new GregorianCalendar();
		Employee emp=new Employee();
		long eid=Long.parseLong((String)map.get("eid"));
		System.out.println("eid is"+eid);
		emp.setEmpid(eid);
		System.out.println(emp.toString());
		user.setOpeningdate(gc.getTime());
		user.setEmployee(emp);
		System.out.println(user.toString());
		user.setStatus("open");
		dao=new VacancyDao();
		dao.create(user);
		return SUCCESS;
	}

	@Override
	public void setSession(Map arg0)
	{
		
		map=arg0;
	}
	
	
	/*@Override
	public void validate()
	{
	
	if ( (user.getTitle() == null ) || (user.getTitle().length() == 0) ) {
		this.addFieldError("title", "Title cannot be blank");
	}
	int count=0;
	for(int i=0;i<=user.getTitle().length()-1;i++){		
		if(!(Character.isAlphabetic((user.getTitle().charAt(i))))){
			count++;
			break;
		}
	}
	if(count>=1)
		addFieldError("title","Enter alphabetic value");
	
	
	  String st=user.getJobopenings().toString();
	  System.out.println(st);
	  
	  if(!(st.matches("[0-9]{10}")))
		  this.addFieldError("jobopenings",getText("mob no cant be empty"));
	  
			if((user.getJobopenings()==null) ||(user.getJobopenings().intValue()==0))
			{
				this.addFieldError("mobno",getText("mob no cant be empty"));
			}int count4=0;
			for(int i=0;i<=user.getJobopenings().intValue()-1;i++){		
				if(!(Character.isDigit(charAt(i)))){
					count4++;
					break;
				}
			}
			if(count4>=1)
				addFieldError("mobno","Enter Numeric value");
	
}*/
}