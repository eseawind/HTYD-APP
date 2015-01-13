package czp.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import util.ui.UItoolKit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aqscgkpt.R;

import czp.CzpDownloader;
import czp.bean.CzpBean;
import czp.bean.CzpZpBean;

public class CzpListFragment extends ListFragment {

	private static final String LISTCZP = "czplist";

	private ListItemClickListener mListener;
	private static boolean isEmpty;
	private CzpDownloader<Integer> mCzpDownloader;
	@SuppressLint("UseSparseArrays")
	private HashMap<Integer, CzpZpBean> list;

	public static Fragment newInstance(ArrayList<CzpBean> czpList) {
		if (czpList != null) {
			isEmpty = false;
			Bundle arg = new Bundle();
			arg.putParcelableArrayList(LISTCZP, czpList);
			Fragment fragment = new CzpListFragment();
			fragment.setArguments(arg);
			return fragment;
		} else {
			isEmpty = true;
			return new CzpListFragment();
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mListener = (ListItemClickListener) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	public interface ListItemClickListener {
		public void onItemClick(int position, CzpZpBean mBean);
	}

	@SuppressLint("UseSparseArrays")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		list = new HashMap<Integer, CzpZpBean>();
		initLoader();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.czp_list_frament, container, false);
		initView(v);
		return v;
	}

	@Override
	public void onDestroy() {
		mCzpDownloader.quit();
		list.clear();
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mCzpDownloader.clearQueue();
	}

	private void initView(View v) {
		ListView listView = (ListView) v.findViewById(android.R.id.list);
		if (!isEmpty) {
			Log.i("fanjishuo____initView", "isEmpty" + isEmpty);
			if (getArguments().getParcelableArrayList(LISTCZP).size() == 0) {
				((TextView) v.findViewById(R.id.tv_empty_text))
						.setText("当前还没有操作票！");
			} else {
				((TextView) v.findViewById(R.id.tv_empty_text))
						.setText("网络连接异常！");
			}
			listView.setAdapter(new CzpListAdapter(getArguments()
					.getParcelableArrayList(LISTCZP)));
		}
	}

	private void initLoader() {
		mCzpDownloader = new CzpDownloader<Integer>(getActivity(),
				new Handler());
		mCzpDownloader.setListener(new CzpDownloader.Listener<Integer>() {
			@Override
			public void onCzpAllDownloaded(Integer token, CzpZpBean mBean) {
				Log.e("fanjishuo____onCzpAllDownloaded", "token" + token
						+ "list.size()" + list.size());
				list.put(token, mBean);
			}
		});
		mCzpDownloader.start();
		mCzpDownloader.getLooper();
	}

	@SuppressLint("CommitTransaction")
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		if (list.containsKey(position)) {
			mListener.onItemClick(position, list.get(position));
		} else {
			UItoolKit.showToastShort(getActivity(), "详细信息还未加载完成");
		}
	}

	private class CzpListAdapter extends BaseAdapter {

		private ArrayList<Parcelable> czpList = new ArrayList<Parcelable>();

		public CzpListAdapter(ArrayList<Parcelable> arrayList) {
			this.czpList = arrayList;
		}

		@Override
		public int getCount() {
			return czpList.size();
		}

		@Override
		public Object getItem(int position) {
			return czpList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@SuppressLint({ "InflateParams", "UseValueOf" })
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder mHolder;
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.czp_list_item, null);
				mHolder = new ViewHolder(convertView);
				convertView.setTag(mHolder);
			} else {
				mHolder = (ViewHolder) convertView.getTag();
			}
			CzpBean mBean = (CzpBean) getItem(position);
			mCzpDownloader.queueCzpAll(new Integer(position), mBean.getCzpID()
					+ "");
			mHolder.setTask(mBean.getCzpTask());
			mHolder.setPersonName(mBean.getCzrName());
			mHolder.setTime(mBean.getCzpStartTime());
			mHolder.setNum((position + 1) + "");
			return convertView;
		}

		private class ViewHolder {
			private TextView taskTextView;
			private TextView personNameTextView;
			private TextView time;
			private TextView numArray;

			public ViewHolder(View v) {
				taskTextView = (TextView) v.findViewById(R.id.tv_czp_task);
				personNameTextView = (TextView) v
						.findViewById(R.id.tv_czp_person_name);
				time = (TextView) v.findViewById(R.id.tv_czp_kptime);
				numArray = (TextView) v.findViewById(R.id.tv_czp_czpid);
			}

			public void setTask(String task) {
				taskTextView.setText(task);
			}

			public void setPersonName(String name) {
				personNameTextView.setText(name);
			}

			public void setTime(String time) {
				this.time.setText(time);
			}

			public void setNum(String num) {
				numArray.setText(num);
			}
		}
	}
}
