package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Patient (
       PatientNo   INTEGER NOT NULL,
       NoAss       VARCHAR(12) NOT NULL,
       PatientType TEXT NOT NULL,
       PRIMARY KEY (PatientNo),
       FOREIGN KEY (NoAss) REFERENCES Person(NoAss)
)
 */

public class T_Patient extends SQLTable {
	private static final String T_NAME = "Patient";
	private static final String[] COLUMNS = {"PatientNo", "NoAss", "PatientType"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "'%(" + COLUMNS[1] + ")', "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      ")";
	
	public T_Patient(SQLiteDatabase db) {
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
