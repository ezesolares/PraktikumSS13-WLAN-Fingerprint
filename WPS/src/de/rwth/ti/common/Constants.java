package de.rwth.ti.common;

import java.io.File;
import java.util.Locale;

import android.graphics.Color;
import android.os.Environment;

public class Constants {

	public static final String SD_APP_DIR = Environment
			.getExternalStorageDirectory().getAbsolutePath()
			+ File.separator
			+ "WPS";
	public static final Locale LOCALE = Locale.GERMAN;
	public static final String DB_SUFFIX = ".sqlite";
	public static final String LOCAL_DB_NAME = "local" + DB_SUFFIX;
	public static final int FILE_BUFFER_SIZE = 10240;
	public static final int AUTO_SCAN_SEC = 2;
	public static final int ANGLE_DIFF = 30;
	public static final String MAP_SUFFIX = ".svg";
	public static final int IMPORTANT_APS = 3;
	public static final long COMPASS_TIMESPAN = 100;

	// MapView color schema
	public static final int COLOR_FLOOR_FILL = Color.WHITE;
	public static final int COLOR_FLOOR_WALL = Color.GRAY;
	public static final int COLOR_MEASURE_POINTS = Color.LTGRAY;
	public static final int COLOR_MEASURE_POINTS_BEST = Color.GREEN;
	public static final int COLOR_MEASURE_POINTS_MEDIUM = Color.YELLOW;
	public static final int COLOR_MEASURE_POINTS_BAD = Color.RED;
	public static final int COLOR_POSITION = Color.BLUE;
	public static final int COLOR_ACTIVE_POINT = Color.GREEN;
	public static final String PACKAGE_NAME = "de.rwth.ti.wps";

}
