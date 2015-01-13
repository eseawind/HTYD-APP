package main.bean;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class DepartmentBean implements Parcelable {

	private int departmentID;
	private String departmentName;
	private int parentID;
	private int arrayNum;

	
	
	
	
	public DepartmentBean() {
	}
	public DepartmentBean(JSONObject jsonObject) throws NumberFormatException, JSONException{
		departmentID = jsonObject.getInt("BMID");
		departmentName = jsonObject.getString("BMMC");
		parentID = jsonObject.getInt("FJID");
		arrayNum = jsonObject.getInt("PXXH");
	}
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(departmentID);
		dest.writeString(departmentName);
		dest.writeInt(parentID);
		dest.writeInt(arrayNum);
	}

	public static final Parcelable.Creator<DepartmentBean> CREATOR = new Creator<DepartmentBean>() {

		@Override
		public DepartmentBean createFromParcel(Parcel source) {
			DepartmentBean mDepartmentBean = new DepartmentBean();
			mDepartmentBean.departmentID = source.readInt();
			mDepartmentBean.departmentName = source.readString();
			mDepartmentBean.parentID = source.readInt();
			mDepartmentBean.arrayNum = source.readInt();
			return mDepartmentBean;
		}

		@Override
		public DepartmentBean[] newArray(int size) {
			return new DepartmentBean[size];
		}
	};

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getArrayNum() {
		return arrayNum;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public void setArrayNum(int arrayNum) {
		this.arrayNum = arrayNum;
	}
}
