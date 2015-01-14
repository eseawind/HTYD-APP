package main.activity;

import main.ui.CenterLockHorizontalScrollview;
import main.ui.SizeCallBackForMenu;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aqscgkpt.R;

import czp.CzpActivity;

public abstract class SimpleActivityWithMenu extends Activity {


	protected abstract Fragment createFragment();

	private Context context;
	private MenuHorizontalScrollView scrollView;
	private View mainView;
	private TextView titleText;
	private LinearLayout bottomMenu;
	private CenterLockHorizontalScrollview mTopHorizontalScrollview;
	private CenterLockHorizontalScrollview mBottomHorizontalScrollview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		setContentView(R.layout.base_activity_with_menu);
		init();
		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.main_fragment_container);
		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction().add(R.id.main_fragment_container, fragment)
					.commit();
		}
	}

	public void setTitle(String title) {
		titleText.setText(title);
	}

	@SuppressLint("CommitTransaction")
	public void replaceFragment(Fragment newFragment,boolean isAddToStack) {
		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.main_fragment_container);
		FragmentTransaction ft = fm.beginTransaction();
		if (fragment != null) {
			ft.remove(fragment);
			ft.replace(R.id.main_fragment_container, newFragment);
			ft.commit();
		}
	}

	public void setTopMenuVisibility(boolean isVisable) {
		if (isVisable) {
			mTopHorizontalScrollview.setVisibility(View.VISIBLE);
		} else {
			mTopHorizontalScrollview.setVisibility(View.GONE);
		}
	}

	public void setTopMenuAdapter(BaseAdapter adapter) {
		mTopHorizontalScrollview.setAdapter(context, adapter);
	}

	public void setBottomMenuVisibility(boolean isVisable) {
		if (isVisable) {
			bottomMenu.setVisibility(View.VISIBLE);
			Log.i("fanjishuo____setBottomMenuVisibility", isVisable+"");
		} else {
			bottomMenu.setVisibility(View.GONE);
		}
	}

	public void setBottomMenuAdapter(BaseAdapter adapter) {
		mBottomHorizontalScrollview.setAdapter(context, adapter);
	}

	@SuppressLint("InflateParams")
	private void init() {
		LayoutInflater inflater = LayoutInflater.from(this);
		scrollView = (MenuHorizontalScrollView) findViewById(R.id.scrollView);
		mainView = inflater.inflate(R.layout.base_fragment_activity, null);
		ListView menuList = (ListView) findViewById(R.id.list_main_menu);
		titleText = (TextView) mainView.findViewById(R.id.tv_title_text);
		LinearLayout menuLayout = (LinearLayout) findViewById(R.id.linear_main_menu);
		mTopHorizontalScrollview = (CenterLockHorizontalScrollview) mainView
				.findViewById(R.id.top_scroll_menu);
		mBottomHorizontalScrollview = (CenterLockHorizontalScrollview) mainView
				.findViewById(R.id.bottom_scroll_menu);
		bottomMenu = (LinearLayout) mainView.findViewById(R.id.linea_bottom_menu);
		
		
		menuList.setAdapter(new MenuListAdapter());

		ImageView menuButton = (ImageView) mainView
				.findViewById(R.id.img_menu_out);

		View leftView = new View(this);

		View[] children = new View[] { leftView, mainView };
		menuButton.setOnClickListener(new MenuButtonClickListener());
		menuList.setOnItemClickListener(new MenuItemClickListener());
		scrollView.initViews(children, new SizeCallBackForMenu(menuButton),
				menuLayout);
		scrollView.setMenuBtn(menuButton);
		setBottomMenuVisibility(false);
		setTopMenuVisibility(false);
	}

	private class MenuItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			switch (position) {
			case 0:
				scrollView.clickMenuBtn();
				Intent in = new Intent(SimpleActivityWithMenu.this,SelectPersonActivity.class);
				startActivity(in);
				break;
			case 1:
				scrollView.clickMenuBtn();
				break;
			case 2:
				scrollView.clickMenuBtn();
				break;
			case 3:
				scrollView.clickMenuBtn();
				Intent i = new Intent(context, CzpActivity.class);
				startActivity(i);
				finish();
				break;
			case 4:
				scrollView.clickMenuBtn();
				break;
			case 5:
				scrollView.clickMenuBtn();
				break;
			case 6:
				scrollView.clickMenuBtn();
				break;
			case 7:
				scrollView.clickMenuBtn();
				break;
			}
		}
	}

	private class MenuButtonClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.img_menu_out:
				scrollView.clickMenuBtn();
			}
		}
	}

	private class MenuListAdapter extends BaseAdapter {

		private String[] menuTitle;
		private int[] menuImgId;

		public MenuListAdapter() {
			super();
			menuTitle = getResources().getStringArray(R.array.meun_title);
			menuImgId = getResources().getIntArray(R.array.meun_picture_id);
		}

		@Override
		public int getCount() {
			return menuTitle.length;
		}

		@Override
		public Object getItem(int position) {
			return menuTitle[position];
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
				convertView = getLayoutInflater().inflate(
						R.layout.main_menu_item_layout, null);
				mHolder = new ViewHolder(convertView);
				convertView.setTag(mHolder);
			} else {
				mHolder = (ViewHolder) convertView.getTag();
			}
			mHolder.setMenuTitle(menuTitle[position]);
			mHolder.setMenuImg(menuImgId[position]);
			return convertView;
		}

		private class ViewHolder {
			private TextView mTextView;

			public ViewHolder(View v) {
				mTextView = (TextView) v.findViewById(R.id.tv_menu_item);
			}

			public void setMenuTitle(String title) {
				mTextView.setText(title);
			}

			public void setMenuImg(int id) {
				Drawable drawable = getResources().getDrawable(id);
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());
				mTextView.setCompoundDrawables(drawable, null, null, null);
			}
		}
	}
}
