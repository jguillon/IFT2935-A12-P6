package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Role (
       NoAss      VARCHAR(12) NOT NULL,
       PersonRole VARCHAR(12) NOT NULL,
       PRIMARY KEY (NoAss)
)
 */

public class T_Role extends SQLTable {
	private static final String T_NAME = "Role";
	private static final String[] COLUMNS = {"NoAss", "PersonRole"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "'%(" + COLUMNS[0] + ")', "   +
			                                      "'%(" + COLUMNS[1] + ")', "   +
			                                      ")";
	
	public T_Role(SQLiteDatabase db) {
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
