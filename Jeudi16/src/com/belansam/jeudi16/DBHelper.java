package com.belansam.jeudi16;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	static final int VERSION = 1;

	static final String TABLE = "meteo";

	static final String C_ID = "_id";	//Pour faire plaisir a Android et son CursorAdapter
	static final String C_TEMP = "temperature";
	static final String C_COND = "conditions";
	static final String C_HEURE = "heure";

	public DBHelper(Context context) {
		super(context, "meteo.db", null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String sql = "create table" + TABLE + " ("
				+C_ID+ " integer primary key ,"
				+C_TEMP+ " text, "
				+C_COND+ " text,"
				+C_HEURE+ "long )";

		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("drop table if exists "+TABLE);
		onCreate(db);
	}

}
