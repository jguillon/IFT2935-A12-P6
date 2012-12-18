package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Report (
       ReportNo   INTEGER NOT NULL,
       EventNo    INTEGER NOT NULL,
       ReportSrc  TEXT    NOT NULL,
       ReportDate DATE    NOT NULL,
       Descr      TEXT,
       url        TEXT,
       PRIMARY KEY (ReportNo)
)
 */

public class T_Report extends SQLTable {
	private static final String T_NAME = "Report";
	private static final String[] COLUMNS = {"ReportNo", "EventNo", "ReportSrc", "ReportDate",
		                                     "Descr", "url"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "%(" + COLUMNS[0] + "), "   +
			                                      "%(" + COLUMNS[1] + "), "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      "'%(" + COLUMNS[3] + ")', "   +
			                                      "'%(" + COLUMNS[4] + ")', "   +
			                                      "'%(" + COLUMNS[5] + ")', "   +
			                                      ")";
	
	public T_Report(SQLiteDatabase db) {
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
