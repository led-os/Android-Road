package com.sny.tangyong.basic;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tang
 *
 *         <p/>
 *         <p/>
 *         <activity android:name="com.ty.exsample_unit_4.CanvasSavelayerActivity"></activity>
 */
public class HandlerTestActivity extends Activity implements Callback, OnClickListener {

    Handler mHandler;
    private static final int MESSAGE_TYPE_S = 1;
    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler = new Handler(this);
        Button btn = new Button(this);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 167);
        btn.setLayoutParams(params);
        btn.setText("Click Me");

        btn.setOnClickListener(this);

        mContainer = new LinearLayout(this);
        mContainer.setOrientation(LinearLayout.VERTICAL);
        LayoutParams ly_params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        mContainer.setLayoutParams(ly_params);

        mContainer.addView(btn);

        setContentView(mContainer);
    }

    @Override
    public boolean handleMessage(Message msg) {

        int what = msg.what;

        switch (what) {
            case MESSAGE_TYPE_S:

                TextView tx = new TextView(this);
                LayoutParams params = new LayoutParams(
                        LayoutParams.MATCH_PARENT, 67);
                tx.setLayoutParams(params);
                tx.setText(getStringDate());

                mContainer.addView(tx);

                Log.i("tyler.tang", "我来了.");

                break;

            default:
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        mHandler.removeMessages(MESSAGE_TYPE_S);
        mHandler.sendEmptyMessageDelayed(MESSAGE_TYPE_S, 2 * 1000);

    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

}
