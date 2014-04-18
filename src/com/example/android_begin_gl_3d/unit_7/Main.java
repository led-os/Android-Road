package com.example.android_begin_gl_3d.unit_7;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.example.android_begin_gl_3d.R;

/**
 * 
 * <br>
 * 类描述: 程序主入口 <br>
 * 功能详细描述: 包含多个测试样例的列表
 * 
 * @author dengweiming
 * @date [2013-5-29]
 */
public class Main extends ListActivity {
	public final static String KEY_CONTENT_VIEW = "ContentView";
	public final static String VIEW_NAME_PREFIX = "com.go.test.shellengine.";

	private List<String> mItemTitle = new ArrayList<String>();
	private List<String> mItemViewName = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addItems();
		ArrayAdapter<String> fileList = new ArrayAdapter<String>(this, R.layout.main_list,
				mItemTitle);
		setListAdapter(fileList);
		setContentView(R.layout.main);
	}

	private void addItem(String title, String viewName) {
		mItemTitle.add(title);
		if (viewName.indexOf('.') < 0) {
			mItemViewName.add(VIEW_NAME_PREFIX + viewName);
		} else if (viewName.indexOf(' ') >= 0) {
			mItemViewName.add(viewName.substring(viewName.indexOf(' ') + 1));
		} else {
			mItemViewName.add(viewName);
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		if (position >= 0 && position < mItemViewName.size()) {
			Intent intent = new Intent(this, BaseTestActivity.class);
			intent.putExtra(KEY_CONTENT_VIEW, mItemViewName.get(position));
			startActivity(intent);
		}
	}

	/**
	 * TODO: 在这里添加具体的GLView和名称
	 */
	void addItems() {
		addItem("Cylinder Drag", CylinderDragTestView.class.toString());
		addItem("Animation", AnimatorSetTestView.class.toString());
		addItem("MotionFilter", MotionFilterTestView.class.toString());
		addItem("Rotate", RotateTestView.class.toString());
		addItem("Drag", DragTestView.class.toString());
	}
}
