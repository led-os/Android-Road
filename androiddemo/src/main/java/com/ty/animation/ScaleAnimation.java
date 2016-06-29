/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ty.animation;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;

/**
 * An animation that controls the scale of an object. You can specify the point
 * to use for the center of scaling.
 * 
 */
//CHECKSTYLE:OFF
public class ScaleAnimation extends Animation {
    private final Resources mResources;

    private float mFromX;
    private float mToX;
    private float mFromY;
    private float mToY;
    private float mFromZ;
    private float mToZ;

//    private int mFromXType = TypedValue.TYPE_NULL;
//    private int mToXType = TypedValue.TYPE_NULL;
//    private int mFromYType = TypedValue.TYPE_NULL;
//    private int mToYType = TypedValue.TYPE_NULL;
//
//    private int mFromXData = 0;
//    private int mToXData = 0;
//    private int mFromYData = 0;
//    private int mToYData = 0;
//
//    private int mPivotXType = ABSOLUTE;
//    private int mPivotYType = ABSOLUTE;
//    private float mPivotXValue = 0.0f;
//    private float mPivotYValue = 0.0f;
//
//    private float mPivotX;
//    private float mPivotY;

    /**
     * Constructor to use when building a ScaleAnimation from code
     * 
     * @param fromX Horizontal scaling factor to apply at the start of the
     *        animation
     * @param toX Horizontal scaling factor to apply at the end of the animation
     * @param fromY Vertical scaling factor to apply at the start of the
     *        animation
     * @param toY Vertical scaling factor to apply at the end of the animation
     */
    public ScaleAnimation(float fromX, float toX, float fromY, float toY, float fromZ, float toZ) {
        mResources = null;
        mFromX = fromX;
        mToX = toX;
        mFromY = fromY;
        mToY = toY;
        mFromZ = fromZ;
        mToZ = toZ;
//        mPivotX = 0;
//        mPivotY = 0;
    }

    /**
     * Constructor to use when building a ScaleAnimation from code
     * 
     * @param fromX Horizontal scaling factor to apply at the start of the
     *        animation
     * @param toX Horizontal scaling factor to apply at the end of the animation
     * @param fromY Vertical scaling factor to apply at the start of the
     *        animation
     * @param toY Vertical scaling factor to apply at the end of the animation
     * @param pivotX The X coordinate of the point about which the object is
     *        being scaled, specified as an absolute number where 0 is the left
     *        edge. (This point remains fixed while the object changes size.)
     * @param pivotY The Y coordinate of the point about which the object is
     *        being scaled, specified as an absolute number where 0 is the top
     *        edge. (This point remains fixed while the object changes size.)
     */
//    public ScaleAnimation(float fromX, float toX, float fromY, float toY, float fromZ, float toZ,
//            float pivotX, float pivotY) {
//        mResources = null;
//        mFromX = fromX;
//        mToX = toX;
//        mFromY = fromY;
//        mToY = toY;
//
//        mPivotXType = ABSOLUTE;
//        mPivotYType = ABSOLUTE;
//        mPivotXValue = pivotX;
//        mPivotYValue = pivotY;
//        initializePivotPoint();
//    }

    /**
     * Constructor to use when building a ScaleAnimation from code
     * 
     * @param fromX Horizontal scaling factor to apply at the start of the
     *        animation
     * @param toX Horizontal scaling factor to apply at the end of the animation
     * @param fromY Vertical scaling factor to apply at the start of the
     *        animation
     * @param toY Vertical scaling factor to apply at the end of the animation
     * @param pivotXType Specifies how pivotXValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param pivotXValue The X coordinate of the point about which the object
     *        is being scaled, specified as an absolute number where 0 is the
     *        left edge. (This point remains fixed while the object changes
     *        size.) This value can either be an absolute number if pivotXType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     * @param pivotYType Specifies how pivotYValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param pivotYValue The Y coordinate of the point about which the object
     *        is being scaled, specified as an absolute number where 0 is the
     *        top edge. (This point remains fixed while the object changes
     *        size.) This value can either be an absolute number if pivotYType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     */
//    public ScaleAnimation(float fromX, float toX, float fromY, float toY,
//            int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
//        mResources = null;
//        mFromX = fromX;
//        mToX = toX;
//        mFromY = fromY;
//        mToY = toY;
//
//        mPivotXValue = pivotXValue;
//        mPivotXType = pivotXType;
//        mPivotYValue = pivotYValue;
//        mPivotYType = pivotYType;
//        initializePivotPoint();
//    }

    /**
     * Called at the end of constructor methods to initialize, if possible, values for
     * the pivot point. This is only possible for ABSOLUTE pivot values.
     */
//    private void initializePivotPoint() {
//        if (mPivotXType == ABSOLUTE) {
//            mPivotX = mPivotXValue;
//        }
//        if (mPivotYType == ABSOLUTE) {
//            mPivotY = mPivotYValue;
//        }
//    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float sx = 1.0f;
        float sy = 1.0f;
        float sz = 1.0f;
        float scale = getScaleFactor();

        if (mFromX != 1.0f || mToX != 1.0f) {
            sx = mFromX + ((mToX - mFromX) * interpolatedTime);
        }
        if (mFromY != 1.0f || mToY != 1.0f) {
            sy = mFromY + ((mToY - mFromY) * interpolatedTime);
        }
        if (mFromZ != 1.0f || mToZ != 1.0f) {
            sz = mFromZ + ((mToZ - mFromZ) * interpolatedTime);
        }
//        t.getMatrix().scale(sx, sy, sz);
        Log.d("KEVIN", "sx = " + sx + ", sy = " + sy + ", sz = " + sz);
//        t.getMatrix().scl(sx, sy, sz);
        t.getMatrix().scl(sx, sy, sz);
        

//        if (mPivotX == 0 && mPivotY == 0) {
//            t.getMatrix().setScale(sx, sy);
//        } else {
//            t.getMatrix().setScale(sx, sy, scale * mPivotX, scale * mPivotY);
//        }
    }

    float resolveScale(float scale, int type, int data, int size, int psize) {
        float targetSize;
        if (type == TypedValue.TYPE_FRACTION) {
            targetSize = TypedValue.complexToFraction(data, size, psize);
        } else if (type == TypedValue.TYPE_DIMENSION) {
            targetSize = TypedValue.complexToDimension(data, mResources.getDisplayMetrics());
        } else {
            return scale;
        }

        if (size == 0) {
            return 1;
        }

        return targetSize/(float)size;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
//
//        mFromX = resolveScale(mFromX, mFromXType, mFromXData, width, parentWidth);
//        mToX = resolveScale(mToX, mToXType, mToXData, width, parentWidth);
//        mFromY = resolveScale(mFromY, mFromYType, mFromYData, height, parentHeight);
//        mToY = resolveScale(mToY, mToYType, mToYData, height, parentHeight);
//
//        mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
//        mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
    }
}
