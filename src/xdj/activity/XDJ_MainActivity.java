package xdj.activity;

import xdj.fragment.XDJ_MainFragment;
import android.app.Fragment;
import main.activity.SimpleActivityWithMenu;

public class XDJ_MainActivity extends SimpleActivityWithMenu {
	@Override
	protected Fragment createFragment() {
		setTitle("巡点检系统");
		return new XDJ_MainFragment();
	}

}
