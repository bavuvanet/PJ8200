package com.pj8200.android;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

import com.pj8200.android.view.activity.ContactListActivity;
import com.pj8200.android.view.activity.DialActivity;
import com.pj8200.android.view.activity.RecentCallActivity;
import com.pj8200.android.view.activity.ServicesProviderActivity;

@SuppressWarnings("deprecation")
public class HomeActivity extends TabActivity implements OnTabChangeListener {
	/** Called when the activity is first created. */
	
	TabHost mTabHost;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTabHost = getTabHost();
		mTabHost.setOnTabChangedListener(this);

		mTabHost.addTab(mTabHost
				.newTabSpec("Service Tab")
				.setIndicator("",
						getResources().getDrawable(R.drawable.services))
				.setContent(new Intent(this, ServicesProviderActivity.class)));

		mTabHost.addTab(mTabHost
				.newTabSpec("Recent Tab")
				.setIndicator("",
						getResources().getDrawable(R.drawable.recent))
				.setContent(new Intent(this, RecentCallActivity.class)));

		mTabHost.addTab(mTabHost
				.newTabSpec("Contact Tab")
				.setIndicator("",
						getResources().getDrawable(R.drawable.contacts))
				.setContent(new Intent(this, ContactListActivity.class)));
		
		mTabHost.addTab(mTabHost
				.newTabSpec("Dial Tab")
				.setIndicator("",
						getResources().getDrawable(R.drawable.dial))
				.setContent(new Intent(this, DialActivity.class)));
		
		for(int i=0; i < mTabHost.getTabWidget().getChildCount(); i++) {
        	mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.white);
		}
		
		mTabHost.setCurrentTab(0);
		
		mTabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.color.blue);
	}
	
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
			mTabHost.getTabWidget().getChildAt(i)
					.setBackgroundResource(R.color.white);
		}
		mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab())
				.setBackgroundResource(R.color.blue);
	}
	
}