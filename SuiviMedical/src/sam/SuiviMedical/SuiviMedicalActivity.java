package sam.SuiviMedical;

import patientActivities.PatientMainActivity;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import database.DataSource;
import doctorActivities.PatientsList;

public class SuiviMedicalActivity extends Activity {

	Infos session;
	/** Called when the activity is first created. */
	private EditText loginEdit;
	private DataSource ds;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// EditText loginEdit = (EditText) findViewById(R.id.userName);
		setContentView(R.layout.main);

		ds = new DataSource(this);
		Button connect = (Button) findViewById(R.id.connect);
		final EditText loginEdit = (EditText) findViewById(R.id.userName);

		connect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String login = Login();
				Log.w("login ",login);
				ds.open();
				Cursor roleC = ds.selectWhere(DataSource.TBL_ROLE, "Role", "NoAss = "+login);
				roleC.moveToFirst();
				String role = roleC.getString(roleC.getColumnIndex("Role"));
				ds.close();
				if (roleC != null && role.equals("Patient")) {
					Intent doc = new Intent(view.getContext(),
							PatientMainActivity.class);
					doc.putExtra("session", session);
					startActivity(doc);
				} else if (roleC != null && role.equals("Doctor")) {
					Intent doc = new Intent(view.getContext(),
							PatientsList.class);
					doc.putExtra("session", session);
					startActivity(doc);
				} else {
					// EditText loginEdit = (EditText)
					// findViewById(R.id.userName);
					EditText pswEdit = (EditText) findViewById(R.id.editPassword);
					loginEdit.setTextColor(Color.RED);
					pswEdit.setText("");
				}
			}
		});
		loginEdit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				loginEdit.setTextColor(Color.BLACK);
			}
		});
	}

	@Override
	public void onResume() {
		super.onResume();
		if (session != null && loginEdit != null) {
			session.clearSession();
			loginEdit.setText("");
		}
	}

	public String Login() {
		EditText loginEdit = (EditText) findViewById(R.id.userName);
		String login = loginEdit.getText().toString();
		// Cursor c =
		// db.rawQuery("select Role.PersonRole from Role where Role.NoAss = ?",
		// login);
		// c.moveToFirst();
		// String role = c.getString(1);
		if (login.equals("Patient")) {
			session = new Infos("PATT09809830", "Patient");
			return /* role */"Patient";
		} else if (login.equals("Doctor")) {
			session = new Infos("DOCT09809830", "Doctor");
			return "Doctor";
		} else
			return "";
	}
}
