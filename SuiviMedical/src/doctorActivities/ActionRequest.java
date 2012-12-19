package doctorActivities;

import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActionRequest extends Activity implements OnClickListener {

	AlertDialog.Builder simple;
	Button sang;
	Button urine;
	Button xray;
	Button biopsy;
	Button glucose;
	Button psy;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoractions);
		
		simple = new AlertDialog.Builder(this);
		sang = (Button) findViewById(R.id.blood);
		urine = (Button) findViewById(R.id.urinalysis);
		xray = (Button) findViewById(R.id.x_ray);
		biopsy = (Button) findViewById(R.id.biopsy);
		glucose = (Button) findViewById(R.id.glucose);
		psy = (Button) findViewById(R.id.psy);
		
		sang.setOnClickListener(this);
		urine.setOnClickListener(this);
		xray.setOnClickListener(this);
		biopsy.setOnClickListener(this);
		glucose.setOnClickListener(this);
		psy.setOnClickListener(this);

	}
	
	@Override
	public void onClick(View view) {
		if (view == sang) {
			dialogQuestion("prise de sang");
		} else if (view == urine) {
			dialogQuestion("analyse d'urine");
		} else if (view == biopsy) {
			dialogQuestion("biopsie");
		} else if (view == xray) {
			dialogQuestion("radiographie");
		} else if (view == psy) {
			dialogQuestion("évaluation psychologique");
		} else if (view == glucose) {
			dialogQuestion("prise de taux de glucose");
		}


	}

	public void dialogQuestion(String action){
		
		simple.setMessage("Êtes-vous certain de vouloir demander un(e) "+ action+" pour ce dossier ?");
        simple.setCancelable(false);
        simple.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
        	 @Override
			public void onClick(DialogInterface dialog, int id) {
        		 	dialogConfirmation();
    				dialog.cancel();
        	 }
        	 });
        simple.setNegativeButton("Non", new DialogInterface.OnClickListener() {
        	 @Override
			public void onClick(DialogInterface dialog, int id) {
    				dialog.cancel();
        	 }
        	 });
        simple.create();
        simple.setTitle("Confirmation");
        simple.setIcon(R.drawable.patient_file);
        simple.show();
	}
	
	public void dialogConfirmation(){
		
		AlertDialog.Builder  simple1 = new AlertDialog.Builder(this);
		simple1.setMessage("La demande d'action a été ajoutée au dossier.");
        simple1.setCancelable(false);
        simple1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        	 @Override
			public void onClick(DialogInterface dialog, int id) {
        		 
    				finish();
        	 }
        	 });
        simple1.create();
        simple1.setTitle("Confirmation");
        simple1.setIcon(R.drawable.patient_file);
        simple1.show();
	}
}
