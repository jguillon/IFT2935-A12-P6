package sam.SuiviMedical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Page listant les �v�nements (actifs ou non) du patient s�lectionn� � la
 * page pr�c�dente.
 * @author J�r�my
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
		//On r�cup�re l'intent qui a lanc� cette activit�.
		i = getIntent();
		//On va chercher dans ses extras, le nom qu'on avait stock�.
		pName = i.getStringExtra("sam.DocotPatientEventList.patientName");
		oELView = (ListView) findViewById(R.id.listEventOpen);
		cELView = (ListView) findViewById(R.id.listEventClosed);
		cEList = new String[] {"Bronchite", "Cancer du sein", "Angine"};
					 //  = db.query( <Ev�nements ferm�s de patientName> );
		oEList = new String[] {"Alzheimer", "Fracture du bras", "Gastro","Hypertension"};
				   //  = db.query( <Ev�nements ouverts de patientName> );
		oELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, oEList);
		cELAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cEList);
		//==========Param�trisations==========
		cELView.setAdapter(cELAdapter);
		oELView.setAdapter(oELAdapter);
	}
}
