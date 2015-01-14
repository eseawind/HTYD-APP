package main.adapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.aqscgkpt.R;

import main.activity.LoginActivity;
import main.entity.Mk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuListAdapter extends BaseAdapter 
{

	private List<Mk> m_Mk;
	Activity m_Context;
	
	public MenuListAdapter(Activity context)
	{
		init();
		this.m_Context = context;
	}
	
	public MenuListAdapter(Activity context,List<Mk> mk)
	{
		this.m_Mk = mk;
		this.m_Context = context;
	}

	@Override
	public int getCount() 
	{
		return (m_Mk==null)?0:m_Mk.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return m_Mk.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}
	
	
	public class ViewHolder
	{
		ImageView Iv_LeftMenuItemIcon;
		TextView Tv_LeftMenuItemText;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		final Mk mk = (Mk)getItem(position);
		ViewHolder viewHolder = null;
		if(convertView==null)
		{
			Log.d("MyBaseAdapter", "新建convertView,position="+position);
			convertView = LayoutInflater.from(m_Context).inflate(
					R.layout.main_left_menu_item, null);
			
			viewHolder = new ViewHolder();
			viewHolder.Tv_LeftMenuItemText = (TextView)convertView.findViewById(
					R.id.Tv_LeftMenuItemText);
			viewHolder.Iv_LeftMenuItemIcon = (ImageView)convertView.findViewById(
					R.id.Iv_LeftMenuItemIcon);
			
			/*/动态增加1个ImageView
			viewHolder.Iv_LeftMenuItemIcon = new ImageView(m_Context);
			LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			mParams.gravity = Gravity.CENTER;
			mParams.width=50;
			viewHolder.Iv_LeftMenuItemIcon.setLayoutParams(mParams);
			//这个ImageView放到ListView的第2列之后
			((LinearLayout)convertView).addView(viewHolder.Iv_LeftMenuItemIcon,0);
			*/
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
			Log.d("MyBaseAdapter", "旧的convertView,position="+position);
		}
		
		String menuItemText;
		menuItemText = String.valueOf(mk.Mkid) + "|" + String.valueOf(mk.Fjid) + "|" + mk.Mkmc + "|" + mk.Ljye;
		
		viewHolder.Tv_LeftMenuItemText.setText(menuItemText);		
		viewHolder.Iv_LeftMenuItemIcon.setImageResource(mk.Icon);
		
		//对ListView中第1个TextView配置OnClick事件
		viewHolder.Tv_LeftMenuItemText.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast.makeText(m_Context, 
						"[textViewItem01.setOnClickListener]点击了" + mk.Mkmc, 
						Toast.LENGTH_SHORT).show();
			}
		});
		
		//对ListView中的每一行信息配置OnClick事件
		convertView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(m_Context, 
						"[convertView.setOnClickListener]点击了" + mk.Mkmc, 
						Toast.LENGTH_SHORT).show();
			}
			
		});		
		
		return convertView;
	}
	
	private void gotoActivity(int position)
	{		
		Intent intent = new Intent();
		switch(position)
		{
		case 0:
			intent.setClass(m_Context,LoginActivity.class);
			m_Context.startActivity(intent);
			//给界面添加动画
			m_Context.overridePendingTransition(R.anim.push_in,R.anim.push_out);
			//关闭当前的activity
			m_Context.finish();
			break;		
		default:
			intent.setClass(m_Context, LoginActivity.class);
			intent.putExtra("position", position);
			m_Context.overridePendingTransition(R.anim.push_in,R.anim.push_out);
			m_Context.startActivity(intent);
		}
	}
	
	private void init()
	{
		m_Mk = new ArrayList<Mk>();
		
		m_Mk.add(new Mk(1, 0, "工作台", "gzt",R.drawable.loading_01));
		m_Mk.add(new Mk(2, 0, "任务单", "rwd",R.drawable.loading_02));
		m_Mk.add(new Mk(3, 0, "工作票", "gzp",R.drawable.loading_03));
		m_Mk.add(new Mk(4, 0, "操作票", "czp",R.drawable.loading_04));
		m_Mk.add(new Mk(5, 0, "运行日志", "yxrz",R.drawable.loading_05));
	}

}
