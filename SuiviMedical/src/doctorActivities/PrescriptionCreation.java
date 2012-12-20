package doctorActivities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PrescriptionCreation extends Activity {

	Button prescrire;

	Intent i;
	Infos session;

	List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
	String[] from = new String[] { "drug", "days", "quantity", "frequency" };
	int[] to = new int[] { R.id.drugName, R.id.daysLeft, R.id.quantity,
			R.id.frequency };

	ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drugdoctor); // TODO Il manque le Layout !!!
		i = getIntent();
		session = (Infos) i.getSerializableExtra("session");

		prescrire = (Button) findViewById(R.id.prescrireMed);
		prescrire.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent presc = new Intent(view.getContext(), Prescription.class);
				presc.putExtra("session", session);
				startActivity(presc);
			}
		});

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("drug", "Tylenol");
		map.put("days", "12 jours");
		map.put("quantity", "2 comprimés");
		map.put("frequency", "2 fois par jours");
		data.add(map);

		for (int i = 0; i < 2; i++) {
			map = new HashMap<String, String>();
			map.put("drug", "The power of love");
			map.put("days", "Infinit");
			map.put("quantity", "More possible");
			map.put("frequency", "All day");
			data.add(map);
		}

		lv = (ListView) findViewById(R.id.listDrugsDoc);
		Adapter adapter = new SimpleAdapter(this, data, R.layout.drugs, from,
				to);
		// ListAdapter adapter = new ArrayAdapter<String>(
		// this,R.layout.rangee, R.id.textView1 ,tableau);
		lv.setAdapter((ListAdapter) adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos,
					long id) {
				Intent med = new Intent(v.getContext(), DoctorMedsc.class);
				med.putExtra("session", session);
				startActivity(med);
				// Toast.makeText(PatientMeds.this,"Clic! pos = " + pos +
				// " id = " + id, Toast.LENGTH_LONG).show();
			}
		});
		/** Ca ne semble pas fonctionner le OnItemClick. Bizarre... */

	}

}
