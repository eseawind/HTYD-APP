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

	//����һ����ʾ��Ϣ�ĶԻ���
	public static void showDialog(Context ctx,String msg,Boolean goHome) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage(msg);
		builder.setCancelable(false);
		if (goHome) 
		{
			builder.setPositiveButton("ȷ��",null);	
			builder.setNegativeButton("ȡ��", null);
		}
		else 
		{
			builder.setPositiveButton("ȷ��",null);			
		}
		builder.create().show();
	}
	//����һ����ʾ��Ϣ�ͱ���ĶԻ���
	public static void showDialog(Context ctx,String msg,String title,Boolean goHome) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage(msg);
		builder.setTitle(title);
		builder.setCancelable(false);
		if (goHome) 
		{
			builder.setPositiveButton("ȷ��", null);		
			builder.setNegativeButton("ȡ��", null);
		}
		else 
		{
			builder.setPositiveButton("ȷ��",null);			
		}

		builder.create().show();
	}
	//����һ����ʾ��Ϣ��ͼƬ�ĶԻ���
	public static void showDialog(Context ctx,String msg,int icon,Boolean goHome) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage(msg);
		builder.setIcon(icon);
		builder.setCancelable(false);
		if (goHome) 
		{
			builder.setPositiveButton("ȷ��", null);		
			builder.setNegativeButton("ȡ��", null);
		}
		else 
		{
			builder.setPositiveButton("ȷ��",null);			
		}
		
		builder.create().show();
	}
	//����һ����ʾ��Ϣ,�����ͼƬ�ĶԻ���
		public static void showDialog(Context ctx,String msg,String title,int icon,Boolean goHome) 
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
			builder.setMessage(msg);
			builder.setTitle(title);
			builder.setIcon(icon);
			builder.setCancelable(false);
			
			if (goHome) 
			{
				builder.setPositiveButton("ȷ��", null);
				builder.setNegativeButton("ȡ��", null);
			}
			else 
			{
				builder.setPositiveButton("ȷ��",null);			
			}
			
			builder.create().show();
		}
		
	//����һ����ʾ����ĶԻ���
	public static  void showDialog(Context ctx,View view,OnClickListener clickp) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setView(view);
		builder.setCancelable(false);
		builder.setPositiveButton("ȷ��",clickp);	
		builder.setNegativeButton("ȡ��",null);
		builder.create().show();
	}
	
	//����һ����ʾ����ĶԻ���,���������ͼƬ
	public static  void showDialog(Context ctx,View view,String title,int icon,OnClickListener clickp) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setView(view);
		builder.setCancelable(false);
		builder.setTitle(title);
		builder.setIcon(icon);
		builder.setPositiveButton("ȷ��",clickp);	
		builder.setNegativeButton("ȡ��", null);
		builder.create().show();
	}
	
	
	//����һ����ʾ��ѡ,��ѡ���б�����
	public static void showDialog(Context ctx,String title,int icon,String choice){
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		final String [] persons = new String[10];
		builder.setTitle(title);
		builder.setIcon(icon);
		builder.setCancelable(false);
		//�ж�choice��true����false,�����true����õ�ѡ��ť�����Ϊfalse����ö�ѡ��ť
		if (choice.equals("��ѡ")) {
			//����1�������б�����2��Ĭ��ѡ�е�����
			builder.setSingleChoiceItems(persons, 0, new AlertDialog.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
			
					dialog.dismiss();//�رնԻ��򣬵���dialog.cancel();

				}
			});
			builder.setNegativeButton("ȡ��", null);
		}else if(choice.equals("��ѡ"))
		{
			builder.setMultiChoiceItems(persons, null, new OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					System.out.println("which="+which+"�Ƿ�ѡ��"+isChecked);
				}
			});
			builder.setPositiveButton("ȷ��", null);
			builder.setNegativeButton("ȡ��", null);
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
	//����һ��ԲȦ�ͽ������Ի���
	public static void showDialog(Context ctx,String message,String title,int icon) {
		//����һ���������Ի������
		ProgressDialog pd = new ProgressDialog(ctx);
		pd.setMessage(message);
		pd.setTitle(title);
		pd.setCancelable(false);
		pd.setIcon(icon);
		pd.show();
	}
	//����һ���н��ȳ����ͽ��ȶԻ���
	public static void showDialog(Context ctx,String message,String title,int icon,int style,boolean minate) {
		//����һ���������Ի������
		ProgressDialog pd = new ProgressDialog(ctx);
		pd.setMessage(message);
		pd.setTitle(title);
		pd.setCancelable(false);
		pd.setIcon(icon);
		pd.setMax(100);  
		//���ý��������STYLE_HORIZONTAL  
		pd.setProgressStyle(style);  
		pd.setIndeterminate(minate);
		pd.show();
	}
	
	//�������ڶԻ���
	public static void showDialogDate(Context ctx,OnDateSetListener date) {
		
		DatePickerDialog dpd = new DatePickerDialog(ctx, date, 2012, 8, 26); // ע�⣺����������Ǵ�0��11
		dpd.show();

	}
	//����ʱ��Ի���
	public static void showDialogTime(Context ctx,OnTimeSetListener time) {
		
		TimePickerDialog tpd = new TimePickerDialog(ctx,time, 12, 3, true);// true��ʾ24Сʱ�ƣ�false��ʾ12Сʱ��
		tpd.show();   
	}
}
