package gzp.impl;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import util.config.Urls;
import util.https.HttpHelper;

public class Gzp 
{	
	public Gzp()
    {
    }
	
    public JSONObject GetGzpList(Context context) throws JSONException
    {
    	JSONObject rejJsonObject;
   	 
	   	String strUrl;
	   	String strOperate = "Operate=GetGzpList"; 	   	
	   	strUrl = Urls.YH_URL + strOperate;
	   	
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl));
	   	
	    return rejJsonObject;
    }
    
    public JSONObject AddGzp(Context context,String param) throws JSONException
    {
    	JSONObject rejJsonObject;
    	 
	   	String strUrl;
	   	String strOperate = "Operate=AddGzp";  
	   	 
	   	strUrl = Urls.GZP_URL + strOperate;    	 
	   	     	 
	   	NameValuePair params = new BasicNameValuePair("params",param.toString());
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl,params));
   	 
        return rejJsonObject;
    }
    
    public JSONObject UpdateGzp(Context context,String param) throws JSONException
    {
    	JSONObject rejJsonObject;
    	 
	   	String strUrl;
	   	String strOperate = "Operate=UpdateGzp";  
	   	 
	   	strUrl = Urls.GZP_URL + strOperate;    	 
	   	     	 
	   	NameValuePair params = new BasicNameValuePair("params",param.toString());
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl,params));
   	 
        return rejJsonObject;
    }
    public JSONObject DeleteGzp(Context context,String param) throws JSONException
    {
    	JSONObject rejJsonObject;
    	 
	   	String strUrl;
	   	String strOperate = "Operate=UpdateGzp";  
	   	 
	   	strUrl = Urls.GZP_URL + strOperate;    	 
	   	     	 
	   	NameValuePair params = new BasicNameValuePair("params",param.toString());
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl,params));
   	 
        return rejJsonObject;
    }
    public JSONObject GetGzpAllByGzpId(Context context,String param) throws JSONException
    {
    	JSONObject rejJsonObject;
    	 
	   	String strUrl;
	   	String strOperate = "Operate=GetGzpAllByGzpId";  
	   	 
	   	strUrl = Urls.GZP_URL + strOperate;    	 
	   	     	 
	   	NameValuePair params = new BasicNameValuePair("params",param.toString());
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl,params));
   	 
        return rejJsonObject;
    }
    public JSONObject GetGzpByGzpId(Context context,String param) throws JSONException
    {
    	JSONObject rejJsonObject;
    	 
	   	String strUrl;
	   	String strOperate = "Operate=GetGzpByGzpId";  
	   	 
	   	strUrl = Urls.GZP_URL + strOperate;    	 
	   	     	 
	   	NameValuePair params = new BasicNameValuePair("params",param.toString());
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl,params));
   	 
        return rejJsonObject;
    }
    public JSONObject GetGzpSubByGzpId(Context context,String param) throws JSONException
    {
    	JSONObject rejJsonObject;
    	 
	   	String strUrl;
	   	String strOperate = "Operate=GetGzpSubByGzpId";  
	   	 
	   	strUrl = Urls.GZP_URL + strOperate;    	 
	   	     	 
	   	NameValuePair params = new BasicNameValuePair("params",param.toString());
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl,params));
   	 
        return rejJsonObject;
    }
    public JSONObject GetGzpListByCondition(Context context,String param) throws JSONException
    {
    	JSONObject rejJsonObject;
    	 
	   	String strUrl;
	   	String strOperate = "Operate=GetGzpListByCondition";
	   	 
	   	strUrl = Urls.GZP_URL + strOperate;
	   	     	 
	   	NameValuePair params = new BasicNameValuePair("params",param.toString());
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl,params));
   	 
        return rejJsonObject;
    }   
}
