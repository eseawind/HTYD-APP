package main.bean;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonBean implements Parcelable {

	private int personID;
	private String name;
	private int parentID;

	public PersonBean() {
		super();
	}

	public PersonBean(JSONObject json, int parentID) throws JSONException {
		personID = json.getInt("YHID");
		name = json.getString("YHMC");
		this.parentID = parentID;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeInt(personID);
	}

	public static final Parcelable.Creator<PersonBean> CREATOR = new Creator<PersonBean>() {

		@Override
		public PersonBean createFromParcel(Parcel source) {
			PersonBean mPersonBean = new PersonBean();
			mPersonBean.name = source.readString();
			mPersonBean.personID = source.readInt();
			return mPersonBean;
		}

		@Override
		public PersonBean[] newArray(int size) {
			return new PersonBean[size];
		}
	};

	public int getPersonID() {
		return personID;
	}

	public String getName() {
		return name;
	}

	public int getParentID() {
		return parentID;
	}
}
