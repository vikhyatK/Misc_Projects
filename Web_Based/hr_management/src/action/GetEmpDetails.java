package action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import pojo.Employee;

import com.opensymphony.xwork2.ActionSupport;

import dao.EmployeeDao;


public class GetEmpDetails extends ActionSupport implements SessionAware{

	private EmployeeDao dao;
	Employee emp=new Employee();
	private Map map;
	
	@Override
	public String execute() throws Exception {
		dao=new EmployeeDao();
		long eid=Long.parseLong((String) map.get("eid"));
		emp=dao.getEmp(eid);
		map.put("emp", emp);
		return emp.getLogin().getRole();
	}
	
	public Employee getEmp() {
		return emp;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		map=arg0;
		
	}
	
}
