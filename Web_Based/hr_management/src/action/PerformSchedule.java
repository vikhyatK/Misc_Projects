package action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import pojo.Applicant;
import pojo.Applyvacancy;
import pojo.Employee;
import pojo.Vacancy;

import com.opensymphony.xwork2.ActionSupport;

import dao.ApplyVacancyDao;
import dao.VacancyDao;

public class PerformSchedule extends ActionSupport implements ServletRequestAware,SessionAware
{ 
	private long appid;
	private Date interviewDate;
	private long irid;
	Applyvacancy applyvac =new Applyvacancy(); 
	Employee hr=new Employee();
	Employee iw=new Employee();
	Applicant applicant=new Applicant();
	Vacancy vacancy=new Vacancy();
	HttpServletRequest request;
	ApplyVacancyDao dao=new ApplyVacancyDao();
	
	String vac;
	Map<String,Object> map;
	

	@Override
	public String execute() throws Exception 
	{
		long hrid=Long.parseLong((String)map.get("eid"));
		long vid=(long)map.get("vid");
		//applicant.setAppid(appid);
		iw.setEmpid(irid);
		hr.setEmpid(hrid);
		//vacancy.setVid(vid);
		applyvac.setApplicant(applicant);
		applyvac.setEmployee1(iw);
		applyvac.setEmployee2(hr);
		//applyvac.setVacancy(vacancy);
		applyvac.setScheduledate(interviewDate);
		dao.SheduleVacancy(applyvac,vid,appid);
	//hm=dao.getAllVacancy();
		//request.setAttribute("vaca", hm);
		//System.out.println("map "+hm);
		
		//vac=dao.getAllVacancies();
		//request.setAttribute("vaca", vac);
		return SUCCESS;
	}

	public long getAppid() {
		return appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public long getIrid() {
		return irid;
	}

	public void setIrid(long irid) {
		this.irid = irid;
	}

	
	@Override
	public void setServletRequest(HttpServletRequest arg0)
	{
	
		this.request=arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
	map=arg0;
		
	}

}
