package com.sny.tangyong.demostart.service;

import android.content.Context;
import android.content.Intent;

import com.sny.tangyong.demostart.bean.Chapter;

import java.util.ArrayList;
import java.util.logging.Handler;

/**
 * Created by T540P on 2015/8/28.
 */
public class ChapterDataControler implements ILifeCycle {

    private static ChapterDataControler mInstance;
    private ILoaderDataService mLoaderDataService;
    private ArrayList<Chapter> mChapters;
    private Context mContext;

    private ChapterDataControler() {
    }


    private ILoaderDataService getmLoaderDataService() {

        if (mLoaderDataService == null) {
            mLoaderDataService = new LoadDataServiceImpl();
        }

        return mLoaderDataService;
    }

    public static ChapterDataControler getmInstance() {

        if (mInstance == null) {
            mInstance = new ChapterDataControler();
        }

        return mInstance;
    }


    /**
     * 在 ChapterDataControler里面控制 Chapter 的访问    *
     *
     * @return
     * @throws Exception
     */
    public ArrayList<Chapter> getmChapters(Context mContext) throws Exception {

        if (mChapters != null && !mChapters.isEmpty()) {
            return mChapters;
        }

        ILoaderDataService loaderDataService = getmLoaderDataService();

        try {

            mChapters = loaderDataService.loadChapterData(mContext);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return mChapters;
    }


    public Class getChapterIntentByTitle(String id, Context context) throws Exception {

        Class c = null;
        if (mChapters == null) {
            mChapters = getmChapters(context);
        }

        for (Chapter temp : mChapters) {

            String key = temp.getKey();

            if (key.equals(id)) {
                c = temp.getActionIntentClass();
            }
        }
        return c;
    }


    @Override
    public void onSetup() {

    }


    @Override
    public void onDestory() {

        mChapters = null;
        mLoaderDataService.onDestory();
        mLoaderDataService = null;

    }
}
