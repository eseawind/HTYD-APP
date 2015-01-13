package main.fragment.selectperson;

import java.util.ArrayList;

import main.bean.PersonBean;

import org.json.JSONException;

import util.ui.UItoolKit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aqscgkpt.R;

public class ListPersonFragment extends Fragment {

	private String tag = "ListPersonFragment";
	private static final String PARENTID = "parentid";
	private static final String PARENTNAME = "parentname";
	private static final String ISSELECTED = "isselected";
	private static final String SELECTEDNAME = "selectedname";
	private static final String NUMSELECTED = "selectednum";

	private ListView mListView;
	private String parentName;
	private TextView selectPersonName;
	private boolean[] isSelect;
	private CallBacks mCallBack;

	public interface CallBacks {
		public void onPersonSelected(int pos, boolean isSelected, int size,
				PersonBean person);
	}

	public static Fragment newInstance(String parentID, String name,
			boolean[] isSelect,String nameSelect,int num) {
		Bundle arg = new Bundle();
		arg.putString(PARENTID, parentID);
		arg.putString(PARENTNAME, name);
		arg.putBooleanArray(ISSELECTED, isSelect);
		arg.putString(SELECTEDNAME, nameSelect);
		arg.putInt(NUMSELECTED, num);
		Fragment fragment = new ListPersonFragment();
		fragment.setArguments(arg);
		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mCallBack = (CallBacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallBack = null;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String parentID = getArguments().getString(PARENTID);
		parentName = getArguments().getString(PARENTNAME);
		isSelect = getArguments().getBooleanArray(ISSELECTED);
		if (parentID != "")
			startTask(parentID);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_list_person, container,
				false);
		initView(v);
		return v;
	}

	private void initView(View v) {
		if (mListView == null)
			mListView = (ListView) v.findViewById(R.id.list_select_person);
		mListView.setOnItemClickListener(new PersonSelectListener());
		TextView title = (TextView) v.findViewById(R.id.tv_person_list_title);
		if (parentName.length() == 0) {
			title.setText("人员列表");
		} else {
			title.setText(parentName);
		}
		Button defineButton = (Button) v.findViewById(R.id.btn_define);
		selectPersonName = (TextView) v.findViewById(R.id.tv_select_name);
		String nameList = getString(R.string.select_person_name, getArguments().getString(SELECTEDNAME),
				getArguments().getInt(NUMSELECTED)+"");
		selectPersonName.setText(nameList);
		defineButton.setOnClickListener(new DefineListener());
	}

	public ArrayList<PersonBean> loadData(String string) {
		ArrayList<PersonBean> result = new ArrayList<PersonBean>();
		try {
			result = PersonDataOperator.getPersonListByParentId(getActivity(),
					string);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	private class DefineListener implements OnClickListener {
		@Override
		public void onClick(View v) {

		}
	}

	private class PersonSelectListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			int size = mListView.getAdapter().getCount();
			if (isSelect == null) {
				isSelect = new boolean[size];
			}
			TextView status = (TextView) view
					.findViewById(R.id.tv_item_select_status);
			PersonBean pb = (PersonBean) mListView.getAdapter().getItem(
					position);
			Log.i("fanjishuo_____onItemClick", "position" + position);
			if (status.isEnabled()) {
				status.setEnabled(false);
				isSelect[position] = false;
			} else {
				status.setEnabled(true);
				isSelect[position] = true;
			}
			mCallBack.onPersonSelected(position, status.isEnabled(), size, pb);
			/*
			 * if (status.isEnabled()) { selectPersonList.add(pb); } else {
			 * selectPersonList.remove(pb); } setNameTextView(selectPersonList);
			 */
		}
	}

	private class PersonListAdapter extends BaseAdapter {

		private ArrayList<PersonBean> listPerson;

		public PersonListAdapter(ArrayList<PersonBean> listPerson) {
			super();
			this.listPerson = listPerson;
		}

		@Override
		public int getCount() {
			return listPerson.size();
		}

		@Override
		public Object getItem(int position) {
			return listPerson.get(position);
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
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.item_list_person, null);
				mHolder = new ViewHolder(convertView);
				convertView.setTag(mHolder);
			} else {
				mHolder = (ViewHolder) convertView.getTag();
			}
			PersonBean pb = (PersonBean) getItem(position);
			mHolder.setPersonName(pb.getName());
			if (isSelect != null) {
				mHolder.setSelectStatus(isSelect[position]);
				Log.i("fanjishuo____getView", "isSelect[position]:"
						+ isSelect[position] + position);
			} else {
				mHolder.setSelectStatus(false);
				Log.i("fanjishuo____getView", "isSelect = null" + "position"
						+ position);
			}
			return convertView;
		}

	}

	private class ViewHolder {
		private TextView departName;
		private TextView selectStatus;

		public ViewHolder(View v) {
			departName = (TextView) v.findViewById(R.id.tv_person_name);

			selectStatus = (TextView) v
					.findViewById(R.id.tv_item_select_status);
		}

		public void setPersonName(String name) {
			departName.setText(name);
		}

		public void setSelectStatus(boolean status) {
			selectStatus.setEnabled(status);
		}

	}

	private class LoadDataTask extends
			AsyncTask<String, Void, ArrayList<PersonBean>> {

		@Override
		protected void onPreExecute() {
			if (mListView == null) {
				mListView = (ListView) getActivity().findViewById(
						R.id.list_select_person);
			}
		}

		@Override
		protected ArrayList<PersonBean> doInBackground(String... params) {
			ArrayList<PersonBean> result = new ArrayList<PersonBean>();
			result = loadData(params[0]);
			Log.i("fanjishuo____doInBackground ListPersonFragment",
					"result.size()" + result.size());
			return result;
		}

		@Override
		protected void onPostExecute(ArrayList<PersonBean> result) {
			if (result == null) {
				UItoolKit.showToastShort(getActivity(), "网络异常或连接出错");
				stopTask(this);
				return;
			}
			if (mListView != null) {
				Log.i("fanjishuo____onPostExecute " + tag, "setA");
				mListView.setAdapter(new PersonListAdapter(result));
				// hd.sendEmptyMessage(1);
			}
			stopTask(this);
		}
	}

	private void startTask(String par) {
		Log.i("fanjishuo__startTask ListPersonFragment", par);
		new LoadDataTask().execute(par);
	}

	private void stopTask(LoadDataTask task) {
		Log.i("fanjishuo__stopTask ListPersonFragment", "stopTask");
		task.cancel(false);
	}

	public void setNameTextView(ArrayList<PersonBean> selectPerson) {
		Log.i("fanjishuo_____setNameTextView", "selectPerson.size()"
				+ selectPerson.size());
		StringBuilder sb = new StringBuilder();
		for (PersonBean pb : selectPerson) {
			sb.append(pb.getName() + "、");
		}
		String nameList = getString(R.string.select_person_name, sb.toString(),
				selectPerson.size() + "");
		selectPersonName.setText(nameList);
	}
}
