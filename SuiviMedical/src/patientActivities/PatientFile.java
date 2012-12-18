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
import doctorActivities.PatientEventModification;

public class PatientFile extends Activity implements OnItemClickListener {

	TextView info1, info2, info3, info4, op, cl;
	ListView openEventsLV, closedEventsLV;
	ArrayList<String> openEventsL, closedEventsL;
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

		openEventsLV = (ListView) findViewById(R.id.listEventOpen);
		openEventsLV.setVisibility(View.GONE);
		closedEventsLV = (ListView) findViewById(R.id.listEventClosed);
		closedEventsLV.setVisibility(View.GONE);
		Button addButton = (Button) findViewById(R.id.addEvent);
		addButton.setVisibility(View.GONE);

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

		openEventsL = new ArrayList<String>();
		openEventsL.add("Fracture bras");
		openEventsL.add("Chute parachute");
		openEventsL.add("Mal de tête intense");

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, openEventsL);
		openEventsLV.setAdapter((ListAdapter) adapter);
		openEventsLV.setOnItemClickListener(this);

		closedEventsL = new ArrayList<String>();
		closedEventsL.add("Enflure");
		closedEventsL.add("Rougeurs");
		closedEventsL.add("Plaques rouges");

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, closedEventsL);
		closedEventsLV.setAdapter((ListAdapter) adapter);
		closedEventsLV.setOnItemClickListener(this);

	}

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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		if(parent == openEventsLV) {
			session.setActiveEvent(openEventsL.get(pos));
			i = new Intent(view.getContext(), PatientEvent.class);
			startActivity(i);
		} else if(parent == closedEventsLV) {
			session.setActiveEvent(closedEventsL.get(pos));
			i = new Intent(view.getContext(), PatientEvent.class);
			startActivity(i);	
		}
	}
}