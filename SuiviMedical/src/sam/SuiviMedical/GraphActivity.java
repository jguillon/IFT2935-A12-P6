package sam.SuiviMedical;

import graphClasses.GraphView;
import graphClasses.GraphView.GraphViewData;
import graphClasses.GraphViewSeries;
import graphClasses.LineGraphView;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import database.DataSource;

public class GraphActivity extends Activity implements OnItemSelectedListener,
		OnClickListener {

	public Spinner spinner;
	RadioGroup buttongroup;
	boolean semaine = false;
	String type = "Temperature";
	private DataSource ds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.graphmain);
		ds = new DataSource(this);
		// setting the spinner for the different vital signs
		spinner = (Spinner) findViewById(R.id.spinnerValeurs);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.signesVitaux_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);

		buttongroup = (RadioGroup) findViewById(R.id.time_buttons);
		RadioButton btn = (RadioButton) findViewById(R.id.semaine);
		RadioButton btn2 = (RadioButton) findViewById(R.id.annee);
		btn2.setChecked(true);
		btn.setOnClickListener(this);
		btn2.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		// get selected radio button from radioGroup
		int selectedId = buttongroup.getCheckedRadioButtonId();

		// find the radiobutton by returned id
		Button btn = (RadioButton) findViewById(selectedId);

		if (btn.getText().equals("derniere semaine")) {

			semaine = true;

		} else {
			semaine = false;

		}

		update(type);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		String item = spinner.getSelectedItem().toString();
		type = item;
		update(type);

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		// layout.addView(createGraph("Temperature"));

	}

	public void update(String type) {

		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		LinearLayout graph = new LinearLayout(this);
		try {
			layout.removeAllViewsInLayout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (createGraph(type) != null) {
			graph.addView(createGraph(type));
			layout.invalidate();
			layout.addView(graph);
		}

	}

	public GraphView createGraph(String type) {
		String title = "";
		GraphViewSeries series = new GraphViewSeries(new GraphViewData[] {});

		if (type.equals("Temperature")) {
			title = "Temperature en ¡C";
		}
		if (type.equals("Taux de glucose")) {
			title = "Taux de glucose en g/L";
		}
		if (type.equals("Saturation O2")) {
			title = "Saturation O2 en %";
		}
		if (type.equals("Frequence respiratoire")) {
			title = "Frequence respiratoire en cycles par minute";
		}
		if (type.equals("Frequence cardiaque")) {
			title = "Frequence cardiaque en pulsations par minute";
		}
		if (type.equals("Pression systolique")) {
			title = "Pression systolique en mm de mercure";
		}
		if (type.equals("Pression diastolique")) {
			title = "Pression diastolique en en mm de mercure";
		}
		if (type.equals("IMC")) {
			title = "IMC";
		}

		// series = new GraphViewSeries(new GraphViewData[] {
		// new GraphViewData(1, 2.13), new GraphViewData(2, 1.31),
		// new GraphViewData(3, 3.03), new GraphViewData(4, 1.00),
		// new GraphViewData(5, 1.98) });
		GraphView graphView = null;
		if (getValues(type).length > 0) {
			series = new GraphViewSeries(getValues(type));
			graphView = new LineGraphView(this, title);
			graphView.addSeries(series);
		}
		if (getLabels(type).length > 0) {
			graphView.setHorizontalLabels(getLabels(type));
		}

		return graphView;

	}

	public GraphViewData[] getValues(String type) throws NullPointerException {
		int iter = 0;
		ds.open();
		ArrayList<GraphViewData> list = new ArrayList<GraphViewData>();
		Cursor val = null;
		if (semaine) {
			// TODO eplace EventNo = 1 with EvenNo = session.getEventNo
			val = ds.selectWhere(DataSource.TBL_STATUT, "Val, Timestmp",
					"StatusType= \"" + type
							+ "\" AND Timestmp >= datetime('now', '-7 days')");
			// val = ds.selectAll(DataSource.TBL_STATUT);
		} else {
			// val = ds.selectWhere(DataSource.TBL_STATUT, "Val, Timestmp",
			// "EventNo = \"50\" " +
			// "AND StatusType= \""+type+"\" AND Timestmp >= datetime('now', '-1 years')");
			val = ds.selectWhere(DataSource.TBL_STATUT, "Val, Timestmp",
					"StatusType= \"" + type
							+ "\" AND Timestmp >= datetime('now', '-1 years')");
		}
		if (val != null) {
			if (val.moveToFirst()) {
				val.moveToFirst();
				do {
					String value = val.getString(val.getColumnIndex("Val"));
					list.add(iter,
							new GraphViewData(iter, Double.parseDouble(value)));
					Log.w("add", value);
					iter++;
				} while (val.moveToNext());

			}
		}

		return list.toArray(new GraphViewData[list.size()]);
	}

	public String[] getLabels(String type) {
		int iter = 0;
		ds.open();
		ArrayList<String> list = new ArrayList<String>();
		Cursor val = null;
		if (semaine) {
			// TODO eplace EventNo = 1 with EvenNo = session.getEventNo
			val = ds.selectWhere(DataSource.TBL_STATUT, "Timestmp",
					"EventNo = \"1\" " + "AND StatusType= \"" + type
							+ "\" AND Timestmp >= datetime('now', '-7 days')");
		} else {
			val = ds.selectWhere(DataSource.TBL_STATUT, "Timestmp",
					"EventNo = \"1\" " + "AND StatusType= \"" + type
							+ "\" AND Timestmp >= datetime('now', '-1 years')");
		}
		if (val != null) {

			if (val.moveToFirst()) {
				val.moveToFirst();
				do {
					String label = val
							.getString(val.getColumnIndex("Timestmp"));
					String[] date = label.split("-");
					list.add(iter, date[2]);
					iter++;
				} while (val.moveToNext());
			}
		}
		return list.toArray(new String[list.size()]);

	}

}
