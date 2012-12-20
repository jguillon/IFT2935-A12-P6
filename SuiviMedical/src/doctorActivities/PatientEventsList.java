package doctorActivities;

import database.DataSource;
import sam.SuiviMedical.GraphActivity;
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
	private String[] openEventsL, closedEventsL;
	private ListView openEventsLV, closedEventsLV;
	private TextView info1TV, info2TV, info3TV, info4TV, op, cl;
	private ArrayAdapter<String> openEventsLA, closedEventsLA;
	private Infos session;
	private Button addEvent;
	private Button showStatus;
	private String noAssurance, firstname, lastname, middlename, birthdate,
			sex, address, notel, email;

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
		showStatus = (Button) findViewById(R.id.StatusBtn);

		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		closedEventsL = new String[] { "Bronchite", "Cancer du sein", "Angine" };
		openEventsL = new String[] { "Alzheimer", "Fracture du bras", "Gastro",
				"Hypertension" };
		openEventsLA = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, openEventsL);
		closedEventsLA = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, closedEventsL);

		setInfosPatient(session.getActivePatient());
		closedEventsLV.setAdapter(closedEventsLA);
		openEventsLV.setAdapter(openEventsLA);
		closedEventsLV.setOnItemClickListener(this);
		openEventsLV.setOnItemClickListener(this);
		op.setOnClickListener(this);
		cl.setOnClickListener(this);
		addEvent.setOnClickListener(this);
		showStatus.setOnClickListener(this);
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
			session.setActiveEvent(openEventsL[pos]);
			i = new Intent(view.getContext(), PatientEventModification.class);
			i.putExtra("session", session);
			startActivity(i);
		} else if (parent == closedEventsLV) {
			session.setActiveEvent(closedEventsL[pos]);
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
	public void onClick(View v) {
		if (v == addEvent) {
			Intent newEvent = new Intent(v.getContext(), EventCreation.class);
			newEvent.putExtra("session", session);
			startActivity(newEvent);
		} else if (v == op) {
			if (openEventsLV.getVisibility() == View.GONE)
				openEventsLV.setVisibility(View.VISIBLE);
			else
				openEventsLV.setVisibility(View.GONE);
		} else if(v == cl) {
			if (closedEventsLV.getVisibility() == View.GONE)
				closedEventsLV.setVisibility(View.VISIBLE);
			else
				closedEventsLV.setVisibility(View.GONE);
		} else if(v == showStatus) {
			Intent newEvent = new Intent(v.getContext(),
					GraphActivity.class);
			newEvent.putExtra("session", session);
			startActivity(newEvent);
		}
	}

}
