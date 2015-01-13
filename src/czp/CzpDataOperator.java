package czp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import util.config.Urls;
import util.https.HttpHelper;
import android.content.Context;
import android.util.Log;
import czp.bean.CzpBean;
import czp.bean.CzpCzxBean;
import czp.bean.CzpZpBean;

public class CzpDataOperator {

	
	
	
	public static ArrayList<CzpBean> getCzpList(Context context)
			throws JSONException {
		ArrayList<CzpBean> czpList = new ArrayList<CzpBean>();
		String strUrl;
		String strOperate = "Operate=GetCzpList";

		strUrl = Urls.CZP_URL + strOperate;

		String result = "";
		try {
			result = HttpHelper.GetResponse(context, strUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.equals("false") || result.length() == 0) {
			return null;
		}
		JSONArray array = (JSONArray) new JSONTokener(result).nextValue();
		int length = array.length();
		for (int i = 0; i < length; i++) {
			czpList.add(new CzpBean(array.getJSONObject(i)));
		}
		return czpList;
	}

	
	
	
	public static ArrayList<CzpBean> getCzpListByUserID(Context context)
			throws JSONException {
		ArrayList<CzpBean> czpList = new ArrayList<CzpBean>();
		String strUrl;
		String strOperate = "Operate=GetCzpListByYhid";

//		String id = Dlyh.getYhId(context);
		JSONObject param = new JSONObject();
		param.put("YHID", "1000");

		strUrl = Urls.CZP_URL + strOperate;

		NameValuePair params = new BasicNameValuePair("params",
				param.toString());

		String result = "";
		try {
			result = HttpHelper.GetResponse(context, strUrl, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.equals("false")) {
			return null;
		}
		if(result.length() == 0){
			return czpList;
		}
		JSONArray array = (JSONArray) new JSONTokener(result).nextValue();
		int length = array.length();
		for (int i = 0; i < length; i++) {
			czpList.add(new CzpBean(array.getJSONObject(i)));
		}
		return czpList;
	}
	
	
	
	public static CzpZpBean getCzpAllByID(Context context,String czpId)
			throws JSONException {
		HashMap<String,String> resultMap = new HashMap<String, String>();
		String strUrl;
		String strOperate = "Operate=GetCzpAllByCzpId";

		JSONObject param = new JSONObject();
		param.put("CZPID", czpId);

		strUrl = Urls.CZP_URL + strOperate;

		NameValuePair params = new BasicNameValuePair("params",
				param.toString());

		String result = "";
		try {
			result = HttpHelper.GetResponse(context, strUrl, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.equals("false")) {
			return null;
		}
		CzpZpBean mBean = new CzpZpBean();
		if(result.length() == 0){
			return mBean;
		}
		JSONObject json = new JSONObject(result);
		String reultSub = json.getString("CZPSUB");
		
		JSONArray array = (JSONArray) new JSONTokener(reultSub).nextValue();
		int length = array.length();
		for (int i = 0; i < length; i++) {
			json = array.getJSONObject(i);
			resultMap.put(json.getString("KJID"), json.getString("KJNR"));
		}
		mBean = praseResult(resultMap);
		return mBean;
	}
	
	private static CzpZpBean praseResult(HashMap<String,String> resultMap){
		CzpZpBean mBean = new CzpZpBean();
		mBean.setCzpNum(resultMap.get("Tb_BianHao"));
		mBean.setDepart(resultMap.get("Tb_Bm"));
		mBean.setStartTime(resultMap.get("Tb_CzKsSj"));
		mBean.setEndTime(resultMap.get("Tb_CzJsSj"));
		mBean.setCzpCzrName(resultMap.get("Tb_CzqCzr"));
		mBean.setCzpGuardName(resultMap.get("Tb_CzqJhr"));
		mBean.setCzpLeaderName(resultMap.get("Tb_Zbfzr"));
		mBean.setCzpDutyName(resultMap.get("Tb_Zz"));
		mBean.setCzpRemark(resultMap.get("Tb_Beiz"));
		return mBean;
	}
	
	public static ArrayList<CzpCzxBean> getCzpCzxListByID(Context context,String czpID,String czpType)
			throws JSONException {
		ArrayList<CzpCzxBean> czxList = new ArrayList<CzpCzxBean>();
		String strUrl;
		String strOperate = "Operate=GetCzpCzxListById";

//		String id = Dlyh.getYhId(context);
		JSONObject param = new JSONObject();
		param.put("FORMID", czpType);
		param.put("CZPID", czpID);

		strUrl = Urls.CZP_URL + strOperate;

		NameValuePair params = new BasicNameValuePair("params",
				param.toString());

		String result = "";
		try {
			result = HttpHelper.GetResponse(context, strUrl, params);
		} catch (Exception e) {
			Log.i("fanjishuo___getCzpCzxListByID", "catch e");
			e.printStackTrace();
		}
		if (result.equals("false")) {
			Log.i("fanjishuo____getCzpCzxListByID", result + "false");
			return null;
		}
		if(result.length() == 0){
			Log.i("fanjishuo_____getCzpCzxListByID == 0", "result.length() == 0");
			return czxList;
		}
		JSONArray array = (JSONArray) new JSONTokener(result).nextValue();
		int length = array.length();
		Log.i("fanjishuo____getCzpCzxListByID", "length" + result);
		for (int i = 0; i < length; i++) {
			czxList.add(new CzpCzxBean(array.getJSONObject(i)));
		}
		return czxList;
	}
}
