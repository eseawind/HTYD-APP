package util.config;

import org.json.JSONException;
import org.json.JSONObject;

import platform.impl.Yh;
import android.content.Context;

public class Code {
	
	/**
	 * 密码解密
	 * 
	 * @throws JSONException
	 */
	public static String deCode(Context pContext, String pStrPsw) throws Exception {
		//加码，解决特殊字符问题
		String _pwdCode = java.net.URLEncoder.encode(pStrPsw, "UTF-8");
		Yh _yh = new Yh();
		JSONObject _param = new JSONObject();
		_param.put("CODE", _pwdCode);
		//调用解密方法
		JSONObject dlmmJO = _yh.deCode(pContext, _param.toString());
		return dlmmJO.getString("CODE");
	}
	
	/**
	 * 密码加密
	 * 
	 * @throws JSONException
	 */
	public static String enCode(Context pContext, String pStrPsw) throws Exception {
		//加码，解决特殊字符问题
		String _pwdCode = java.net.URLEncoder.encode(pStrPsw, "UTF-8");
		Yh _yh = new Yh();
		JSONObject _param = new JSONObject();
		_param.put("CODE", _pwdCode);
		//调用解密方法
		JSONObject dlmmJO = _yh.enCode(pContext, _param.toString());
		return dlmmJO.getString("CODE");
	}
}
