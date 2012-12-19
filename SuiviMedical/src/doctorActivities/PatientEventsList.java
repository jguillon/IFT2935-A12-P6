package doctorActivities;

import patientActivities.PatientSendInfos;
import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
	private String[] openEventsL, closedEventsL;
	private ListView openEventsLV, closedEventsLV;
	private TextView info1TV, info2TV, info3TV, op, cl;
	private ArrayAdapter<String> openEventsLA, closedEventsLA; 
	private Infos session;
	private Button addEvent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
		
		openEventsLV 	= (ListView) findViewById(R.id.listEventOpen);
		closedEventsLV 	= (ListView) findViewById(R.id.listEventClosed);
		info1TV 		= (TextView) findViewById(R.id.info1Patient);
		info2TV 		= (TextView) findViewById(R.id.info2Patient);
		info3TV 		= (TextView) findViewById(R.id.info3Patient);
		op 				= (TextView) findViewById(R.id.textOpenEvent);
		cl				= (TextView) findViewById(R.id.textEventClosed);
		addEvent		= (Button)   findViewById(R.id.addEvent);
		

		i 				= getIntent();
		session 		= (Infos) i.getSerializableExtra("session");
		closedEventsL 	= new String[] {"Bronchite", "Cancer du sein", "Angine"};
		openEventsL 	= new String[] {"Alzheimer", "Fracture du bras", "Gastro","Hypertension"};
		openEventsLA 	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, openEventsL);
		closedEventsLA 	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, closedEventsL);
		
		closedEventsLV.setAdapter(closedEventsLA);
		openEventsLV.setAdapter(openEventsLA);
		closedEventsLV.setOnItemClickListener(this);
		openEventsLV.setOnItemClickListener(this);
		closedEventsLV.setVisibility(ListView.GONE);
		openEventsLV.setVisibility(ListView.GONE);
		info1TV.setText(session.getActivePatient());
		info2TV.setText("Adresse");
		info3TV.setText("N° de tel");
		
		op.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (openEventsLV.getVisibility() == View.GONE)
					openEventsLV.setVisibility(View.VISIBLE);
				else
					openEventsLV.setVisibility(View.GONE);
			}
		});

		cl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (closedEventsLV.getVisibility() == View.GONE)
					closedEventsLV.setVisibility(View.VISIBLE);
				else
					closedEventsLV.setVisibility(View.GONE);
			}
		});
		
		addEvent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent newEvent = new Intent(view.getContext(), EventCreation.class);
				newEvent.putExtra("session", session);
				startActivity(newEvent);
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		if(parent == openEventsLV) {
			session.setActiveEvent(openEventsL[pos]);
			i = new Intent(view.getContext(), PatientEventModification.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if(parent == closedEventsLV) {
			session.setActiveEvent(closedEventsL[pos]);
			i = new Intent(view.getContext(), EventVisualization.class);
			i.putExtra("session", session);
			startActivity(i);	
		}
	}
	
}
