package main.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class CenterLockHorizontalScrollview extends HorizontalScrollView {
	Context context;
	int prevIndex = 0;

	public CenterLockHorizontalScrollview(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		this.setSmoothScrollingEnabled(true);
		addchildrenView();

	}
    ViewPager vp;
	public void setAdapter(Context context, BaseAdapter mAdapter) {

		try {
			fillViewWithAdapter(mAdapter);
		} catch (ZeroChildException e) {

			e.printStackTrace();
		}
	}


	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if(vp!=null)
		vp.requestDisallowInterceptTouchEvent(true);
		return super.onTouchEvent(ev);
	}
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
    	if(vp!=null)
    	vp.requestDisallowInterceptTouchEvent(true);
    	return super.onInterceptTouchEvent(ev);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    	if(vp!=null)
        	vp.requestDisallowInterceptTouchEvent(true);
    	return super.dispatchTouchEvent(ev);
    }
	private void fillViewWithAdapter(BaseAdapter mAdapter)
			throws ZeroChildException {
		if (getChildCount() == 0) {
			throw new ZeroChildException(
					"CenterLockHorizontalScrollView must have one child");
		}
		if (getChildCount() == 0 || mAdapter == null)
			return;

		ViewGroup parent = (ViewGroup) getChildAt(0);

		parent.removeAllViews();

		for (int i = 0; i < mAdapter.getCount(); i++) {
			// o.v("CenterLockHorizontalScrollview","parent.addView("+i);
			parent.addView(mAdapter.getView(i, null, parent));
		}
	}

	public void setCenter(int index) {

		ViewGroup parent = (ViewGroup) getChildAt(0);

		View preView = parent.getChildAt(prevIndex);
		preView.setBackgroundColor(Color.parseColor("#64CBD8"));
		android.widget.LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		lp.setMargins(5, 5, 5, 5);
		preView.setLayoutParams(lp);

		View view = parent.getChildAt(index);
		view.setBackgroundColor(Color.RED);

		@SuppressWarnings("deprecation")
		int screenWidth = ((Activity) context).getWindowManager()
				.getDefaultDisplay().getWidth();

		int scrollX = (view.getLeft() - (screenWidth / 2))
				+ (view.getWidth() / 2);
		this.smoothScrollTo(scrollX, 0);
		prevIndex = index;
	}

	private void addchildrenView() {
		LinearLayout line = new LinearLayout(context);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		line.setLayoutParams(params);
		this.addView(line);
	}

	public ViewPager getVp() {
		return vp;
	}

	public void setVp(ViewPager vp) {
		this.vp = vp;
	}
}
