package sam.SuiviMedical;

public class Infos {
	private String user;
	private String userPermission;
	private static String activePatient;
	private String activeEvent;
	private boolean medReminder;
	
	public Infos(String user, String userPermission){
		this.user = user;
		this.userPermission = userPermission;
		this.medReminder = true;
	}
	
	public String getUser(){
		return user;
	}
	
	public String getUserPermission(){
		return userPermission;
	}
	
	public static String getActivePatient(){
		return activePatient;
	}
	
	public String getActiveEvent(){
		return activeEvent;
	}
	
	public Boolean getMedReminder(){
		return this.medReminder;
	}
	
	public void setUser(String value){
		if(value != null)
			this.user = value;
		else 
			this.user = null;
	}
	
	public void setUserPermission(String value){
		if(value != null)
			this.userPermission = value;
		else 
			this.userPermission = null;
	}
	
	public static void setActivePatient(String value){
		if(value != null)
			activePatient = value;
		else 
			activePatient = null;
	}
	
	public void setActiveEvent(String value){
		if(value != null)
			this.activeEvent = value;
		else 
			this.activeEvent = null;
	}
	
	public void setMedReminder(Boolean value){
		this.medReminder = value;
	}
}
