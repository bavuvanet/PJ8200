package com.pj8200.android.view.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pj8200.android.R;
import com.pj8200.android.view.adapter.ServiceAdapter;

public class ServicesProviderActivity extends Activity implements OnItemClickListener {

	private ListView mServiceListView;
	private List<String> mList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		
		mServiceListView = (ListView) findViewById(R.id.list);
		mServiceListView.setOnItemClickListener(this);

		// hard code
		mList.add("English");
		mList.add("Vietnamese");
		mList.add("France");
		mList.add("Pari");
		mList.add("London");
		mList.add("Ha Noi");
		mList.add("TP. Ho Chi Minh");
		mList.add("Hai Phong");
		mList.add("Da Nang");
		mList.add("Nghe An");
		
		ServiceAdapter objAdapter = new ServiceAdapter(
				ServicesProviderActivity.this, R.layout.service_row, mList);
		mServiceListView.setAdapter(objAdapter);

		if (null != mList && mList.size() != 0) {
			Collections.sort(mList, new Comparator<String>() {

				@Override
				public int compare(String lhs, String rhs) {
					return lhs.compareTo(rhs);
				}
			});

		} else {
//			showToast("No Contact Found!!!");
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> listview, View v, int position,
			long id) {
		String item = (String) listview.getItemAtPosition(position);
	}
	
}
