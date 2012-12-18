package doctorActivities;

import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Page présentant les actions qu'il est possible d'effectuer sur l'évènement sélectionné
 * @author Jérémy
 *
 */
public class PatientEventModification extends Activity implements OnClickListener {
	
	private Button visualizationB, reportB, prescriptionB, actionB, diagnosisB, closureB; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorevent);
        
		visualizationB 	= (Button) findViewById(R.id.visualize);
		reportB 		= (Button) findViewById(R.id.addReport);
		prescriptionB 	= (Button) findViewById(R.id.prescribe);
		actionB 		= (Button) findViewById(R.id.action);
		diagnosisB 		= (Button) findViewById(R.id.diagnosis);
		closureB 		= (Button) findViewById(R.id.closeEvent);
	
		visualizationB.setOnClickListener(this);
		reportB.setOnClickListener(this);
		prescriptionB.setOnClickListener(this);
		actionB.setOnClickListener(this);
		diagnosisB.setOnClickListener(this);
		closureB.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if(view == visualizationB) {
			System.out.println("Visu !");
		} else if(view == reportB) {
			Intent i = new Intent(view.getContext(), PatientEventsList.class);
			startActivity(i);
		} else if(view == prescriptionB) {
			
		} else if(view == actionB) {
			
		} else if(view == diagnosisB) {
			
		} else if(view == closureB) {
			
		}
	}
	
}
