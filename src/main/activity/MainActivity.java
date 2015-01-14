package main.activity;


import gzt.fragment.gzt_dbtx_list_fragment;
import main.fragment.gzt_menu_fragment;
import main.ui.MenuHorizontalScrollView;
import main.ui.SizeCallBackForMenu;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aqscgkpt.R;

@SuppressLint("NewApi")
public class MainActivity extends Activity 
{
	private View m_RightView, m_LeftView;
	private ImageView m_MenuBtn;
	private View[] m_Children;
	private LinearLayout m_MenuList;
	private MenuHorizontalScrollView  m_ScrollView;
	private LayoutInflater m_Inflater;
	
	ListAdapter m_ListAdapter;
	ListView m_MenuListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);				
		
		/**初始化界面******************************************************/
		
		util.function.Screen.FullWindow(this);
		util.function.Screen.getScreenSize(this);

		m_Inflater = LayoutInflater.from(this);    
		setContentView(m_Inflater.inflate(R.layout.main_layout, null)); 
		
		//左边导航
		m_MenuList = (LinearLayout)findViewById(R.id.Ll_Left);
		
		//右边部分
		m_RightView = m_Inflater.inflate(R.layout.main_right,null);
		m_MenuBtn = (ImageView) m_RightView.findViewById(R.id.top_head);
		
		//左边覆盖的空白部分
		m_LeftView = new View(this);
		m_LeftView.setBackgroundColor(Color.TRANSPARENT);
		
		//滚动部分
		m_ScrollView = (MenuHorizontalScrollView) findViewById(R.id.Mhsv_ScrollView);
		m_Children = new View[] {m_LeftView, m_RightView};
		m_ScrollView.initViews(m_Children, new SizeCallBackForMenu(m_MenuBtn),m_MenuList);
		m_ScrollView.setMenuBtn(m_MenuBtn);
		
		m_MenuBtn.setOnClickListener(new OnClickListener() {  

        	 @Override  
        	 public void onClick(View v) {  
        		 m_ScrollView.clickMenuBtn();        		 
        	 }  
         });	
		
		initActivity();
	}	
	public MenuHorizontalScrollView getScrollView() {
		return m_ScrollView;
	}

	public void setScrollView(MenuHorizontalScrollView scrollView) {
		this.m_ScrollView = scrollView;
	}	
	
	private void initActivity()
	{
		FragmentManager fragmentManager = getFragmentManager(); 
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 
       
        TextView tv_title = (TextView)findViewById(R.id.title);
        
		tv_title.setText("个人工作台");										   
        
        gzt_menu_fragment my_gzt_menu_fragment = new gzt_menu_fragment();
        gzt_dbtx_list_fragment gztdbtx = new gzt_dbtx_list_fragment(); 
        fragmentTransaction.replace(R.id.Ll_RightTopMenu, my_gzt_menu_fragment);	
        fragmentTransaction.replace(R.id.Ll_RightMain, gztdbtx);
        
        fragmentTransaction.addToBackStack(null); 
        fragmentTransaction.commit(); 
	}
}
