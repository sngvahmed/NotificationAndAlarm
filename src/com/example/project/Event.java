package com.example.project;

import java.io.Serializable;

import android.widget.EditText;

public class Event implements Serializable {

	private static final long serialVersionUID = -7461624129779163877L;
	private int day, year, month;
	private pair start_time = null;
	private pair end_time = null;
	private String Data = "";
	private String userName = "";

	public Event(int nday, int nyear, int nmonth) {
		setDay(nday);
		setMonth(nmonth);
		setYear(nyear);
	}

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public String PRIMARYKEY() {
		return Integer.toString(getDay()) + Integer.toString(getMonth() + 1)
				+ Integer.toString(getYear());
	}

	public String toString() {
		return Integer.toString(getDay()) + "/"
				+ Integer.toString(getMonth() + 1) + "/"
				+ Integer.toString(getYear());
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public boolean validate() {
		if (Data.equals("") || end_time == null || start_time == null
				|| userName.equals(""))
			return false;
		if (start_time.validate() && end_time.validate())
			return true;
		return false;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getTextData() {
		return Data;
	}

	public void setTextData(EditText textData) {
		this.Data = textData.getText().toString();
	}

	public pair getStart_time() {
		return start_time;
	}

	public pair getEnd_time() {
		return end_time;
	}

	public void CastingToStartTime(String txt) {
		int indx = txt.indexOf(":");
		String hour = txt.substring(0, indx);
		String minute = txt.substring(indx + 1);
		start_time = new pair(Integer.parseInt(hour), Integer.parseInt(minute));
	}

	public void setStart_time(EditText txt) {
		try {
			CastingToStartTime(txt.getText().toString());
		} catch (Exception e) {
			System.out.println("String is invalid in the start time ");
		}
	}

	public void CastingToEndTime(String txt) {
		int indx = txt.indexOf(":");
		String hour = txt.substring(0, indx);
		String minute = txt.substring(indx + 1);
		end_time = new pair(Integer.parseInt(hour), Integer.parseInt(minute));
	}

	public void setEnd_time(EditText txt) {
		try {
			CastingToEndTime(txt.getText().toString());
		} catch (Exception e) {
			System.out.println("String is invalid is end time");
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
};