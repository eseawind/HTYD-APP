package util.dialog;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.AlertDialog.Builder;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;
import android.view.LayoutInflater;

@SuppressLint("NewApi")
public class  DialogHelper 
{

	//定义一个显示消息的对话框
	public static void showDialog(Context ctx,String msg,Boolean goHome) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage(msg);
		builder.setCancelable(false);
		if (goHome) 
		{
			builder.setPositiveButton("确定",null);	
			builder.setNegativeButton("取消", null);
		}
		else 
		{
			builder.setPositiveButton("确定",null);			
		}
		builder.create().show();
	}
	//定义一个显示消息和标题的对话框
	public static void showDialog(Context ctx,String msg,String title,Boolean goHome) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage(msg);
		builder.setTitle(title);
		builder.setCancelable(false);
		if (goHome) 
		{
			builder.setPositiveButton("确定", null);		
			builder.setNegativeButton("取消", null);
		}
		else 
		{
			builder.setPositiveButton("确定",null);			
		}

		builder.create().show();
	}
	//定义一个显示消息和图片的对话框
	public static void showDialog(Context ctx,String msg,int icon,Boolean goHome) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage(msg);
		builder.setIcon(icon);
		builder.setCancelable(false);
		if (goHome) 
		{
			builder.setPositiveButton("确定", null);		
			builder.setNegativeButton("取消", null);
		}
		else 
		{
			builder.setPositiveButton("确定",null);			
		}
		
		builder.create().show();
	}
	//定义一个显示消息,标题和图片的对话框
		public static void showDialog(Context ctx,String msg,String title,int icon,Boolean goHome) 
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
			builder.setMessage(msg);
			builder.setTitle(title);
			builder.setIcon(icon);
			builder.setCancelable(false);
			
			if (goHome) 
			{
				builder.setPositiveButton("确定", null);
				builder.setNegativeButton("取消", null);
			}
			else 
			{
				builder.setPositiveButton("确定",null);			
			}
			
			builder.create().show();
		}
		
	//定义一个显示组件的对话框
	public static  void showDialog(Context ctx,View view,OnClickListener clickp) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setView(view);
		builder.setCancelable(false);
		builder.setPositiveButton("确定",clickp);	
		builder.setNegativeButton("取消",null);
		builder.create().show();
	}
	
	//定义一个显示组件的对话框,包含标题和图片
	public static  void showDialog(Context ctx,View view,String title,int icon,OnClickListener clickp) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setView(view);
		builder.setCancelable(false);
		builder.setTitle(title);
		builder.setIcon(icon);
		builder.setPositiveButton("确定",clickp);	
		builder.setNegativeButton("取消", null);
		builder.create().show();
	}
	
	
	//定义一个显示单选,多选和列表的组件
	public static void showDialog(Context ctx,String title,int icon,String choice){
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		final String [] persons = new String[10];
		builder.setTitle(title);
		builder.setIcon(icon);
		builder.setCancelable(false);
		//判断choice是true还是false,如果是true则调用单选按钮，如果为false则调用多选按钮
		if (choice.equals("单选")) {
			//参数1：数据列表，参数2：默认选中的索引
			builder.setSingleChoiceItems(persons, 0, new AlertDialog.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
			
					dialog.dismiss();//关闭对话框，等于dialog.cancel();

				}
			});
			builder.setNegativeButton("取消", null);
		}else if(choice.equals("多选"))
		{
			builder.setMultiChoiceItems(persons, null, new OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					System.out.println("which="+which+"是否选中"+isChecked);
				}
			});
			builder.setPositiveButton("确定", null);
			builder.setNegativeButton("取消", null);
		}
		else{
			builder.setItems(persons, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
				
				}
			});
		}
	
		builder.show();
		
	}
	//定义一个圆圈型进度条对话框
	public static void showDialog(Context ctx,String message,String title,int icon) {
		//创建一个进度条对话框组件
		ProgressDialog pd = new ProgressDialog(ctx);
		pd.setMessage(message);
		pd.setTitle(title);
		pd.setCancelable(false);
		pd.setIcon(icon);
		pd.show();
	}
	//定义一个有进度长条型进度对话框
	public static void showDialog(Context ctx,String message,String title,int icon,int style,boolean minate) {
		//创建一个进度条对话框组件
		ProgressDialog pd = new ProgressDialog(ctx);
		pd.setMessage(message);
		pd.setTitle(title);
		pd.setCancelable(false);
		pd.setIcon(icon);
		pd.setMax(100);  
		//设置进度条风格STYLE_HORIZONTAL  
		pd.setProgressStyle(style);  
		pd.setIndeterminate(minate);
		pd.show();
	}
	
	//定义日期对话框
	public static void showDialogDate(Context ctx,OnDateSetListener date) {
		
		DatePickerDialog dpd = new DatePickerDialog(ctx, date, 2012, 8, 26); // 注意：这里的数字是从0到11
		dpd.show();

	}
	//定义时间对话框
	public static void showDialogTime(Context ctx,OnTimeSetListener time) {
		
		TimePickerDialog tpd = new TimePickerDialog(ctx,time, 12, 3, true);// true表示24小时制，false表示12小时制
		tpd.show();   
	}
}
