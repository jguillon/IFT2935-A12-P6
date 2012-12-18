package doctorActivities;

import sam.SuiviMedical.GraphActivity;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Page présentant les actions qu'il est possible d'effectuer sur l'évènement
 * sélectionné
 * 
 * @author Jérémy
 * 
 */
public class PatientEventModification extends Activity implements
		OnClickListener {

	private Button visualizationB, reportB, prescriptionB, actionB, diagnosisB,
			closureB;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctorevent);

		visualizationB = (Button) findViewById(R.id.visualize);
		reportB = (Button) findViewById(R.id.addReport);
		prescriptionB = (Button) findViewById(R.id.prescribe);
		actionB = (Button) findViewById(R.id.action);
		diagnosisB = (Button) findViewById(R.id.diagnosis);
		closureB = (Button) findViewById(R.id.closeEvent);

		visualizationB.setOnClickListener(this);
		reportB.setOnClickListener(this);
		prescriptionB.setOnClickListener(this);
		actionB.setOnClickListener(this);
		diagnosisB.setOnClickListener(this);
		closureB.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == visualizationB) {
			Intent i = new Intent(view.getContext(), EventVisualization.class);
			startActivity(i);
		} else if (view == reportB) {
			Intent i = new Intent(view.getContext(), ReportCreation.class);
			startActivity(i);
		} else if (view == prescriptionB) {
			Intent i = new Intent(view.getContext(), PrescriptionCreation.class);
			startActivity(i);
		} else if (view == actionB) {
			Intent i = new Intent(view.getContext(), ActionRequest.class);
			startActivity(i);
		} else if (view == diagnosisB) {
			Intent i = new Intent(view.getContext(), DiagnosisCreation.class);
			startActivity(i);
		} else if (view == closureB) {
			// TODO Close Event
		}

		Button visualize = (Button) findViewById(R.id.visualize);

		visualize.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent graph = new Intent(view.getContext(),
						GraphActivity.class);
				startActivity(graph);
			}
		});
	}

}
