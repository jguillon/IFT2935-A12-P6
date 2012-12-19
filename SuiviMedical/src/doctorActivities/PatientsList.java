package doctorActivities;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View; 
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Page d'accueil de l'interface du docteur.
 * @author Jérémy
 *
 */
public class PatientsList extends Activity implements OnItemClickListener {
	
	private String[] patientsL;
	private ListView patientsLV;
	private ArrayAdapter<String> patientsLA;
	private Button addPatient;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctormainview);
        
        patientsLV 	= (ListView) findViewById(R.id.listPatient);
        addPatient		= (Button)	 findViewById(R.id.addPatient);
		addPatient.setVisibility(Button.GONE); //notre application ne permet pas d'ajouter de nouveaux patients.
        
        patientsL 	= new String[] {"Robert Duclou", "Alicia Partu", "Henri Dufour"};
        patientsLA 	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, patientsL);
     
        patientsLV.setAdapter(patientsLA);
        patientsLV.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		Intent i = new Intent(view.getContext(), PatientEventsList.class);
		Infos session = new Infos("Patrice Medoc","doc");
		session.setActivePatient(patientsL[pos]);
		i.putExtra("session", session);
		startActivity(i);
	}
	
}