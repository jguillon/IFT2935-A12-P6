package patientActivities;

import java.util.ArrayList;

import sam.SuiviMedical.Infos;
import sam.SuiviMedical.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class PatientEvent extends Activity {
	
	private static final int RB1_ID = 1000;//first radio button id
	private static final int RB2_ID = 1001;//second radio button id
	private static final int RB3_ID = 1002;//third radio button id
	private static final int RB4_ID = 1004;//first radio button id
	private static final int RB5_ID = 1005;//second radio button id
	
	Intent i;
	Infos session;
	
	RadioGroup radioC;
	ListView choices;
	TextView open;
	TextView close;
	
	ArrayList<String> list;
	Adapter adapter;
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorvisualize);
        i = getIntent();
        session = (Infos) i.getSerializableExtra("session");
        
        radioC = (RadioGroup) findViewById(R.id.radioChoices);
        
        int choixRadio = radioC.getCheckedRadioButtonId();
        
        choices = (ListView) findViewById(R.id.listShowChoices);
        open = (TextView) findViewById(R.id.openDate);
        close = (TextView) findViewById(R.id.closedDate);

        setInfos();
        
        list = new ArrayList<String> ();
        list.add("kljslkasjlakjs");
        list.add("dfsdfsdfsdf");
        list.add("sdfsdfsfgdhfh");
        		//  = db.query( <Nom et prénom de tous les patients> );
        
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        choices.setAdapter((ListAdapter) adapter);
        
       choices.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,long itemID) {

                @SuppressWarnings("unused")
				int position = (int) arg0.getSelectedItemId();
                //avec la position, on recupere le doc et son numero de tel.
            }
        });
        
        
        switch (choixRadio) {
        case RB1_ID:
        	// the first RadioButton is checked.
        break;
            //other checks for the other RadioButtons ids from the RadioGroup
        
        case RB2_ID:
            // the second RadioButton is checked.
        break;
        
        case RB3_ID:
            // the third RadioButton is checked.
        break;
        
        case RB4_ID:
            // the forth RadioButton is checked.
        break;
        
        case RB5_ID:
            // the fifth RadioButton is checked.
        break;
      
        case -1:
            // no RadioButton is checked in the RadioGroup
        break;
        }
    }
        /** Source : http://stackoverflow.com/questions/10356733/getcheckedradiobuttonid-returning-useless-int/10356828#10356828 */
    public void setInfos(){
    	open.setText("06/07/1999");
    	close.setText("01/02/2003");
    }

}
