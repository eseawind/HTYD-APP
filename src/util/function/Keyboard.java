package util.function;

import android.app.Activity;
import android.view.WindowManager;

public class Keyboard 
{
	public static void hideSoftInput(Activity context)
	{
		context.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);	
	}
}
