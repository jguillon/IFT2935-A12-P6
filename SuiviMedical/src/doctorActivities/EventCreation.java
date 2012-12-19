package doctorActivities;

import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventCreation extends Activity {

	TextView title; 
	Button send;
	Button cancel;
	AlertDialog.Builder simple;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);

		title = (TextView) findViewById(R.id.titleDesc);
		title.setText("Nouvel évenement");
		
		send = (Button) findViewById(R.id.bsendReport);
		cancel = (Button) findViewById(R.id.bCancelReport);
		simple = new AlertDialog.Builder(this);
		
		
        send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				simple.setMessage("L'évènement a été ajouté au dossier.");
		        simple.setCancelable(false);
		        simple.setPositiveButton("ok", new DialogInterface.OnClickListener() {
		        	 @Override
					public void onClick(DialogInterface dialog, int id) {
		    				finish();
		        	 }
		        	 });
		        
		        simple.create();
		        simple.setTitle("Confirmation");
		        simple.setIcon(R.drawable.patient_file);
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