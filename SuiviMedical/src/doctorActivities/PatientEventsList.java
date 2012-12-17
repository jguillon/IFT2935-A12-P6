package doctorActivities;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import sam.SuiviMedical.R.id;
import sam.SuiviMedical.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Page listant les évènements (actifs ou non) du patient sélectionné à la
 * page précédente.
 * @author Jérémy
 *
 */
public class PatientEventsList extends Activity implements OnItemClickListener {
	
	private Intent i;
	private String[] oEList, cEList;						//Open Events List, Closed Events List
	private ListView oELView, cELView;						//Open Events ListView, Closed Events ListView
	private TextView i1TView, i2TView, i3TView;				//Info n TextView
	private ArrayAdapter<String> oELAdapter, cELAdapter; 	//Open Events List Adapter, Closed Events List Adapter
	private Infos session;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
		
		oELView = (ListView) findViewById(R.id.listEventOpen);
		cELView = (ListView) findViewById(R.id.listEventClosed);
		i1TView = (TextView) findViewById(R.id.info1Patient);
		i2TView = (TextView) findViewById(R.id.info2Patient);
		i3TView = (TextView) findViewById(R.id.info3Patient);
		//==========Initialisations==========
		//On récupère l'intent qui a lancé cette activité.
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		cEList = new String[] {"Bronchite", "Cancer du sein", "Angine"};
					 //  = db.query( <Evènements fermés de patientName> );
		oEList = new String[] {"Alzheimer", "Fracture du bras", "Gastro","Hypertension"};
				   //  = db.query( <Evènements ouverts de patientName> );
		oELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, oEList);
		cELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cEList);
		//==========Paramétrisations==========
		cELView.setAdapter(cELAdapter);
		oELView.setAdapter(oELAdapter);
		cELView.setOnItemClickListener(this);
		oELView.setOnItemClickListener(this);
		i1TView.setText(session.getActivePatient());
		i2TView.setText("Adresse");
		i3TView.setText("N° de tel");
	}

	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		if(parent == oELView) {
			session.setActiveEvent(oEList[pos]);
			i = new Intent(view.getContext(), PatientEventModification.class);
			startActivity(i);
		} else if(parent == cELView) {
			session.setActiveEvent(cEList[pos]);
			i = new Intent(view.getContext(), PatientEventModification.class);
			startActivity(i);	
		}
	}
}
