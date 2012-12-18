package patientActivities;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class PatientMainActivity extends Activity {
	Intent i;
	Infos session;
	Button dossier, report, drugs, skype, urgence;
	AlertDialog.Builder simple;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientmain);
        i = getIntent();
        
        session = (Infos) i.getSerializableExtra("session");
        dossier = (Button) findViewById(R.id.bDossierP);
        report 	= (Button) findViewById(R.id.bReportP);
        drugs 	= (Button) findViewById(R.id.bDrugsP);
        skype 	= (Button) findViewById(R.id.bSkypeP);
        urgence = (Button) findViewById(R.id.bAlertP);
        simple = new AlertDialog.Builder(this);
        
        
        dossier.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent dossier = new Intent(view.getContext(), PatientFile.class);
				dossier.putExtra("session", session);
				startActivity(dossier);
				}
        });
        
        report.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent report = new Intent(view.getContext(), PatientSendInfos.class);
				report.putExtra("session", session);
				startActivity(report);
				}
        });
        
        drugs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent drugs = new Intent(view.getContext(), PatientMeds.class);
				drugs.putExtra("session", session);
				startActivity(drugs);
				}
        });
        
        skype.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent skype = new Intent(view.getContext(), PatientSkype.class);
				skype.putExtra("session", session);
				startActivity(skype);
				}
        });
        
        urgence.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				simple.setMessage("Avez-vous besoin d'assistance immédiate ?");
		        simple.setCancelable(false);
		        simple.setPositiveButton("Oui, envoyez-moi de l'aide d'urgence.", new DialogInterface.OnClickListener() {
		        	 @Override
					public void onClick(DialogInterface dialog, int id) {
		        		 	dialog.cancel();
		        	        confirmationAmbulance();
		        	 }
		        	 });
		        simple.setNegativeButton("Non, j'ai accroché le bouton.", new DialogInterface.OnClickListener() {
		        	        @Override
							public void onClick(DialogInterface dialog, int id) {
		        	        dialog.cancel();
		        	    }
		       });
		        simple.create();
		        simple.setTitle("URGENCE");
		        simple.setIcon(R.drawable.ambulance_ic);
		        simple.show();
			}
        });
    }
    
    @Override
	public void onResume(){
    	super.onResume();
    	if(Infos.getMedReminder())
    		alertMeds();
    }
    
    public void alertMeds(){
        
        
        simple.setMessage("Avez-vous pris vos médicaments ?");
        simple.setCancelable(false);
        simple.setPositiveButton("Accèder à la page de confirmation", new DialogInterface.OnClickListener() {
        	 @Override
			public void onClick(DialogInterface dialog, int id) {
    				Intent doc = new Intent(((Dialog) dialog).getContext(), PatientMeds.class);
    				startActivity(doc);
    				Infos.setMedReminder(false);
        	        dialog.cancel();
        	 }
        	 });
        simple.setNegativeButton("Me rappeler plus tard", new DialogInterface.OnClickListener() {
        	        @Override
					public void onClick(DialogInterface dialog, int id) {
        	        //  Action for 'NO' Button
        	        Infos.setMedReminder(true);
        	        dialog.cancel();
        	    }
       });
        simple.create();
        simple.setTitle("Rappel");
        simple.setIcon(R.drawable.patient_meds);
        simple.show();
    }
    
    public void confirmationAmbulance(){
    	AlertDialog.Builder confirm =  new AlertDialog.Builder(this);
    	confirm.setMessage("Restez calme, une ambulance s'en vient");
        confirm.setCancelable(false);
        confirm.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        	 @Override
			public void onClick(DialogInterface dialog, int id) {
        	        dialog.cancel();
        	 }
        	 });
        confirm.create();
        confirm.setTitle("Confirmation");
        confirm.setIcon(R.drawable.ambulance_ic);
        confirm.show();
    }
}
