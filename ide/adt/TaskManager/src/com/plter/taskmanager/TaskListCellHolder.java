package com.plter.taskmanager;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskListCellHolder {
	
	
	public TaskListCellHolder(View listCell,View taskDataContainer,View gapTitleContainer,TextView tvLabel,TextView tvProcessName,ImageView ivIcon,Button btnKill,TextView tvGapTitle) {
		this.tvLabel = tvLabel;
		this.ivIcon = ivIcon;
		this.btnKill = btnKill;
		this.listCell = listCell;
		this.tvGapTitle = tvGapTitle;
		this.gapTitleContainer = gapTitleContainer;
		this.taskDataContainer = taskDataContainer;
		this.tvProcessName = tvProcessName;
	}
	
	public Button getBtnKill() {
		return btnKill;
	}
	
	public ImageView getIvIcon() {
		return ivIcon;
	}
	
	public TextView getTvLabel() {
		return tvLabel;
	}
	
	public View getListCell() {
		return listCell;
	}
	
	public TextView getTvGapTitle() {
		return tvGapTitle;
	}
	
	public View getTaskDataContainer() {
		return taskDataContainer;
	}
	
	public View getGapTitleContainer() {
		return gapTitleContainer;
	}
	
	public void showTaskDataContainer(){
		getTaskDataContainer().setVisibility(View.VISIBLE);
		getGapTitleContainer().setVisibility(View.GONE);
	}
	
	
	public void showGapTitleContainer(){
		getTaskDataContainer().setVisibility(View.GONE);
		getGapTitleContainer().setVisibility(View.VISIBLE);
	}

	public TextView getTvProcessName() {
		return tvProcessName;
	}
	
	private TextView tvLabel;
	private ImageView ivIcon;
	private Button btnKill;
	private View listCell;
	private TextView tvGapTitle;
	private View taskDataContainer;
	private View gapTitleContainer;
	private TextView tvProcessName;
}
