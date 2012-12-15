package sam.SuiviMedical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuiviMedicalActivity extends Activity {
    /** Called when the activity is first created. */
    @Override //Test 3,4
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button connect = (Button) findViewById(R.id.connect);
        
        connect.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent doc = new Intent(view.getContext(), DoctorPatientList.class);
				startActivity(doc);
			}
        });
    }
}