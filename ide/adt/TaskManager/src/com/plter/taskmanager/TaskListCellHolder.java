package com.plter.taskmanager;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskListCellHolder {
	
	
	public TaskListCellHolder(View listCell,TextView tvLabel,ImageView ivIcon,Button btnKill) {
		this.tvLabel = tvLabel;
		this.ivIcon = ivIcon;
		this.btnKill = btnKill;
		this.listCell = listCell;
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

	private TextView tvLabel;
	private ImageView ivIcon;
	private Button btnKill;
	private View listCell;
}
