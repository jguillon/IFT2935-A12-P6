package doctorActivities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import database.DataSource;
import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EventCreation extends Activity {

	private TextView titleTV;
	private Button sendB, cancelB;
	private EditText descrET;
	private AlertDialog.Builder simpleAD;
	private DataSource ds;
	private Intent i;
	private Infos session;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);

		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");
		descrET = (EditText) findViewById(R.id.editRapport);
		titleTV = (TextView) findViewById(R.id.titleDesc);
		sendB = (Button) findViewById(R.id.bsendReport);
		cancelB = (Button) findViewById(R.id.bCancelReport);
		
		titleTV.setText("Nouvel évenement");
		
		simpleAD = new AlertDialog.Builder(this);
		ds = new DataSource(this);

		sendB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ds.open();
				Cursor c = ds.select(DataSource.TBL_EVENT, "EventNo"); //TODO
				int max = columnMax(c,"EventNo");
				c = ds.selectWhere(DataSource.TBL_DOSSIER, "DossierNo", "NoAss = \""+session.getActivePatient()+"\"");
				String dossierNo = checkAndGetFirst("DossierNo",c);
				Date d = new Date();
				String openDate = d.getYear()+"-"+d.getMonth()+"-"+d.getDate();
				String descr = descrET.getText().toString();
				HashMap<String, Object> insertTable = new HashMap<String, Object>();
				insertTable.put("EventNo", Integer.toString(max+1));
				insertTable.put("DossierNo", dossierNo);
				insertTable.put("OpenDate", openDate);
				insertTable.put("CloseDate", "");
				insertTable.put("Descr", descr);
				ds.insert(DataSource.TBL_EVENT, insertTable);
				ds.close();
				simpleAD.setMessage("L'évènement a été ajouté au dossier.");
				simpleAD.setCancelable(false);
				simpleAD.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								finish();
							}
						});
				simpleAD.create();
				simpleAD.setTitle("Confirmation");
				simpleAD.setIcon(R.drawable.patient_file);
				simpleAD.show();
			}

			
		});
		cancelB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
	}

	private int columnMax(Cursor c, String column) {
		ArrayList<Integer> t = new ArrayList<Integer>();
		if (c != null && c.moveToFirst()) {
			for(int i = 0; i<c.getCount() ;i++) {
				t.add(c.getInt(c.getColumnIndex(column)));
			}
		}
		int max = 0;
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i) > max)
					max = t.get(i);			
		}
					
		return max;
	}
	
	private String checkAndGetFirst(String s, Cursor c) {
		if (c != null && c.getCount() > 0 && c.moveToFirst())
			return c.getString(c.getColumnIndex(s));
		return "";
	}
}