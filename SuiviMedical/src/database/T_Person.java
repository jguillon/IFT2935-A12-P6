package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/*
  CREATE TABLE Person (
       NoAss    VARCHAR(12) NOT NULL,
       fName    VARCHAR(20) NOT NULL,
       mName    VARCHAR(20),
       lName    VARCHAR(50) NOT NULL,
       bDate    DATE        NOT NULL,
       sex      CHAR        NOT NULL,
       streetNo INTEGER     NOT NULL,
       street   VARCHAR(30) NOT NULL,
       appt     INTEGER,
       city     VARCHAR(20) NOT NULL,
       province VARCHAR(20) NOT NULL,
       pc       VARCHAR(6)  NOT NULL,
       country  VARCHAR(50) NOT NULL,
       telno    VARCHAR(10),
       email    TEXT,
       PRIMARY KEY (NoAss)
)
 */

public class T_Person extends SQLTable {
	private static final String T_NAME = "Person";
	private static final String[] COLUMNS = {"NoAss", "fName", "mName", "lName",
		                                     "bDate", "sex", "streetNo", "street",
		                                     "appt", "city", "province", "pc",
		                                     "country", "telno", "email"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "'%(" + COLUMNS[0] + ")', "   +
			                                      "'%(" + COLUMNS[1] + ")', "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      "'%(" + COLUMNS[3] + ")', "   +
			                                      "'%(" + COLUMNS[4] + ")', "   +
			                                      "'%(" + COLUMNS[5] + ")', "   +
			                                      "%("  + COLUMNS[6] + "), "    +
			                                      "'%(" + COLUMNS[7] + ")', "   +
			                                      "%("  + COLUMNS[8] + "), "    +
			                                      "'%(" + COLUMNS[9] + ")', "   +
			                                      "'%(" + COLUMNS[10] + ")', "  +
			                                      "'%(" + COLUMNS[11] + ")', "  + 
			                                      "'%(" + COLUMNS[12] + ")', "  +
			                                      "'%(" + COLUMNS[13] + ")', "  +
			                                      "'%(" + COLUMNS[14] + ")'"    +
			                                      ")";
	
	public T_Person(SQLiteDatabase db) {
		super(T_NAME, INSERT_TEMPLATE, db);
	}
	
	public static void importAtCursor(Cursor c) {
		if (c != null ) {
		    if  (c.moveToFirst()) {
		        do {
		            String noAss = c.getString(c.getColumnIndex(COLUMNS[0]));
		            int streetNo = c.getInt(c.getColumnIndex(COLUMNS[6]));
		            Log.w("dbproto", (noAss + " " + String.valueOf(streetNo)));
		        } while (c.moveToNext());
		    }
		}
		c.close();
	}
}
