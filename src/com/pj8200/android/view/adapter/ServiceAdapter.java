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

public class ServiceAdapter extends ArrayAdapter<String> {

	private Activity mActivity;
	private List<String> mItems;
	private int mRow;
	private String mServiceName;

	public ServiceAdapter(Activity act, int row, List<String> items) {
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

		mServiceName = mItems.get(position);

		holder.serviceName = (TextView) view.findViewById(R.id.serviceName);

		if (holder.serviceName != null && null != mServiceName
				&& mServiceName.trim().length() > 0) {
			holder.serviceName.setText(Html.fromHtml(mServiceName));
		}
		return view;
	}

	public class ViewHolder {
		public TextView serviceName;
	}

}
