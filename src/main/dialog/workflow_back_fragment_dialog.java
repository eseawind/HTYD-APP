package main.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aqscgkpt.R;

@SuppressLint("NewApi")
public class workflow_back_fragment_dialog extends DialogFragment {
	
	private Spinner m_strSpn;
	private EditText m_editText;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//给spinner赋值
		ArrayAdapter<String> arrayAdapter;
		String[] db = {"建票"};
		arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,db);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("退回窗口");
		builder.setIcon(android.R.drawable.ic_dialog_info);		
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View view = inflater.inflate(R.layout.main_workflow_back_fragment_dialog, null);
		final EditText et_send_back = (EditText) view.findViewById(R.id.Et_Send_Back);
		builder.setView(view);
		//获取spinner控件
		m_strSpn = (Spinner) view.findViewById(R.id.sp);
		m_strSpn.setAdapter(arrayAdapter);
		//获取EditText控件
		m_editText = (EditText) view.findViewById(R.id.Et_Send_Back);
		
		builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(!"".equals(et_send_back.getText().toString().trim())){
					Toast.makeText(getActivity(), "退回成功" + et_send_back.getText(), Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(getActivity(), "退回失败，请输入意见", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		builder.setNegativeButton("取消", null);
		
		return builder.show();
	}

	public EditText getM_editText() {
		return m_editText;
	}

	public void setM_editText(EditText m_editText) {
		this.m_editText = m_editText;
	}
	
}
