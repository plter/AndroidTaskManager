package com.plter.taskmanager;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskListAdapter extends BaseAdapter {
	
	private OnClickListener btnKillClickHandler=new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			BtnKillAttachment attachment = (BtnKillAttachment) v.getTag();
			attachment.getCell().startAnimation(new RemoveCellAnimWork(attachment.getCell(),TaskListAdapter.this,attachment.getTaskData()).getAnimation());
			
			getActivityManager().killBackgroundProcesses(attachment.getPackageName());
		}
	};

	public TaskListAdapter(ActivityManager activityManager,Context context) {
		this.context = context;
		tasks = new ArrayList<TaskData>();
		this.activityManager = activityManager;
		packageManager = context.getPackageManager();
	}
	
	
	public void killAll(){
		for (TaskData data : tasks) {
			getActivityManager().killBackgroundProcesses(data.getPackageName());
		}
		
		//kill self
		System.exit(0);
	}


	@Override
	public int getCount() {
		return tasks.size();
	}

	@Override
	public TaskData getItem(int arg0) {
		return tasks.get(arg0);
	}
	
	public void remove(TaskData data){
		tasks.remove(data);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	public void addTaskData(TaskData data){
		tasks.add(data);
	}

	public void clear(){
		tasks.clear();
	}


	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {

		TaskListCellHolder holder;

		if (arg1==null) {
			arg1 = LayoutInflater.from(getContext()).inflate(R.layout.task_list_cell, null);
			holder = new TaskListCellHolder(arg1,(TextView)arg1.findViewById(R.id.tvLabel), (ImageView)arg1.findViewById(R.id.ivIcon), (Button)arg1.findViewById(R.id.btnKill));
			arg1.setTag(holder);
		}else{
			holder = (TaskListCellHolder) arg1.getTag();
		}

		TaskData data = getItem(arg0);
		holder.getTvLabel().setText(data.getLabel());
		holder.getIvIcon().setImageDrawable(data.getIcon());

		BtnKillAttachment attachment = null;
		if (holder.getBtnKill().getTag()!=null) {
			attachment = (BtnKillAttachment) holder.getBtnKill().getTag();
		}else{
			attachment = new BtnKillAttachment();
			holder.getBtnKill().setTag(attachment);
			holder.getBtnKill().setOnClickListener(btnKillClickHandler);
		}
		
		//attach current data
		attachment.setCell(arg1);
		attachment.setPackageName(data.getPackageName());
		attachment.setTaskData(data);
		
		return arg1;
	}

	public Context getContext() {
		return context;
	}
	
	public PackageManager getPackageManager() {
		return packageManager;
	}

	public ActivityManager getActivityManager() {
		return activityManager;
	}
	
	private List<TaskData> tasks = null;
	private Context context = null;
	private PackageManager packageManager = null;
	private ActivityManager activityManager = null;

}
