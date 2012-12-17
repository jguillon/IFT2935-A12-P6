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
import android.widget.ListView;

/**
 * Page d'accueil de l'interface du docteur.
 * @author J�r�my
 *
 */
public class PatientsList extends Activity {
	
	private String[] patientList;
	private ListView patientListView;
	private ArrayAdapter<String> adapter;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctormainview);
        
        patientListView = (ListView) findViewById(R.id.listPatient);
        //==========Initialisations==========
        patientList = new String[] {"Robert Duclou", "Alicia Partu", "Henri Dufour"};
        		//  = db.query( <Nom et pr�nom de tous les patients> );
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, patientList);
        //==========Param�trisation===========
        patientListView.setAdapter(adapter);
        patientListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
				Intent doc = new Intent(view.getContext(), PatientEventsList.class);
				Infos session = new Infos("Patrice Medoc","doc");
				session.setActivePatient(patientList[pos]);
				doc.putExtra("session", session);
				startActivity(doc);
			}        	
        });
	}
}