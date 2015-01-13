package main.fragment.selectperson;

import java.util.ArrayList;

import main.bean.DepartmentBean;

import org.json.JSONException;

import util.ui.UItoolKit;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aqscgkpt.R;

public class ListDepartmentFragment extends ListFragment {

	// private ArrayList<DepartmentBean> departmentList;
	private ListView mListView;
	private Callbacks mCallBack; 
	private String parentID;
	private String preString;
	private String currentParent;
	private String name;

	public interface Callbacks {
		void onDepartSelect(String parentId,String name);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mCallBack = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallBack = null;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		preString = "0";
		parentID = "0";
		startTask(parentID);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_list_department, container,
				false);
		initView(v);
		return v;
	}

	private void initView(View v) {
		if (mListView == null) {
			mListView = (ListView) v.findViewById(android.R.id.list);
		}
		Button goToPre = (Button) v.findViewById(R.id.btn_goto_pre);
		goToPre.setOnClickListener(new GotoPreListener());
	}

	private ArrayList<DepartmentBean> loadData(String num) {
		ArrayList<DepartmentBean> result = new ArrayList<DepartmentBean>();
		try {
			result = PersonDataOperator.getDepartmentListByParentId(
					getActivity(), num);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	private class DepartListAdapter extends ArrayAdapter<DepartmentBean> {

		public DepartListAdapter(ArrayList<DepartmentBean> departList) {
			super(getActivity(), 0, departList);
		}

		@SuppressLint("InflateParams")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder mHolder;
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.item_list_department, null);
				mHolder = new ViewHolder(convertView);
				convertView.setTag(mHolder);
			} else {
				mHolder = (ViewHolder) convertView.getTag();
			}
			DepartmentBean db = getItem(position);
			mHolder.setDepartName(db.getDepartmentName());
			return convertView;
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.i("fanjishuo___onListItemClick ListDepartmentFragment", "position"
				+ position);
		DepartmentBean db = ((DepartListAdapter) mListView.getAdapter())
				.getItem(position);
		if(!currentParent.equals(db.getParentID()+"")){
				preString = db.getParentID()+"";
		}/*else{
			v.setBackgroundColor(getActivity().getResources().getColor(R.color.skyblue));
			
		}*/
		parentID = db.getDepartmentID() + "";
		name = db.getDepartmentName();
		startTask(parentID);
	}

	private class GotoPreListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if(preString.equals(currentParent)){
				UItoolKit.showToastShort(getActivity(), "当前已经是第一级");
				return;
			}
			startTask(preString);
		}
	}

	private class ViewHolder {
		private TextView departName;
public TextView icoTextView;




		public ViewHolder(View v) {
			departName = (TextView) v.findViewById(R.id.tv_depart_name);
			icoTextView = (TextView) v.findViewById(R.id.tv_item_select_status);
		}

		public void setDepartName(String name) {
			departName.setText(name);
		}
	}

	private class LoadDataTask extends
			AsyncTask<String, Void, ArrayList<DepartmentBean>> {

		@Override
		protected ArrayList<DepartmentBean> doInBackground(String... params) {
			ArrayList<DepartmentBean> result = new ArrayList<DepartmentBean>();
			result = loadData(params[0]);
			return result;
		}

		@Override
		protected void onPostExecute(ArrayList<DepartmentBean> result) {
			if(result == null){
				UItoolKit.showToastShort(getActivity(), "网络异常或连接出错");
				stopTask(this);
				return;
			}
			if (mListView != null) {
				Log.i("fanjishuo_____onPostExecute ListDepartmentFragment",
						"result.size()" + result.size() + "");
				if (result.size() == 0) {
					mCallBack.onDepartSelect(parentID,name);
					stopTask(this);
					return;
				}
				currentParent = result.get(0).getParentID()+"";
				mListView.setAdapter(new DepartListAdapter(result));
			}
			stopTask(this);
		}
	}

	/*
	 * Handler hd = new Handler() {
	 * 
	 * @Override public void handleMessage(Message msg) { switch (msg.what) {
	 * case 1: mListView.setAdapter(new DepartListAdapter(departmentList)); } }
	 * 
	 * };
	 */

	private void startTask(String par) {
		Log.i("fanjishuo__startTask ListDepartmentFragment", "par" + par);
		new LoadDataTask().execute(par);
	}

	private void stopTask(LoadDataTask task) {
		Log.i("fanjishuo__stopTask ListDepartmentFragment", "stopTask");
		task.cancel(false);
	}
}
