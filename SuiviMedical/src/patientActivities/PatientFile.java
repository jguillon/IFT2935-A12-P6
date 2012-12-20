package patientActivities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import database.DataSource;
import doctorActivities.PatientEventModification;

public class PatientFile extends Activity implements OnItemClickListener {

	DataSource ds;
	TextView info1, info2, info3, info4, op, cl;
	ListView openEventsLV, closedEventsLV;
	List<HashMap<String, String>> openEventsL, closedEventsL;
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
		ds = new DataSource(this);
		if (session.getUserPermission().equals("Doctor"))
			setInfosPatient(session.getActivePatient());
		else
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

		if (session.getUserPermission().equals("Doctor"))
			setLists(session.getActivePatient());
		else
			setLists(session.getUser());

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

	}

	@Override
	public void onResume() {
		super.onResume();
		this.setLists(session.getUser());
	}

	public void setInfosPatient(String user) {

		ds.open();
		Cursor c = ds.selectWhere(DataSource.TBL_PERSON, "fName", "NoAss = \""
				+ user + "\"");
		firstname = checkAndGet("fName", c);
		c = ds.rawQuery("SELECT mName FROM PERSON WHERE NoAss = \"" + user
				+ "\"");
		// c = ds.selectWhere(DataSource.TBL_PERSON, "mName", "NoAss = \"" +
		// user
		// + "\"");
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

	@SuppressLint({ "UseSparseArrays", "UseSparseArrays" })
	public void setLists(String user) {
		HashMap<String, String> hm;
		ds.open();

		Cursor c = ds
				.selectWhere(
						DataSource.TBL_EVENT,
						"Descr, EventNo",
						"EVENT.CloseDate = \"NULL\" AND EVENT.DossierNo = (SELECT DossierNo FROM DOSSIER WHERE DOSSIER.NoAss = \""
								+ user + "\")");
		openEventsL = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			hm = new HashMap<String, String>();
			hm.put("EventNo", c.getString(1));
			hm.put("Description", c.getString(0));
			openEventsL.add(hm);

		}

		c = ds.selectWhere(
				DataSource.TBL_EVENT,
				"Descr, EventNo",
				"EVENT.CloseDate != \"NULL\" AND EVENT.DossierNo = (SELECT DossierNo FROM DOSSIER WHERE DOSSIER.NoAss = \""
						+ user + "\")");
		closedEventsL = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			hm = new HashMap<String, String>();
			hm.put("EventNo", c.getString(1));
			hm.put("Description", c.getString(0));
			closedEventsL.add(hm);
		}

		ds.close();

		String[] lists = new String[] { "Description" };
		int[] listi = new int[] { R.id.affiche };

		adapter = new SimpleAdapter(this, openEventsL, R.layout.textview,
				lists, listi);
		openEventsLV.setAdapter((ListAdapter) adapter);
		openEventsLV.setOnItemClickListener(this);

		adapter = new SimpleAdapter(this, closedEventsL, R.layout.textview,
				lists, listi);
		closedEventsLV.setAdapter((ListAdapter) adapter);
		closedEventsLV.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		if (parent == openEventsLV) {
			session.setActiveEvent(openEventsL.get(pos).get("EventNo"));
			if (session.getUserPermission().equals("Doctor"))
				i = new Intent(view.getContext(),
						PatientEventModification.class);
			else
				i = new Intent(view.getContext(), PatientEvent.class);
			i.putExtra("session", session);
			startActivity(i);
			// Toast.makeText(PatientFile.this, "pos :" + pos + " EventNo : " +
			// openEventsL.get(pos).get("EventNo") + " active event : " +
			// session.getActiveEvent(), Toast.LENGTH_LONG).show();
		} else if (parent == closedEventsLV) {
			session.setActiveEvent(closedEventsL.get(pos).get("EventNo"));
			if (session.getUserPermission().equals("Doctor"))
				i = new Intent(view.getContext(),
						PatientEventModification.class);
			else
				i = new Intent(view.getContext(), PatientEvent.class);
			i.putExtra("session", session);
			startActivity(i);
		}
	}
}