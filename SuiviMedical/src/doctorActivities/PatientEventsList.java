package doctorActivities;

import java.util.ArrayList;

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
import android.widget.TextView;

/**
 * Page listant les évènements (actifs ou non) du patient sélectionné à la
 * page précédente.
 * @author Jérémy
 *
 */
public class PatientEventsList extends Activity implements OnItemClickListener {
	
	private Intent i;
	private ArrayList<String> openEventsL, closedEventsL;
	private ListView openEventsLV, closedEventsLV;
	private TextView info1TV, info2TV, info3TV;
	private ArrayAdapter<String> openEventsLA, closedEventsLA; 
	private Infos session;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
		
		openEventsLV 	= (ListView) findViewById(R.id.listEventOpen);
		closedEventsLV 	= (ListView) findViewById(R.id.listEventClosed);
		info1TV 		= (TextView) findViewById(R.id.info1Patient);
		info2TV 		= (TextView) findViewById(R.id.info2Patient);
		info3TV 		= (TextView) findViewById(R.id.info3Patient);

		i 				= getIntent();
		session 		= (Infos) i.getSerializableExtra("session");
		openEventsLA 	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, openEventsL);
		closedEventsLA 	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, closedEventsL);

		closedEventsLV.setAdapter(closedEventsLA);
		openEventsLV.setAdapter(openEventsLA);
		closedEventsLV.setOnItemClickListener(this);
		openEventsLV.setOnItemClickListener(this);
		info1TV.setText(session.getActivePatient());
		info2TV.setText("Adresse");
		info3TV.setText("N° de tel");
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		if(parent == openEventsLV) {
			session.setActiveEvent(openEventsL.get(pos));
			i = new Intent(view.getContext(), PatientEventModification.class);
			startActivity(i);
		} else if(parent == closedEventsLV) {
			session.setActiveEvent(closedEventsL.get(pos));
			i = new Intent(view.getContext(), PatientEventModification.class);
			startActivity(i);	
		}
	}
}
