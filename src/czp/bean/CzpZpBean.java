package czp.bean;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class CzpZpBean implements Parcelable {

	/* ���� */
	private String depart;
	/* Ʊ�� */
	private String czpNum;
	/* ������ʼʱ�� */
	private String startTime;
	/* ��������ʱ�� */
	private String endTime;
	/* ����Ʊ��ע */
	private String czpRemark;
	/* ���������� */
	private String czpOperatorName;
	/* �໤������ */
	private String czpGuardName;
	/* ֵ�ฺ�������� */
	private String czpLeaderName;
	/* ֵ������ */;
	private String czpDutyName;
	/* ����Ʊ������ */
	private List<CzpCzxBean> czxList;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(depart);
		dest.writeString(czpNum);
		dest.writeString(startTime);
		dest.writeString(endTime);
		dest.writeString(czpRemark);
		dest.writeString(czpOperatorName);
		dest.writeString(czpGuardName);
		dest.writeString(czpLeaderName);
		dest.writeString(czpDutyName);
	}

	public static final Parcelable.Creator<CzpZpBean> CREATOR = new Creator<CzpZpBean>() {

		@Override
		public CzpZpBean createFromParcel(Parcel source) {
			CzpZpBean mBean = new CzpZpBean();
			mBean.depart = source.readString();
			mBean.czpNum = source.readString();
			mBean.startTime = source.readString();
			mBean.endTime = source.readString();
			mBean.czpRemark = source.readString();
			mBean.czpOperatorName = source.readString();
			mBean.czpGuardName = source.readString();
			mBean.czpLeaderName = source.readString();
			return mBean;
		}

		@Override
		public CzpZpBean[] newArray(int size) {
			return new CzpZpBean[size];
		}
	};

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getCzpNum() {
		return czpNum;
	}

	public void setCzpNum(String czpNum) {
		this.czpNum = czpNum;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCzpRemark() {
		return czpRemark;
	}

	public void setCzpRemark(String czpRemark) {
		this.czpRemark = czpRemark;
	}

	public String getCzpCzrName() {
		return czpOperatorName;
	}

	public void setCzpCzrName(String czpCzrName) {
		this.czpOperatorName = czpCzrName;
	}

	public String getCzpGuardName() {
		return czpGuardName;
	}

	public void setCzpGuardName(String czpGuardName) {
		this.czpGuardName = czpGuardName;
	}

	public String getCzpLeaderName() {
		return czpLeaderName;
	}

	public void setCzpLeaderName(String czpLeaderName) {
		this.czpLeaderName = czpLeaderName;
	}

	public String getCzpDutyName() {
		return czpDutyName;
	}

	public void setCzpDutyName(String czpDutyName) {
		this.czpDutyName = czpDutyName;
	}

	public List<CzpCzxBean> getCzxList() {
		return czxList;
	}

	public void setCzxList(List<CzpCzxBean> czxList) {
		this.czxList = czxList;
	}
}
