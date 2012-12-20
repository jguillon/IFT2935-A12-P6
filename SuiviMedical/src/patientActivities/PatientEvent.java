package patientActivities;

import java.util.ArrayList;
import java.util.HashMap;

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
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import database.DataSource;

public class PatientEvent extends Activity {

	Intent i;
	Infos session;
	DataSource ds;

	RadioGroup radioC;
	ListView choices;
	TextView open;
	TextView close;
	TextView title;

	ArrayList<HashMap<String, String>> list;
	Adapter adapter;

	String[] lists;
	int[] listi;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctorvisualize);
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		ds = new DataSource(this);

		radioC = (RadioGroup) findViewById(R.id.radioChoices);

		choices = (ListView) findViewById(R.id.listShowChoices);
		open = (TextView) findViewById(R.id.openDate);
		close = (TextView) findViewById(R.id.closedDate);
		title = (TextView) findViewById(R.id.titleEvent);

		setInfos();
		this.setlistStatuts();

		radioC.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// Toast.makeText(PatientEvent.this, "change " + arg1,
				// Toast.LENGTH_LONG).show();
				switch (arg1) {

				case R.id.radioDiagnosis:
					setListDiagnosis();
					// the second RadioButton is checked.
					break;

				case R.id.radioReport:
					// the third RadioButton is checked.
					setListReports();
					break;

				case R.id.radioPrescription:
					// Toast.makeText(PatientEvent.this, "Prescription",
					// Toast.LENGTH_LONG).show();

					setListPrescriptions();
					// the forth RadioButton is checked.
					break;

				case R.id.radioStatus:
					// the fifth RadioButton is checked.
					setlistStatuts();
					break;

				case -1:
					// no RadioButton is checked in the RadioGroup
					break;
				}

				adapter = new SimpleAdapter(PatientEvent.this, list,
						R.layout.textview3, lists, listi);
				choices.clearChoices();
				choices.setAdapter((ListAdapter) adapter);
				choices.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> arg0, View view,
							int arg2, long itemID) {

						@SuppressWarnings("unused")
						int position = (int) arg0.getSelectedItemId();

					}
				});
				choices.invalidateViews();
			}
		});

	}

	@Override
	public void onResume() {
		super.onResume();
	}

	/**
	 * Source :
	 * http://stackoverflow.com/questions/10356733/getcheckedradiobuttonid
	 * -returning-useless-int/10356828#10356828
	 */
	public void setInfos() {
		ds.open();
		Cursor c = ds.selectWhere(DataSource.TBL_EVENT,
				"Descr, OpenDate, CloseDate",
				"EVENT.EventNo = \"" + session.getActiveEvent() + "\"");
		c.moveToFirst();
		title.setText(c.getString(0));
		open.setText(c.getString(1));
		if (!c.getString(2).equals("NULL"))
			close.setText(c.getString(2));
		else {
			close.setText("N/A");
		}
		ds.close();
	}

	public void setlistStatuts() {
		HashMap<String, String> hm;
		ds.open();

		Cursor c = ds.selectWhere(DataSource.TBL_STATUT,
				"StatusNo, Timestmp, StatusType, Val",
				"STATUT.DossierNo = (SELECT DossierNo FROM DOSSIER WHERE DOSSIER.NoAss = \""
						+ session.getUser()
						+ "\") ORDER BY STATUT.Timestmp desc");
		list = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			hm = new HashMap<String, String>();
			hm.put("StatusNo", c.getString(0));
			hm.put("Timestmp", c.getString(1));
			hm.put("StatusType", c.getString(2));
			hm.put("Val", c.getString(3) + getUnit(c.getString(2)));
			list.add(hm);

		}

		ds.close();

		lists = new String[] { "Timestmp", "StatusType", "Val" };
		listi = new int[] { R.id.affiche31, R.id.affiche32, R.id.affiche33 };

	}

	public void setListReports() {
		HashMap<String, String> hm;
		ds.open();

		Cursor c = ds.selectWhere(DataSource.TBL_REPORT,
				"ReportNo, ReportSrc, ReportDate, Descr", "REPORT.EventNo = \""
						+ session.getActiveEvent()
						+ "\" ORDER BY REPORT.ReportDate desc");

		list = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			hm = new HashMap<String, String>();
			hm.put("ReportNo", c.getString(0));
			hm.put("ReportSrc", c.getString(1));
			hm.put("ReportDate", c.getString(2));
			hm.put("Descr", c.getString(3));

			Cursor c2 = ds.selectWhere(DataSource.TBL_ROLE, "PersonRole",
					"ROLE.NoAss = \"" + c.getString(1) + "\"");
			c2.moveToFirst();
			Cursor c3 = ds.selectWhere(DataSource.TBL_PERSON, "fName, lName",
					"PERSON.NoAss = \"" + c.getString(1) + "\"");
			c3.moveToFirst();
			hm.put("Auteur", c3.getString(0) + " " + c3.getString(1) + ", "
					+ c2.getString(0));
			list.add(hm);

		}

		ds.close();

		lists = new String[] { "ReportDate", "Descr", "Auteur" };
		listi = new int[] { R.id.affiche31, R.id.affiche32, R.id.affiche33 };

	}

	public void setListPrescriptions() {
		HashMap<String, String> hm;
		ds.open();

		Cursor c = ds
				.selectWhere(
						DataSource.TBL_PRESCRIPTION,
						"PrescriptionNo, DoctorNo, PrescDate, DrugName, Qty, Frequency, TimeBase",
						"PRESCRIPTION.EventNo = \"" + session.getActiveEvent()
								+ "\" ORDER BY PRESCRIPTION.PrescDate desc");

		list = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			hm = new HashMap<String, String>();
			hm.put("PrescriptionNo", c.getString(0));
			hm.put("DoctorNo", c.getString(1));
			hm.put("PrescDate", c.getString(2));
			hm.put("DrugName", c.getString(3));
			hm.put("Qty", c.getString(4));
			hm.put("Frequency", c.getString(5));
			hm.put("TimeBase", c.getString(6));
			Cursor c2 = ds.selectWhere(DataSource.TBL_DOCTOR,
					"NoAss, Speciality", "DOCTOR.DoctorNo = \"" + c.getInt(1)
							+ "\"");
			c2.moveToFirst();
			Cursor c3 = ds.selectWhere(DataSource.TBL_PERSON, "fName, lName",
					"PERSON.NoAss = \"" + c2.getString(0) + "\"");
			c3.moveToFirst();
			hm.put("Doc", "Dr." + c3.getString(1) + ", " + c2.getString(1));
			list.add(hm);

		}

		ds.close();

		lists = new String[] { "PrescDate", "DrugName", "Doc" };
		listi = new int[] { R.id.affiche31, R.id.affiche32, R.id.affiche33 };

	}

	public void setListDiagnosis() {
		HashMap<String, String> hm;
		ds.open();

		Cursor c = ds.selectWhere(DataSource.TBL_DIAGNOSIS,
				"DiagnosisNo, DoctorNo, DiagDate, Descr",
				"DIAGNOSIS.EventNo = \"" + session.getActiveEvent()
						+ "\" ORDER BY DIAGNOSIS.DiagDate desc");

		list = new ArrayList<HashMap<String, String>>();

		while (c.moveToNext()) {
			hm = new HashMap<String, String>();
			hm.put("DiagnosisNo", c.getString(0));
			hm.put("DoctorNo", c.getString(1));
			hm.put("DiagDate", c.getString(2));
			hm.put("Descr", c.getString(3));
			Cursor c2 = ds.selectWhere(DataSource.TBL_DOCTOR,
					"NoAss, Speciality", "DOCTOR.DoctorNo = \"" + c.getInt(1)
							+ "\"");
			c2.moveToFirst();
			Cursor c3 = ds.selectWhere(DataSource.TBL_PERSON, "fName, lName",
					"PERSON.NoAss = \"" + c2.getString(0) + "\"");
			c3.moveToFirst();
			hm.put("Doc", "Dr." + c3.getString(1) + ", " + c2.getString(1));
			list.add(hm);

		}

		ds.close();

		lists = new String[] { "DiagDate", "Descr", "Doc" };
		listi = new int[] { R.id.affiche31, R.id.affiche32, R.id.affiche33 };

	}

	public String getUnit(String type) {
		if (type.equals("Temperature"))
			return "°C";
		else if (type.equals("Pression systolique")
				|| type.equals("Pression diastolique"))
			return "mm de mercure";
		else if (type.equals("Frequence respiratoire"))
			return "cycles par min";
		else if (type.equals("Frequence cardiaque"))
			return "pulsations par min";
		else if (type.equals("Saturation O2"))
			return "%";
		else if (type.equals("Taux de glucose"))
			return "g/L";
		else
			return "";
	}
}
