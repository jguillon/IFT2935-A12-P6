package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Event(
       EventNo   INTEGER NOT NULL,
       DossierNo INTEGER NOT NULL,
       OpenDate  DATE    NOT NULL,
       CloseDate DATE,
       Descr     VARCHAR(50) NOT NULL,
       PRIMARY KEY (EventNo),
       FOREIGN KEY (DossierNo) REFERENCES Dossier(DossierNo)
)
 */

public class T_Event extends SQLTable {
	private static final String T_NAME = "Event";
	private static final String[] COLUMNS = {"EventNo", "DossierNo", "OpenDate", "CloseDate",
		                                     "Descr"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "%(" + COLUMNS[1] + "), "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      "'%(" + COLUMNS[3] + ")', "   +
			                                      "'%(" + COLUMNS[4] + ")', "   +
			                                      ")";
	
	public T_Event(SQLiteDatabase db) {
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
