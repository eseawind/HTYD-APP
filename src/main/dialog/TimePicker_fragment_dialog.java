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
public class TimePicker_fragment_dialog extends DialogFragment implements OnTimeSetListener {

	EditText etTimePicker;
	
	public EditText getEtTimePicker() {
		return etTimePicker;
	}
	public void setEtTimePicker(EditText etTimePicker) {
		this.etTimePicker = etTimePicker;
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		TimePickerDialog tpd = new TimePickerDialog(getActivity(), this, hour, minute,true);
		return tpd;
	}
	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		String time = hourOfDay+":"+minute;
			etTimePicker.setText(time);
	}
}