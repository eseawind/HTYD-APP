package main.activity;

import org.json.JSONException;
import org.json.JSONObject;

import platform.impl.Yh;
import util.config.Code;
import util.config.Dlyh;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aqscgkpt.R;

import czp.CzpActivity;

public class LoginActivity extends Activity {

	private EditText Et_Dlzh;
	private EditText Et_Mm;
	private Button Btn_Dl;
	private CheckBox Cb_Jzmm;
	private Yh m_Yh;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		util.function.Screen.FullWindow(this);
		util.function.Screen.getScreenSize(this);

		setContentView(R.layout.main_login);

		try {
           System.out.println("00");
			initActivtiy();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	private void initActivtiy() throws JSONException {
		// ��ȡ��¼��Id
		Et_Dlzh = (EditText) findViewById(R.id.Et_Yh);
		// ��ȡ�����Id
		Et_Mm = (EditText) findViewById(R.id.Et_Mm);
		// ��ȡ��ťId
		Btn_Dl = (Button) findViewById(R.id.Btn_Dl);
		// ����½��ť�Ӽ����¼�
		Btn_Dl.setOnClickListener(new btn_Dl_OnClickListener());
		// ��ȡ��ס�����id
		Cb_Jzmm = (CheckBox) findViewById(R.id.checkLogin);

		// ��¼�û���������
		saveLogin();
	}

	/**
	 * ��¼����
	 */
	private void saveLogin() {
		if (Dlyh.isLogin(this)) {
			Et_Dlzh.setText(Dlyh.getDlzh(this));
			Et_Mm.setText(Dlyh.getDlmm(this));

			Cb_Jzmm.setChecked(true);
		} else {
			Cb_Jzmm.setChecked(false);
		}
	}

	/**
	 * �ж��û���¼
	 * @throws Exception 
	 */
	private void getYh() throws Exception {
		String strYh;
		String strMm;
		// ��ȡ�û�������
		strYh = Et_Dlzh.getText().toString();
		// ��ȡ���������
		strMm = Et_Mm.getText().toString();
		/**
		 * �ж��˺������Ƿ�Ϊ��
		 */
		if ("".equals(strYh)) {
			Toast.makeText(this, "�������˺�/����", Toast.LENGTH_LONG).show();
			return;
		}
		m_Yh = new Yh();
		// ����JSONobject���󣬴���DLZH����
		String strDlzh = new JSONObject().put("DLZH", strYh).toString();
		// ����getYhIdByDlzh��������json�ַ�����ȡ�û�id
		JSONObject yhjJsonObject = m_Yh.getYhIdByDlzh(this, strDlzh);
		// �ж��û����Ƿ����
		if ("false".equals(yhjJsonObject.get("YHID"))) {
			Toast.makeText(this, "�˺Ŵ���", Toast.LENGTH_LONG).show();
		}
		// ����yhid������json�ַ�����ȡ�û�������Ϣ
		JSONObject jsonUserText = m_Yh.getYhxxByYhId(this, yhjJsonObject.toString());
		// ��ȡ�û��˺�
		String strYhZh = jsonUserText.getString("Dlzh");
		// ��ȡ�û�����
		String strYhMm = jsonUserText.getString("Dlmm");
		String _strDlmm = Code.deCode(this, strYhMm);
		String strYhMc = jsonUserText.getString("Yhmc");
		String id = jsonUserText.getString("Yhid");
		if (strYhZh.equals(strYh) && _strDlmm.equals(strMm)) {
			if (Cb_Jzmm.isChecked()) {
				// ��ס�û��˺�
				Dlyh.setDlyh(this, Dlyh.STR_DLZH, strYh);
				Dlyh.setDlyh(this, Dlyh.STR_DLMM, strMm);
				Dlyh.setDlyh(this, Dlyh.STR_YHMC, strYhMc);
				Dlyh.setDlyh(this, Dlyh.STR_YHID, id);
			} else {
				// �����û�����Ϊ��
				Dlyh.setDlyh(this, Dlyh.STR_DLMM, null);
			}

			Intent intent = new Intent(LoginActivity.this, CzpActivity.class);
			startActivity(intent);
			this.finish();
		} else {
			Toast.makeText(this, "�����������������", Toast.LENGTH_LONG).show();
		}

	}

	private class btn_Dl_OnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// �����ж��û�����
			try {
				getYh();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
