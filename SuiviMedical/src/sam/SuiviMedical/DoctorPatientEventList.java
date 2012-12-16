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
	private String patientName;
	private String[] openEventsList, closedEventsList;
	private ListView openEventsListView, closedEventsListView;
	private ArrayAdapter<String> openEventsListAdapter, closedEventsListAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
		
		//On récupère l'intent qui a lancé cette activité.
		i = getIntent();
		//On va chercher dans ses extras, le nom qu'on avait stocké.
		patientName = i.getStringExtra("sam.DocotPatientEventList.patientName");
		openEventsListView = (ListView) findViewById(R.id.listEventOpen);
		closedEventsListView = (ListView) findViewById(R.id.listEventClosed);
		closedEventsList = new String[] {"Bronchite", "Cancer du sein"};
					 //  = db.query( <Evènements fermés de patientName> );
		openEventsList = new String[] {"Amzheimer", "Fracture du bras"};
				   //  = db.query( <Evènements ouverts de patientName> );
		openEventsListAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, openEventsList);
		closedEventsListAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, closedEventsList);
	}
}
