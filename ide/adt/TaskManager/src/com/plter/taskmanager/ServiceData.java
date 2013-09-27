package com.plter.taskmanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class ServiceData extends TaskListCellData{

	public ServiceData(Context context, String processName,ComponentName componentName,String label, Drawable icon) {
		super(context,processName, label, icon);
		this.componentName = componentName;
	}

	@Override
	public void killThisTask() {
		try{
			Intent i = new Intent();
			i.setComponent(getComponentName());
			getContext().stopService(i);
		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("TODO:need permission "+getComponentName().getPackageName());
		}
	}

	@Override
	public void checkToExit() {
	}

	public ComponentName getComponentName() {
		return componentName;
	}

	private ComponentName componentName;

}
