package patientActivities;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import database.DataSource;

public class PatientSendInfos extends Activity {

	/**
	 * On peut soit remplir le spinner avec notre base de données où la remplir
	 * d'avance par le xml
	 */

	/** Called when the activity is first created. */
	Intent i;
	Infos session;
	DataSource ds;

	AlertDialog.Builder simple;
	TextView mesure;
	EditText value;
	TextView unites;
	String[] names;
	String[] units;
	int pos = 0;

	Button ok;
	Button cancel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendinfo);
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		ds = new DataSource(this);

		simple = new AlertDialog.Builder(this);
		ok = (Button) findViewById(R.id.bOk);
		cancel = (Button) findViewById(R.id.bCancel);
		mesure = (TextView) findViewById(R.id.textMesure);
		value = (EditText) findViewById(R.id.editValue);
		unites = (TextView) findViewById(R.id.textMesureUnit);
		names = getResources().getStringArray(R.array.info_array);
		units = getResources().getStringArray(R.array.unit_array);

		mesure.setText(names[0]);
		unites.setText(units[0]);

		final Spinner spinner = (Spinner) findViewById(R.id.spinInfo);
		/**
		 * Create an ArrayAdapter using the string array and a default spinner
		 * layout
		 */

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.info_array, android.R.layout.simple_spinner_item);
		/** Specify the layout to use when the list of choices appears */

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		/** Apply the adapter to the spinner */

		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentView, View view,
					int pos, long id) {
				/**
				 * Code selon l'item sélectionné. Avec sql on va fonctionner
				 * avec id?
				 */
				mesure.setText(names[pos]);
				unites.setText(units[pos]);
				PatientSendInfos.this.pos = pos;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
				// your code here
			}

		});

		ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (!value.getText().toString().matches("")) {
					// On vérifie et envoie les données à la base
					if (pos == 0 || pos == 1) {
						//Double d = 0.0;
						try {
							//d = Double.parseDouble(value.getText().toString());
							// TODO Envoyer d dans la DB
							showConfirMessage("Vos informations ont été envoyées à votre médecin.");
						} catch (NumberFormatException nfe) {
							showErrorMessage("Veuillez entrer une valeur numérique. Pour les nombres décimaux, utilisez le point (.) et non la virgule (,).");
						}

					} else {
						//int i = 0;
						try {
							//i = Integer.parseInt(value.getText().toString());
							// TODO Envoyer i dans la DB
							showConfirMessage("Vos informations ont été envoyées à votre médecin.");
						} catch (NumberFormatException nfe) {
							showErrorMessage("Veuillez entrer une valeur numérique entière.");
						}
					}

				} else {
					showErrorMessage("Veuillez remplir les champs obligatoires.");
				}
			}
		});

		cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});

		// getLastEvent();
	}

	public void showErrorMessage(String erreur) {
		simple.setMessage(erreur);
		simple.setCancelable(false);
		simple.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});

		simple.create();
		simple.setTitle("Attention");
		simple.show();
	}

	public void showConfirMessage(String mess) {
		simple.setMessage(mess);
		simple.setCancelable(false);
		simple.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});

		simple.create();
		simple.setTitle("Confirmation");
		simple.setIcon(R.drawable.patient_sendinfos);
		simple.show();
	}

	// public void getLastEvent(){
	// ds.open();
	// Cursor c =
	// ds.rawQuery("SELECT EVENT.EventNo, EVENT.OpenDate FROM EVENT INNER JOIN DOSSIER ON EVENT.DossierNo = DOSSIER.DossierNo WHERE DOSSIER.NoAss = \""
	// + session.getUser() + "\" ORDER BY OpenDate asc LIMIT 1");
	// c.moveToFirst();
	// Toast.makeText(this, "Event " + c.getString(0),
	// Toast.LENGTH_LONG).show();
	// }
}