package patientActivities;

import java.util.ArrayList;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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
import database.DataSource;

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
		info2.setText("Sexe : " + sex + "\nDate de Naissance : " + birthdate
				+ "\nNo Assurance : " + session.getUser());
		info3.setText("Adresse : " + address);
		info4.setText("No Tel : " + notel + "\nEmail : " + email);

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

		DataSource ds = new DataSource(this);
		ds.open();
		Cursor c = ds.selectWhere(DataSource.TBL_PERSON, "fName", "NoAss = \""
				+ user + "\"");
		firstname = checkAndGet("fName", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "mName", "NoAss = \"" + user
				+ "\"");
		middlename = checkAndGet("mName", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "lName", "NoAss = \"" + user
				+ "\"");
		lastname = checkAndGet("lName", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "bDate", "NoAss = \"" + user
				+ "\"");
		birthdate = checkAndGet("bDate", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "sex", "NoAss = \"" + user
				+ "\"");
		sex = checkAndGet("sex", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "streetNo", "NoAss = \""
				+ user + "\"");
		String streetNo = checkAndGet("streetNo", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "street", "NoAss = \"" + user
				+ "\"");
		String street = checkAndGet("street", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "appt", "NoAss = \"" + user
				+ "\"");
		String appt = checkAndGet("appt", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "city", "NoAss = \"" + user
				+ "\"");
		String city = checkAndGet("city", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "province", "NoAss = \""
				+ user + "\"");
		String province = checkAndGet("province", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "pc", "NoAss = \"" + user
				+ "\"");
		String pc = checkAndGet("pc", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "country", "NoAss = \""
				+ user + "\"");
		String country = checkAndGet("country", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "telno", "NoAss = \"" + user
				+ "\"");
		notel = checkAndGet("telno", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "email", "NoAss = \"" + user
				+ "\"");
		email = checkAndGet("email", c);
		ds.close();
		address = ((appt.equals("")) ? "" : ("Appt. " + appt + " ")) + streetNo
				+ " " + street + ",\n\t" + city + ", " + province + ", "
				+ country + ",\n\t" + pc;
	}

	private String checkAndGet(String s, Cursor c) {
		if (c != null && c.getCount() > 0 && c.moveToFirst())
			return c.getString(c.getColumnIndex(s));
		return "";
	}
}