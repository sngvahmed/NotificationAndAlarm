package com.example.project;

import java.io.PrintStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EventClass extends Activity {

	public TextView txtmsg, dateTxt, editTxt;
	public EditText start, end, userName;
	public Event event;
	public Button sub;
	public DBHelper db;
	public Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
		context = this;
		getIntentExtra();
		findByID();
		setDateTxt();
		Listner();
	}

	public void Listner() {
		sub.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				event.setStart_time(start);
				event.setEnd_time(end);
				event.setData(txtmsg.getText().toString());
				event.setUserName(userName.getText().toString());
				if (event.validate()) {
					db = new DBHelper(context, event.PRIMARYKEY());
					long l = db.insertContact(event);
					if (l != -1) {
						Intent openIntent = new Intent(EventClass.this,
								MainActivity.class);
						startActivity(openIntent);
					} else
						editTxt.setText("excute failed  \n" + Long.toString(l));
				} else {
					editTxt.setText("Failed to validate \n");
				}
			}
		});
	}

	public void findByID() {

		dateTxt = (TextView) findViewById(R.id.txtDateView); // date recive
		editTxt = (TextView) findViewById(R.id.inputCheck); // only for debug

		start = ((EditText) findViewById(R.id.SperoidTime)); // start date
		end = ((EditText) findViewById(R.id.EperoidTime)); // end date
		txtmsg = (EditText) findViewById(R.id.editTextEvent); // task desc
		userName = (EditText) findViewById(R.id.UserName); // user name

		sub = (Button) findViewById(R.id.Submit_desc);
	}

	public void getIntentExtra() {
		// recive data from the class previous
		event = (Event) getIntent().getSerializableExtra("event-date");
	}

	public void setDateTxt() {
		dateTxt.setText(event.toString());
	}

}
