package main.fragment;
import com.example.aqscgkpt.R;

import czp.fragment.CzpListFragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class czp_menu_fragment extends Fragment{
	
	TextView tv_gzp_wdczp,tv_gzp_dsczp,tv_gzp_zzxczp,tv_gzp_xjczp;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.czp_menu_fragment,container,false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);  
		tv_gzp_wdczp=(TextView) getActivity().findViewById(R.id.tv_gzp_wdczp);
		tv_gzp_dsczp=(TextView) getActivity().findViewById(R.id.tv_gzp_dsczp);
		tv_gzp_zzxczp=(TextView) getActivity().findViewById(R.id.tv_gzp_zzxczp);
		tv_gzp_xjczp=(TextView) getActivity().findViewById(R.id.tv_gzp_xjczp);
		
		
		tv_gzp_wdczp.setOnClickListener(onClickListener);
		tv_gzp_dsczp.setOnClickListener(onClickListener);
		tv_gzp_zzxczp.setOnClickListener(onClickListener);
		tv_gzp_xjczp.setOnClickListener(onClickListener);
		setSelected(tv_gzp_wdczp);
	}
	
	private void setSelected(TextView tv)
	{
		tv_gzp_wdczp.setSelected(false);
		tv_gzp_dsczp.setSelected(false);
		tv_gzp_zzxczp.setSelected(false);
		tv_gzp_xjczp.setSelected(false);
		
		tv.setSelected(true);
	}
	private OnClickListener onClickListener = new OnClickListener(){


		@Override
		public void onClick(View v) {
			
			FragmentManager  fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

			switch (v.getId()) {
			case R.id.tv_gzp_wdczp:
				
				setSelected((TextView)v);
				CzpListFragment czplist = new CzpListFragment();
				fragmentTransaction.replace(R.id.Ll_RightMain,czplist);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
				break;
			case R.id.tv_gzp_dsczp:
				
				setSelected((TextView)v);
				czplist = new CzpListFragment();
				fragmentTransaction.replace(R.id.Ll_RightMain,czplist);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
				break;
			case R.id.tv_gzp_zzxczp:
				
				break;
			case R.id.tv_gzp_xjczp:
				
				break;
			default:
				break;
			}
			
		}};
}
