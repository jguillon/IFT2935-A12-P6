package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	private static final String DB_NAME    = "data.db3";
	private static final int    DB_VERSION = 1;
	
	public MySQLiteHelper(Context context) {
	    super(context, DB_NAME, null, DB_VERSION);
	  }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
