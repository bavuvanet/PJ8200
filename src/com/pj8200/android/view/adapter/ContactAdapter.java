package com.pj8200.android.view.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pj8200.android.R;
import com.pj8200.android.view.adapter.item.ContactItem;

public class ContactAdapter extends ArrayAdapter<ContactItem> {

	private Activity mActivity;
	private List<ContactItem> mItems;
	private int mRow;
	private ContactItem mContactItem;

	public ContactAdapter(Activity act, int row, List<ContactItem> items) {
		super(act, row, items);

		this.mActivity = act;
		this.mRow = row;
		this.mItems = items;

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) mActivity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(mRow, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((mItems == null) || ((position + 1) > mItems.size()))
			return view;

		mContactItem = mItems.get(position);

		holder.tvname = (TextView) view.findViewById(R.id.tvname);
		holder.tvPhoneNo = (TextView) view.findViewById(R.id.tvphone);

		if (holder.tvname != null && null != mContactItem.getName()
				&& mContactItem.getName().trim().length() > 0) {
			holder.tvname.setText(Html.fromHtml(mContactItem.getName()));
		}
		if (holder.tvPhoneNo != null && null != mContactItem.getPhoneNo()
				&& mContactItem.getPhoneNo().trim().length() > 0) {
			holder.tvPhoneNo.setText(Html.fromHtml(mContactItem.getPhoneNo()));
		}
		return view;
	}

	public class ViewHolder {
		public TextView tvname, tvPhoneNo;
	}

}
