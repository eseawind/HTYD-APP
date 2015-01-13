package gzt.fragment;

import gzt.impl.Dbtx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.aqscgkpt.R;

@SuppressLint("NewApi")
public class gzt_rcgz_list_fragment extends Fragment {
	

	private ListView lv;
	private SimpleAdapter adapter;
	private Context context;
	private Activity activity;
	
	private Dbtx m_Dbtx;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.gzt_rcgz_list_fragment,container, false);
	
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
 
		final ImageView  iv =  (ImageView) getActivity().findViewById(R.id.aa);
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				iv.setImageResource(R.drawable.aaa);
				Toast.makeText(getActivity(), "哈哈哈哈哈哈--我是工作台", Toast.LENGTH_LONG).show();
			}
		});
//		System.out.println("=============sdffsdsdf"+iv);
//		if (iv.isPressed()) {
//			System.out.println("==ssss==dsgsdgsdgsdgsadgsdg");
// 			iv.setImageResource(R.id.title);
//		}
		
//		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String,Object> map1 = new HashMap<String, Object>();
//		map1.put("gzt_gznr", "习大大前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map1.put("gzt_gzfl", "教育培训");
//		map1.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map2 = new HashMap<String, Object>();
//		map2.put("gzt_gznr", "习习前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map2.put("gzt_gzfl", "教育培训");
//		map2.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map3 = new HashMap<String, Object>();
//		map3.put("gzt_gznr", "习哥前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map3.put("gzt_gzfl", "教育培训");
//		map3.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map4 = new HashMap<String, Object>();
//		map4.put("gzt_gznr", "习老师前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map4.put("gzt_gzfl", "教育培训");
//		map4.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map5 = new HashMap<String, Object>();
//		map5.put("gzt_gznr", "习近平前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map5.put("gzt_gzfl", "教育培训");
//		map5.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map6 = new HashMap<String, Object>();
//		map6.put("gzt_gznr", "习近平前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map6.put("gzt_gzfl", "教育培训");
//		map6.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map7 = new HashMap<String, Object>();
//		map7.put("gzt_gznr", "习近平前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map7.put("gzt_gzfl", "教育培训");
//		map7.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map8 = new HashMap<String, Object>();
//		map8.put("gzt_gznr", "习近平前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map8.put("gzt_gzfl", "教育培训");
//		map8.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map9 = new HashMap<String, Object>();
//		map9.put("gzt_gznr", "习近平前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map9.put("gzt_gzfl", "教育培训");
//		map9.put("gzt_txsj", "2014-10-10 12:20");
//		Map<String,Object> map10 = new HashMap<String, Object>();
//		map10.put("gzt_gznr", "习近平前来汇通远德参观指导学习先进的IT技术,希望有朝一日成为一名程序猿");
//		map10.put("gzt_gzfl", "教育培训");
//		map10.put("gzt_txsj", "2014-10-10 12:20");
//		list.add(map1);
//		list.add(map2);
//		list.add(map3);
//		list.add(map4);
//		list.add(map5);
//		list.add(map6);
//		list.add(map7);
//		list.add(map8);
//		list.add(map9);
//		list.add(map10);
//	
//	
//		adapter = new SimpleAdapter(getActivity(), list, R.layout.gzt_dbtx_list_item, new String[]{"gzt_gznr","gzt_gzfl","gzt_txsj"},new int[]{R.id.gzt_gznr,R.id.gzt_gzfl,R.id.gzt_txsj});
//		setListAdapter(adapter);
		
		
//		try 
//		{
//			JSONObject dbtxJsonObject = m_Dbtx.GetDbtxList(getActivity());
//			//String gzt="[{'a':'b'}{'c':'d'}]";
//			//JSONArray dbtxJsonArray = new JSONArray(dbtxJsonObject.toString());
//			JSONArray dbtxJsonArray = dbtxJsonObject.getJSONArray(dbtxJsonObject.toString());
//			
//           List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//            for(int i=0;i<dbtxJsonArray.length();i++){
//            	JSONObject jsonObject2=dbtxJsonArray.getJSONObject(i);
//            	Map<String, Object> map = new HashMap<String, Object>();
//            	Iterator<String> iterator = jsonObject2.keys();
//            	while(iterator.hasNext()){
//            		String json_key=iterator.next();
//            		Object json_value=jsonObject2.get(json_key);
//            		if(json_value==null){
//            			
//            		}else{
//            			map.put(json_key, json_value);
//            		}
//            		list.add(map);
//            	}
//            }
//           
//        //   JSONObject jsonObject = new JSONObject(gzt);
//          // JSONArray jsonArray = jsonObject.getJSONArray();
//           
//			
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

//	@Override
//	public void onListItemClick(ListView l, View v, int position, long id) {
//		FragmentManager fragmentManager = getFragmentManager();
//		FragmentTransaction fragmentTransaction = fragmentManager
//				.beginTransaction();
//
//		gzt_rcgz_list_fragment my_gzp_edit_dqyzgzp_fragment = new gzt_rcgz_list_fragment();
//
//		Bundle args = new Bundle();
//		args.putInt("id", position);
//		my_gzp_edit_dqyzgzp_fragment.setArguments(args);
//
//		fragmentTransaction.replace(R.id.Ll_RightMain,
//				my_gzp_edit_dqyzgzp_fragment);
//		fragmentTransaction.addToBackStack(null);
//		fragmentTransaction.commit();
//
//		// Toast.makeText(getActivity(), Integer.toString(position) +"||"+
//		// Long.toString(id), Toast.LENGTH_LONG).show();
//	}
}
