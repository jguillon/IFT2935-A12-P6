package sam.SuiviMedical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DossierMain extends Activity {
	
	private static final int RB1_ID = 1000;//first radio button id
	private static final int RB2_ID = 1001;//second radio button id
	private static final int RB3_ID = 1002;//third radio button id
	private static final int RB4_ID = 1004;//first radio button id
	private static final int RB5_ID = 1005;//second radio button id

	RadioGroup radioC;
	ListView choices;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctormainview);
        
        /**Probablement nécessaire*/
        radioC = (RadioGroup) findViewById(R.id.radioChoices);
        
        int choixRadio = radioC.getCheckedRadioButtonId();
        
        choices = (ListView) findViewById(R.id.listShowChoices);
        
        
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
        
        /** Source : http://stackoverflow.com/questions/10356733/getcheckedradiobuttonid-returning-useless-int/10356828#10356828 */
        }
        
        /**Need a lot of sql request!!*/
        
        /**Est-ce que c'est ici qu'on peut cliquer pour faire des graphiques?*/
        /**
         * choices.setAdapter((ListAdapter) adapter);
         * choices.setOnItemClickListener(new OnItemClickListener(){
         * 		@Override
         * 		public void onItemClick(AdapterView parent, View v, int pos, long id){
         * 
         * 		}
         * 
         * });
         */
        
    }
}