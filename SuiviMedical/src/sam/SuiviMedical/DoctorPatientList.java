package sam.SuiviMedical;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DoctorPatientList extends Activity {
	private String[] patientList;
	private ListView patientListView;
	private ArrayAdapter<String> adapter;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctormainview);
        	
        patientListView = (ListView) findViewById(R.id.listPatient);
        patientList = new String[] {"Robert Duclou", "Alicia Partu", "Henri Dufour"};
        		//  = db.query( <Nom et prénom de tous les patients> );
        
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, patientList);
        patientListView.setAdapter(adapter);
        patientListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			}        	
        });
	}
}