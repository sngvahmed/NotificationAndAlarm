package com.example.project;

public class pair {
	public pair(int x, int y) {
		hour = x;
		minute = y;
	}

	public boolean validate() {
		if (hour < 0 || hour > 24)
			return false;
		if (minute > 60 || minute < 0)
			return false;
		return true;
	}

	public String toString() {
		return Integer.toString(hour) + ":" + Integer.toString(minute);
	}

	public int minute, hour;
};