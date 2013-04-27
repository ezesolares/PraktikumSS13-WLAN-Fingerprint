package de.rwth.ti.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class is responsible for creating and upgrading the database
 * 
 * @author tcuje
 * 
 */
public class Storage extends SQLiteOpenHelper {

	private final static String DB_NAME = "local";
	private static final int DB_VERSION = 1;

	public Storage(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	/** Called when the database is created for the first time. */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(AccessPoint.TABLE_CREATE);
		db.execSQL(Scan.TABLE_CREATE);
		db.execSQL(Checkpoint.TABLE_CREATE);
		db.execSQL(Map.TABLE_CREATE);
	}

	/** Called when the database needs to be upgraded */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion < 1) {
			db.execSQL(AccessPoint.TABLE_DROP);
			db.execSQL(Scan.TABLE_DROP);
			db.execSQL(Checkpoint.TABLE_DROP);
			db.execSQL(Map.TABLE_DROP);
			onCreate(db);
		}
	}
}
