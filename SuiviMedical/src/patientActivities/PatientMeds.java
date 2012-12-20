package patientActivities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import database.DataSource;

public class PatientMeds extends Activity {

	Intent i;
	Infos session;

	List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
	String[] from = new String[] { "drug", "days", "quantity", "frequency" };
	int[] to = new int[] { R.id.drugName, R.id.daysLeft, R.id.quantity,
			R.id.frequency };

	DataSource ds;
	List<HashMap<String, String>> list;

	ListView lv;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drugsmain);
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		ds = new DataSource(this);

		setList();

	}

	public void setList() {
		HashMap<String, String> hm;
		ds.open();
		// Toast.makeText(PatientMeds.this,session.getUser(),
		// Toast.LENGTH_LONG).show();

		// Cursor c =
		// ds.rawQuery("SELECT PrescriptionNo, PrescDate, DrugName, Qty,  Frequency, TimeBase  "
		// +
		// "				FROM PRESCRIPTION" +
		// "				 WHERE PRESCRIPTION.EventNo = (SELECT EVENT.EventNo " +
		// "													FROM EVENT " +
		// "													WHERE EVENT.DossierNo = " +
		// "(SELECT DOSSIER.DossierNo " +
		// "																			FROM DOSSIER " +
		// "																			WHERE DOSSIER.NoAss = \""+session.getUser()
		// +"\"))" +
		// "ORDER BY PrescDate");
		Cursor c = ds
				.rawQuery("SELECT PRESCRIPTION.PrescriptionNo, "
						+ "						PRESCRIPTION.PrescDate, "
						+ " 						PRESCRIPTION.DrugName, "
						+ "						PRESCRIPTION.Qty, "
						+ "						PRESCRIPTION.Frequency, "
						+ "						PRESCRIPTION.TimeBase"
						+ "				FROM PRESCRIPTION "
						+ "				INNER JOIN EVENT ON PRESCRIPTION.EventNo = EVENT.EventNo "
						+ "	INNER JOIN DOSSIER ON EVENT.DossierNo = DOSSIER.DossierNo "
						+ "	WHERE DOSSIER.NoAss = \"" + session.getUser()
						+ "\"");

		list = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			hm = new HashMap<String, String>();
			hm.put("PrescrNo", c.getString(0));
			hm.put("PrescrDate", c.getString(1));
			hm.put("DrugName", c.getString(2));
			hm.put("Qty", c.getString(3));
			hm.put("Frequency", c.getString(4));
			hm.put("TimeBase", c.getString(5));
			list.add(hm);

		}

		ds.close();

		String[] from = new String[] { "DrugName", "PrescrDate", "TimeBase",
				"Qty", "Frequency" };
		int[] to = new int[] { R.id.drugName, R.id.viewDaysLeft, R.id.daysLeft,
				R.id.quantity, R.id.frequency };

		lv = (ListView) findViewById(R.id.listDrugs);
		Adapter adapter = new SimpleAdapter(this, list, R.layout.drugs, from,
				to);
		lv.setAdapter((ListAdapter) adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos,
					long id) {
				session.setActiveMed(list.get(pos).get("PrescrNo"));
				Intent med = new Intent(v.getContext(), PatientMedscc.class);
				med.putExtra("session", session);
				startActivity(med);
				// Toast.makeText(PatientMeds.this,"Clic! pos = " + pos +
				// " id = " + id, Toast.LENGTH_LONG).show();
			}
		});
	}
}