package doctorActivities;

import java.util.ArrayList;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import database.DataSource;

/**
 * Page d'accueil de l'interface du docteur.
 * 
 * @author Jérémy
 * 
 */
public class PatientsList extends Activity implements OnItemClickListener {

	private ArrayList<String> patientsL;
	private ListView patientsLV;
	private ArrayAdapter<String> patientsLA;
	private Button addPatient;
	private Intent i;
	private Infos session;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctormainview);

		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		patientsLV = (ListView) findViewById(R.id.listPatient);
		addPatient = (Button) findViewById(R.id.addPatient);
		addPatient.setVisibility(View.GONE); // notre application ne permet pas
												// d'ajouter de nouveaux
												// patients.

		patientsL = new ArrayList<String>();
		setPatientsList();
		patientsLA = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, patientsL);

		patientsLV.setAdapter(patientsLA);
		patientsLV.setOnItemClickListener(this);
	}

	private void setPatientsList() {
		DataSource ds = new DataSource(this);
		ds.open();
		Cursor c = ds.selectWhere(DataSource.TBL_ROLE, "NoAss",
				"PersonRole = \"Patient\""), c2;
		String noAss;
		if (c != null && c.getCount() > 0 && c.moveToFirst()) {
			for (int i = 0; i < c.getCount(); i++) {
				noAss = c.getString(c.getColumnIndex("NoAss"));
				c.moveToNext();
				c2 = ds.selectWhere(DataSource.TBL_PERSON, "fName, lName",
						"NoAss = \"" + noAss + "\"");
				if (c2 != null && c2.getCount() > 0 && c2.moveToFirst()) {
					patientsL.add(c2.getString(c2.getColumnIndex("fName"))
							+ " " + c2.getString(c2.getColumnIndex("lName")));
				} else {
					System.err.println("Aucun patient n'a été trouvé avec ce NoAss.");
				}
			}
		} else {
			System.err.println("Aucun rôle \"Patient\" n'a été trouvé.");
		}
		ds.close();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		Intent i = new Intent(view.getContext(), PatientEventsList.class);
		DataSource ds = new DataSource(this);
		ds.open();
		String fName = patientsL.get(pos).split(" ")[0], lName = patientsL.get(pos).split(" ")[1];
		Cursor c = ds.selectWhere(DataSource.TBL_PERSON, "NoAss",
				"fName = \""+fName+"\" AND lName = \""+lName+"\"");
		if (c != null && c.getCount() > 0 && c.moveToFirst())
			session.setActivePatient(c.getString(c.getColumnIndex("NoAss")));
		i.putExtra("session", session);
		startActivity(i);
	}

}