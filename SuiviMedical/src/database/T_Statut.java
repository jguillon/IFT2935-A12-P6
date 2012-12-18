package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Statut (
       StatusNo   INTEGER     NOT NULL,
       EventNo    INTEGER     NOT NULL,
       Timestmp   DATE        NOT NULL,
       StatusType VARCHAR(25) NOT NULL,
       Val        INTEGER     NOT NULL,
       PRIMARY KEY (StatusNo),
       FOREIGN KEY (EventNo) REFERENCES Event(EventNo)       
)
 */

public class T_Statut extends SQLTable {
	private static final String T_NAME = "T_Statut";
	private static final String[] COLUMNS = {"StatusNo", "EventNo", "Timestmp", "StatusType",
		                                     "Val"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "%(" + COLUMNS[1] + "), "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      "'%(" + COLUMNS[3] + ")', "   +
			                                      "%(" + COLUMNS[4] + "), "   +
			                                      ")";
	
	public T_Statut(SQLiteDatabase db) {
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
