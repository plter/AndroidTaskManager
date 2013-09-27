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
	
	
	public void setTaskData(TaskListCellData taskData) {
		this.taskData = taskData;
	}
	
	public TaskListCellData getTaskListCellData() {
		return taskData;
	}
	
	private TaskListCellData taskData;
	private View cell;
}
