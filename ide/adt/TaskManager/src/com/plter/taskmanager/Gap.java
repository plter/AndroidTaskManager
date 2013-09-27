package com.plter.taskmanager;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Gap extends TaskListCellData {

	public Gap(Context context, String label, Drawable icon) {
		super(context,null, label, icon);
	}
	
	
	@Override
	public boolean isGap() {
		return true;
	}
	

	@Override
	public void killThisTask() {
	}

	@Override
	public void checkToExit() {
	}

}
