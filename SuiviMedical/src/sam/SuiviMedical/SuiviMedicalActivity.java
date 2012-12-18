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
	public void onClick(View v) {
		//On commence par ouvrir la base de donn�es
		ds.open();
		
		String login = loginET.getText().toString();
		String pswd = passwordET.getText().toString();
		//On d�clare un curseur sur la table retourn�e par la requ�te SQL
		Cursor roleC = ds.selectWhere(DataSource.TBL_ROLE, "PersonRole", "NoAss = \""+login+"\"");
		
		//On v�rifie que le curseur n'est pas nul et qu'il ne pointe pas sur une table vide
		if(roleC != null && roleC.getCount() != 0 && pswd == login) {
			//On remet le curseur au d�but
			roleC.moveToFirst();
			//On r�cup�re l'index de la colonne qui nous int�resse et la cha�ne qu'elle contient
			String role = roleC.getString( roleC.getColumnIndex("PersonRole") );
			//Et enfin, on n'oublie pas de refermer la base de donn�es.
			ds.close();
			Infos session = new Infos(login, role);
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
