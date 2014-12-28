package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class CreateScheduale extends Activity {

	public Intent openIntent;
	public CalendarView calendar;
	Event event;
	public Button Buttonlist_press;
	public String DAY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create);
		findByIdAssign(); // to match xml (button , txtview , ....) with java
		listnerAssign(); // Handle any action happen
	}

	public void findByIdAssign() {
		calendar = (CalendarView) findViewById(R.id.calendarView1); // calendar

	}

	public void listnerAssign() {
		// to handle of i press on day on calendar
		calendar.setOnDateChangeListener(new OnDateChangeListener() {
			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				event = new Event(dayOfMonth, year, month + 1);
				openIntent = new Intent(CreateScheduale.this, EventClass.class);
				openIntent.putExtra("event-date", event);
				startActivity(openIntent);
			}
		});

	}

}
