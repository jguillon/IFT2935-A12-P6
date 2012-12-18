package database;

import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataSource {
	// All table names
	public static final String TBL_ACTION       = "Action";
	public static final String TBL_COMMAND      = "Command";
	public static final String TBL_DEPENDANCE   = "Dependance";
	public static final String TBL_DEPENDANT    = "Dependant";
	public static final String TBL_DIAGNOSIS    = "Diagnosis";
	public static final String TBL_DOCTOR       = "Doctor";
	public static final String TBL_DOSSIER      = "Dossier";
	public static final String TBL_EVENT        = "Event";
	public static final String TBL_NURSE        = "Nurse";
	public static final String TBL_PATIENT      = "Patient";
	public static final String TBL_PERSON       = "Person";
	public static final String TBL_PRESCRIPTION = "Prescription";
	public static final String TBL_REPORT       = "Report";
	public static final String TBL_ROLE         = "Role";
	public static final String TBL_STATUT       = "Statut";
	
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	//All tables obj defs
	HashMap<String, SQLTable> tables;
	
	
	public DataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		this.tables = new HashMap<String, SQLTable>();
		this.tables.put(TBL_ACTION, new T_Action(database));
		this.tables.put(TBL_COMMAND, new T_Command(database));
		this.tables.put(TBL_DEPENDANCE, new T_Dependance(database));
		this.tables.put(TBL_DEPENDANT, new T_Dependant(database));
		this.tables.put(TBL_DIAGNOSIS, new T_Diagnosis(database));
		this.tables.put(TBL_DOCTOR, new T_Doctor(database));
		this.tables.put(TBL_DOSSIER, new T_Dossier(database));
		this.tables.put(TBL_EVENT, new T_Event(database));
		this.tables.put(TBL_NURSE, new T_Nurse(database));
		this.tables.put(TBL_PATIENT, new T_Patient(database));
		this.tables.put(TBL_PERSON, new T_Person(database));
		this.tables.put(TBL_PRESCRIPTION, new T_Prescription(database));
		this.tables.put(TBL_REPORT, new T_Report(database));
		this.tables.put(TBL_ROLE, new T_Role(database));
		this.tables.put(TBL_STATUT, new T_Statut(database));
		
        Log.w("dbproto", "DataSource::open");
        Log.w("dbproto", database.toString());
	}

	public void close() {
		dbHelper.close();
        Log.w("dbproto", "DataSource::close");
	}
	
	//
	// Data access methods
	//
	
	public void insert(String tbl_name, HashMap<String, Object> values) {
		this.tables.get(tbl_name).insert(values);
	}
	
	public Cursor rawSelect(String tbl_name, String q) {
		return this.tables.get(tbl_name).rawSelect(q);
	}
	
	// fields is field name if single
	// or list of fields if many, e.g. (field1, field2, ...)
	// or * for all fields
	public Cursor select(String tbl_name, String fields) {
		return this.tables.get(tbl_name).select(fields);
	}
	
	public Cursor selectAll(String tbl_name) {
		return this.tables.get(tbl_name).selectAll();
	}

	// 'fields' is as above
	// 'where' is the string representing the 'where' part of the query
	// e.g. SELECT * FROM table WHERE score < .60
	//                                -----------
	//                                   where
	public Cursor selectWhere(String tbl_name, String fields, String where) {
		return this.tables.get(tbl_name).selectWhere(fields, where);
	}
	
	public void test() {
        Log.w("dbproto", "DataSource::test start");
        T_Person.importAtCursor(this.tables.get(TBL_PERSON).selectAll());
        Log.w("dbproto", "DataSource::test end");
	}
}
