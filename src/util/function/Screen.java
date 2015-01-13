package util.function;

import util.values.Variable;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class Screen
{
	@SuppressWarnings("deprecation")
	public static void getScreenSize(Activity activity)
	{
		Display display = activity.getWindowManager().getDefaultDisplay();
		
		Variable.screenWidth = display.getWidth();
		Variable.screenHeight = display.getHeight();
		WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);		
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(metrics);
		Variable.densityDpi = metrics.densityDpi;
	}

	public static void FullWindow(Activity activity)
	{
		//�����ޱ���  
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);  
        //����ȫ��  
		activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	}
}
