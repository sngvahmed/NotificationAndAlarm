package com.example.project;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
	private String date = "";
	private static String FIXED = "DATE";
	private static String TASKS = "TASKS";
	private static String START = "START";
	private static String USERNAME = "USERNAME";
	private static String END = "END";

	public DBHelper(Context context, String date) {
		super(context, "PROJECT", null, 4);
		this.date = date;
	}

	public void onCreate(SQLiteDatabase db) {
		String Query = "CREATE TABLE IF NOT EXISTS " + FIXED + date + " (";
		// add date of task
		Query += TASKS + " VARCHAR(255) ,";
		Query += START + " VARCHAR(255) , ";
		Query += END + " VARCHAR(255) ,";
		Query += USERNAME + " VARCHAR(255)  PRIMARY KEY);";
		db.execSQL(Query);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + FIXED + date);
		onCreate(db);
	}

	public void newDate(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + FIXED + date);
		onCreate(db);
	}

	public long insertContact(Event event) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(TASKS, event.getData());
		contentValues.put(START, event.getStart_time().toString());
		contentValues.put(END, event.getEnd_time().toString());
		contentValues.put(USERNAME, event.getUserName());

		int id = -1;
		try {
			id = (int) db.insert(FIXED + date, null, contentValues);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return id;
	}

	public Cursor getData() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select * from " + FIXED + date, null);
		return res;
	}
}