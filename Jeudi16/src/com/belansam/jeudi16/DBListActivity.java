package com.belansam.jeudi16;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class DBListActivity extends ListActivity {
	
	DBHelper dbh;
	SQLiteDatabase db;
	Cursor cursor;
	SimpleCursorAdapter adapter;
	
	static final String[] colonne = new String[] {
		DBHelper.C_ID,
		DBHelper.C_COND,
		DBHelper.C_HEURE
	};
	
	static final String[] from = new String[] {
		DBHelper.C_COND,
		DBHelper.C_HEURE
	};
	
	static final int[] to = new int[] {
		R.id.textView1,
		R.id.textView2
	};
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        dbh = new DBHelper(this);
        db = dbh.getReadableDatabase();
        
        cursor = db.query(DBHelper.TABLE,
        		colonne, null,  null, null, null, null);
        
        startManagingCursor(cursor);
        
        adapter = new SimpleCursorAdapter(this, R.layout.rangee, cursor, from, to);
        setListAdapter(adapter);
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		db.close();
	}

    

}