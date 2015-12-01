package com.example.androiddemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.androiddemo.unit_7.Main;
import com.example.androiddemo.unit_8.UnitEight;
import com.exsample.apiguids.APIGUIDS;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.ty.example_unit_1.UnitOneActivity;
import com.ty.example_unit_3.libgdx.UnitThreeActivity;
import com.ty.example_unit_6.UnitSixActivity;
import com.sny.tangyong.androiddemo.R;

import com.ty.exsample_unit_5.UnitFiveActivity;
import com.ty.open_source_project.OpenSouceProjectActivity;

//import com.ty.dex.TestDex;

/**
 * @author tangyong
 */
public class MainActivity extends ListActivity {

    GoogleAnalytics analytics;

    String[] units = new String[]{"unit_1", "unit_2[OpenGL1.x/2.x]", "unit_3[LibGDX]", "unit_4[Android基本知识]", "unit_5[Android游戏开发案例]", "unit_6[重用组件]", "unit_7[Shell Engine]",
            "unit_8[EffectJava]", "unit_9[android源码剖析]", "API guids", "Open Source Project"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setListAdapter(new ArrayAdapter<>(this, R.layout.main_items, units));


        // google analytics mainActivity Enter
        analytics = GoogleAnalytics.getInstance(this);
        Tracker traker = analytics.newTracker("UA-54473027-2");
        traker.setPage("MainActivity");
        traker.send(new HitBuilders.EventBuilder().setCategory("UX").setAction("Enter").setLabel("init").setValue(0).build());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Class cls = null;
        switch (position) {
            case 0:
                cls = UnitOneActivity.class;
                break;
            case 1:
                cls = com.ty.example_unit_2.UnitTwoActivity.class;
                break;
            case 2:
                cls = UnitThreeActivity.class;
                break;
            case 3:
                //	cls = UnitFourActivity.class;
                break;
            case 4:
                cls = UnitFiveActivity.class;
                break;
            case 5:
                cls = UnitSixActivity.class;
                break;
            case 6:
                cls = Main.class;
                break;
            case 7:

                cls = EffectJavaActivity.class;
                break;
            case 8:
                cls = UnitEight.class;
                break;

            case 9:

                cls = APIGUIDS.class;

                break;
            case 10:

                cls = OpenSouceProjectActivity.class;
                break;

            default:
                break;
        }

        intentToUnit(cls);
    }

    private void intentToUnit(Class cls) {

        Intent intent = new Intent();
        intent.setClass(this, cls);

        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
