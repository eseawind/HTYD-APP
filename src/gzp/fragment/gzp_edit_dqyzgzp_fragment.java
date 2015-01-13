package gzp.fragment;

import gzp.impl.Gzp;

import java.lang.reflect.Field;

import main.activity.SelectPersonActivity;
import main.dialog.DateTimePicker_fragment_dialog;
import main.dialog.sign_yhmc_fragment_dialog;
import main.dialog.workflow_back_fragment_dialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.aqscgkpt.R;

@SuppressLint("NewApi")
public class gzp_edit_dqyzgzp_fragment extends Fragment {
	/***** 签名控件 ********************************/
	private EditText Tb_GzpQfr; // 工作票签发人
	private EditText Tb_DjQfr; // 点检签发人
	private EditText Tb_GzpJsr; // 工作票接收人
	private EditText Tb_Gzxkr; // 工作许可人
	private EditText Tb_ZbFzr; // 值班负责人
	private EditText Tb_ZhiZ; // 值长
	private EditText Tb_XkGzXkr; // 许可工作许可人
	private EditText Tb_XkGzFzr; // 许可工作负责人

	/****** 时间控件 *****************************/
	private EditText Tb_JhKsSj; // 计划开始时间
	private EditText Tb_JhJsSj; // 计划结束时间
	private EditText Tb_GzpQmSj; // 工作票签发人签名时间
	private EditText Tb_DjQmSj; // 点检签名时间
	private EditText Tb_GzpJsRQmSj; // 工作票接收人签名时间
	private EditText Tb_PzGzJsSj; // 批准工作结束时间
	private EditText Tb_XkGzKsSj; // 许可工作开始时间
	private EditText Tb_ZjSj; // 点检签名时间

	/****** 选择工作班成员 ****************************/
	private EditText Tb_GzbCy; // 工作班成员

	/***** 操作按钮 ********************************/
	private TextView Ib_BaoCun;
	private TextView Ib_XiaYiBu;
	private TextView Ib_TuiHui;
	private TextView Ib_Zzx;
	private TextView Ib_ZuoFei;
	private TextView Ib_ZhongJie;

	private TextView Ib_ZhuPiao;
	private TextView Ib_FuPiao;

	/***** 全局变量 *****************************/
	private Gzp m_Gzp;

	private ScrollView Ll_gzpMain;
	private ScrollView Ll_gzpSub;

	/**************************************************/

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.gzp_edit_dqyzgzp_fragment,
				container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

//		try {
			getControl();
			setControlDisabled();
//			setControlText();
			setControlEvent();

/*		} catch (JSONException e) {
			e.printStackTrace();
		}*/
	}

	private void getControl() {
		/***** 签名控件 ********************************/
		Tb_GzpQfr = (EditText) getActivity().findViewById(R.id.Tb_GzpQfr); // 工作票签发人
		Tb_DjQfr = (EditText) getActivity().findViewById(R.id.Tb_DjQfr); // 点检签发人
		Tb_GzpJsr = (EditText) getActivity().findViewById(R.id.Tb_GzpJsr); // 工作票接收人
		Tb_Gzxkr = (EditText) getActivity().findViewById(R.id.Tb_Gzxkr); // 工作许可人
		Tb_ZbFzr = (EditText) getActivity().findViewById(R.id.Tb_ZbFzr); // 值班负责人
		Tb_ZhiZ = (EditText) getActivity().findViewById(R.id.Tb_ZhiZ); // 值长
		Tb_XkGzXkr = (EditText) getActivity().findViewById(R.id.Tb_XkGzXkr); // 许可工作许可人
		Tb_XkGzFzr = (EditText) getActivity().findViewById(R.id.Tb_XkGzFzr); // 许可工作负责人

		/****** 时间控件 *****************************/
		Tb_JhKsSj = (EditText) getActivity().findViewById(R.id.Tb_JhKsSj); // 计划开始时间
		Tb_JhJsSj = (EditText) getActivity().findViewById(R.id.Tb_JhJsSj); // 计划结束时间
		Tb_GzpQmSj = (EditText) getActivity().findViewById(R.id.Tb_GzpQmSj); // 工作票签发人签名时间
		Tb_DjQmSj = (EditText) getActivity().findViewById(R.id.Tb_DjQmSj); // 点检签名时间
		Tb_GzpJsRQmSj = (EditText) getActivity().findViewById(
				R.id.Tb_GzpJsRQmSj); // 工作票接收人签名时间
		Tb_PzGzJsSj = (EditText) getActivity().findViewById(R.id.Tb_PzGzJsSj); // 批准工作结束时间
		Tb_XkGzKsSj = (EditText) getActivity().findViewById(R.id.Tb_XkGzKsSj); // 许可工作开始时间
		Tb_ZjSj = (EditText) getActivity().findViewById(R.id.Tb_ZjSj); // 点检签名时间

		/****** 选择工作班成员 ****************************/
		Tb_GzbCy = (EditText) getActivity().findViewById(R.id.Tb_GzbCy); // 工作班成员

		/***** 操作按钮 ********************************/
		Ib_BaoCun = (TextView) getActivity().findViewById(R.id.Ib_BaoCun);
		Ib_XiaYiBu = (TextView) getActivity().findViewById(R.id.Ib_XiaYiBu);
		Ib_TuiHui = (TextView) getActivity().findViewById(R.id.Ib_TuiHui);
		Ib_Zzx = (TextView) getActivity().findViewById(R.id.Ib_Zzx);
		Ib_ZuoFei = (TextView) getActivity().findViewById(R.id.Ib_ZuoFei);
		Ib_ZhongJie = (TextView) getActivity().findViewById(R.id.Ib_ZhongJie);

		Ib_ZhuPiao = (TextView) getActivity().findViewById(R.id.Ib_ZhuPiao);
		Ib_FuPiao = (TextView) getActivity().findViewById(R.id.Ib_FuPiao);

		/***** 主附票布局 ***********************************/
		Ll_gzpMain = (ScrollView) getActivity().findViewById(R.id.Ll_gzpMain);
		Ll_gzpSub = (ScrollView) getActivity().findViewById(R.id.Ll_gzpSub);

	}

	private void setControlDisabled() {
		/***** 签名控件 ********************************/
		Tb_GzpQfr.setFocusable(false); // 工作票签发人
		Tb_DjQfr.setFocusable(false); // 点检签发人
		Tb_GzpJsr.setFocusable(false); // 工作票接收人
		Tb_Gzxkr.setFocusable(false); // 工作许可人
		Tb_ZbFzr.setFocusable(false); // 值班负责人
		Tb_ZhiZ.setFocusable(false); // 值长
		Tb_XkGzXkr.setFocusable(false); // 许可工作许可人
		Tb_XkGzFzr.setFocusable(false); // 许可工作负责人

		/****** 时间控件 *****************************/
		Tb_JhKsSj.setFocusable(false); // 计划开始时间
		Tb_JhJsSj.setFocusable(false); // 计划结束时间
		Tb_GzpQmSj.setFocusable(false); // 工作票签发人签名时间
		Tb_DjQmSj.setFocusable(false); // 点检签名时间
		Tb_GzpJsRQmSj.setFocusable(false); // 工作票接收人签名时间
		Tb_PzGzJsSj.setFocusable(false); // 批准工作结束时间
		Tb_XkGzKsSj.setFocusable(false); // 许可工作开始时间
		Tb_ZjSj.setFocusable(false); // 点检签名时间

		/***** 主附票布局 ***********************************/
		Ll_gzpSub.setVisibility(View.GONE);
		Ib_ZhuPiao.setVisibility(View.GONE);

	}

	public void setControlText() throws JSONException {
		/*** 获取服务器数据 ************************/
		// 1、初始化参数
		JSONObject param = new JSONObject();
		param.put("GZPID", "2");

		m_Gzp = new Gzp();
		// 2、获取数据
		JSONObject gzpJsonObject = m_Gzp.GetGzpAllByGzpId(getActivity(),
				param.toString());
		JSONArray gzpSubJsonArray = gzpJsonObject.getJSONArray("GZPSUB");

		// 循环赋值
		int length = gzpSubJsonArray.length();
		String kjid, kjnr;
		for (int i = 0; i < length; i++) {
			kjid = gzpSubJsonArray.getJSONObject(i).getString("KJID");
			kjnr = gzpSubJsonArray.getJSONObject(i).getString("KJNR");
			try {
				if (null != ((EditText) getActivity().findViewById(
						getResourceId(kjid)))) {
					if ((kjnr != "null") && (kjnr != "-1")) {
						((EditText) getActivity().findViewById(
								getResourceId(kjid))).setText(kjnr);
					} else {
						((EditText) getActivity().findViewById(
								getResourceId(kjid))).setText("");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 通过反射获得控件
	public int getResourceId(String source) throws NoSuchFieldException,
			NumberFormatException, IllegalAccessException,
			IllegalArgumentException {
		Field field = R.id.class.getField(source);

		return Integer.parseInt(field.get(null).toString());
	}

	private void setControlEvent() {
		/***** 签名控件 ********************************/
		Tb_GzpQfr.setOnClickListener(new showSignYhmcFragmentDialog()); // 工作票签发人
		Tb_DjQfr.setOnClickListener(new showSignYhmcFragmentDialog()); // 点检签发人
		Tb_GzpJsr.setOnClickListener(new showSignYhmcFragmentDialog()); // 工作票接收人
		Tb_Gzxkr.setOnClickListener(new showSignYhmcFragmentDialog()); // 工作许可人
		Tb_ZbFzr.setOnClickListener(new showSignYhmcFragmentDialog()); // 值班负责人
		Tb_ZhiZ.setOnClickListener(new showSignYhmcFragmentDialog()); // 值长
		Tb_XkGzXkr.setOnClickListener(new showSignYhmcFragmentDialog()); // 许可工作许可人
		Tb_XkGzFzr.setOnClickListener(new showSignYhmcFragmentDialog()); // 许可工作负责人

		/****** 时间控件 *****************************/
		Tb_JhKsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // 计划开始时间
		Tb_JhJsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // 计划结束时间
		Tb_GzpQmSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // 工作票签发人签名时间
		Tb_DjQmSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // 点检签名时间
		Tb_GzpJsRQmSj
				.setOnClickListener(new showDateTimePickerFragmentDialog()); // 工作票接收人签名时间
		Tb_PzGzJsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // 批准工作结束时间
		Tb_XkGzKsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // 许可工作开始时间
		Tb_ZjSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // 点检签名时间

		/****** 选择工作班成员 ****************************/
		Tb_GzbCy.setOnClickListener(new showSelectBzcyFragmentDialog()); // 工作班成员

		/***** 操作按钮 ********************************/
		Ib_BaoCun.setOnClickListener(new Ib_Buton());
		Ib_XiaYiBu.setOnClickListener(new Ib_Buton());
		Ib_TuiHui.setOnClickListener(new Ib_Buton());
		Ib_Zzx.setOnClickListener(new Ib_Buton());
		Ib_ZuoFei.setOnClickListener(new Ib_Buton());
		Ib_ZhongJie.setOnClickListener(new Ib_Buton());

		Ib_ZhuPiao.setOnClickListener(new Ib_Buton());
		Ib_FuPiao.setOnClickListener(new Ib_Buton());

	}

	public class showSignYhmcFragmentDialog implements OnClickListener {
		@Override
		public void onClick(View v) {
			sign_yhmc_fragment_dialog signDialog = new sign_yhmc_fragment_dialog();
			signDialog.setEt((EditText) v);
			signDialog.show(getFragmentManager(), "dialog");
		}
	}

	public class showDateTimePickerFragmentDialog implements OnClickListener {
		@Override
		public void onClick(View v) {
			DateTimePicker_fragment_dialog DateTimeDialog = new DateTimePicker_fragment_dialog();
			DateTimeDialog.setEdt((EditText) v);
			DateTimeDialog.show(getFragmentManager(), "dialog");
		}
	}

	public class showSelectBzcyFragmentDialog implements OnClickListener {
		@Override
		public void onClick(View v) {
			sign_yhmc_fragment_dialog signDialog = new sign_yhmc_fragment_dialog();
			signDialog.setEt((EditText) v);
			signDialog.show(getFragmentManager(), "dialog");
		}
	}

	public class Ib_Buton implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.Ib_BaoCun:
				onClick_BaoCun();
				break;
			case R.id.Ib_XiaYiBu:
				onClick_XiaYiBu(v);
				break;
			case R.id.Ib_TuiHui:
				onClick_TuiHui(v);
				break;
			case R.id.Ib_Zzx:
				onClick_Zzx();
				break;
			case R.id.Ib_ZuoFei:
				onClick_ZuoFei();
				break;
			case R.id.Ib_ZhongJie:
				onClick_ZhongJie();
				break;
			case R.id.Ib_ZhuPiao:
				onClick_ZhuPiao();
				break;
			case R.id.Ib_FuPiao:
				onClick_FuPiao();
				break;

			default:
				break;
			}
		}
	}

	public void onClick_BaoCun() {

	}

	public void onClick_XiaYiBu(View v) {
		/*
		 * workflow_send_fragment_dialog sendDialog = new
		 * workflow_send_fragment_dialog();
		 * sendDialog.show(getFragmentManager(), "dialog");
		 */
		Intent i = new Intent(getActivity(), SelectPersonActivity.class);
		startActivity(i);
	}

	public void onClick_TuiHui(View v) {
		workflow_back_fragment_dialog backDialog = new workflow_back_fragment_dialog();
		backDialog.show(getFragmentManager(), "dialog");
	}

	public void onClick_Zzx() {

	}

	public void onClick_ZuoFei() {

	}

	public void onClick_ZhongJie() {

	}

	public void onClick_ZhuPiao() {
		Ll_gzpMain.setVisibility(View.VISIBLE);
		Ib_FuPiao.setVisibility(View.VISIBLE);

		Ll_gzpSub.setVisibility(View.GONE);
		Ib_ZhuPiao.setVisibility(View.GONE);
	}

	public void onClick_FuPiao() {
		Ll_gzpSub.setVisibility(View.VISIBLE);
		Ib_ZhuPiao.setVisibility(View.VISIBLE);

		Ll_gzpMain.setVisibility(View.GONE);
		Ib_FuPiao.setVisibility(View.GONE);
	}

	public boolean gzpBaoCun() {
		return true;
	}
}
