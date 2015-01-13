package main.fragment;


import gzp.fragment.gzp_list_fragment;

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
public class gzp_menu_fragment extends Fragment 
{
	TextView tv_gzp_wdgzp,tv_gzp_dsgzp,tv_gzp_zzxgzp,tv_gzp_xjgzp;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
        return inflater.inflate(R.layout.gzp_menu_fragment, container, false);
    }
	@Override  
	 public void onActivityCreated(Bundle savedInstanceState) 
	 {  
         super.onActivityCreated(savedInstanceState);  
         
         tv_gzp_wdgzp = (TextView)getActivity().findViewById(R.id.tv_gzp_wdgzp);
         tv_gzp_dsgzp = (TextView)getActivity().findViewById(R.id.tv_gzp_dsgzp);
         tv_gzp_zzxgzp = (TextView)getActivity().findViewById(R.id.tv_gzp_zzxgzp);
         tv_gzp_xjgzp = (TextView)getActivity().findViewById(R.id.tv_gzp_xjgzp);
         
         tv_gzp_wdgzp.setOnClickListener(onClickListener);
         tv_gzp_dsgzp.setOnClickListener(onClickListener);
         tv_gzp_zzxgzp.setOnClickListener(onClickListener);
         tv_gzp_xjgzp.setOnClickListener(onClickListener);
         
         setSelected(tv_gzp_wdgzp);
	 }
	private void setSelected(TextView tv)
	{
		tv_gzp_wdgzp.setSelected(false);
		tv_gzp_dsgzp.setSelected(false);
		tv_gzp_zzxgzp.setSelected(false);
		tv_gzp_xjgzp.setSelected(false);
		
		tv.setSelected(true);
	}
	 private OnClickListener onClickListener = new OnClickListener() 
	 {
		public void onClick(View v) 
		{
			FragmentManager fragmentManager = getFragmentManager(); 
	        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 

			switch (v.getId()) {
			case R.id.tv_gzp_wdgzp:
				
				setSelected((TextView)v);
		        Fragment1 fragment1 = new Fragment1();

		        fragmentTransaction.replace(R.id.Ll_RightMain, fragment1);
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit(); 		        
				break;
			case R.id.tv_gzp_dsgzp: 
		        
				setSelected((TextView)v);
				
				gzp_list_fragment my_gzp_list_fragment = new gzp_list_fragment();

		        fragmentTransaction.replace(R.id.Ll_RightMain, my_gzp_list_fragment);
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit(); 		        
				break;
			default:				
				break;
			}

		}
	};
}
