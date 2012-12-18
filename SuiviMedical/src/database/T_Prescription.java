package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Prescription (
       PrescriptionNo INTEGER NOT NULL,
       EventNo        INTEGER NOT NULL,
       DoctorNo       INTEGER NOT NULL,
       PrescDate      TEXT,
       DrugName       VARCHAR(25) NOT NULL,
       Qty            VARCHAR(10) NOT NULL,
       Frequency      VARCHAR(25) NOT NULL,
       Timebase       VARCHAR(25) NOT NULL,
       PRIMARY KEY (PrescriptionNo),
       FOREIGN KEY (EventNo) REFERENCES Event(EventNo),
       FOREIGN KEY (DoctorNo) REFERENCES Doctor(DoctorNo)
)
 */

public class T_Prescription extends SQLTable {
	private static final String T_NAME = "Prescription";
	private static final String[] COLUMNS = {"PrescriptionNo", "EventNo", "DoctorNo", "PrescDate",
		                                     "DrugName", "Qty", "Frequency", "Timebase"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "%(" + COLUMNS[1] + "), "   +
			                                      "%(" + COLUMNS[2] + "), "   +
			                                      "'%(" + COLUMNS[3] + ")', "   +
			                                      "'%(" + COLUMNS[4] + ")', "   +
			                                      "'%(" + COLUMNS[5] + ")', "   +
			                                      "'%("  + COLUMNS[6] + ")', "    +
			                                      "'%(" + COLUMNS[7] + ")', "   +
			                                      ")";
	
	public T_Prescription(SQLiteDatabase db) {
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
