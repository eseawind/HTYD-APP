package czp.fragment;

import java.util.ArrayList;
import java.util.List;

import util.ui.ListViewForScrollView;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aqscgkpt.R;

import czp.bean.CzpCzxBean;
import czp.bean.CzpZpBean;

public class CzpItemDetailFragment extends Fragment {

	private static final String CZPBEAN = "czpdetailbean";

	private CzpZpBean mBean;
	private List<CzpCzxBean> czxList;

	public static Fragment newInstance(String task, CzpZpBean bean) {
		Bundle arg = new Bundle();
		arg.putString("task", task);
		arg.putParcelable(CZPBEAN, bean);
		Fragment fragment = new CzpItemDetailFragment();
		fragment.setArguments(arg);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBean = getArguments().getParcelable(CZPBEAN);
		czxList = new ArrayList<CzpCzxBean>();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.czp_detail, container, false);
		loadData();
		initView(v);
		return v;
	}

	@Override
	public void onDestroy() {
		mBean = null;
		czxList.clear();
		czxList = null;
		super.onDestroy();
	}

	@SuppressLint("InflateParams")
	private void initView(View v) {
		ListViewForScrollView mListView = (ListViewForScrollView) v
				.findViewById(R.id.list_czp_item);
		TextView emptyView = (TextView) v.findViewById(R.id.empty_list_view);
		emptyView.setText("还没有操作项");
		mListView.setEmptyView(emptyView);
		mListView.setAdapter(new CZPListAdapter());
		PagePanel mPanel = new PagePanel(v);
		mPanel.setText(mBean);
		mPanel.setEnable(false);
	}

	private void loadData() {
		czxList = mBean.getCzxList();
	}

	private class CZPListAdapter extends BaseAdapter {

		private CzpCzxBean mBean = new CzpCzxBean();

		@Override
		public int getCount() {
			return czxList.size();
		}

		@Override
		public Object getItem(int position) {
			return czxList.get(position);
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
						R.layout.czp_item_layout, null);
				mHolder = new ViewHolder(convertView);
				convertView.setTag(mHolder);
			} else {
				mHolder = (ViewHolder) convertView.getTag();
			}
			mBean = (CzpCzxBean) getItem(position);
			mHolder.setArrayNum(mBean.getArrayNum());
			mHolder.setWork(mBean.getCzxWork());
			mHolder.setTime(mBean.getTime());
			return convertView;
		}
	}

	private class ViewHolder {

		private CheckBox simulationCheckbox;
		private CheckBox actulCheckBox;
		private TextView numTextView;
		private TextView itemTextView;
		private TextView timeTextView;

		public ViewHolder(View v) {
			simulationCheckbox = (CheckBox) v
					.findViewById(R.id.ch_list_czp_simulation);
			actulCheckBox = (CheckBox) v.findViewById(R.id.ch_list_czp_actual);
			numTextView = (TextView) v.findViewById(R.id.tv_list_czp_num);
			itemTextView = (TextView) v.findViewById(R.id.tv_list_czp_work);
			timeTextView = (TextView) v.findViewById(R.id.tv_list_czp_time);
		}

		public void setArrayNum(String num) {
			numTextView.setText(num);
		}

		public void setWork(String work) {
			itemTextView.setText(work);
		}

		public void setTime(String time) {
			timeTextView.setText(time);
		}

	}

	private class PagePanel {
		EditText departEdit, arrayNumEdit, startTimeEdit, endTimeEdit,
				taskEdit, remarkEdit, operatorNameEdit, guardNameEdit,
				dutyNameEdit, dutyLeaderEdit;

		public PagePanel(View v) {
			departEdit = (EditText) v.findViewById(R.id.edit_department);
			arrayNumEdit = (EditText) v.findViewById(R.id.edit_number);
			startTimeEdit = (EditText) v.findViewById(R.id.ed_start_time);
			endTimeEdit = (EditText) v.findViewById(R.id.ed_end_time);
			taskEdit = (EditText) v.findViewById(R.id.ed_czp_task);
			remarkEdit = (EditText) v.findViewById(R.id.ed_czp_remark);
			operatorNameEdit = (EditText) v.findViewById(R.id.ed_operator_name);
			guardNameEdit = (EditText) v.findViewById(R.id.ed_guard_name);
			dutyNameEdit = (EditText) v.findViewById(R.id.ed_duty_name);
			dutyLeaderEdit = (EditText) v
					.findViewById(R.id.ed_duty_leader_name);
		}

		public void setText(CzpZpBean mBean) {
			departEdit.setText(mBean.getDepart());
			arrayNumEdit.setText(mBean.getCzpNum());
			startTimeEdit.setText(mBean.getStartTime());
			endTimeEdit.setText(mBean.getEndTime());
			taskEdit.setText(getArguments().getString("task"));
			remarkEdit.setText(mBean.getCzpRemark());
			operatorNameEdit.setText(mBean.getCzpCzrName());
			guardNameEdit.setText(mBean.getCzpGuardName());
			dutyNameEdit.setText(mBean.getCzpDutyName());
			dutyLeaderEdit.setText(mBean.getCzpLeaderName());
		}

		public void setEnable(boolean isEnable) {
			departEdit.setEnabled(isEnable);
			arrayNumEdit.setEnabled(isEnable);
			startTimeEdit.setEnabled(isEnable);
			endTimeEdit.setEnabled(isEnable);
			taskEdit.setEnabled(isEnable);
			remarkEdit.setEnabled(isEnable);
			operatorNameEdit.setEnabled(isEnable);
			guardNameEdit.setEnabled(isEnable);
			dutyNameEdit.setEnabled(isEnable);
			dutyLeaderEdit.setEnabled(isEnable);
		}
	}
}
