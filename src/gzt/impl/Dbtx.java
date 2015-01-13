package gzt.impl;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import util.config.Urls;
import util.https.HttpHelper;

public class Dbtx 
{
	public JSONObject GetDbtxList(Context context) throws JSONException
    {
    	JSONObject rejJsonObject;
   	 
	   	String strUrl;
	   	String strOperate = "Operate=GetDbtxList"; 	   	
	   	strUrl = Urls.DBTX_URL + strOperate;
	   	
	   	rejJsonObject = new JSONObject(HttpHelper.GetResponse(context,strUrl));
	   	
	    return rejJsonObject;
    }  
    
}
