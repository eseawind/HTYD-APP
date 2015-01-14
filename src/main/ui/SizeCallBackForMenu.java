package main.ui;

import util.values.Variable;
import android.widget.ImageView;

public class SizeCallBackForMenu implements SizeCallBackInterface {
	private ImageView m_menuLeft;
	private int m_menuWidth;

	public SizeCallBackForMenu(ImageView menu) {

		super();
		this.m_menuLeft = menu;
	}

	public void onGlobalLayout() {
		/*** 根据手机精度设置显示menu主界面的右边布局宽度 **/

		if (Variable.densityDpi >= 320) {
			this.m_menuWidth = this.m_menuLeft.getMeasuredWidth() + 420;
		} else if (Variable.densityDpi >= 240 && Variable.densityDpi < 320) {
			this.m_menuWidth = this.m_menuLeft.getMeasuredWidth() + 180;
		} else if (240 > Variable.densityDpi && Variable.densityDpi >= 180) {
			this.m_menuWidth = this.m_menuLeft.getMeasuredWidth() + 420;
		} else if (Variable.densityDpi < 180 && Variable.densityDpi > 120) {
			this.m_menuWidth = this.m_menuLeft.getMeasuredWidth() + 100;
		} else if (Variable.densityDpi <= 120) {
			this.m_menuWidth = this.m_menuLeft.getMeasuredWidth() + 60;
		}

	}

	public void getViewSize(int idx, int width, int height, int[] dims) {
		dims[0] = width;
		dims[1] = height;
		if (idx != 1) {
			dims[0] = width - this.m_menuWidth;
		}
	}

}
