package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Action (
       ActionNo   INTEGER     NOT NULL,
       EventNo    INTEGER     NOT NULL,
       DoctorNo   INTEGER     NOT NULL,
       ActionDate DATE        NOT NULL,
       Descr      VARCHAR(50) NOT NULL,
       PRIMARY KEY (ActionNo),
       FOREIGN KEY (EventNo) REFERENCES Event(EventNo),
       FOREIGN KEY (DoctorNo) REFERENCES Doctor(DoctorNo)
)
 */

public class T_Action extends SQLTable {

	private static final String T_NAME = "Action";
	private static final String[] COLUMNS = {"ActionNo", "EventNo", "DoctorNo", "ActionDate", "Descr"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "       +
	                                              T_NAME               +
	                                              " VALUES ("          +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "%(" + COLUMNS[1] + "), "   +
			                                      "%(" + COLUMNS[2] + "), "   +
			                                      "'%(" + COLUMNS[3] + ")', "   +
			                                      "'%(" + COLUMNS[4] + ")', "   +
			                                      ")";
	
	public T_Action(SQLiteDatabase db) {
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
