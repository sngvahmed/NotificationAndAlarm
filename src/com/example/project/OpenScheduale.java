package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class OpenScheduale extends Activity {
	public Intent openIntent;
	public CalendarView calendar;
	Event event;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create);
		// funcgetIntent(); // to get value from old Activity
		findByIdAssign(); // to match xml (button , txtview , ....) with java
		listnerAssign(); // Handle any action happen
	}

	public void findByIdAssign() {
		calendar = (CalendarView) findViewById(R.id.calendarView1); // calendar
		// list_press = (Button) findViewById(R.id.list_data); // button

	}

	public void funcgetIntent() {
		// recive data from the class previous
		// event = (ArrayList<Event>) getIntent().getSerializableExtra(
		// "array_data");

	}

	public void listnerAssign() {
		// to handle of i press on day on calendar
		calendar.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				event = new Event(dayOfMonth, year, month + 1);
				openIntent = new Intent(OpenScheduale.this, LoadDataOpen.class);
				openIntent.putExtra("event-date", event);
				startActivity(openIntent);
			}

		});
	}
}
