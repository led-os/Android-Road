package com.example.android_begin_gl_3d.unit_7;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ty.exsample.R;
import com.ty.example_unit_6.seekbar.DockLineDialog;

/**
 * 
 * @author tang
 * 
 */
public class ShellEngineActivity extends ListActivity {

	String[] units = new String[] { "绘制功能表圆柱体" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.main_items,
				units));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		Class cls = null;
		switch (position) {
		case 0:
			cls = Cire3DActivity.class;
			break;

		}
		intentToActivity(cls);
	}

	private void intentToActivity(Class cls) {
		if (cls == null)
			return;
		Intent intent = new Intent();
		intent.setClass(this, cls);

		startActivity(intent);
	}

}
