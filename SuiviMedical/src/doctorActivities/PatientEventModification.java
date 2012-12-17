package doctorActivities;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PatientEventModification extends Activity {
	
	private Intent i;
	private Infos session;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorevent);
        
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
	}
	
}
