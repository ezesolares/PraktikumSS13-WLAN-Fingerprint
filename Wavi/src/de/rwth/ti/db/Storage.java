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

	private final static String DB_NAME = "map";
	private static final int DB_VERSION = 6;

	public Storage(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	/** Called when the database is created for the first time. */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(AccessPoint.TABLE_CREATE);
		db.execSQL(Scan.TABLE_CREATE);
	}

	/** Called when the database needs to be upgraded */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion < 4) {
			db.execSQL(AccessPoint.TABLE_DROP);
			db.execSQL(Scan.TABLE_DROP);
			onCreate(db);
		}
		if (oldVersion < 5) {
			db.execSQL("ALTER TABLE " + AccessPoint.TABLE_NAME
					+ " ADD ssid string null");
		}
		if (oldVersion < 6) {
			db.execSQL("ALTER TABLE " + Scan.TABLE_NAME + " ADD time integer");
		}
	}
}
