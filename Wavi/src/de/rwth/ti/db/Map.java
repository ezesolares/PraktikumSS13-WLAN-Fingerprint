package de.rwth.ti.db;

public class Map {

	public static final String TABLE_NAME = "maps";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_FILE = "file";

	public static final String[] ALL_COLUMNS = { COLUMN_ID, COLUMN_NAME,
			COLUMN_FILE };

	public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME
			+ "(" + COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " text null, " + COLUMN_FILE + " text null);";
	public static final String TABLE_DROP = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	private long id;
	private String name;
	private String file;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
