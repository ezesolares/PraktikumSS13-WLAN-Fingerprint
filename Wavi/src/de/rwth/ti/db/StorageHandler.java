package de.rwth.ti.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * This class handles the database access
 * 
 * @author tcuje
 * 
 */
public class StorageHandler {

	private SQLiteDatabase db;
	private Storage storage;

	public StorageHandler(Context context) {
		storage = new Storage(context);
	}

	public void open() throws SQLException {
		db = storage.getWritableDatabase();
	}

	public void close() {
		storage.close();
	}

	/**
	 * Add the access point to measurement database
	 * 
	 * @return The id for the new access point
	 */
	public long addAp(Scan scan, String bssid, int level, int freq, String ssid) {
		ContentValues values = new ContentValues();
		values.put(AccessPoint.COLUMN_SCAN, scan.getId());
		values.put(AccessPoint.COLUMN_BSSID, bssid);
		values.put(AccessPoint.COLUMN_LEVEL, level);
		values.put(AccessPoint.COLUMN_FREQ, freq);
		values.put(AccessPoint.COLUMN_SSID, ssid);
		long insertId = db.insert(AccessPoint.TABLE_NAME, null, values);
		return insertId;
	}

	public AccessPoint cursorToAp(Cursor cursor) {
		AccessPoint ap = new AccessPoint();
		ap.setId(cursor.getLong(0));
		ap.setScan(cursor.getLong(1));
		ap.setBssid(cursor.getString(2));
		ap.setLevel(cursor.getInt(3));
		ap.setFreq(cursor.getInt(4));
		ap.setSsid(cursor.getString(5));
		return ap;
	}

	public Scan addScan(long time) {
		ContentValues values = new ContentValues();
		values.put(Scan.COLUMN_NAME, "");
		long insertId = db.insert(Scan.TABLE_NAME, null, values);
		Cursor cursor = db.query(Scan.TABLE_NAME, Scan.ALL_COLUMNS,
				Scan.COLUMN_ID + " = " + insertId + ", " + Scan.COLUMN_TIME
						+ " = " + time, null, null, null, null);
		cursor.moveToFirst();
		Scan scan = cursorToScan(cursor);
		cursor.close();
		return scan;
	}

	public Scan cursorToScan(Cursor cursor) {
		Scan scan = new Scan();
		scan.setId(cursor.getLong(0));
		scan.setName(cursor.getString(1));
		scan.setTime(cursor.getLong(2));
		return scan;
	}

	public long countScans() {
		Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + Scan.TABLE_NAME,
				null);
		cursor.moveToFirst();
		long result = cursor.getLong(0);
		cursor.close();
		return result;
	}

	public long countAccessPoints() {
		Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM "
				+ AccessPoint.TABLE_NAME, null);
		cursor.moveToFirst();
		long result = cursor.getLong(0);
		cursor.close();
		return result;
	}
}
