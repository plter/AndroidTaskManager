package com.plter.taskmanager;

import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class TaskListCellData {

	public TaskListCellData(Context context, String processName,String label,Drawable icon) {
		this.icon = icon;
		this.label = label;
		this.context = context;
		this.processName = processName;
	}
	
	public Drawable getIcon() {
		return icon;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Context getContext() {
		return context;
	}
	
	public boolean isGap(){
		return false;
	}
	
	public String getProcessName() {
		return processName;
	}
	
	public abstract void killThisTask();
	public abstract void checkToExit();
	
	
	private Drawable icon = null;
	private String label = null;
	private Context context = null;
	private String processName = null;
}
