package czp;

import java.util.ArrayList;

import main.activity.SimpleActivityWithMenu;

import org.json.JSONException;

import util.ui.UItoolKit;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.aqscgkpt.R;

import czp.adapter.CzpBottomMenuAdapter;
import czp.adapter.CzpTopMenuAdapter;
import czp.bean.CzpBean;
import czp.bean.CzpZpBean;
import czp.fragment.CzpItemDetailFragment;
import czp.fragment.CzpListFragment;

public class CzpActivity extends SimpleActivityWithMenu implements
		CzpListFragment.ListItemClickListener,
		CzpBottomMenuAdapter.BottomMenuClickListener,
		CzpTopMenuAdapter.TopMenuClickListener {

	private ArrayList<CzpBean> czpList = new ArrayList<CzpBean>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		startTask();
		initView();
	}

	private void initView() {
		String[] menuNameTop = getResources().getStringArray(
				R.array.czp_top_menu);
		String[] menuNameBottom = getResources().getStringArray(
				R.array.czp_bottom_menu);
		setTopMenuVisibility(true);
		setTopMenuAdapter(new CzpTopMenuAdapter(this, menuNameTop));
		setBottomMenuAdapter(new CzpBottomMenuAdapter(this, menuNameBottom));
	}

	@Override
	protected Fragment createFragment() {
		return  CzpListFragment.newInstance(null);
	}

	@Override
	public void onItemClick(int position,CzpZpBean mBean) {
		if(czpList.get(position).getCzpType() == 25){
			UItoolKit.showToastShort(getBaseContext(), "还没有热力机械操作票的模块!");
			return;
		}
		replaceFragment(CzpItemDetailFragment.newInstance(czpList.get(position).getCzpTask(), mBean),false);
		setBottomMenuVisibility(true);
	}

	@Override
	public void onTopMenuClickListener(int position) {
		switch(position){
		case 0://我的操作票
			setBottomMenuVisibility(false);
			replaceFragment(CzpListFragment.newInstance(czpList),false);
			break;
		case 1://待审操作票
			setBottomMenuVisibility(false);
			replaceFragment(CzpListFragment.newInstance(czpList),false);
			break;
		case 2://在执行操作票
			setBottomMenuVisibility(false);
			replaceFragment(CzpListFragment.newInstance(czpList),false);
			break;
		case 3://新建操作票
			setBottomMenuVisibility(false);
			replaceFragment(CzpListFragment.newInstance(czpList),false);
			break;
		}
	}

	@Override
	public void onBottomMenuClickListener(int position) {
		switch(position){
		case 0://主票
			replaceFragment(new CzpListFragment(),false);
			break;
		case 1://工作前操作票
			replaceFragment(new CzpListFragment(),false);
			break;
		case 2://工作后操作票
			replaceFragment(new CzpListFragment(),false);
			break;
		case 3://保存
			replaceFragment(new CzpListFragment(),false);
			break;
		case 4://下一步
			replaceFragment(new CzpListFragment(),false);
			break;
		case 5://返回
			replaceFragment(new CzpListFragment(),false);
			break;
		case 6://转执行
			replaceFragment(new CzpListFragment(),false);
			break;
		case 7://作废
			replaceFragment(new CzpListFragment(),false);
			break;
		case 8://终结
			replaceFragment(new CzpListFragment(),false);
			break;
		}
	}
	private class LoadDataTask extends AsyncTask<Void, Void, ArrayList<CzpBean>>{

		@Override
		protected void onPreExecute() {
			
			super.onPreExecute();
		}


		@Override
		protected ArrayList<CzpBean> doInBackground(Void... params) {
			try {
//			return CzpDataOperator.getCzpListByUserID(getBaseContext());
			return CzpDataOperator.getCzpList(getBaseContext());
			} catch (JSONException e) {
				e.printStackTrace();
				Log.i("fanjishuo____doInBackground", "catch e");
				return null;
			}
		}
		
		@Override
		protected void onPostExecute(ArrayList<CzpBean> result) {
			if(result != null){
				czpList = result;
				Fragment fragment = CzpListFragment.newInstance(czpList);
				replaceFragment(fragment,false);
			}else{
				UItoolKit.showToastShort(getBaseContext(), "连接失败或网络异常");
			}
			stopTask(this);
		}
	}
	private void startTask() {
		new LoadDataTask().execute();
	}

	private void stopTask(LoadDataTask task) {
		task.cancel(false);
	}
}
