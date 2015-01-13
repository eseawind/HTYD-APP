package util.config;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Dlyh extends Fragment {
	private static SharedPreferences sharedPreferences;
	private static Editor editor;
	// ��¼�˺�
	public static final String STR_DLZH = "Dlzh";
	// �û�����
	public static final String STR_DLMM = "Dlmm";
	// �û�����
	public static final String STR_YHMC = "Yhmc";
	// �û�����ID
	public static final String STR_BMID = "Yhmc";
	// �û���������
	public static final String STR_BMMC = "Yhmc";
	// �û���ɫID
	public static final String STR_JSID = "Yhmc";
	// �û���ɫ����
	public static final String STR_JSMC = "Yhmc";
	// ��¼�û�ID
	public static final String STR_YHID = "Yhid";
	// �Զ���xml������
	public static final String XML_NAME = "Dlyh";

	public static void setDlyh(Context context, String key, String keyValue) {
		// �������ȡһ���Ѿ����ڵ�sharedPreferences���󣨵����ģ�
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);
		// �������ݱ༭��
		editor = sharedPreferences.edit();
		// ������Ҫ���������
		editor.putString(key, keyValue);
		// ��������
		editor.commit();
	}

	public static String getDlzh(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_DLZH, "");
	}

	public static String getYhmc(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_YHMC, "");
	}

	public static String getDlmm(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_DLMM, "");
	}

	public static String getBmid(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_BMID, "");
	}

	public static String getBmmc(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_YHID, "");
	}

	public static String getJsid(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_JSID, "");
	}

	public static String getJsmc(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_JSMC, "");
	}

	public static String getYhId(Context context){
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		return sharedPreferences.getString(STR_JSMC, "");
	}
	
	public static boolean isLogin(Context context) {
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);

		if ("".equals(sharedPreferences.getString(STR_DLMM, ""))) {
			return false;
		} else {
			return true;
		}
	}

	public static SharedPreferences getSharedPreferences() {
		return sharedPreferences;
	}

}
