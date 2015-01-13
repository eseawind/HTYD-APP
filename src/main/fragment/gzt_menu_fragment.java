package main.fragment;


import gzp.fragment.gzp_list_fragment;
import gzt.fragment.gzt_dbtx_list_fragment;
import gzt.fragment.gzt_rcgz_list_fragment;

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
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class gzt_menu_fragment extends Fragment 
{
	TextView tv_gzt_dbtx,tv_gzt_rcgz,tv_gzt_gzjh,tv_gzt_txsz,tv_gzt_xgmm;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
        return inflater.inflate(R.layout.gzt_menu_fragment, container, false);
    }
	@Override  
	 public void onActivityCreated(Bundle savedInstanceState) 
	 {  
         super.onActivityCreated(savedInstanceState);  
         
         tv_gzt_dbtx = (TextView)getActivity().findViewById(R.id.tv_gzt_dbtx);
         tv_gzt_rcgz = (TextView)getActivity().findViewById(R.id.tv_gzt_rcgz);
         tv_gzt_gzjh = (TextView)getActivity().findViewById(R.id.tv_gzt_gzjh);
         tv_gzt_txsz = (TextView)getActivity().findViewById(R.id.tv_gzt_txsz);
         tv_gzt_xgmm = (TextView)getActivity().findViewById(R.id.tv_gzt_xgmm);
         
         tv_gzt_dbtx.setOnClickListener(onClickListener);
         tv_gzt_rcgz.setOnClickListener(onClickListener);
         tv_gzt_gzjh.setOnClickListener(onClickListener);
         tv_gzt_txsz.setOnClickListener(onClickListener);
         tv_gzt_xgmm.setOnClickListener(onClickListener);
         
         setSelected(tv_gzt_dbtx);
	 }
	private void setSelected(TextView tv)
	{
		tv_gzt_dbtx.setSelected(false);
		tv_gzt_rcgz.setSelected(false);
		tv_gzt_gzjh.setSelected(false);
		tv_gzt_txsz.setSelected(false);
		tv_gzt_xgmm.setSelected(false);
		
		tv.setSelected(true);
	}
	 private OnClickListener onClickListener = new OnClickListener() 
	 {
		public void onClick(View v) 
		{
			FragmentManager fragmentManager = getFragmentManager(); 
	        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 

			switch (v.getId()) {
			case R.id.tv_gzt_dbtx:
				
				setSelected((TextView)v);
		        gzt_dbtx_list_fragment gztdbtx = new gzt_dbtx_list_fragment();

		        fragmentTransaction.replace(R.id.Ll_RightMain, gztdbtx);
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit(); 		        
				break;
			case R.id.tv_gzt_rcgz: 
		        
				setSelected((TextView)v);
		        gzt_rcgz_list_fragment gztrcgz = new gzt_rcgz_list_fragment();

		        fragmentTransaction.replace(R.id.Ll_RightMain, gztrcgz);
		        fragmentTransaction.addToBackStack(null); 
		        fragmentTransaction.commit(); 		        
				break;
			default:				
				break;
			}

		}
	};
}
