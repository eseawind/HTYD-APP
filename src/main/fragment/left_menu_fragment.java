package main.fragment;



import gzp.fragment.gzp_list_fragment;
import gzt.fragment.gzt_dbtx_list_fragment;
import util.config.Dlyh;
import main.ui.MenuHorizontalScrollView;

import com.example.aqscgkpt.R;

import czp.fragment.CzpListFragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle; 
import android.view.LayoutInflater; 
import android.view.View; 
import android.view.ViewGroup; 
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;


@SuppressLint("NewApi")
public class left_menu_fragment extends Fragment 
{
	RelativeLayout Rl_gzt,Rl_rwd,Rl_gzp,Rl_czp,Rl_xdj,Rl_qx,Rl_sczb,Rl_xtsz;
	
	private TextView Tv_Left_Yhxx;
	 @Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState) { 
        // ---Inflate the layout for this fragment---  
        return inflater.inflate(R.layout.main_left_menu_fragment, container, false); 
    } 

	 @Override  
	 public void onActivityCreated(Bundle savedInstanceState) 
	 {  
         super.onActivityCreated(savedInstanceState);  
         
         Rl_gzt = (RelativeLayout)getActivity().findViewById(R.id.Rl_gzt);
         Rl_rwd = (RelativeLayout)getActivity().findViewById(R.id.Rl_rwd);
         Rl_gzp = (RelativeLayout)getActivity().findViewById(R.id.Rl_gzp);
         Rl_czp = (RelativeLayout)getActivity().findViewById(R.id.Rl_czp);
         Rl_xdj = (RelativeLayout)getActivity().findViewById(R.id.Rl_xdj);
         Rl_qx = (RelativeLayout)getActivity().findViewById(R.id.Rl_qx);
         Rl_sczb = (RelativeLayout)getActivity().findViewById(R.id.Rl_sczb);
         Rl_xtsz = (RelativeLayout)getActivity().findViewById(R.id.Rl_xtsz);
         
         Rl_gzt.setOnClickListener(onClickListener);
         Rl_rwd.setOnClickListener(onClickListener);
         Rl_gzp.setOnClickListener(onClickListener);
         Rl_czp.setOnClickListener(onClickListener);
         Rl_xdj.setOnClickListener(onClickListener);
         Rl_qx.setOnClickListener(onClickListener);
         Rl_sczb.setOnClickListener(onClickListener);
         Rl_xtsz.setOnClickListener(onClickListener);
         
         
         Tv_Left_Yhxx = (TextView) getActivity().findViewById(R.id.Tv_Left_Yhxx);
         Tv_Left_Yhxx.setText("欢迎您，" + Dlyh.getYhmc(getActivity()));


	 }
	 private OnClickListener onClickListener = new OnClickListener() 
	 {
		public void onClick(View v) 
		{
			FragmentManager fragmentManager = getFragmentManager(); 
	        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 
	        MenuHorizontalScrollView m_ScrollView = (MenuHorizontalScrollView) getActivity().findViewById(R.id.Mhsv_ScrollView);
	        TextView tv_title = (TextView)getActivity().findViewById(R.id.title);
	        
			switch (v.getId()) {
			case R.id.Rl_gzt:
				
				m_ScrollView.clickMenuBtn();				
				tv_title.setText("个人工作台");										   
		        
		        gzt_menu_fragment my_gzt_menu_fragment = new gzt_menu_fragment();
		        gzt_dbtx_list_fragment gztdbtx = new gzt_dbtx_list_fragment(); 
		        fragmentTransaction.replace(R.id.Ll_RightTopMenu, my_gzt_menu_fragment);	
		        fragmentTransaction.replace(R.id.Ll_RightMain, gztdbtx);
		        
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit();        
				break;
			case R.id.Rl_rwd: 
		        	        	
				m_ScrollView.clickMenuBtn();				
				tv_title.setText("生产任务单");										   
		        
		        rwd_menu_fragment my_rwd_menu_fragment = new rwd_menu_fragment();
		        Fragment1 fragment1 = new Fragment1(); 
		        fragmentTransaction.replace(R.id.Ll_RightTopMenu, my_rwd_menu_fragment);	
		        fragmentTransaction.replace(R.id.Ll_RightMain, fragment1);
		        
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit();        
				break;
			case R.id.Rl_gzp: 
	        	
				m_ScrollView.clickMenuBtn();				
				tv_title.setText("工作票");										   
		        
		        gzp_menu_fragment my_gzp_menu_fragment = new gzp_menu_fragment();
		        gzp_list_fragment gzplist = new gzp_list_fragment(); 
		        fragmentTransaction.replace(R.id.Ll_RightTopMenu, my_gzp_menu_fragment);	
		        fragmentTransaction.replace(R.id.Ll_RightMain, gzplist);
		        
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit();        
				break;
			case R.id.Rl_czp: 	        	
				m_ScrollView.clickMenuBtn();				
				tv_title.setText("操作票");										   
		        
		        czp_menu_fragment my_czp_menu_fragment = new czp_menu_fragment();
		        CzpListFragment czplist = new CzpListFragment(); 
		        fragmentTransaction.replace(R.id.Ll_RightTopMenu, my_czp_menu_fragment);	
		        fragmentTransaction.replace(R.id.Ll_RightMain, czplist);
		        
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit();        
				break;
			default:
				break;
			}
		}
	};
}
