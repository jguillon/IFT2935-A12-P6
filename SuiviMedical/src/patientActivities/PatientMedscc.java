package patientActivities;

import database.DataSource;
import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PatientMedscc extends Activity {
	
	Intent i;
	Infos session;
	DataSource ds;
	
	TextView name;
	TextView freq;
	TextView qte;
	
	Button commander;
	Button confirmer;
	
	AlertDialog.Builder simple;
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugcc); 
        i = getIntent();
        session = (Infos) i.getSerializableExtra("session");
        ds = new DataSource(this);

        
        simple = new AlertDialog.Builder(this);
        
        commander = (Button) findViewById(R.id.bCommander);
        confirmer = (Button) findViewById(R.id.bConfirmer);
        name = (TextView) findViewById(R.id.drugNamecc);
        freq = (TextView) findViewById(R.id.frequencycc);
        qte = (TextView) findViewById(R.id.quantitycc);
        setInfosMed();
                
        commander.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				simple.setMessage("Une dose de " + name + " a été commandé à votre pharmacie préférée.");
		        simple.setCancelable(false);
		        simple.setPositiveButton("ok", new DialogInterface.OnClickListener() {
		        	 @Override
					public void onClick(DialogInterface dialog, int id) {
		        		 	Infos.setMedReminder(false);
		    				finish();
		        	 }
		        	 });
		        
		        simple.create();
		        simple.setTitle("Confirmation");
		        simple.setIcon(R.drawable.patient_meds);
		        simple.show();
				}
        });
        
        confirmer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				simple.setMessage("Votre médecin a été avisé de la prise de votre médicament. Merci.");
		        simple.setCancelable(false);
		        simple.setPositiveButton("ok", new DialogInterface.OnClickListener() {
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
        
	}
    
    public void setInfosMed(){
    	ds.open();
    	Cursor c = ds.rawQuery("SELECT PRESCRIPTION.DrugName, PRESCRIPTION.Frequency, PRESCRIPTION.Qty, PRESCRIPTION.DoctorNo " +
    			"FROM PRESCRIPTION WHERE PRESCRIPTION.PrescriptionNo = \"" + session.getActiveMed() + "\"");
    	c.moveToFirst();
    	Cursor c2 = ds.rawQuery("SELECT NoAss, Speciality FROM DOCTOR WHERE DOCTOR.DoctorNo = \"" + c.getString(3) + "\"");
    	c2.moveToFirst();
    	Cursor c3 = ds.rawQuery("SELECT fName, lName FROM PERSON WHERE PERSON.NoAss = \"" + c2.getString(0) + "\"");
    	c3.moveToFirst();
    	name.setText(c.getString(0) + "\nMédecin : Dr. " + c3.getString(0) + " " + c3.getString(1) + ", " + c2.getString(1));
    	freq.setText(c.getString(1));
    	
    	qte.setText(c.getString(2));
    }
}
