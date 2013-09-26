package com.plter.taskmanager;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

public class RemoveCellAnimWork {

	private AnimationListener animListener=new Animation.AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			
			getTaskListAdapter().remove(getTaskData());
			getTaskListAdapter().notifyDataSetChanged();
			
			if (getTaskData().getPackageName().equals(getTaskListAdapter().getContext().getPackageName())) {
				System.exit(0);
			}
		}
	};
	
	
	public RemoveCellAnimWork(View cell,TaskListAdapter adapter,TaskData data) {
		this.cell = cell;
		taskListAdapter = adapter;
		taskData = data;
		
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
		animation.setDuration(300);
		animation.setAnimationListener(animListener);
	}
	
	public View getCell() {
		return cell;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public TaskListAdapter getTaskListAdapter() {
		return taskListAdapter;
	}
	
	public TaskData getTaskData() {
		return taskData;
	}
	
	private View cell;
	private Animation animation = null;
	private TaskListAdapter taskListAdapter = null;
	private TaskData taskData = null;
}
