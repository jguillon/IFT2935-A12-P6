package sam.SuiviMedical;

import patientActivities.PatientMainActivity;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import database.DataSource;
import doctorActivities.PatientsList;

public class SuiviMedicalActivity extends Activity implements OnClickListener {

	Infos session;
	/** Called when the activity is first created. */
	private EditText loginET, passwordET;
	private Button connectB;
	private DataSource ds;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		connectB 	= (Button) 	 findViewById(R.id.connect);
		loginET 	= (EditText) findViewById(R.id.userName);
		passwordET	= (EditText) findViewById(R.id.editPassword);

		ds = new DataSource(this);

		connectB.setOnClickListener(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		if (session != null && loginET != null) {
			session.clearSession();
			loginET.setText("");
		}
	}

	@Override
	public void onClick(View v) {
		ds.open();
		
		String login = loginET.getText().toString();
		String pswd = passwordET.getText().toString();
		Cursor roleC = ds.selectWhere(DataSource.TBL_ROLE, "PersonRole", "NoAss = \""+login+"\"");
		
		if(roleC != null && roleC.getCount() != 0 && pswd == login) {
			roleC.moveToFirst();
			String role = roleC.getString( roleC.getColumnIndex("PersonRole") );
			ds.close();
			session = new Infos(login, role);
			if (role.equals("Patient")) {
				Intent i = new Intent(v.getContext(), PatientMainActivity.class);
				i.putExtra("session", session);
				startActivity(i);
			} else if (role.equals("Doctor")) {
				Intent i = new Intent(v.getContext(), PatientsList.class);
				i.putExtra("session", session);
				startActivity(i);
			}
		}
		loginET.setTextColor(Color.RED);
		passwordET.setText("");
	}
}
