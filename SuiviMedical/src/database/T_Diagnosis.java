package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Diagnosis (
       DiagnosisNo INTEGER     NOT NULL,
       EventNo     INTEGER     NOT NULL,
       DoctorNo    INTEGER     NOT NULL,
       DiagDate    DATE        NOT NULL,
       Descr       VARCHAR(50) NOT NULL,
       PRIMARY KEY (DiagnosisNo),
       FOREIGN KEY (EventNo)  REFERENCES Event(EventNo),
       FOREIGN KEY (DoctorNo) REFERENCES Doctor(DoctorNo)
)
 */

public class T_Diagnosis extends SQLTable {
	private static final String T_NAME = "Diagnosis";
	private static final String[] COLUMNS = {"DiagnosisNo", "EventNo", "DoctorNo", "DiagDate",
		                                     "Descr"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "%(" + COLUMNS[1] + "), "   +
			                                      "%(" + COLUMNS[2] + "), "   +
			                                      "'%(" + COLUMNS[3] + ")', "   +
			                                      "'%(" + COLUMNS[4] + ")', "   +
			                                      ")";
	
	public T_Diagnosis(SQLiteDatabase db) {
		super(T_NAME, INSERT_TEMPLATE, db);
	}
	
	public static void importAtCursor(Cursor c) {
		if (c != null ) {
		    if  (c.moveToFirst()) {
		        do {
//		            String noAss = c.getString(c.getColumnIndex(COLUMNS[0]));
//		            int streetNo = c.getInt(c.getColumnIndex(COLUMNS[6]));
//		            Log.w("dbproto", (noAss + " " + String.valueOf(streetNo)));
		        } while (c.moveToNext());
		    }
		}
		c.close();
	}
}
