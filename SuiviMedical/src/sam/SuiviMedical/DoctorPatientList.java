package sam.SuiviMedical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class DoctorPatientList extends Activity {
	private String[] patientList;
	private ListView patientListView;
	private ArrayAdapter<String> adapter;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctormainview);
        	
        patientListView = (ListView) findViewById(R.id.listPatient);
        patientList = new String[] {"Robert Duclou", "Alicia Partu", "Henri Dufour", "saiushia", "jaskaksjh", "asjaksjhaksh", "skjahskjahs", "askljaksjlas", "ajskasjhakshkas", "aksjhkajshkajhsa", "askjahjskahjsd", "asjkaSJHKajhs"};
        		//  = db.query( <Nom et prénom de tous les patients> );
        
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, patientList);
        patientListView.setAdapter(adapter);
	}
}