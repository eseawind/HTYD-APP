package czp.bean;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class CzpBean implements Parcelable {

	/* 操作票ID */
	private int czpID;
	/* 操作票状态 */
	private String czpState;
	/* 操作票类型 */
	private int czpType;
	/* 操作票开票时间 */
	private String czpCreateTime;
	/* 操作票终结时间 */
	private String czpDieTime;
	/* 操作票任务 */
	private String czpTask;
	/* 操作人姓名 */
	private String czrName;
	/* 主票上要显示的内容bean */
	private CzpZpBean czpZpBean;

	/*
	 * 部门 private String depart; 监护人姓名 private String guardName; 机组长姓名 private
	 * String leaderName; 值长姓名 private String dutyName; 操作票编号 private String
	 * czpNum;
	 */

	public CzpBean() {
		super();
	}

	public CzpBean(JSONObject json) throws JSONException {
		czpID = json.getInt("CZPID");
		czpState = json.getString("PAOZT");
		czpCreateTime = json.getString("KPSJ");
		czpDieTime = json.getString("PZJSJ");
		czpTask = json.getString("CZRW");
		czrName = json.getString("CZRY");
		czpType = json.getInt("PLXID");
		czpZpBean = new CzpZpBean();
		/*
		 * depart = json.getString("CZRBM"); czpNum = json.getString("PAOH");
		 * guardName = json.getString("JHRY"); leaderName =
		 * json.getString("ZBFZRRY"); dutyName = json.getString("ZZRY");
		 */
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(czpID);
		dest.writeString(czpState);
		dest.writeString(czpCreateTime);
		dest.writeString(czpDieTime);
		dest.writeString(czpTask);
		dest.writeString(czrName);
		dest.writeInt(czpType);
		dest.writeParcelable(czpZpBean, 0);
		/*
		 * dest.writeString(depart); dest.writeString(czpNum);
		 * dest.writeString(guardName); dest.writeString(leaderName);
		 * dest.writeString(dutyName);
		 */
	}

	public static final Parcelable.Creator<CzpBean> CREATOR = new Creator<CzpBean>() {

		@Override
		public CzpBean[] newArray(int size) {
			return new CzpBean[size];
		}

		@Override
		public CzpBean createFromParcel(Parcel source) {
			CzpBean mBean = new CzpBean();
			mBean.czpID = source.readInt();
			mBean.czpState = source.readString();
			mBean.czpCreateTime = source.readString();
			mBean.czpDieTime = source.readString();
			mBean.czpTask = source.readString();
			mBean.czrName = source.readString();
			mBean.czpID = source.readInt();
			mBean.czpZpBean = source.readParcelable(null);
			// source.readParcelable();
			/*
			 * mBean.depart = source.readString(); mBean.czpNum =
			 * source.readString(); mBean.guardName = source.readString();
			 * mBean.leaderName = source.readString(); mBean.dutyName =
			 * source.readString();
			 */
			return mBean;
		}
	};

	public int getCzpID() {
		return czpID;
	}

	public void setCzpID(int czpID) {
		this.czpID = czpID;
	}

	public String getCzpState() {
		return czpState;
	}

	public void setCzpState(String czpState) {
		this.czpState = czpState;
	}

	public String getCzpStartTime() {
		return czpCreateTime;
	}

	public void setCzpStartTime(String czpCreateTime) {
		this.czpCreateTime = czpCreateTime;
	}

	public String getCzpEndTime() {
		return czpDieTime;
	}

	public void setCzpEndTime(String czpDieTime) {
		this.czpDieTime = czpDieTime;
	}

	public String getCzpTask() {
		return czpTask;
	}

	public void setCzpTask(String czpTask) {
		this.czpTask = czpTask;
	}

	public String getCzrName() {
		return czrName;
	}

	public void setCzrName(String czrName) {
		this.czrName = czrName;
	}

	public CzpZpBean getCzpZpBean() {
		return czpZpBean;
	}

	public void setCzpZpBean(CzpZpBean czpZpBean) {
		this.czpZpBean = czpZpBean;
	}

	public int getCzpType() {
		return czpType;
	}

	public void setCzpType(int czpType) {
		this.czpType = czpType;
	}
	/*
	 * public String getGuardName() { return guardName; }
	 * 
	 * public void setGuardName(String guardName) { this.guardName = guardName;
	 * }
	 * 
	 * public String getLeaderName() { return leaderName; }
	 * 
	 * public void setLeaderName(String leaderName) { this.leaderName =
	 * leaderName; }
	 * 
	 * public String getDutyName() { return dutyName; }
	 * 
	 * public void setDutyName(String dutyName) { this.dutyName = dutyName; }
	 * public String getCzpNum() { return czpNum; } public String getDepart() {
	 * return depart; }
	 * 
	 * public void setDepart(String depart) { this.depart = depart; }
	 * 
	 * public void setCzpNum(String czpNum) { this.czpNum = czpNum; }
	 */
}
