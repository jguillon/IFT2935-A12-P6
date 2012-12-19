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
import android.widget.TextView;

public class DoctorMedsc extends Activity {
	
	Intent i;
	Infos session;
	
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

        
        simple = new AlertDialog.Builder(this);
        
        commander = (Button) findViewById(R.id.bCommander);
        confirmer = (Button) findViewById(R.id.bConfirmer);
        confirmer.setVisibility(Button.GONE);
        name = (TextView) findViewById(R.id.drugNamecc);
        freq = (TextView) findViewById(R.id.frequencycc);
        qte = (TextView) findViewById(R.id.quantitycc);
        setInfosMed();
                
        commander.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				simple.setMessage("Une dose de " + name + " a été commandé à la pharmacie du patient.");
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
        
	}
    
    public void setInfosMed(){
    	//on fait une recherche dans la base de données à l'aide de session
    	name.setText("Advil");
    	freq.setText("Une fois par jour");
    	qte.setText("200 mg");
    }
}