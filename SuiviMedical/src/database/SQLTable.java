package database;

import java.util.HashMap;
import org.apache.commons.lang3.text.StrSubstitutor;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

public class SQLTable {
	private StrSubstitutor sub;
	private String t_name;
	private SQLiteDatabase db;
	private String insertTemplate;

	public SQLTable(String t_name, String insertTemplate, SQLiteDatabase db) {
		this.t_name = t_name;
		this.insertTemplate = insertTemplate;
		this.db = db;
	}
	
	public void insert(HashMap<String, Object> rec) {
		sub = new StrSubstitutor(rec, "%(", ")");
		db.execSQL(sub.replace(this.insertTemplate));
	}
	
	public Cursor rawSelect(String q) {
		return db.rawQuery(q, null);
	}
	
	// fields is field name if single
	// or list of fields if many, e.g. (field1, field2, ...)
	// or * for all fields
	public Cursor select(String fields) {
		return rawSelect("SELECT " + fields + " FROM " + t_name);
	}
	
	public Cursor selectAll() {
		return select("*");
	}

	// 'fields' is as above
	// 'where' is the string representing the 'where' part of the query
	// e.g. SELECT * FROM table WHERE score < .60
	//                                -----------
	//                                   where
	public Cursor selectWhere(String fields, String where) {
		return rawSelect("SELECT " + fields + " FROM " + t_name + " WHERE " + where);
	}
}
