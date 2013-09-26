package com.plter.taskmanager;

import android.graphics.drawable.Drawable;

public class TaskData {

	public TaskData(String packageName,String label,Drawable icon) {
		this.icon = icon;
		this.packageName = packageName;
		this.label = label;
	}
	
	public Drawable getIcon() {
		return icon;
	}
	
	public String getPackageName(){
		return packageName;
	}
	
	public String getLabel() {
		return label;
	}
	
	
	private Drawable icon = null;
	private String packageName = null;
	private String label = null;
	
}
