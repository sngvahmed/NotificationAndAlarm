package com.example.project;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	public Intent openIntent;
	public TextView txt;
	public Button createSchedule, openSchedule;
	public ArrayList<Event> array_data = new ArrayList<Event>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findByIdAssign();
		listnerAssign();
	}

	public void findByIdAssign() {
		txt = (TextView) findViewById(R.id.testTxt);
		txt.setText("");
		createSchedule = (Button) findViewById(R.id.create_schedule);
		openSchedule = (Button) findViewById(R.id.open_schedules);
	}

	// listener
	public void listnerAssign() {
		createSchedule.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				openIntent = new Intent(MainActivity.this,
						CreateScheduale.class);
//				openIntent.putExtra("array_data", array_data);
				startActivity(openIntent);
			}
		});

		openSchedule.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				openIntent = new Intent(MainActivity.this, OpenScheduale.class);
//				openIntent.putExtra("array_data", array_data);
				startActivity(openIntent);
			}
		});

	}
}