package czp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aqscgkpt.R;

public class CzpTopMenuAdapter extends BaseAdapter {

	private Context context;
	private String[] menuName;
	private TopMenuClickListener mListener;
	
	public interface TopMenuClickListener{
		public void onTopMenuClickListener(int position);
	}

	public CzpTopMenuAdapter(Context context, String[] menuName) {
		this.context = context;
		this.menuName = menuName;
		mListener = (TopMenuClickListener) context;
	}

	@Override
	public int getCount() {
		return menuName.length;
	}

	@Override
	public Object getItem(int position) {
		return menuName[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.top_bottom_meun_item_layout, null);
			mHolder = new ViewHolder(convertView);
			convertView.setTag(mHolder);
		}else{
			mHolder = (ViewHolder) convertView.getTag();
		}
		mHolder.setText(menuName[position]);
		mHolder.menuTextView.setTag(position);
		mHolder.menuTextView.setOnClickListener(menuItemClickListener);
		return convertView;
	}

	private class ViewHolder {

		public TextView menuTextView;

		public ViewHolder(View v) {
			menuTextView = (TextView) v
					.findViewById(R.id.tv_top_bottom_meun_item);
		}
		public void setText(String name){
			menuTextView.setText(name);
		}
	}
	private OnClickListener menuItemClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			int position = (Integer) v.getTag();
			mListener.onTopMenuClickListener(position);
		}
	};
}
