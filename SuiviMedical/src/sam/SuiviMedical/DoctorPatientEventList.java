package sam.SuiviMedical;

import android.app.Activity;
import android.os.Bundle;

/**
 * Page listant les �v�nements (actifs ou non) du patient s�lectionn� � la
 * page pr�c�dente.
 * @author J�r�my
 *
 */
public class DoctorPatientEventList extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctoreventlist);
	}
}
