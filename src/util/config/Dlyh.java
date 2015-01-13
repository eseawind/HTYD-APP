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
	// 登录账号
	public static final String STR_DLZH = "Dlzh";
	// 用户密码
	public static final String STR_DLMM = "Dlmm";
	// 用户姓名
	public static final String STR_YHMC = "Yhmc";
	// 用户部门ID
	public static final String STR_BMID = "Yhmc";
	// 用户部门名称
	public static final String STR_BMMC = "Yhmc";
	// 用户角色ID
	public static final String STR_JSID = "Yhmc";
	// 用户角色名称
	public static final String STR_JSMC = "Yhmc";
	// 登录用户ID
	public static final String STR_YHID = "Yhid";
	// 自定义xml的名字
	public static final String XML_NAME = "Dlyh";

	public static void setDlyh(Context context, String key, String keyValue) {
		// 创建类获取一个已经存在的sharedPreferences对象（单例的）
		sharedPreferences = context.getSharedPreferences(XML_NAME,
				Context.MODE_PRIVATE);
		// 创建数据编辑器
		editor = sharedPreferences.edit();
		// 传递需要保存的数据
		editor.putString(key, keyValue);
		// 保存数据
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
