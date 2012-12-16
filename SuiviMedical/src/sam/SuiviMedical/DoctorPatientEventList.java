package sam.SuiviMedical;

import android.app.Activity;
import android.os.Bundle;

/**
 * Page listant les évènements (actifs ou non) du patient sélectionné à la
 * page précédente.
 * @author Jérémy
 *
 */
public class DoctorPatientEventList extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
	}
}
