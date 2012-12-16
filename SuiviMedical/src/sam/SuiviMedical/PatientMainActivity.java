package sam.SuiviMedical;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientMainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientmain);
        
        Button dossier = (Button) findViewById(R.id.bDossierP);
        Button envoiInfo = (Button) findViewById(R.id.bReportP);
        Button meds = (Button) findViewById(R.id.bDrugsP);
        Button skype = (Button) findViewById(R.id.bSkypeP);
        
        dossier.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					Intent doc = new Intent(view.getContext(), PatientFile.class);
					startActivity(doc);
				}});
        envoiInfo.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					Intent doc = new Intent(view.getContext(), PatientSendInfos.class);
					startActivity(doc);
				}});
        meds.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					Intent doc = new Intent(view.getContext(), PatientMeds.class);
					startActivity(doc);
				}});
        skype.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					Intent doc = new Intent(view.getContext(), PatientSkype.class);
					startActivity(doc);
				}});
    }

}
