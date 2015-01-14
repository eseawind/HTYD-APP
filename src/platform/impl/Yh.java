package platform.impl;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import util.config.Urls;
import util.https.HttpHelper;
import android.content.Context;

public class Yh {
	public Yh() {}

	/**
	 * 根据用户登陆账号获取用户ID
	 * @throws JSONException 
	 */
	public JSONObject getYhIdByDlzh(Context context, String param) throws JSONException{
		JSONObject jsonUserInfo;
		String strUrl;
		//定义字符串；根据用户登陆账号获取用户ID的方法
		String strOperate = "Operate=GetYhIdByDlzh";
		//拼接查询用户的url
		strUrl = Urls.YH_URL + strOperate;
		//转义登录界面传来的用户名
		NameValuePair number = new BasicNameValuePair("Params", param);
		//调用方法解析url
		jsonUserInfo = new JSONObject(HttpHelper.GetResponse(context, strUrl, number));
		return jsonUserInfo;
	}
	/**
	 * 密码解密
	 * @param context
	 * @param param
	 * @return
	 * @throws JSONException
	 */
	public JSONObject deCode(Context context, String param) throws JSONException {
		JSONObject _jsonDeCode;
		String _strUrl;
		
		String _strOperate = "Operate=DeCode";
		
		_strUrl = Urls.CODE_URL + _strOperate;
		
		NameValuePair _code = new BasicNameValuePair("Params", param);
		
		_jsonDeCode = new JSONObject(HttpHelper.GetResponse(context, _strUrl, _code));
		
		return _jsonDeCode;
	}
	/**
	 * 密码加密
	 * @param context
	 * @param param
	 * @return
	 * @throws JSONException
	 */
	public JSONObject enCode(Context context, String param) throws JSONException {
		JSONObject _jsonDeCode;
		String _strUrl;
		
		String _strOperate = "Operate=EnCode";
		
		_strUrl = Urls.CODE_URL + _strOperate;
		
		NameValuePair _code = new BasicNameValuePair("Params", param);
		
		_jsonDeCode = new JSONObject(HttpHelper.GetResponse(context, _strUrl, _code));
		
		return _jsonDeCode;
	}
	
	/**
	 * 根据用户登陆账号获取用户ID
	 * @throws JSONException 
	 */
	public JSONObject getYhmcByDlzh(Context context, String param) throws JSONException{
		JSONObject jsonUserInfo;
		String strUrl;
		//定义字符串；根据用户登陆账号获取用户ID的方法
		String strOperate = "Operate=GetYhmcByDlzh";
		//拼接查询用户的url
		strUrl = Urls.YH_URL + strOperate;
		//转义登录界面传来的用户名
		NameValuePair number = new BasicNameValuePair("Params", param);
		//调用方法解析url
		jsonUserInfo = new JSONObject(HttpHelper.GetResponse(context, strUrl, number));
		return jsonUserInfo;
	}
	
	/**
	 * 根据用户ID获取用户信息
	 * @throws JSONException 
	 */
	public JSONObject getYhxxByYhId(Context context, String param) throws JSONException{
		JSONObject jsonUserText;
		String strUrl;
		//定义字符串；根据用户ID获取用户信息
		String strOperate = "Operate=GetYhxxByYhId";
		//拼接查询用户所有信息的url
		strUrl = Urls.YH_URL + strOperate;
		//转义登录界面传来的YHID
		NameValuePair number = new BasicNameValuePair("Params", param);
		//调用方法解析url
		jsonUserText = new JSONObject(HttpHelper.GetResponse(context, strUrl, number));
		return jsonUserText;
	}
}
