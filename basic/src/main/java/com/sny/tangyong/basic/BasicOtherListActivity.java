package com.sny.tangyong.basic;

import android.os.Bundle;

import java.util.ArrayList;

public class BasicOtherListActivity extends BaseListActivity {


    public BasicOtherListActivity() {
        initListItems();
    }

    public void initListItems() {

        mItemsInfo = new ArrayList<BaseListActivity.ItemComponentInfo>();

        BaseListActivity.ItemComponentInfo info;

        info = new ItemComponentInfo("ViewSave", ViewCycleTestActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("DeviceInfo", BasicDeviceInfoActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("UnCatchException", UnCatchExceptionActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("Http/Https", BasicHttpTwoActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("Identifying", BasicUnquiueIdentifyActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("Wifi Connected", BasicOtherWifiConectedActivity.class);
        mItemsInfo.add(info);

        info = new ItemComponentInfo("Error Report Test", BasicErrorReportActivity.class);
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
