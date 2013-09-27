package com.plter.taskmanager;

import java.util.List;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ListActivity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ListActivity {
	
	private OnClickListener btnKillAllClickHandler = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			adapter.killAll();
		}
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        packageManager = getPackageManager();
        
        adapter = new TaskListAdapter(am,this);
        setListAdapter(adapter);    
        
        findViewById(R.id.btnKillAll).setOnClickListener(btnKillAllClickHandler );
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	refreshTaskList();
    }
    
    public void refreshTaskList(){
    	
    	adapter.clear();
    	
    	List<RunningAppProcessInfo> processes = am.getRunningAppProcesses();
    	
    	for (RunningAppProcessInfo runningAppProcessInfo : processes) {
    		try {
				ApplicationInfo appInfo = packageManager.getApplicationInfo(runningAppProcessInfo.processName, PackageManager.GET_META_DATA);
				adapter.addTaskData(new TaskData(runningAppProcessInfo.processName, packageManager.getApplicationLabel(appInfo).toString(),packageManager.getApplicationIcon(appInfo)));
    		} catch (NameNotFoundException e) {
			}
		}
    	
    	adapter.notifyDataSetChanged();
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
		case R.id.action_about:
			new AlertDialog.Builder(this).setTitle(R.string.action_about).setMessage(R.string.action_about_content).setPositiveButton(R.string.close, null).show();
			break;
		}
    	
    	return super.onOptionsItemSelected(item);
    }
    
    private ActivityManager am;
	private TaskListAdapter adapter = null;
	private PackageManager packageManager = null;
    
}
