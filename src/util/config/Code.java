package util.config;

import org.json.JSONException;
import org.json.JSONObject;

import platform.impl.Yh;
import android.content.Context;

public class Code {
	
	/**
	 * �������
	 * 
	 * @throws JSONException
	 */
	public static String deCode(Context pContext, String pStrPsw) throws Exception {
		//���룬��������ַ�����
		String _pwdCode = java.net.URLEncoder.encode(pStrPsw, "UTF-8");
		Yh _yh = new Yh();
		JSONObject _param = new JSONObject();
		_param.put("CODE", _pwdCode);
		//���ý��ܷ���
		JSONObject dlmmJO = _yh.deCode(pContext, _param.toString());
		return dlmmJO.getString("CODE");
	}
	
	/**
	 * �������
	 * 
	 * @throws JSONException
	 */
	public static String enCode(Context pContext, String pStrPsw) throws Exception {
		//���룬��������ַ�����
		String _pwdCode = java.net.URLEncoder.encode(pStrPsw, "UTF-8");
		Yh _yh = new Yh();
		JSONObject _param = new JSONObject();
		_param.put("CODE", _pwdCode);
		//���ý��ܷ���
		JSONObject dlmmJO = _yh.enCode(pContext, _param.toString());
		return dlmmJO.getString("CODE");
	}
}
