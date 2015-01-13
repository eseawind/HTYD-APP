package util.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonHelper 
{

	public JSONObject GetJsonObject(String strJson) throws JSONException 
	{
		JSONObject reJsonObject = new JSONObject(strJson);
		
		return reJsonObject;
	}
	public JSONArray GetJsonArray(String strJson) throws JSONException 
	{		
		JSONArray resultArray = new JSONArray(strJson);
		
		return resultArray;
	}
	public JSONArray GetJsonArrayGzp(String strJson) throws JSONException 
	{		
		JSONObject reJsonObject = new JSONObject(strJson);
	
		JSONArray resultArrayGzpSub = reJsonObject.getJSONArray("GZPSUB");
		
		return resultArrayGzpSub;
	}
}
