package doctorActivities;

import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class DiagnosisCreation extends Activity {

	Button send;
	Button cancel;
	
	AlertDialog.Builder simple;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctordiagnosis);
		
		send = (Button) findViewById(R.id.bOkDiagn);
		cancel = (Button) findViewById(R.id.bCancelDiagn);
		simple = new AlertDialog.Builder(this);
		
		send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				simple.setMessage("Le diagnostic a été ajouté au dossier.");
		        simple.setCancelable(false);
		        simple.setPositiveButton("ok", new DialogInterface.OnClickListener() {
		        	 @Override
					public void onClick(DialogInterface dialog, int id) {
		    				finish();
		        	 }
		        	 });
		        
		        simple.create();
		        simple.setTitle("Confirmation");
		        simple.setIcon(R.drawable.doctor_ic);
		        simple.show();
				}
        });
        cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
        });
        
		final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		/** Create an ArrayAdapter using the string array and a default spinner
		 layout*/
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.diagnosis_array, android.R.layout.simple_spinner_item);
		/** Specify the layout to use when the list of choices appears*/
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		/** Apply the adapter to the spinner */
		
		spinner.setAdapter(adapter);
	}
	
}
