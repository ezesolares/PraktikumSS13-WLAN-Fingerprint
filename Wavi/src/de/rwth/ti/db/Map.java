package de.rwth.ti.db;

public class Map {
	
	public static final String TABLE_NAME = "map";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_data = "data";

	public static final String[] ALL_COLUMNS = { COLUMN_ID, COLUMN_data,
		};

	public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME
			+ "(" + COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_data +  " text null,);";
	public static final String TABLE_DROP = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	private long id;
	private String data;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
