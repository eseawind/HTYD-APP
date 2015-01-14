package util.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

@SuppressLint("DrawAllocation")
public class StrokeEditText extends EditText {

	public StrokeEditText(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	
	@Override
	protected void onDraw(Canvas canvas) 
	{
		super.onDraw(canvas);

		this.setFocusable(true);
		this.setBackgroundColor(Color.WHITE);
		Paint myPaint = new Paint();
		myPaint.setStyle(Paint.Style.STROKE); // 设置style
		myPaint.setAntiAlias(true); // 抗锯齿
		myPaint.setStrokeWidth(3); // 设置边框宽度
		myPaint.setColor(Color.parseColor("#02b9f5")); // 设置边框颜色
		canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), myPaint);
	}
}
