package main.fragment;


import com.example.aqscgkpt.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

@SuppressLint("NewApi")
public class rwd_menu_fragment extends Fragment 
{
	TextView tv_rwd_wdrwd,tv_rwd_dsrwd,tv_rwd_zzxrwd,tv_rwd_wkprwd;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
        return inflater.inflate(R.layout.rwd_menu_fragment, container, false);
    }
	@Override  
	 public void onActivityCreated(Bundle savedInstanceState) 
	 {  
         super.onActivityCreated(savedInstanceState);  
         
         tv_rwd_wdrwd = (TextView)getActivity().findViewById(R.id.tv_rwd_wdrwd);
         tv_rwd_dsrwd = (TextView)getActivity().findViewById(R.id.tv_rwd_dsrwd);
         tv_rwd_zzxrwd = (TextView)getActivity().findViewById(R.id.tv_rwd_zzxrwd);
         tv_rwd_wkprwd = (TextView)getActivity().findViewById(R.id.tv_rwd_wkprwd);
         
         tv_rwd_wdrwd.setOnClickListener(onClickListener);
         tv_rwd_dsrwd.setOnClickListener(onClickListener);
         tv_rwd_zzxrwd.setOnClickListener(onClickListener);
         tv_rwd_wkprwd.setOnClickListener(onClickListener);
         
         setSelected(tv_rwd_wdrwd);
	 }
	private void setSelected(TextView tv)
	{
		tv_rwd_wdrwd.setSelected(false);
		tv_rwd_dsrwd.setSelected(false);
		tv_rwd_zzxrwd.setSelected(false);
		tv_rwd_wkprwd.setSelected(false);
		
		tv.setSelected(true);
	}
	 private OnClickListener onClickListener = new OnClickListener() 
	 {
		public void onClick(View v) 
		{
			FragmentManager fragmentManager = getFragmentManager(); 
	        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 

			switch (v.getId()) {
			case R.id.tv_rwd_wdrwd:
				
				setSelected((TextView)v);
		        Fragment1 fragment1 = new Fragment1();

		        fragmentTransaction.replace(R.id.Ll_RightMain, fragment1);
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit(); 		        
				break;
			case R.id.tv_rwd_dsrwd: 
		        
				setSelected((TextView)v);
		        Fragment2 fragment2 = new Fragment2();

		        fragmentTransaction.replace(R.id.Ll_RightMain, fragment2);
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit(); 		        
				break;
			default:				
				break;
			}

		}
	};
}
