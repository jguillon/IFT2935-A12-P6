package sam.SuiviMedical;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuiviMedicalActivity extends Activity {
    /** Called when the activity is first created. */
	private EditText loginEdit; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	//EditText loginEdit = (EditText) findViewById(R.id.userName);
        setContentView(R.layout.main);
        AlertDialog.Builder simple = new AlertDialog.Builder(this);
        simple.setMessage("C'est aussi simple que ca ?");
        simple.setCancelable(false);
        simple.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        	 public void onClick(DialogInterface dialog, int id) {
        	        finish();
        	 }
        	 });
        simple.setNegativeButton("No", new DialogInterface.OnClickListener() {
        	        public void onClick(DialogInterface dialog, int id) {
        	        //  Action for 'NO' Button
        	        dialog.cancel();
        	    }
       });
        simple.create();
        simple.show();
        	  
        
        Button connect = (Button) findViewById(R.id.connect);
        final EditText loginEdit = (EditText) findViewById(R.id.userName);
        
        connect.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				String login = Login();
				if(login.equals("Patient")){
					Intent doc = new Intent(view.getContext(), PatientMainActivity.class);
					startActivity(doc);
				}
				else if (login.equals("Doctor")){
					Intent doc = new Intent(view.getContext(), DoctorPatientList.class);
					startActivity(doc);
				}
				else {
					//EditText loginEdit = (EditText) findViewById(R.id.userName);
			    	EditText pswEdit = (EditText) findViewById(R.id.editPassword);
			    	loginEdit.setTextColor(Color.RED);
			    	pswEdit.setText("");
				}
			}});
		loginEdit.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view){
					loginEdit.setTextColor(Color.BLACK);
			}
		});
    }
    
    public String Login(){
    	EditText loginEdit = (EditText) findViewById(R.id.userName);
    	String login = loginEdit.getText().toString();
    	//Cursor c = db.rawQuery("select Role.PersonRole from Role where Role.NoAss = ?", login);
    	//c.moveToFirst();
    	//String role = c.getString(1);
    	if(login.equals("Patient"))
    			return /*role*/"Patient";
    	else if(login.equals("Doctor"))
    			return "Doctor";
    	else
    		return "";
    }
}
