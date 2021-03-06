package com.sny.tangyong.basic;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author tang
 * 
 */
public class LayoutActivity extends ListActivity {

	String[] units = new String[] { "FrameLayout" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.basic_item,
				units));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		Class cls = null;
		switch (position) {
		case 0:

			cls = LayoutViewActivity.class;

			break;
		default:

			break;
		}

		if (cls != null) {
			intentToActivity(cls);

		}
	}

	private void intentToActivity(Class cls) {
		Intent intent = new Intent();
		intent.setClass(this, cls);

		startActivity(intent);
	}

}
