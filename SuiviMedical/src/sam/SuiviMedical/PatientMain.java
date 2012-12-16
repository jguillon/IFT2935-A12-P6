package sam.SuiviMedical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientMain extends Activity {
	
	Button dossier;
	Button report;
	Button drugs;
	Button skype;
	Button urgence;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientmain);
        
        dossier = (Button) findViewById(R.id.bDossierP);
        report = (Button) findViewById(R.id.bReportP);
        drugs = (Button) findViewById(R.id.bDrugsP);
        skype = (Button) findViewById(R.id.bSkypeP);
        urgence = (Button) findViewById(R.id.bAlertP);
        
        dossier.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent dossier = new Intent(view.getContext(), DossierMain.class);
				startActivity(dossier);
				}
        });
        
        report.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent report = new Intent(view.getContext(), DossierMain.class);
				startActivity(report);
				}
        });
        
        drugs.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent drugs = new Intent(view.getContext(), DossierMain.class);
				startActivity(drugs);
				}
        });
        
        skype.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				/** to do */
				}
        });
        
        urgence.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				/** to do */
				}
        });
    }
}