package com.plter.taskmanager;

import android.view.View;

public class BtnKillAttachment {

	public BtnKillAttachment() {
	}
	
	public View getCell() {
		return cell;
	}
	
	public void setCell(View cell) {
		this.cell = cell;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public void setTaskData(TaskData taskData) {
		this.taskData = taskData;
	}
	
	public TaskData getTaskData() {
		return taskData;
	}
	
	private TaskData taskData;
	private View cell;
	private String packageName;
}
