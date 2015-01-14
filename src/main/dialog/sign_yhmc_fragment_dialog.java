package main.dialog;
import gzp.fragment.gzp_edit_dqyzgzp_fragment;

import org.json.JSONException;
import org.json.JSONObject;

import platform.impl.Yh;
import util.config.Dlyh;
import util.dialog.DialogHelper;

import com.example.aqscgkpt.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
@SuppressLint("NewApi")
public class sign_yhmc_fragment_dialog extends DialogFragment{

	private String m_strYhmc;
	private EditText m_etYhmc,m_etDlzh,m_etDlmm;
	private EditText et;
	
	public EditText getEt() {
		return et;
	}

	public void setEt(EditText et) {
		this.et = et;
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
   
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("签名窗口");
		builder.setIcon(android.R.drawable.ic_dialog_info);		
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View view = inflater.inflate(R.layout.main_sign_yhmc_fragment_dialog, null);
		builder.setView(view);
		
		m_etYhmc = (EditText) view.findViewById(R.id.Et_Yhmc);
		m_etDlzh = (EditText) view.findViewById(R.id.Et_Dlzh);
		m_etDlmm = (EditText) view.findViewById(R.id.Et_Dlmm);
		
		m_etYhmc.setFocusable(false);
		if (et.getText().toString()!=null) {
			m_etYhmc.setText(Dlyh.getYhmc(getActivity()));
			m_etDlzh.setText(Dlyh.getDlzh(getActivity()));
		}

		
		m_etDlzh.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
					if (!hasFocus) {
						String zhanghao = m_etDlzh.getText().toString();
					 	String strName = getYhidByDlzh(zhanghao);
					 	m_etYhmc.setText(strName);	
					 	m_strYhmc = strName;
					}					
			}
		});
		
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				boolean bool = getYhIdByDlzh(m_etDlzh.getText().toString(),m_etDlmm.getText().toString());
				 if (bool==true) {
					 //close(true);
					 et.setText(m_strYhmc);
				 }else{
					 DialogHelper.showDialog(getActivity(), "操作失败","操作提示", android.R.drawable.ic_dialog_info, false);
				 }
			}
		});
		builder.setNeutralButton("清除", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					String zhanghao = m_etDlzh.getText().toString();
				 	String strName = getYhidByDlzh(zhanghao);
				 	if (m_etYhmc.getText().toString().equals(strName)) {
				 		//DialogHelper.showDialog(getActivity(), "操作成功","操作提示",	android.R.drawable.ic_dialog_info, false);
				 		et.setText(null);
				 	}else{
				 		DialogHelper.showDialog(getActivity(), "操作失败,必须是本人的账号和密码","操作提示",
				 				android.R.drawable.ic_dialog_info, false);
				 	}
				}
			});

		builder.setNegativeButton("取消", null);
		return builder.show();
	}	
	
	// 根据登录账号获取用户id
	public boolean getYhIdByDlzh(String strDlzh, String password) {
		String strId = null;
		Yh myYh = new Yh();
		try {
			JSONObject jin = new JSONObject();
			jin.put("DLZH", strDlzh);
			JSONObject str = myYh.getYhIdByDlzh(getActivity(), jin.toString());
			strId = str.getString("YHID");
			if (!strId.equals("false")) {
				boolean b = getYhxxById(strId, password);
				if (b == true) {
					return true;
				}

			} else {
				//DialogHelper.showDialog(getActivity(), "账号名无效", "操作提示",android.R.drawable.ic_dialog_info, false);
				return false;
			}
		} catch (JSONException e) {

			e.printStackTrace();

		}
		return false;

	}

	// 根据用户id获取用户信息
	public boolean getYhxxById(String strId, String password) {
		String strMm = null;
		Yh myYh = new Yh();
		try {
			JSONObject jo = new JSONObject();
			jo.put("YHID", strId);
			JSONObject str = myYh.getYhxxByYhId(getActivity(), jo.toString());
			strMm = str.getString("Dlmm");
			if (strMm.equals(password)) {
				//DialogHelper.showDialog(getActivity(), "操作成功", "操作提示",android.R.drawable.ic_dialog_info, false);
				return true;
			} else {
				DialogHelper.showDialog(getActivity(), "用户密码无效", "操作提示",
						android.R.drawable.ic_dialog_info, false);
				return false;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 根据登录账号获取用户id，改变EditText触发事件调用的方法
	public String getYhidByDlzh(String strDlzh) {
		String strId = null;
		String strName = null;
		Yh myYh = new Yh();
		try {
			JSONObject jin = new JSONObject();
			jin.put("DLZH", strDlzh);
			JSONObject str = myYh.getYhIdByDlzh(getActivity(), jin.toString());
			strId = str.getString("YHID");
			if (!strId.equals("false")) {
				strName = GetYhMcByYhId(strId);
			}
		} catch (JSONException e) {

			e.printStackTrace();

		}
		return strName;
	}

	// 根据登录Id获取用户姓名,改变EditText触发事件调用的方法
	public String GetYhMcByYhId(String strId) {
		String strXm = null;
		Yh myYh = new Yh();
		try {
			JSONObject jo = new JSONObject();
			jo.put("YHID", strId);
			JSONObject str = myYh.getYhxxByYhId(getActivity(), jo.toString());
			strXm = str.getString("Yhmc");
			return strXm;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

}
	

