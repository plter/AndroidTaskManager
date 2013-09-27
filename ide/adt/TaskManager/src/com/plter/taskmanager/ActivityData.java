package com.plter.taskmanager;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.drawable.Drawable;

public class ActivityData extends TaskListCellData {

	public ActivityData(Context context, ActivityManager am,String packageName,String label, Drawable icon) {
		super(context,packageName,label, icon);
		activityManager = am;
		this.packageName = packageName;
	}
	
	public ActivityManager getActivityManager() {
		return activityManager;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public String getProcessName() {
		return packageName;
	}

	@Override
	public void killThisTask() {
		getActivityManager().killBackgroundProcesses(getProcessName());
	}		
	
	
	@Override
	public void checkToExit() {
		if (getProcessName().equals(getContext().getPackageName())) {
			System.exit(0);
		}
	}
	
	private ActivityManager activityManager;
	private String packageName = null;
	

}
