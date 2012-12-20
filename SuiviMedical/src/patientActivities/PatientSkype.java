package patientActivities;

import java.util.ArrayList;
import java.util.HashMap;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import database.DataSource;

public class PatientSkype extends Activity {

	Intent i;
	Infos session;

	ArrayList<HashMap<String, String>> listDoctors;
	Adapter adapter;
	ListView view;
	DataSource ds;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drugsmain); // cest juste une liste, on va
											// remplir avec les bonnes choses

		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		ds = new DataSource(this);

		view = (ListView) findViewById(R.id.listDrugs);

		listDoctors = new ArrayList<HashMap<String, String>>();

		setList();

		view.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long itemID) {

				@SuppressWarnings("unused")
				int position = (int) arg0.getSelectedItemId();
				// avec la position, on recupere le doc et son numero de tel.
				call("tel:5147504212");
			}
		});
	}

	public void setList() {
		HashMap<String, String> hm;
		ds.open();

		String q = "SELECT * FROM (SELECT ACTION.DoctorNo "
				+ "FROM ACTION INNER JOIN EVENT ON ACTION.EventNo = EVENT.EventNo "
				+ "INNER JOIN DOSSIER ON EVENT.DossierNo = DOSSIER.DossierNo "
				+ "WHERE DOSSIER.NoAss = \""
				+ session.getUser()
				+ "\" "
				+ "UNION "
				+ "SELECT DIAGNOSIS.DoctorNo "
				+ "FROM DIAGNOSIS INNER JOIN EVENT ON DIAGNOSIS.EventNo = EVENT.EventNo "
				+ "INNER JOIN DOSSIER ON EVENT.DossierNo = DOSSIER.DossierNo "
				+ "WHERE DOSSIER.NoAss = \""
				+ session.getUser()
				+ "\""
				+ "UNION "
				+ "SELECT PRESCRIPTION.DoctorNo "
				+ "FROM PRESCRIPTION INNER JOIN EVENT ON PRESCRIPTION.EventNo = EVENT.EventNo "
				+ "INNER JOIN DOSSIER ON EVENT.DossierNo = DOSSIER.DossierNo "
				+ "WHERE DOSSIER.NoAss = \""
				+ session.getUser()
				+ "\" "
				+ "UNION "
				+ "SELECT DOCTOR.DoctorNo "
				+ "FROM DOCTOR INNER JOIN REPORT ON DOCTOR.NoAss = REPORT.ReportSrc "
				+ "INNER JOIN EVENT ON REPORT.EventNo = EVENT.EventNo "
				+ "INNER JOIN DOSSIER ON DOSSIER.DossierNo = EVENT.DossierNo "
				+ "WHERE DOSSIER.NoAss = \"" + session.getUser() + "\"" + ")";
		Cursor c = ds.rawQuery(q);
		listDoctors = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			Cursor c4 = ds.selectWhere(DataSource.TBL_PERSON,
					"fName, lName, telno",
					"PERSON.NoAss = (SELECT DOCTOR.NoAss FROM DOCTOR WHERE DOCTOR.DoctorNo = \""
							+ c.getString(0) + "\")");
			c4.moveToFirst();
			Cursor c5 = ds.selectWhere(DataSource.TBL_DOCTOR, "Speciality",
					"DoctorNo = \"" + c.getString(0) + "\"");
			c5.moveToFirst();
			hm = new HashMap<String, String>();
			hm.put("Doc", "Dr." + c4.getString(0) + " " + c4.getString(1));
			hm.put("Spec", c5.getString(0));
			hm.put("NoTel", c4.getString(2));
			listDoctors.add(hm);
		}

		ds.close();

		String[] lists = new String[] { "Doc", "Spec", "NoTel" };
		int[] listi = new int[] { R.id.affiche31, R.id.affiche32,
				R.id.affiche33 };

		adapter = new SimpleAdapter(this, listDoctors, R.layout.textview3,
				lists, listi);
		view.setAdapter((ListAdapter) adapter);

	}

	private void call(String number) {
		try {
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse(number));
			startActivity(callIntent);
			// il y aurait moyen de restarter l'application quand l'appel
			// termine, mais pour le moment on s'en fout
		} catch (ActivityNotFoundException activityException) {
			Log.e(number, "Call failed", activityException);
		}
	}
}
