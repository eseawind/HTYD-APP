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
	 * �����û���½�˺Ż�ȡ�û�ID
	 * @throws JSONException 
	 */
	public JSONObject getYhIdByDlzh(Context context, String param) throws JSONException{
		JSONObject jsonUserInfo;
		String strUrl;
		//�����ַ����������û���½�˺Ż�ȡ�û�ID�ķ���
		String strOperate = "Operate=GetYhIdByDlzh";
		//ƴ�Ӳ�ѯ�û���url
		strUrl = Urls.YH_URL + strOperate;
		//ת���¼���洫�����û���
		NameValuePair number = new BasicNameValuePair("Params", param);
		//���÷�������url
		jsonUserInfo = new JSONObject(HttpHelper.GetResponse(context, strUrl, number));
		return jsonUserInfo;
	}
	/**
	 * �������
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
	 * �������
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
	 * �����û���½�˺Ż�ȡ�û�ID
	 * @throws JSONException 
	 */
	public JSONObject getYhmcByDlzh(Context context, String param) throws JSONException{
		JSONObject jsonUserInfo;
		String strUrl;
		//�����ַ����������û���½�˺Ż�ȡ�û�ID�ķ���
		String strOperate = "Operate=GetYhmcByDlzh";
		//ƴ�Ӳ�ѯ�û���url
		strUrl = Urls.YH_URL + strOperate;
		//ת���¼���洫�����û���
		NameValuePair number = new BasicNameValuePair("Params", param);
		//���÷�������url
		jsonUserInfo = new JSONObject(HttpHelper.GetResponse(context, strUrl, number));
		return jsonUserInfo;
	}
	
	/**
	 * �����û�ID��ȡ�û���Ϣ
	 * @throws JSONException 
	 */
	public JSONObject getYhxxByYhId(Context context, String param) throws JSONException{
		JSONObject jsonUserText;
		String strUrl;
		//�����ַ����������û�ID��ȡ�û���Ϣ
		String strOperate = "Operate=GetYhxxByYhId";
		//ƴ�Ӳ�ѯ�û�������Ϣ��url
		strUrl = Urls.YH_URL + strOperate;
		//ת���¼���洫����YHID
		NameValuePair number = new BasicNameValuePair("Params", param);
		//���÷�������url
		jsonUserText = new JSONObject(HttpHelper.GetResponse(context, strUrl, number));
		return jsonUserText;
	}
}
