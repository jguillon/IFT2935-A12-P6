package sam.SuiviMedical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class SendInfo extends Activity {

	

	/**
	 * On peut soit remplir le spinner avec notre base de données où la remplir
	 * d'avance par le xml
	 */

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendinfo);

		final Spinner spinner = (Spinner) findViewById(R.id.spinInfo);
		/** Create an ArrayAdapter using the string array and a default spinner
		 layout*/
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.info_array, android.R.layout.simple_spinner_item);
		/** Specify the layout to use when the list of choices appears*/
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		/** Apply the adapter to the spinner */
		
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

		    @Override
		    public void onItemSelected(AdapterView <?> parentView, View view, int pos, long id) {
		       /**Code selon l'item sélectionné. Avec sql on va fonctionner avec id?*/
		    	Toast.makeText(SendInfo.this, "Clic! pos = "+pos+" id = "+id, Toast.LENGTH_LONG).show();
		    }

		    @Override
		    public void onNothingSelected(AdapterView <?> parentView) {
		        // your code here
		    }

		});


		
		
	}
}