package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Doctor (
       DoctorNo   INTEGER     NOT NULL,
       NoAss      VARCHAR(12) NOT NULL,
       Speciality VARCHAR(30) NOT NULL,
       PRIMARY KEY (DoctorNo),
       FOREIGN KEY (NoAss) REFERENCES Person(NoAss)
)
 */

public class T_Doctor extends SQLTable {
	private static final String T_NAME = "Doctor";
	private static final String[] COLUMNS = {"DoctorNo", "NoAss", "Speciality"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "'%(" + COLUMNS[1] + ")', "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      ")";
	
	public T_Doctor(SQLiteDatabase db) {
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
