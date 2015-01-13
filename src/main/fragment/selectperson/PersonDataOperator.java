package main.fragment.selectperson;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.bean.DepartmentBean;
import main.bean.PersonBean;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import util.config.Urls;
import util.https.HttpHelper;
import android.content.Context;
import android.os.Parcelable;

public class PersonDataOperator {
	public static ArrayList<DepartmentBean> getDepartmentListByParentId(Context context,
			String parentId) throws JSONException {
		ArrayList<DepartmentBean> departList = new ArrayList<DepartmentBean>();

		String strUrl;
		String strOperate = "Operate=GetBmxxByFjId";

		JSONObject param = new JSONObject();
		param.put("FJID", parentId);

		strUrl = Urls.BM_URL + strOperate;
		NameValuePair params = new BasicNameValuePair("params",
				param.toString());
		String result = HttpHelper.GetResponse(context, strUrl, params);
		if(result.equals("false") || result.length() == 0){
			return null;
		}
		JSONArray array = (JSONArray) new JSONTokener(result).nextValue();
		int length = array.length();
		for(int i = 0 ;i <length;i++){
			departList.add(new DepartmentBean(array.getJSONObject(i)));
		}
		Collections.sort(departList, new NameComparator());
		return departList;
	}
	public static ArrayList<PersonBean> getPersonListByParentId(Context context,
			String parentId) throws JSONException{
		ArrayList<PersonBean> perList = new ArrayList<PersonBean>();
		String strUrl;
		String strOperate = "Operate=GetYhByBmId";

		JSONObject param = new JSONObject();
		param.put("BMID", parentId);

		strUrl = Urls.BM_URL + strOperate;
		NameValuePair params = new BasicNameValuePair("params",
				param.toString());
		String result = HttpHelper.GetResponse(context, strUrl, params);
		if(result.equals("false") || result.length() == 0){
			return null;
		}
		JSONArray array = (JSONArray) new JSONTokener(result).nextValue();
		int length = array.length();
		for(int i = 0 ;i <length;i++){
			perList.add(new PersonBean(array.getJSONObject(i),Integer.parseInt(parentId)));
		}
		Collections.sort(perList, new NameComparator());
		return perList;
	}
	

    
    public static class NameComparator implements Comparator <Parcelable>{

		@Override
		public int compare(Parcelable lhs, Parcelable rhs) {
			Collator cnCollator = Collator.getInstance(java.util.Locale.CHINA);
			 cnCollator.setStrength(Collator.PRIMARY);
			 if(lhs.getClass().equals(DepartmentBean.class)&&rhs.getClass().equals(DepartmentBean.class)){
				 String name1 = ((DepartmentBean)lhs).getDepartmentName();
				 String name2 = ((DepartmentBean)rhs).getDepartmentName();
				return  cnCollator.compare(name1, name2);
			 }else if(lhs.getClass().equals(PersonBean.class)&&rhs.getClass().equals(PersonBean.class)){
				 String name1 = ((PersonBean)lhs).getName();
				 String name2 = ((PersonBean)rhs).getName();
				return  cnCollator.compare(name1, name2);
			 }else{
				 return 0;
			 }
		}
    }
}
