package com.graphics.engine.gl.scroller;

/**
 * 连续滑屏的滚动器的监听者
 * 
 * @author dengweiming
 * 
 */
public interface ScrollerListener {

	/**
	 * <pre>
	 * 在滚动视图的过程中，每一步都会被调用。
	 * 1. 使用getProgress()获得滚动的进度（浮点索引值），若n为屏幕数目，
	 *    则默认调用的setPadding(0.5)使得它取值范围为(-0.5, n-0.5)
	 * 2. 使用getIndicatorOffset()获得指示器滑块的偏移量
	 * </pre>
	 * 
	 * @param newScroll
	 *            当前（新的）滚动量
	 * @param oldScroll
	 *            前一次的滚动量
	 * 
	 */
	void onScrollChanged(int newScroll, int oldScroll);

	// 以下这些是从ViewGroup的方法中抽取出来的接口
	/**
	 * 引发重绘
	 */
	void invalidate();

	/**
	 * 滚动视图
	 * 
	 * @param x
	 *            水平方向上的偏移增量
	 * @param y
	 *            垂直方向上的偏移增量
	 */
	void scrollBy(int x, int y);

	/**
	 * 获取水平方向上的偏移量
	 * 
	 * @return
	 */
	int getScrollX();

	/**
	 * 获取垂直方向上的偏移量
	 * 
	 * @return
	 */
	int getScrollY();

}
