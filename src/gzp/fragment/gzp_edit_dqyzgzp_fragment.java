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
	/***** ǩ���ؼ� ********************************/
	private EditText Tb_GzpQfr; // ����Ʊǩ����
	private EditText Tb_DjQfr; // ���ǩ����
	private EditText Tb_GzpJsr; // ����Ʊ������
	private EditText Tb_Gzxkr; // ���������
	private EditText Tb_ZbFzr; // ֵ�ฺ����
	private EditText Tb_ZhiZ; // ֵ��
	private EditText Tb_XkGzXkr; // ��ɹ��������
	private EditText Tb_XkGzFzr; // ��ɹ���������

	/****** ʱ��ؼ� *****************************/
	private EditText Tb_JhKsSj; // �ƻ���ʼʱ��
	private EditText Tb_JhJsSj; // �ƻ�����ʱ��
	private EditText Tb_GzpQmSj; // ����Ʊǩ����ǩ��ʱ��
	private EditText Tb_DjQmSj; // ���ǩ��ʱ��
	private EditText Tb_GzpJsRQmSj; // ����Ʊ������ǩ��ʱ��
	private EditText Tb_PzGzJsSj; // ��׼��������ʱ��
	private EditText Tb_XkGzKsSj; // ��ɹ�����ʼʱ��
	private EditText Tb_ZjSj; // ���ǩ��ʱ��

	/****** ѡ�������Ա ****************************/
	private EditText Tb_GzbCy; // �������Ա

	/***** ������ť ********************************/
	private TextView Ib_BaoCun;
	private TextView Ib_XiaYiBu;
	private TextView Ib_TuiHui;
	private TextView Ib_Zzx;
	private TextView Ib_ZuoFei;
	private TextView Ib_ZhongJie;

	private TextView Ib_ZhuPiao;
	private TextView Ib_FuPiao;

	/***** ȫ�ֱ��� *****************************/
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
		/***** ǩ���ؼ� ********************************/
		Tb_GzpQfr = (EditText) getActivity().findViewById(R.id.Tb_GzpQfr); // ����Ʊǩ����
		Tb_DjQfr = (EditText) getActivity().findViewById(R.id.Tb_DjQfr); // ���ǩ����
		Tb_GzpJsr = (EditText) getActivity().findViewById(R.id.Tb_GzpJsr); // ����Ʊ������
		Tb_Gzxkr = (EditText) getActivity().findViewById(R.id.Tb_Gzxkr); // ���������
		Tb_ZbFzr = (EditText) getActivity().findViewById(R.id.Tb_ZbFzr); // ֵ�ฺ����
		Tb_ZhiZ = (EditText) getActivity().findViewById(R.id.Tb_ZhiZ); // ֵ��
		Tb_XkGzXkr = (EditText) getActivity().findViewById(R.id.Tb_XkGzXkr); // ��ɹ��������
		Tb_XkGzFzr = (EditText) getActivity().findViewById(R.id.Tb_XkGzFzr); // ��ɹ���������

		/****** ʱ��ؼ� *****************************/
		Tb_JhKsSj = (EditText) getActivity().findViewById(R.id.Tb_JhKsSj); // �ƻ���ʼʱ��
		Tb_JhJsSj = (EditText) getActivity().findViewById(R.id.Tb_JhJsSj); // �ƻ�����ʱ��
		Tb_GzpQmSj = (EditText) getActivity().findViewById(R.id.Tb_GzpQmSj); // ����Ʊǩ����ǩ��ʱ��
		Tb_DjQmSj = (EditText) getActivity().findViewById(R.id.Tb_DjQmSj); // ���ǩ��ʱ��
		Tb_GzpJsRQmSj = (EditText) getActivity().findViewById(
				R.id.Tb_GzpJsRQmSj); // ����Ʊ������ǩ��ʱ��
		Tb_PzGzJsSj = (EditText) getActivity().findViewById(R.id.Tb_PzGzJsSj); // ��׼��������ʱ��
		Tb_XkGzKsSj = (EditText) getActivity().findViewById(R.id.Tb_XkGzKsSj); // ��ɹ�����ʼʱ��
		Tb_ZjSj = (EditText) getActivity().findViewById(R.id.Tb_ZjSj); // ���ǩ��ʱ��

		/****** ѡ�������Ա ****************************/
		Tb_GzbCy = (EditText) getActivity().findViewById(R.id.Tb_GzbCy); // �������Ա

		/***** ������ť ********************************/
		Ib_BaoCun = (TextView) getActivity().findViewById(R.id.Ib_BaoCun);
		Ib_XiaYiBu = (TextView) getActivity().findViewById(R.id.Ib_XiaYiBu);
		Ib_TuiHui = (TextView) getActivity().findViewById(R.id.Ib_TuiHui);
		Ib_Zzx = (TextView) getActivity().findViewById(R.id.Ib_Zzx);
		Ib_ZuoFei = (TextView) getActivity().findViewById(R.id.Ib_ZuoFei);
		Ib_ZhongJie = (TextView) getActivity().findViewById(R.id.Ib_ZhongJie);

		Ib_ZhuPiao = (TextView) getActivity().findViewById(R.id.Ib_ZhuPiao);
		Ib_FuPiao = (TextView) getActivity().findViewById(R.id.Ib_FuPiao);

		/***** ����Ʊ���� ***********************************/
		Ll_gzpMain = (ScrollView) getActivity().findViewById(R.id.Ll_gzpMain);
		Ll_gzpSub = (ScrollView) getActivity().findViewById(R.id.Ll_gzpSub);

	}

	private void setControlDisabled() {
		/***** ǩ���ؼ� ********************************/
		Tb_GzpQfr.setFocusable(false); // ����Ʊǩ����
		Tb_DjQfr.setFocusable(false); // ���ǩ����
		Tb_GzpJsr.setFocusable(false); // ����Ʊ������
		Tb_Gzxkr.setFocusable(false); // ���������
		Tb_ZbFzr.setFocusable(false); // ֵ�ฺ����
		Tb_ZhiZ.setFocusable(false); // ֵ��
		Tb_XkGzXkr.setFocusable(false); // ��ɹ��������
		Tb_XkGzFzr.setFocusable(false); // ��ɹ���������

		/****** ʱ��ؼ� *****************************/
		Tb_JhKsSj.setFocusable(false); // �ƻ���ʼʱ��
		Tb_JhJsSj.setFocusable(false); // �ƻ�����ʱ��
		Tb_GzpQmSj.setFocusable(false); // ����Ʊǩ����ǩ��ʱ��
		Tb_DjQmSj.setFocusable(false); // ���ǩ��ʱ��
		Tb_GzpJsRQmSj.setFocusable(false); // ����Ʊ������ǩ��ʱ��
		Tb_PzGzJsSj.setFocusable(false); // ��׼��������ʱ��
		Tb_XkGzKsSj.setFocusable(false); // ��ɹ�����ʼʱ��
		Tb_ZjSj.setFocusable(false); // ���ǩ��ʱ��

		/***** ����Ʊ���� ***********************************/
		Ll_gzpSub.setVisibility(View.GONE);
		Ib_ZhuPiao.setVisibility(View.GONE);

	}

	public void setControlText() throws JSONException {
		/*** ��ȡ���������� ************************/
		// 1����ʼ������
		JSONObject param = new JSONObject();
		param.put("GZPID", "2");

		m_Gzp = new Gzp();
		// 2����ȡ����
		JSONObject gzpJsonObject = m_Gzp.GetGzpAllByGzpId(getActivity(),
				param.toString());
		JSONArray gzpSubJsonArray = gzpJsonObject.getJSONArray("GZPSUB");

		// ѭ����ֵ
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

	// ͨ�������ÿؼ�
	public int getResourceId(String source) throws NoSuchFieldException,
			NumberFormatException, IllegalAccessException,
			IllegalArgumentException {
		Field field = R.id.class.getField(source);

		return Integer.parseInt(field.get(null).toString());
	}

	private void setControlEvent() {
		/***** ǩ���ؼ� ********************************/
		Tb_GzpQfr.setOnClickListener(new showSignYhmcFragmentDialog()); // ����Ʊǩ����
		Tb_DjQfr.setOnClickListener(new showSignYhmcFragmentDialog()); // ���ǩ����
		Tb_GzpJsr.setOnClickListener(new showSignYhmcFragmentDialog()); // ����Ʊ������
		Tb_Gzxkr.setOnClickListener(new showSignYhmcFragmentDialog()); // ���������
		Tb_ZbFzr.setOnClickListener(new showSignYhmcFragmentDialog()); // ֵ�ฺ����
		Tb_ZhiZ.setOnClickListener(new showSignYhmcFragmentDialog()); // ֵ��
		Tb_XkGzXkr.setOnClickListener(new showSignYhmcFragmentDialog()); // ��ɹ��������
		Tb_XkGzFzr.setOnClickListener(new showSignYhmcFragmentDialog()); // ��ɹ���������

		/****** ʱ��ؼ� *****************************/
		Tb_JhKsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // �ƻ���ʼʱ��
		Tb_JhJsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // �ƻ�����ʱ��
		Tb_GzpQmSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // ����Ʊǩ����ǩ��ʱ��
		Tb_DjQmSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // ���ǩ��ʱ��
		Tb_GzpJsRQmSj
				.setOnClickListener(new showDateTimePickerFragmentDialog()); // ����Ʊ������ǩ��ʱ��
		Tb_PzGzJsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // ��׼��������ʱ��
		Tb_XkGzKsSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // ��ɹ�����ʼʱ��
		Tb_ZjSj.setOnClickListener(new showDateTimePickerFragmentDialog()); // ���ǩ��ʱ��

		/****** ѡ�������Ա ****************************/
		Tb_GzbCy.setOnClickListener(new showSelectBzcyFragmentDialog()); // �������Ա

		/***** ������ť ********************************/
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
