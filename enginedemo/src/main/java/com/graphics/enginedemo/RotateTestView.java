package com.graphics.enginedemo;


import android.content.Context;
import android.view.MotionEvent;

import com.graphics.engine.graphics.GLCanvas;
import com.graphics.engine.graphics.GLDrawable;
import com.graphics.engine.view.GLView;

/**
 * 
 */
public class RotateTestView extends GLView {
	GLDrawable mDrawable;
	float mEuler[] = new float[3];

	public RotateTestView(Context context) {
		super(context);
		mDrawable = GLDrawable.getDrawable(getResources(), R.drawable.preview_panel);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		mDrawable.setBounds(0, 0, (int) (w * 0.75f), (int) (h * 0.75f));
	}

	float t;	//CHECKSTYLE IGNORE

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		t = (event.getX() - 100) / (getWidth() - 200);
		t = Math.max(0, Math.min(t, 1));
		invalidate();
		return true;
	}

	@Override
	protected void onDraw(GLCanvas canvas) {
		canvas.translate(getWidth() / 2, getHeight() / 2);

		int w = mDrawable.getBounds().width();
		int h = mDrawable.getBounds().height();

		float delta = (float) Math.toRadians(30);
		//		float delta = (float) Math.atan(w / (float) h);
		float a = delta * (1 - t);
		//		canvas.rotateAxisAngle(180 * t, (float) Math.sin(a), (float) Math.cos(a), 0);
		GLCanvas.convertAxisAngleToEulerAngle(180 * t, (float) Math.sin(a), (float) Math.cos(a), 0, mEuler);
		canvas.rotateEuler(mEuler[0], mEuler[1], mEuler[2]);

		canvas.translate(-w / 2, -h / 2);
		mDrawable.draw(canvas);

		canvas.translate(w / 2, 0);
		canvas.rotateAxisAngle(180, 0, 1, 0);
		canvas.translate(-w / 2, 0);
		mDrawable.draw(canvas);
	}

}
