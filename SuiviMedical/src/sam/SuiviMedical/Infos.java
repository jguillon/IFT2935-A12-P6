package sam.SuiviMedical;

import java.io.Serializable;

public class Infos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean medReminder;
	private String user;
	private String userPermission;
	private String activePatient;
	private String activeEvent;
	private String activeMed;

	public Infos(String user, String userPermission) {
		this.user = user;
		this.userPermission = userPermission;
		medReminder = true;
	}

	public String getUser() {
		return user;
	}

	public String getUserPermission() {
		return userPermission;
	}

	public String getActivePatient() {
		return activePatient;
	}

	public String getActiveEvent() {
		return activeEvent;
	}
	 
	public String getActiveMed(){
		return activeMed;
	}

	public static Boolean getMedReminder() {
		return medReminder;
	}

	public void setUser(String value) {
		if (value != null)
			this.user = value;
		else
			this.user = null;
	}

	public void setUserPermission(String value) {
		if (value != null)
			this.userPermission = value;
		else
			this.userPermission = null;
	}

	public void setActivePatient(String value) {
		if (value != null)
			this.activePatient = value;
		else
			this.activePatient = null;
	}

	public void setActiveEvent(String value) {
		if (value != null)
			this.activeEvent = value;
		else
			this.activeEvent = null;
	}
	
	public void setActiveMed(String med){
		if(med != null)
			this.activeMed = med;
		else
			this.activeMed = null;
	}

	public static void setMedReminder(Boolean value) {
		medReminder = value;
	}

	public void clearSession() {
		setMedReminder(true);
		this.activeEvent = null;
		this.activePatient = null;
		this.activeMed = null;
		this.user = null;
		this.userPermission = null;
	}

}