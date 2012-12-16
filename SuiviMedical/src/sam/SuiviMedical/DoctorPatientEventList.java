package sam.SuiviMedical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Page listant les évènements (actifs ou non) du patient sélectionné à la
 * page précédente.
 * @author Jérémy
 *
 */
public class DoctorPatientEventList extends Activity {
	
	private Intent i;
	private String pName;					//Patient Name
	private String[] oEList, cEList;
	private ListView oELView, cELView;
	private ArrayAdapter<String> oELAdapter, cELAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
		//==========Initialisations==========
		//On récupère l'intent qui a lancé cette activité.
		i = getIntent();
		//On va chercher dans ses extras, le nom qu'on avait stocké.
		pName = i.getStringExtra("sam.DocotPatientEventList.patientName");
		oELView = (ListView) findViewById(R.id.listEventOpen);
		cELView = (ListView) findViewById(R.id.listEventClosed);
		cEList = new String[] {"Bronchite", "Cancer du sein", "Angine"};
					 //  = db.query( <Evènements fermés de patientName> );
		oEList = new String[] {"Alzheimer", "Fracture du bras", "Gastro","Hypertension"};
				   //  = db.query( <Evènements ouverts de patientName> );
		oELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, oEList);
		cELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cEList);
		//==========Paramétrisations==========
		cELView.setAdapter(cELAdapter);
		oELView.setAdapter(oELAdapter);
	}
}
