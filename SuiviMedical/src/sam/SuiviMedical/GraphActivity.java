package sam.SuiviMedical;

import sam.SuiviMedical.R;
import graphClasses.*;
import graphClasses.GraphView.GraphViewData;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class GraphActivity extends Activity implements OnItemSelectedListener,
		OnClickListener {

	public Spinner spinner;
	RadioGroup buttongroup;
	boolean semaine;
	String type = "Temperature";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.graphmain);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		layout.addView(createGraph(type));
		
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
		btn.setSelected(true);
		RadioButton btn2 = (RadioButton) findViewById(R.id.annee);

		btn.setOnClickListener(this);
		btn2.setOnClickListener(this);
		


	}

	@Override
	public void onClick(View v) {

		// get selected radio button from radioGroup
		int selectedId = buttongroup.getCheckedRadioButtonId();

		// find the radiobutton by returned id
		Button btn = (RadioButton) findViewById(selectedId);

		if (btn.getText().equals("semaine")) {

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
		if (item.equals("Temperature")) { // || etc
			type = item;
			update(item);
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		// layout.addView(createGraph("Temperature"));

	}

	public void update(String type) {

		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		try {
			layout.removeViewAt(0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ViewParent view = layout.getParent();
		//((ViewGroup) view).removeView(layout);
		layout.addView(createGraph(type));
	}

	public GraphView createGraph(String type) {
		String title = "";
		GraphViewSeries example = null;

		if (type.equals("Temperature")) {
			title = "Temperature en ¡C";
			example = new GraphViewSeries(new GraphViewData[] {
					new GraphViewData(1, 37.03), new GraphViewData(2, 36.27),
					new GraphViewData(3, 37.06), new GraphViewData(4, 36.32),
					new GraphViewData(5, 36.98) });

		}

		if (type.equals("Taux de glucose")) {


			title = "Taux de glucose en g/L";
			example = new GraphViewSeries(new GraphViewData[] {
					new GraphViewData(1, 1.13), new GraphViewData(2, 1.31),
					new GraphViewData(3, 1.03), new GraphViewData(4, 1.00),
					new GraphViewData(5, 0.98) });

		}

			GraphView graphView = new LineGraphView(this, title);
			graphView.addSeries(example);
			
			if (semaine) {
				graphView.setHorizontalLabels(new String[] { "12.12.",
						"12.12.", "13.12.", "13.12", "14.12." });
			}

			return graphView;

	}

}
