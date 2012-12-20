package doctorActivities;

import java.util.ArrayList;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import database.DataSource;

/**
 * Page listant les évènements (actifs ou non) du patient sélectionné à la page
 * précédente.
 * 
 * @author Jérémy
 * 
 */
public class PatientEventsList extends Activity implements OnItemClickListener,
		OnClickListener {

	private Intent i;
	private ArrayList<String> openEventsL, closedEventsL;
	private ListView openEventsLV, closedEventsLV;
	private TextView info1TV, info2TV, info3TV, info4TV, op, cl;
	private ArrayAdapter<String> openEventsLA, closedEventsLA;
	private Infos session;
	private Button addEvent;
	// TODO private Button showStatus;
	private String firstname, lastname, middlename, birthdate, sex, address,
			notel, email;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);

		openEventsLV = (ListView) findViewById(R.id.listEventOpen);
		closedEventsLV = (ListView) findViewById(R.id.listEventClosed);
		info1TV = (TextView) findViewById(R.id.info1Patient);
		info2TV = (TextView) findViewById(R.id.info2Patient);
		info3TV = (TextView) findViewById(R.id.info3Patient);
		info4TV = (TextView) findViewById(R.id.info4Patient);
		op = (TextView) findViewById(R.id.textOpenEvent);
		cl = (TextView) findViewById(R.id.textEventClosed);
		addEvent = (Button) findViewById(R.id.addEvent);
		// TODO showStatus = (Button) findViewById(R.id.);

		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		closedEventsL = new ArrayList<String>();
		openEventsL = new ArrayList<String>();
		openEventsLA = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, openEventsL);
		closedEventsLA = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, closedEventsL);

		setInfosPatient(session.getActivePatient());
		setPatientsList(session.getActivePatient());
		closedEventsLV.setAdapter(closedEventsLA);
		openEventsLV.setAdapter(openEventsLA);
		closedEventsLV.setOnItemClickListener(this);
		openEventsLV.setOnItemClickListener(this);
		op.setOnClickListener(this);
		cl.setOnClickListener(this);
		addEvent.setOnClickListener(this);
		// TODO showStatus.setOnClickListener(this);
		closedEventsLV.setVisibility(View.GONE);
		openEventsLV.setVisibility(View.GONE);
		info1TV.setText(firstname + " " + middlename + " " + lastname);
		info2TV.setText("Sexe : " + sex + "\nDate de Naissance : " + birthdate
				+ "\nNo Assurance : " + session.getUser());
		info3TV.setText("Adresse : " + address);
		info4TV.setText("No Tel : " + notel + "\nEmail : " + email);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		if (parent == openEventsLV) {
			session.setActiveEvent(openEventsL.get(pos));
			i = new Intent(view.getContext(), PatientEventModification.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (parent == closedEventsLV) {
			session.setActiveEvent(closedEventsL.get(pos));
			i = new Intent(view.getContext(), EventVisualization.class);
			i.putExtra("session", session);
			startActivity(i);
		}
	}

	public void setInfosPatient(String user) {

		DataSource ds = new DataSource(this);
		ds.open();
		Cursor c = ds.selectWhere(DataSource.TBL_PERSON, "fName", "NoAss = \""
				+ user + "\"");
		firstname = checkAndGetFirst("fName", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "mName", "NoAss = \"" + user
				+ "\"");
		middlename = checkAndGetFirst("mName", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "lName", "NoAss = \"" + user
				+ "\"");
		lastname = checkAndGetFirst("lName", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "bDate", "NoAss = \"" + user
				+ "\"");
		birthdate = checkAndGetFirst("bDate", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "sex", "NoAss = \"" + user
				+ "\"");
		sex = checkAndGetFirst("sex", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "streetNo", "NoAss = \""
				+ user + "\"");
		String streetNo = checkAndGetFirst("streetNo", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "street", "NoAss = \"" + user
				+ "\"");
		String street = checkAndGetFirst("street", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "appt", "NoAss = \"" + user
				+ "\"");
		String appt = checkAndGetFirst("appt", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "city", "NoAss = \"" + user
				+ "\"");
		String city = checkAndGetFirst("city", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "province", "NoAss = \""
				+ user + "\"");
		String province = checkAndGetFirst("province", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "pc", "NoAss = \"" + user
				+ "\"");
		String pc = checkAndGetFirst("pc", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "country", "NoAss = \""
				+ user + "\"");
		String country = checkAndGetFirst("country", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "telno", "NoAss = \"" + user
				+ "\"");
		notel = checkAndGetFirst("telno", c);
		c = ds.selectWhere(DataSource.TBL_PERSON, "email", "NoAss = \"" + user
				+ "\"");
		email = checkAndGetFirst("email", c);
		ds.close();
		address = ((appt.equals("")) ? "" : ("Appt. " + appt + " ")) + streetNo
				+ " " + street + ",\n\t" + city + ", " + province + ", "
				+ country + ",\n\t" + pc;
	}

	private void setPatientsList(String patient) {
		DataSource ds = new DataSource(this);
		ds.open();
		Cursor c = ds.selectWhere(DataSource.TBL_DOSSIER, "DossierNo",
				"NoAss = \"" + patient + "\"");
		String noDossier = checkAndGetFirst("DossierNo", c);
		c = ds.selectWhere(DataSource.TBL_EVENT, "Descr, CloseDate",
				"DossierNo = \"" + noDossier + "\"");
		if (c != null && c.getCount() > 0 && c.moveToFirst()) {
			for (int i = 0; i < c.getCount(); i++) {
				if (c.getString(c.getColumnIndex("CloseDate")) == "")
					openEventsL.add(c.getString(c.getColumnIndex("Descr")));
				else
					closedEventsL.add(c.getString(c.getColumnIndex("Descr")));
				c.moveToNext();
			}
		} else {
			System.err.println("Aucun Event n'a été trouvé.");
		}
		ds.close();
	}

	private String checkAndGetFirst(String s, Cursor c) {
		if (c != null && c.getCount() > 0 && c.moveToFirst())
			return c.getString(c.getColumnIndex(s));
		return "";
	}

	@Override
	public void onClick(View v) {
		if (v == addEvent) {
			i = new Intent(v.getContext(), EventCreation.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (v == op) {
			if (openEventsLV.getVisibility() == View.GONE)
				openEventsLV.setVisibility(View.VISIBLE);
			else
				openEventsLV.setVisibility(View.GONE);
		} else if (v == cl) {
			if (closedEventsLV.getVisibility() == View.GONE)
				closedEventsLV.setVisibility(View.VISIBLE);
			else
				closedEventsLV.setVisibility(View.GONE);
		} // TODO else if (v == showStatus) {
		// i = new Intent(v.getContext(), GraphActivity.class);
		// i.putExtra("session", session);
		// startActivity(i);
		// }
	}

}
