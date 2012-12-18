package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/*
 CREATE TABLE Command (
       PrescriptionNo INTEGER NOT NULL,
       PharmacyNo     INTEGER NOT NULL,
       commandDate    TEXT,
       PRIMARY KEY (PrescriptionNo, PharmacyNo)
)
 */
public class T_Command extends SQLTable {
	private static final String T_NAME = "Command";
	private static final String[] COLUMNS = {"PrescriptionNo", "PharmacyNo", "commandDate"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "%(" + COLUMNS[1] + "), "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      ")";
	
	public T_Command(SQLiteDatabase db) {
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
