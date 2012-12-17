package doctorActivities;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import sam.SuiviMedical.R.id;
import sam.SuiviMedical.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Page listant les �v�nements (actifs ou non) du patient s�lectionn� � la
 * page pr�c�dente.
 * @author J�r�my
 *
 */
public class PatientEventsList extends Activity {
	
	private Intent i;
	private String pName;									//Patient Name
	private String[] oEList, cEList;						//Open Events List, Closed Events List
	private ListView oELView, cELView;						//Open Events ListView, Closed Events ListView
	private TextView i1TView, i2TView, i3TView;				//Info n TextView
	private ArrayAdapter<String> oELAdapter, cELAdapter; 	//Open Events List Adapter, Closed Events List Adapter
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
		
		oELView = (ListView) findViewById(R.id.listEventOpen);
		cELView = (ListView) findViewById(R.id.listEventClosed);
		i1TView = (TextView) findViewById(R.id.info1Patient);
		i2TView = (TextView) findViewById(R.id.info2Patient);
		i3TView = (TextView) findViewById(R.id.info3Patient);
		//==========Initialisations==========
		//On r�cup�re l'intent qui a lanc� cette activit�.
		i = getIntent();
		//On va chercher dans ses extras, le nom qu'on avait stock�.
		pName = i.getStringExtra("sam.DocotPatientEventList.patientName");
		cEList = new String[] {"Bronchite", "Cancer du sein", "Angine"};
					 //  = db.query( <Ev�nements ferm�s de patientName> );
		oEList = new String[] {"Alzheimer", "Fracture du bras", "Gastro","Hypertension"};
				   //  = db.query( <Ev�nements ouverts de patientName> );
		oELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, oEList);
		cELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cEList);
		//==========Param�trisations==========
		cELView.setAdapter(cELAdapter);
		oELView.setAdapter(oELAdapter);
		i1TView.setText(Infos.getActivePatient());
		i2TView.setText("Adresse");
		i3TView.setText("N� de tel");
	}
}
