package main.dialog;
import java.util.Calendar;
import com.example.aqscgkpt.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker.OnTimeChangedListener;
@SuppressLint("NewApi")
public class DateTimePicker_fragment_dialog extends DialogFragment {
		// 定义5个记录当前时间的变量
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private EditText edt;
	public EditText getEdt() {
		return edt;
	}
	public void setEdt(EditText edt) {
		this.edt = edt;
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("选择时间");
		builder.setIcon(android.R.drawable.ic_dialog_info);
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View view = inflater.inflate(R.layout.main_datetimepicker_fragment_dialog, null);
		builder.setView(view);
		DatePicker dp=(DatePicker) view.findViewById(R.id.datePicher);
		TimePicker tp=(TimePicker) view.findViewById(R.id.timePicker);
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		hour= c.get(Calendar.HOUR_OF_DAY);
		minute=c.get(Calendar.MINUTE);
		builder.setPositiveButton("完成", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
 				edt.setText(year+"-"+(month+1)+"-"+day+" "+String.format("%02d", hour)+":"+String.format("%02d",minute));
				
			}
		});
		builder.setNegativeButton("取消", null);
		 //初始化dataPicker组件，初始化时指定监听器
		 dp.init(year, month, day, new OnDateChangedListener() {
		
		 @Override
		 public void onDateChanged(DatePicker view, int year, int monthOfYear,
		 int dayOfMonth) {
			 DateTimePicker_fragment_dialog.this.year=year;
			 DateTimePicker_fragment_dialog.this.month=monthOfYear;
			 DateTimePicker_fragment_dialog.this.day=dayOfMonth;
			 //显示当前日期，时间
		 
		 }
		 });
		 //为TimePicker指定监听器
		 tp.setOnTimeChangedListener(new OnTimeChangedListener() {
		 @Override
		 public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
		 {
			 DateTimePicker_fragment_dialog.this.hour=hourOfDay;
			 DateTimePicker_fragment_dialog.this.minute=minute;
			  
		 }
		 });
		return builder.show();
	}
}
