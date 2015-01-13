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
		// 获取登录框Id
		Et_Dlzh = (EditText) findViewById(R.id.Et_Yh);
		// 获取密码框Id
		Et_Mm = (EditText) findViewById(R.id.Et_Mm);
		// 获取按钮Id
		Btn_Dl = (Button) findViewById(R.id.Btn_Dl);
		// 给登陆按钮加监听事件
		Btn_Dl.setOnClickListener(new btn_Dl_OnClickListener());
		// 获取记住密码框id
		Cb_Jzmm = (CheckBox) findViewById(R.id.checkLogin);

		// 记录用户名，密码
		saveLogin();
	}

	/**
	 * 记录密码
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
	 * 判断用户登录
	 * @throws Exception 
	 */
	private void getYh() throws Exception {
		String strYh;
		String strMm;
		// 获取用户框内容
		strYh = Et_Dlzh.getText().toString();
		// 获取密码框内容
		strMm = Et_Mm.getText().toString();
		/**
		 * 判断账号密码是否为空
		 */
		if ("".equals(strYh)) {
			Toast.makeText(this, "请输入账号/密码", Toast.LENGTH_LONG).show();
			return;
		}
		m_Yh = new Yh();
		// 定义JSONobject对象，创建DLZH对象
		String strDlzh = new JSONObject().put("DLZH", strYh).toString();
		// 调用getYhIdByDlzh方法解析json字符串获取用户id
		JSONObject yhjJsonObject = m_Yh.getYhIdByDlzh(this, strDlzh);
		// 判断用户名是否存在
		if ("false".equals(yhjJsonObject.get("YHID"))) {
			Toast.makeText(this, "账号错误", Toast.LENGTH_LONG).show();
		}
		// 根据yhid，解析json字符串获取用户所有信息
		JSONObject jsonUserText = m_Yh.getYhxxByYhId(this, yhjJsonObject.toString());
		// 获取用户账号
		String strYhZh = jsonUserText.getString("Dlzh");
		// 获取用户密码
		String strYhMm = jsonUserText.getString("Dlmm");
		String _strDlmm = Code.deCode(this, strYhMm);
		String strYhMc = jsonUserText.getString("Yhmc");
		String id = jsonUserText.getString("Yhid");
		if (strYhZh.equals(strYh) && _strDlmm.equals(strMm)) {
			if (Cb_Jzmm.isChecked()) {
				// 记住用户账号
				Dlyh.setDlyh(this, Dlyh.STR_DLZH, strYh);
				Dlyh.setDlyh(this, Dlyh.STR_DLMM, strMm);
				Dlyh.setDlyh(this, Dlyh.STR_YHMC, strYhMc);
				Dlyh.setDlyh(this, Dlyh.STR_YHID, id);
			} else {
				// 设置用户密码为空
				Dlyh.setDlyh(this, Dlyh.STR_DLMM, null);
			}

			Intent intent = new Intent(LoginActivity.this, CzpActivity.class);
			startActivity(intent);
			this.finish();
		} else {
			Toast.makeText(this, "密码错误，请重新输入", Toast.LENGTH_LONG).show();
		}

	}

	private class btn_Dl_OnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// 调用判断用户方法
			try {
				getYh();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
