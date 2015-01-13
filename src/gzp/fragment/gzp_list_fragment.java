package gzp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import main.fragment.Fragment1;

import com.example.aqscgkpt.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class gzp_list_fragment extends ListFragment 
{
	
	 private ListView lv ;  
	 private SimpleAdapter adapter;  
	
	@Override  
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{  
		View view = inflater.inflate(R.layout.gzp_list_fragment, container, false);  


		return view;
	} 
	 
	 @Override  
	 public void onCreate(Bundle savedInstanceState) 
	 {
		 super.onActivityCreated(savedInstanceState);  
		 
		 /*
		 List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		 Map<String, Object> map;
		 
		 map = new Map<String, Object>(); 
		 map.put("id", "1"); 
		 map.put("title", "第一张工作票"); 
		 list.add(map); 

		 map = new Map<String, Object>(); 
		 map.put("id", "2"); 
		 map.put("title", "第二张工作票"); 
		 list.add(map); 
		 */
		 ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	        Map<String, Object> map1 = new HashMap<String, Object>();
	        Map<String, Object> map2 = new HashMap<String, Object>();
	        Map<String, Object> map3 = new HashMap<String, Object>();
	        Map<String, Object> map4 = new HashMap<String, Object>();
	        Map<String, Object> map5 = new HashMap<String, Object>();
	        Map<String, Object> map6 = new HashMap<String, Object>();
	        Map<String, Object> map7 = new HashMap<String, Object>();
	        Map<String, Object> map8 = new HashMap<String, Object>();
	        Map<String, Object> map9 = new HashMap<String, Object>();
	        Map<String, Object> map10 = new HashMap<String, Object>();
	        Map<String, Object> map11 = new HashMap<String, Object>();
	        Map<String, Object> map12 = new HashMap<String, Object>();
	        
	        	        
	        map1.put("gzp_gznr", "2号机6KV母线室2A、2B凝结水泵电机综合保护装置、变送器、电能表校验及二次回路清扫检查");
	        map1.put("gzp_gzfzr", "方昊");
	        map1.put("gzp_kpsj", "2014-01-22 10:20:30");
	        
	        map2.put("gzp_gznr", "2号机2C电动给水泵电源（1）62GS3-1、2C电动给水泵电源（2）62GS3-2综保、变送器、电能表校验。");
	        map2.put("gzp_gzfzr", "袁志明");
	        map2.put("gzp_kpsj", "2014-03-16 14:50:38");
	        
	        map3.put("gzp_gznr", "2号机2A闭式循环水泵综保、变送器、电度表校验及二次回路检查清扫");
	        map3.put("gzp_gzfzr", "杜金龙");
	        map3.put("gzp_kpsj", "2014-02-11 10:33:35");
	        
	        map4.put("gzp_gznr", "2号机6KV厂用2B段2C、2D高压流化风机综合保护装置校验、变送器及电能表校验");
	        map4.put("gzp_gzfzr", "白龙");
	        map4.put("gzp_kpsj", "2014-03-11 11:12:36");
	        
	        map5.put("gzp_gznr", "2号机2C空冷变综合保护装置、变送器及电能表校验");
	        map5.put("gzp_gzfzr", "赵晓臣");
	        map5.put("gzp_kpsj", "2014-02-22 08:20:22");
	        
	        map6.put("gzp_gznr", "2号机6KV母线室2A、2B凝结水泵电机综合保护装置、变送器、电能表校验及二次回路清扫检查");
	        map6.put("gzp_gzfzr", "方昊");
	        map6.put("gzp_kpsj", "2014-01-22 10:20:30");
	        
	        map7.put("gzp_gznr", "2号机2C电动给水泵电源（1）62GS3-1、2C电动给水泵电源（2）62GS3-2综保、变送器、电能表校验。");
	        map7.put("gzp_gzfzr", "袁志明");
	        map7.put("gzp_kpsj", "2014-03-16 14:50:38");
	        
	        map8.put("gzp_gznr", "2号机2A闭式循环水泵综保、变送器、电度表校验及二次回路检查清扫");
	        map8.put("gzp_gzfzr", "杜金龙");
	        map8.put("gzp_kpsj", "2014-02-11 10:33:35");
	        
	        map9.put("gzp_gznr", "2号机6KV厂用2B段2C、2D高压流化风机综合保护装置校验、变送器及电能表校验");
	        map9.put("gzp_gzfzr", "白龙");
	        map9.put("gzp_kpsj", "2014-03-11 11:12:36");
	        
	        map10.put("gzp_gznr", "2号机2C空冷变综合保护装置、变送器及电能表校验");
	        map10.put("gzp_gzfzr", "赵晓臣");
	        map10.put("gzp_kpsj", "2014-02-22 08:20:22");
	        
	        map11.put("gzp_gznr", "2号机6KV厂用2B段2C、2D高压流化风机综合保护装置校验、变送器及电能表校验;电动给水泵电源（1）62GS3-1、2C电动给水泵电源（2）62GS3-2综保、变送器、电能表校验");
	        map11.put("gzp_gzfzr", "白龙");
	        map11.put("gzp_kpsj", "2014-03-11 11:12:36");
	        
	        map12.put("gzp_gznr", "2号机2C空冷变综合保护装置、变送器及电能表校验");
	        map12.put("gzp_gzfzr", "赵晓臣");
	        map12.put("gzp_kpsj", "2014-02-22 08:20:22");
	        
	        list.add(map1);
	        list.add(map2);
	        list.add(map3);
	        list.add(map4);
	        list.add(map5);
	        list.add(map6);
	        list.add(map7);
	        list.add(map8);
	        list.add(map9);
	        list.add(map10);
	        list.add(map11);
	        list.add(map12);
		 
		 adapter = new SimpleAdapter(getActivity(), list, R.layout.gzp_list_item, new String[]{"gzp_gznr","gzp_gzfzr","gzp_kpsj"}, new int[]{R.id.gzp_gznr,R.id.gzp_gzfzr,R.id.gzp_kpsj});  
	        
		 //lv = (ListView) getActivity().findViewById(R.id.lv_list);
		 setListAdapter(adapter);   
		 
	 }
	 
	 @Override
	public void onListItemClick(ListView l, View v, int position, long id)
	 {
		 FragmentManager fragmentManager = getFragmentManager(); 
	     FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 
	     
	     gzp_edit_dqyzgzp_fragment my_gzp_edit_dqyzgzp_fragment = new gzp_edit_dqyzgzp_fragment();
	     
	     Bundle args = new Bundle();
	     args.putInt("id", position);     
	     my_gzp_edit_dqyzgzp_fragment.setArguments(args); 

	     fragmentTransaction.replace(R.id.Ll_RightMain, my_gzp_edit_dqyzgzp_fragment);
	     fragmentTransaction.addToBackStack(null); 
	     fragmentTransaction.commit(); 
		
		 //Toast.makeText(getActivity(), Integer.toString(position) +"||"+ Long.toString(id), Toast.LENGTH_LONG).show();  	 		
	}
}
