package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import pojo.Applyvacancy;
import pojo.Vacancy;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ApplyVacancyDao;
import dao.VacancyDao;

public class SchduleInterviewProcess extends ActionSupport implements ServletRequestAware,SessionAware
{
	long VID;
	Applyvacancy appvac=new Applyvacancy();
	Vacancy vacancy=new Vacancy();
	HttpServletRequest request;
	ApplyVacancyDao dao=new ApplyVacancyDao();
	//VacancyDao dao =new VacancyDao();
	//String vac;
	Map<String, Object> map;
	@Override
	public String execute() throws Exception 
	{
		//System.out.println("asdfsd "+ VID );
		map.put("vid",VID);
		//vac=dao.getAllVacancies();
		
		//request.setAttribute("vaca", vac);
		//vacancy.setVid(VID);
		//appvac.setVacancy(vacancy);
		String applicant=dao.fetchApp(VID);
		request.setAttribute("appids",applicant);
		
		String iw=dao.fetchIr();
		request.setAttribute("irid",iw);
		//System.out.println("request  "+iw);
		//System.out.println(request.getAttribute("irid"));
		//System.out.println("In execute method and getattrs is "+appvac.toString());
		return SUCCESS;
	}


	public long getVID() 
	{
		return VID;
	}

	public void setVID(long vID) {
		VID = vID;
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

