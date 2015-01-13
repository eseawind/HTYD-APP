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
		//��spinner��ֵ
		ArrayAdapter<String> arrayAdapter;
		String[] db = {"��Ʊ"};
		arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,db);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("�˻ش���");
		builder.setIcon(android.R.drawable.ic_dialog_info);		
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View view = inflater.inflate(R.layout.main_workflow_back_fragment_dialog, null);
		final EditText et_send_back = (EditText) view.findViewById(R.id.Et_Send_Back);
		builder.setView(view);
		//��ȡspinner�ؼ�
		m_strSpn = (Spinner) view.findViewById(R.id.sp);
		m_strSpn.setAdapter(arrayAdapter);
		//��ȡEditText�ؼ�
		m_editText = (EditText) view.findViewById(R.id.Et_Send_Back);
		
		builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(!"".equals(et_send_back.getText().toString().trim())){
					Toast.makeText(getActivity(), "�˻سɹ�" + et_send_back.getText(), Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(getActivity(), "�˻�ʧ�ܣ����������", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		builder.setNegativeButton("ȡ��", null);
		
		return builder.show();
	}

	public EditText getM_editText() {
		return m_editText;
	}

	public void setM_editText(EditText m_editText) {
		this.m_editText = m_editText;
	}
	
}
