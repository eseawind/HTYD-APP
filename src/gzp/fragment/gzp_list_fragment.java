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
		 map.put("title", "��һ�Ź���Ʊ"); 
		 list.add(map); 

		 map = new Map<String, Object>(); 
		 map.put("id", "2"); 
		 map.put("title", "�ڶ��Ź���Ʊ"); 
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
	        
	        	        
	        map1.put("gzp_gznr", "2�Ż�6KVĸ����2A��2B����ˮ�õ���ۺϱ���װ�á������������ܱ�У�鼰���λ�·��ɨ���");
	        map1.put("gzp_gzfzr", "���");
	        map1.put("gzp_kpsj", "2014-01-22 10:20:30");
	        
	        map2.put("gzp_gznr", "2�Ż�2C�綯��ˮ�õ�Դ��1��62GS3-1��2C�綯��ˮ�õ�Դ��2��62GS3-2�۱��������������ܱ�У�顣");
	        map2.put("gzp_gzfzr", "Ԭ־��");
	        map2.put("gzp_kpsj", "2014-03-16 14:50:38");
	        
	        map3.put("gzp_gznr", "2�Ż�2A��ʽѭ��ˮ���۱�������������ȱ�У�鼰���λ�·�����ɨ");
	        map3.put("gzp_gzfzr", "�Ž���");
	        map3.put("gzp_kpsj", "2014-02-11 10:33:35");
	        
	        map4.put("gzp_gznr", "2�Ż�6KV����2B��2C��2D��ѹ��������ۺϱ���װ��У�顢�����������ܱ�У��");
	        map4.put("gzp_gzfzr", "����");
	        map4.put("gzp_kpsj", "2014-03-11 11:12:36");
	        
	        map5.put("gzp_gznr", "2�Ż�2C������ۺϱ���װ�á������������ܱ�У��");
	        map5.put("gzp_gzfzr", "������");
	        map5.put("gzp_kpsj", "2014-02-22 08:20:22");
	        
	        map6.put("gzp_gznr", "2�Ż�6KVĸ����2A��2B����ˮ�õ���ۺϱ���װ�á������������ܱ�У�鼰���λ�·��ɨ���");
	        map6.put("gzp_gzfzr", "���");
	        map6.put("gzp_kpsj", "2014-01-22 10:20:30");
	        
	        map7.put("gzp_gznr", "2�Ż�2C�綯��ˮ�õ�Դ��1��62GS3-1��2C�綯��ˮ�õ�Դ��2��62GS3-2�۱��������������ܱ�У�顣");
	        map7.put("gzp_gzfzr", "Ԭ־��");
	        map7.put("gzp_kpsj", "2014-03-16 14:50:38");
	        
	        map8.put("gzp_gznr", "2�Ż�2A��ʽѭ��ˮ���۱�������������ȱ�У�鼰���λ�·�����ɨ");
	        map8.put("gzp_gzfzr", "�Ž���");
	        map8.put("gzp_kpsj", "2014-02-11 10:33:35");
	        
	        map9.put("gzp_gznr", "2�Ż�6KV����2B��2C��2D��ѹ��������ۺϱ���װ��У�顢�����������ܱ�У��");
	        map9.put("gzp_gzfzr", "����");
	        map9.put("gzp_kpsj", "2014-03-11 11:12:36");
	        
	        map10.put("gzp_gznr", "2�Ż�2C������ۺϱ���װ�á������������ܱ�У��");
	        map10.put("gzp_gzfzr", "������");
	        map10.put("gzp_kpsj", "2014-02-22 08:20:22");
	        
	        map11.put("gzp_gznr", "2�Ż�6KV����2B��2C��2D��ѹ��������ۺϱ���װ��У�顢�����������ܱ�У��;�綯��ˮ�õ�Դ��1��62GS3-1��2C�綯��ˮ�õ�Դ��2��62GS3-2�۱��������������ܱ�У��");
	        map11.put("gzp_gzfzr", "����");
	        map11.put("gzp_kpsj", "2014-03-11 11:12:36");
	        
	        map12.put("gzp_gznr", "2�Ż�2C������ۺϱ���װ�á������������ܱ�У��");
	        map12.put("gzp_gzfzr", "������");
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
