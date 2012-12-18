package database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 CREATE TABLE Dependance (
       DependantNo VARCHAR(12) NOT NULL,
       PatientNo   VARCHAR(12) NOT NULL,
       Relation    VARCHAR(15) NOT NULL,
       PRIMARY KEY (DependantNo),
       FOREIGN KEY (PatientNo) REFERENCES Patient(PatientNo)
)
 */
public class T_Dependance extends SQLTable {
	private static final String T_NAME = "Dependance";
	private static final String[] COLUMNS = {"DependantNo", "PatientNo", "Relation", "lName"};
	private static final String INSERT_TEMPLATE = "INSERT INTO "    +
	                                              T_NAME            +
	                                              " VALUES ("       +
			                                      "'%(" + COLUMNS[0] + ")', "   +
			                                      "'%(" + COLUMNS[1] + ")', "   +
			                                      "'%(" + COLUMNS[2] + ")', "   +
			                                      ")";
	
	public T_Dependance(SQLiteDatabase db) {
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
