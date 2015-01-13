package main.dialog;
import java.util.Calendar;

import gzp.fragment.gzp_edit_dqyzgzp_fragment;

import org.json.JSONException;
import org.json.JSONObject;

import platform.impl.Yh;
import util.dialog.DialogHelper;

import com.example.aqscgkpt.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
@SuppressLint("NewApi")
public class DatePicker_fragment_dialog extends DialogFragment implements OnDateSetListener {

	//年月日
	//年月日时
	//年月日时分
	//年月日时分秒
	private static EditText etDatePicker;
	public EditText getEtDatePicker() {
		return etDatePicker;
	}
	public void setEtDatePicker(EditText etDatePicker) {
		this.etDatePicker = etDatePicker;
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.SECOND);
		DatePickerDialog dpd = new DatePickerDialog(getActivity(), this, year, month, day);
		return dpd;
	}
	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
			etDatePicker.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
		
	}
}



