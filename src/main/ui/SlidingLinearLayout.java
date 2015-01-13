package main.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class SlidingLinearLayout extends LinearLayout {

	/*手势动作最开始时的x坐标*/
	private float lastMotionX = -1;
	
	public SlidingLinearLayout(Context context, AttributeSet attrs) {
		
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		
		if(ev.getAction() == MotionEvent.ACTION_DOWN)
		{
			this.lastMotionX = (int)ev.getRawX();
		}
		if(this.lastMotionX < 20)
			return true;
		else if(main.activity.MenuHorizontalScrollView.menuOut)
			return true;
		else
//			return false;
			return super.onInterceptTouchEvent(ev);
	}

}
