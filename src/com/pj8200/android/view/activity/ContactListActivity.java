package com.pj8200.android.view.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pj8200.android.R;
import com.pj8200.android.view.adapter.ContactAdapter;
import com.pj8200.android.view.adapter.item.ContactItem;

public class ContactListActivity extends Activity implements OnItemClickListener {
	private ListView mContactListView;
	private List<ContactItem> mList = new ArrayList<ContactItem>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		
		mContactListView = (ListView) findViewById(R.id.list);
		mContactListView.setOnItemClickListener(this);

		Cursor phones = getContentResolver().query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
				null, null);
		while (phones.moveToNext()) {

			String name = phones
					.getString(phones
							.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

			String phoneNumber = phones
					.getString(phones
							.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

			ContactItem contactItem = new ContactItem();
			contactItem.setName(name);
			contactItem.setPhoneNo(phoneNumber);
			mList.add(contactItem);

		}
		phones.close();

		ContactAdapter objAdapter = new ContactAdapter(
				ContactListActivity.this, R.layout.contact_row, mList);
		mContactListView.setAdapter(objAdapter);

		if (null != mList && mList.size() != 0) {
			Collections.sort(mList, new Comparator<ContactItem>() {

				@Override
				public int compare(ContactItem lhs, ContactItem rhs) {
					return lhs.getName().compareTo(rhs.getName());
				}
			});

		} else {
//			showToast("No Contact Found!!!");
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> listview, View v, int position,
			long id) {
		ContactItem item = (ContactItem) listview.getItemAtPosition(position);
	}

}
