package main.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import main.bean.PersonBean;
import main.fragment.selectperson.ListDepartmentFragment;
import main.fragment.selectperson.ListPersonFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

import com.example.aqscgkpt.R;

public class SelectPersonActivity extends SimpleFragmentActivity implements
		ListDepartmentFragment.Callbacks, ListPersonFragment.CallBacks {

	private HashMap<String, boolean[]> mSelectStatus = new HashMap<String, boolean[]>();
	private String parentID;
	private ArrayList<PersonBean> selectedList = new ArrayList<PersonBean>();

	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mSelectStatus = null;
		selectedList = null;
		parentID = null;
	}
	
	@Override
	protected int getLayoutResId() {
		return R.layout.fragment_select_person;
	}

	@Override
	protected Fragment[] createFragment() {
		Fragment[] ft = new Fragment[2];
		ft[0] = new ListDepartmentFragment();
		ft[1] = ListPersonFragment.newInstance("", "", null,"",0);
		return ft;
	}

	@Override
	protected int[] getAllFragmentId() {
		int[] id = new int[2];
		id[0] = R.id.department_fragment_container;
		id[1] = R.id.person_fragment_container;
		return id;
	}

	@Override
	public void onDepartSelect(String parentID, String name) {
		this.parentID = parentID;
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		Fragment oldF = fm.findFragmentById(R.id.person_fragment_container);
		boolean[] isSelect = null;
		if (mSelectStatus.containsKey(parentID)) {
			isSelect = mSelectStatus.get(parentID);
		}
		Fragment newF = ListPersonFragment
				.newInstance(parentID, name, isSelect,getSelectedName(selectedList),selectedList.size());
		if (oldF != null) {
			ft.remove(oldF);
		}
		ft.add(R.id.person_fragment_container, newF);
		ft.commit();
	}

	@Override
	public void onPersonSelected(int pos, boolean isSelected, int size,
			PersonBean pb) {
		Log.i("fanjishuo_____onPersonSelected", "isSelected" + isSelected
				+ "pos" + pos);
		boolean[] isSelect;
		if (!mSelectStatus.containsKey(parentID)) {
			isSelect = new boolean[size];
		} else {
			isSelect = mSelectStatus.get(parentID);
		}
		if (isSelected) {
			Log.i("fanjishuo_____onPersonSelected", "add" + pb.getName());
			selectedList.add(pb);
		} else {
			Iterator<PersonBean> it = selectedList.iterator();
			while (it.hasNext()) {
				PersonBean temp = it.next();
				if (temp.getPersonID() == pb.getPersonID())
					it.remove();
			}
		}
		FragmentManager fm = getFragmentManager();
		ListPersonFragment oldF = (ListPersonFragment) fm
				.findFragmentById(R.id.person_fragment_container);
		oldF.setNameTextView(selectedList);
		isSelect[pos] = isSelected;
		mSelectStatus.put(parentID, isSelect);
	}
	private String getSelectedName(ArrayList<PersonBean> selectPerson){
		StringBuilder sb = new StringBuilder();
		for (PersonBean pb : selectPerson) {
			sb.append(pb.getName() + "¡¢");
		}
		return sb.toString();
	}
}
