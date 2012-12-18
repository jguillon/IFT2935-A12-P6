package patientActivities;

import java.util.ArrayList;

import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PatientSkype extends Activity {
	
		ArrayList<String> listDoctors;
		Adapter adapter;
		ListView view;
		
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugsmain); //cest juste une liste, on va remplir avec les bonnes choses

        
        view = (ListView) findViewById(R.id.listDrugs);
        
        listDoctors = new ArrayList<String> ();
        listDoctors.add("Marcotte, André \t   \t 514-555-5555");
        listDoctors.add("Jacques, Marie \t   \t 514-555-5555");
        listDoctors.add("Marcotte, Paul \t   \t 514-555-5555");
        		//  = db.query( <Nom et prénom de tous les patients> );
        
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listDoctors);
        view.setAdapter((ListAdapter) adapter);
        
       view.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,long itemID) {

                @SuppressWarnings("unused")
				int position = (int) arg0.getSelectedItemId();
                //avec la position, on recupere le doc et son numero de tel.
                call("tel:5147504212");
            }
        });
	}
    
    private void call(String number) {
	    try {
	        Intent callIntent = new Intent(Intent.ACTION_CALL);
	        callIntent.setData(Uri.parse(number));
	        startActivity(callIntent);
	        //il y aurait moyen de restarter l'application quand l'appel termine, mais pour le moment on s'en fout
	    } catch (ActivityNotFoundException activityException) {
	         Log.e(number, "Call failed", activityException);
	    }
	}
}

