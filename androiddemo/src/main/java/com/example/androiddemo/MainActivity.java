package com.example.androiddemo;

import android.os.Bundle;

import com.sny.tangyong.common.view.BaseListActivity;
import com.sny.tangyong.common.view.EmptyActivity;
import com.sny.tangyong.common.view.ItemComponentInfo;
import com.ty.example_unit_3.libgdx.UnitThreeActivity;

import java.util.ArrayList;

/**
 *    Basic Demo
 *
 */
public class MainActivity extends BaseListActivity {

    public MainActivity() {
        initListItems();
    }

    public void initListItems() {

        mItemsInfo = new ArrayList<ItemComponentInfo>();

        ItemComponentInfo info;

        info = new ItemComponentInfo("Baisc", com.sny.tangyong.basic.MainActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("OpenGl", com.ty.example_unit_2.UnitTwoActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("Libgdx", UnitThreeActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("Engine", EmptyActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("Open Project", EmptyActivity.class);
        mItemsInfo.add(info);

        initDisplayList();
    }


    private void initDisplayList() {
        if (mItemsInfo != null && mItemsInfo.size() > 0) {
            mUnits = new String[mItemsInfo.size()];

            for (int i = 0; i < mItemsInfo.size(); i++) {
                mUnits[i] = mItemsInfo.get(i).mDisplayName;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActionBar();
    }

}
