package com.ty.example_unit_2.opengl_2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android_begin_gl_3d.R;
import com.ty.example_unit_2.opengl_2.loadmodel.LoadModelActivity;
import com.ty.example_unit_2.opengl_2.meshcube.ＭeshCubeActivity;
import com.ty.example_unit_2.opengl_2.sensormanager.SensorManagerActivity;
import com.ty.example_unit_2.opengl_2.shading.ShadingLanguageActivity;
import com.ty.example_unit_2.opengl_2.shading.ShandingView;

/**
 * 
 * @author tangyong
 * 
 */
public class OpenGL2Activity extends ListActivity {

	String[] units = new String[] { "MeshCube", "LoadModel" ,"Shading Language","sensorManager" };

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
			cls = ＭeshCubeActivity.class;
			break;
		case 1:
			cls = LoadModelActivity.class;
			break;
		case 2:
			cls = ShadingLanguageActivity.class;
			break;
		case 3:
			cls = SensorManagerActivity.class;
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		default:
			break;
		}
		intentToActivity(cls);
	}

	private void intentToActivity(Class cls) {
		Intent intent = new Intent();
		intent.setClass(this, cls);

		startActivity(intent);
	}

}
