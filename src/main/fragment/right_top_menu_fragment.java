package main.fragment;

import main.activity.LoginActivity;
import main.activity.MainActivity;
import main.adapter.MenuListAdapter;

import com.example.aqscgkpt.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class right_top_menu_fragment extends Fragment 
{
	private LinearLayout.LayoutParams LP_FF = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT); 
	private LinearLayout.LayoutParams LP_FW = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT); 
	private LinearLayout.LayoutParams LP_WW = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	private LinearLayout.LayoutParams LP_WM = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
        return inflater.inflate(R.layout.main_right_top_menu_fragment, container, false);
    }
	
	 @Override  
	 public void onActivityCreated(Bundle savedInstanceState) 
	 {  
         super.onActivityCreated(savedInstanceState);  
         
         LinearLayout m_RightTopMenu; 
		 m_RightTopMenu = (LinearLayout)getActivity().findViewById(R.id.Ll_RightTopMenu); 
		 
		//获取左边节点的ID
		int MenuListViewId;
		
		MenuListViewId = 1;
		
		if (MenuListViewId == 1)
		{
			Button myBtn[] = new Button[4];
			
			myBtn[0] = new Button(getActivity());
			myBtn[0].setId(11);
			myBtn[0].setText("待办提醒");
			myBtn[0].setTextSize(11);
			
			//myBtn[0].setWidth(400);
			//myBtn[0].setHeight(40);
			myBtn[0].setBackgroundColor(Color.rgb(0,255, 255));
			myBtn[0].setOnClickListener(new Button.OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{				
					FragmentManager fragmentManager = getFragmentManager(); 
			        FragmentTransaction fragmentTransaction = fragmentManager 
			                .beginTransaction(); 
			        
			        Fragment1 fragment1 = new Fragment1(); 
			        
			        fragmentTransaction.replace(R.id.Ll_RightMain, fragment1);
			        
			        fragmentTransaction.addToBackStack(null); 
			        fragmentTransaction.commit(); 
			        
					Toast.makeText(getActivity(), "默认Toast样式111",
						     Toast.LENGTH_SHORT).show();
				}
			});
			m_RightTopMenu.addView(myBtn[0],LP_WM);
			
			myBtn[1] = new Button(getActivity());
			myBtn[1].setId(12);
			myBtn[1].setText("快捷工作");
			//myBtn[1].setWidth(400);
			//myBtn[1].setHeight(40);
			myBtn[1].setBackgroundColor(Color.rgb(100,0, 255));
			myBtn[1].setOnClickListener(new Button.OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{
					FragmentManager fragmentManager = getFragmentManager(); 
			        FragmentTransaction fragmentTransaction = fragmentManager 
			                .beginTransaction(); 
			        
			        Fragment2 fragment2 = new Fragment2(); 
			        
			        fragmentTransaction.replace(R.id.Ll_RightMain, fragment2);
			        
			        fragmentTransaction.addToBackStack(null); 
			        fragmentTransaction.commit(); 
			        
					Toast.makeText(getActivity(), "默认Toast样式222",
						     Toast.LENGTH_SHORT).show();
				}
			});
			m_RightTopMenu.addView(myBtn[1],LP_WM);
			
			
			myBtn[2] = new Button(getActivity());
			myBtn[2].setId(13);
			myBtn[2].setText("工作计划");
			//myBtn[2].setWidth(400);
			//myBtn[2].setHeight(40);
			myBtn[2].setBackgroundColor(Color.rgb(0,255, 100));
			myBtn[2].setOnClickListener(new Button.OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{
					
				}
			});
			m_RightTopMenu.addView(myBtn[2],LP_WM);
			
			myBtn[3] = new Button(getActivity());
			myBtn[3].setId(14);
			myBtn[3].setText("密码修改");
			//myBtn[3].setWidth(400);
			//myBtn[3].setHeight(40);
			myBtn[3].setBackgroundColor(Color.rgb(0,100, 50));
			myBtn[3].setOnClickListener(new Button.OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{
					
				}
			});
			m_RightTopMenu.addView(myBtn[3],LP_WM);
		}		
	 } 

}
