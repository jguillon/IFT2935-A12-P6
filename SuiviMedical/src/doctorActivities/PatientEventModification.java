package doctorActivities;

import sam.SuiviMedical.GraphActivity;
import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientEventModification extends Activity {
	
	private Intent i;
	private Infos session;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorevent);
        
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		
		Button visualize = (Button) findViewById(R.id.visualize);
        
		visualize.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent graph = new Intent(view.getContext(), GraphActivity.class);
				startActivity(graph);
			}
        });
	}
	
}
