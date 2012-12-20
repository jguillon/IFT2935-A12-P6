package doctorActivities;

import patientActivities.PatientEvent;
import sam.SuiviMedical.GraphActivity;
import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

	Intent i;
	Infos session;

	private Button visualizationB, reportB, prescriptionB, actionB, diagnosisB,
			closureB;
	private AlertDialog.Builder simple;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctorevent);

		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");

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

		simple = new AlertDialog.Builder(this);
	}

	@Override
	public void onClick(View view) {
		if (view == visualizationB) {
			Intent i = new Intent(view.getContext(), PatientEvent.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (view == reportB) {
			Intent i = new Intent(view.getContext(), ReportCreation.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (view == prescriptionB) {
			Intent i = new Intent(view.getContext(), PrescriptionCreation.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (view == actionB) {
			Intent i = new Intent(view.getContext(), ActionRequest.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (view == diagnosisB) {
			Intent i = new Intent(view.getContext(), DiagnosisCreation.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (view == closureB) {

			simple.setMessage("Êtes-vous certain de vouloir fermer cet évènement ?");
			simple.setCancelable(false);
			simple.setPositiveButton("Oui",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							// fermer l'event dans la base de données
							finish();
						}
					});
			simple.setNegativeButton("Non",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			simple.create();
			simple.setTitle("Fermeture de l'évènement");
			simple.setIcon(R.drawable.patient_file);
			simple.show();
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
