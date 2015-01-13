package czp.bean;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class CzpCzxBean implements Parcelable {

	/* 操作项序号 */
	private int czxID;
	/* 模拟 */
	private String czxSimulation;
	/* 实际 */
	private String czxActual;
	/* 序号 */
	private String arrayNum;
	/* 操作项目 */
	private String czxWork;
	/* 时间 */
	private String time;

	public CzpCzxBean() {
	}

	public CzpCzxBean(JSONObject json) throws JSONException {
		czxID = json.getInt("CZXNUM");
		czxSimulation = json.getString("MONI");
		czxActual = json.getString("SHIJI");
		arrayNum = json.getString("XUHAO");
		czxWork = json.getString("CZXM");
		time = json.getString("SHIJIAN");
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(czxID);
		dest.writeString(czxSimulation);
		dest.writeString(czxActual);
		dest.writeString(arrayNum);
		dest.writeString(czxWork);
		dest.writeString(time);
	}

	public static final Parcelable.Creator<CzpCzxBean> CREATOR = new Creator<CzpCzxBean>() {

		@Override
		public CzpCzxBean createFromParcel(Parcel source) {
			CzpCzxBean mBean = new CzpCzxBean();
			mBean.czxID = source.readInt();
			mBean.czxSimulation = source.readString();
			mBean.czxActual = source.readString();
			mBean.arrayNum = source.readString();
			mBean.czxWork = source.readString();
			mBean.time = source.readString();
			return mBean;
		}

		@Override
		public CzpCzxBean[] newArray(int size) {
			return new CzpCzxBean[size];
		}
	};

	public int getCzxID() {
		return czxID;
	}

	public void setCzxID(int czxID) {
		this.czxID = czxID;
	}

	public String getCzxSimulation() {
		return czxSimulation;
	}

	public void setCzxSimulation(String czxSimulation) {
		this.czxSimulation = czxSimulation;
	}

	public String getCzxActual() {
		return czxActual;
	}

	public void setCzxActual(String czxActual) {
		this.czxActual = czxActual;
	}

	public String getArrayNum() {
		return arrayNum;
	}

	public void setArrayNum(String arrayNum) {
		this.arrayNum = arrayNum;
	}

	public String getCzxWork() {
		return czxWork;
	}

	public void setCzxWork(String czxWork) {
		this.czxWork = czxWork;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
