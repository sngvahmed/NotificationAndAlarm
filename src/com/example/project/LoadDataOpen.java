package com.example.project;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class LoadDataOpen extends ListActivity {
	public DBHelper db;
	public Event event;
	public Cursor date;
	public ArrayList<Event> array;
	public String classes[];
	public Intent openIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getIntentExtra();
		db = new DBHelper(this, event.PRIMARYKEY());
		loadDate();
		setListAdapter(new ArrayAdapter<String>(LoadDataOpen.this,
				android.R.layout.simple_expandable_list_item_1, classes));
	}

	private void loadDate() {
		array = new ArrayList<Event>();
		date = db.getData();
		while (date.moveToNext()) {
			Event tmp = new Event();
			tmp.setData(date.getString(0));
			tmp.CastingToStartTime(date.getString(1));
			tmp.CastingToEndTime(date.getString(2));
			tmp.setUserName(date.getString(3));
			array.add(tmp);
		}
		classes = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			classes[i] = array.get(i).getUserName();
		}
	}

	public void getIntentExtra() {
		// recive data from the class previous
		event = (Event) getIntent().getSerializableExtra("event-date");
	}
}
