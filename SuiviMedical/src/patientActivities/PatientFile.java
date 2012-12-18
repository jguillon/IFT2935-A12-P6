package patientActivities;

import java.util.ArrayList;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PatientFile extends Activity {

	TextView info1, info2, info3, info4, op, cl;
	ListView op_eventListView, cl_eventListView;
	ArrayList<String> op_eventList, cl_eventList;
	Adapter adapter;
	Intent i;
	Infos session;
	String noAssurance, firstname, lastname, middlename, birthdate, sex,
			address, notel, email;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);

		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		setInfosPatient(session.getUser());

		info1 = (TextView) findViewById(R.id.info1Patient);
		info2 = (TextView) findViewById(R.id.info2Patient);
		info3 = (TextView) findViewById(R.id.info3Patient);
		info4 = (TextView) findViewById(R.id.info4Patient);
		op = (TextView) findViewById(R.id.textOpenEvent);
		cl = (TextView) findViewById(R.id.textEventClosed);

		info1.setText(firstname + " " + middlename + " " + lastname);
		info2.setText("Sexe : " + sex + "\n" + birthdate + "\n" + noAssurance);
		info3.setText("Adresse : " + address);
		info4.setText("No Tel : " + notel + "\n Email : " + email);

		op_eventListView = (ListView) findViewById(R.id.listEventOpen);
		op_eventListView.setVisibility(View.GONE);
		cl_eventListView = (ListView) findViewById(R.id.listEventClosed);
		cl_eventListView.setVisibility(View.GONE);
		Button addButton = (Button) findViewById(R.id.addEvent);
		addButton.setVisibility(View.GONE);

		op.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (op_eventListView.getVisibility() == View.GONE)
					op_eventListView.setVisibility(View.VISIBLE);
				else
					op_eventListView.setVisibility(View.GONE);
			}
		});

		cl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (cl_eventListView.getVisibility() == View.GONE)
					cl_eventListView.setVisibility(View.VISIBLE);
				else
					cl_eventListView.setVisibility(View.GONE);
			}
		});

		op_eventList = new ArrayList<String>();
		op_eventList.add("Fracture bras");
		op_eventList.add("Chute parachute");
		op_eventList.add("Mal de tête intense");
		// = db.query( <Nom et prénom de tous les patients> );

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, op_eventList);
		op_eventListView.setAdapter((ListAdapter) adapter);

		op_eventListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long itemID) {

				Intent doc = new Intent(view.getContext(), PatientEvent.class);
				doc.putExtra("session", session);
				startActivity(doc);
			}
		});

		cl_eventList = new ArrayList<String>();
		cl_eventList.add("Enflure");
		cl_eventList.add("Rougeurs");
		cl_eventList.add("Plaques rouges");
		// = db.query( <Nom et prénom de tous les patients> );

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, cl_eventList);
		cl_eventListView.setAdapter((ListAdapter) adapter);

		cl_eventListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long itemID) {

				Intent doc = new Intent(view.getContext(), PatientEvent.class);
				startActivity(doc);
			}
		});

		/** Probablement nécessaire */

	}

	/** Need a lot of sql request!! */

	/** Est-ce que c'est ici qu'on peut cliquer pour faire des graphiques? */
	/**
	 * choices.setAdapter((ListAdapter) adapter);
	 * choices.setOnItemClickListener(new OnItemClickListener(){
	 * 
	 * @Override public void onItemClick(AdapterView parent, View v, int pos,
	 *           long id){
	 * 
	 *           }
	 * 
	 *           });
	 */

	public void setInfosPatient(String user) {

		// Cursor c = db.rawQuery("SELECT firstname, lastname, middlename,
		// birthdate, sex, nostreet, street, apt, city, province, pc, country,
		// notel, email
		// FROM PERSON WHERE PERSON.noAssurance = \"" + user "\";")
		// c.moveToFirst()
		noAssurance = user;
		firstname = "Jean"; // c.getString(0)
		lastname = "Tremblay"; // c.getString(1)
		// if(c.getString(2)!=null)
		middlename = "Joseph"; // c.getString(2)
		// else
		// middlename = "";
		birthdate = "10/06/1988"; // c.getDate(3).toString()
		sex = "M"; // c.getString(4)
		address = "45" + "rue" + "DesPins" + ",\n" + "Montréal" + ", "
				+ "Quebec" + ", " + "Canada" + ",\n" + "H7g 5F5"; // etc.
		notel = "514-555-9867";
		email = "jeanTremblay@mymail.com";
	}
}

/*
 * public void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState); setContentView(R.layout.doctoreventlist);
 * 
 * eventListView = (ListView) findViewById(R.id.listEventOpen); eventList = new
 * String[] {"event 1", "event2", "Event 3"}; // = db.query( <Nom et prénom de
 * tous les patients> );
 * 
 * adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
 * eventList); eventListView.setAdapter(adapter);
 * 
 * eventListView.setOnItemClickListener(new OnItemClickListener() {
 * 
 * @Override public void onItemClick(AdapterView<?> arg0, View view, int
 * arg2,long itemID) {
 * 
 * int position = (int) arg0.getSelectedItemId(); Intent doc = new
 * Intent(view.getContext(), PatientEvent.class); startActivity(doc); } }); } }
 */