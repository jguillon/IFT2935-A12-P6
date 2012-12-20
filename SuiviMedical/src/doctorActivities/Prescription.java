package doctorActivities;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Prescription extends Activity {

	Button prescrire;
	Button cancel;

	Intent i;
	Infos session;

	AlertDialog.Builder simple;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctorprescription);
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");

		prescrire = (Button) findViewById(R.id.bsendPresc);
		cancel = (Button) findViewById(R.id.bCancelPresc);
		simple = new AlertDialog.Builder(this);

		prescrire.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				simple.setMessage("La prescription a été ajoutée au dossier.");
				simple.setCancelable(false);
				simple.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								finish();
							}
						});

				simple.create();
				simple.setTitle("Confirmation");
				simple.setIcon(R.drawable.patient_meds);
				simple.show();
			}
		});

		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
	}

}