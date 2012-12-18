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


public class PatientSendInfos extends Activity {

	/**
	 * On peut soit remplir le spinner avec notre base de données où la remplir
	 * d'avance par le xml
	 */

	/** Called when the activity is first created. */
	Intent i;
	Infos session;
	
	AlertDialog.Builder simple;
	TextView mesure;
	EditText value;
	TextView unites;
	String[] names;
	String[] units;

	
	Button ok;
	Button cancel;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendinfo);
		i=getIntent();
		session = (Infos) i.getSerializableExtra("session");
		
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
		
		ok.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				if(!value.getText().toString().matches("")){
					
					//On vérifie et envoie les données à la base
				
			        simple.setMessage("Vos informations ont bien été envoyées.");
			        simple.setCancelable(false);
			        simple.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			        	 @Override
						public void onClick(DialogInterface dialog, int id) {
			    				finish();
			        	 }
			        	 });
			        
			        simple.create();
			        simple.setTitle("Confirmation");
			        simple.setIcon(R.drawable.patient_sendinfos);
			        simple.show();
				}
				else{

			        simple.setMessage("Veuillez remplir les champs obligatoires.");
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
			}
        });
		
		cancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
					finish();
				}
        });
		
		final Spinner spinner = (Spinner) findViewById(R.id.spinInfo);
		/** Create an ArrayAdapter using the string array and a default spinner
		 layout*/
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.info_array, android.R.layout.simple_spinner_item);
		/** Specify the layout to use when the list of choices appears*/
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		/** Apply the adapter to the spinner */
		
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

		    @Override
		    public void onItemSelected(AdapterView <?> parentView, View view, int pos, long id) {
		       /**Code selon l'item sélectionné. Avec sql on va fonctionner avec id?*/
		    	mesure.setText(names[pos]);
		    	unites.setText(units[pos]);
		    }

		    @Override
		    public void onNothingSelected(AdapterView <?> parentView) {
		        // your code here
		    }

		});


		
		
	}
}