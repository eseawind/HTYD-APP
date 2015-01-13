/**
 * Adapter based on BaseExpandableListAdapter
 * @author Anson, 19Apr2011
 *
 */
package main.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
//import android.util.Log;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.aqscgkpt.R;

public class Main_WorkFlow_Send_Fragment_Dialog_ELAdapter extends BaseExpandableListAdapter {
	Activity activity;
	List<String> listGroup = new ArrayList<String>();
	List<List<String>> listChild = new ArrayList<List<String>>();
			
	private int _posGroup = 0;
	private int _posChild = 0;
	
	public Main_WorkFlow_Send_Fragment_Dialog_ELAdapter(Activity a, List<String> group, List<List<String>> children){
		super();
		activity = a;
		listGroup = group;
		listChild = children;
		//Log.v("LH","@MyExpandableListAdapter: ");
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		//Log.v("LH", listChild.get(groupPosition).get(childPosition));
		return listChild.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		Log.v("LH", "ChildID: " + childPosition);		
		_posGroup = groupPosition;
		_posChild = childPosition;
		return childPosition;
	}
	@Override
	public int getChildrenCount(int groupPosition) {
		//Log.v("LH", "ChildrenCount: " + groupPosition);
		return listChild.get(groupPosition).size();
	}
	// TODO 子类需维护
	@Override
	public View getChildView(int groupPosition, int childPosition,boolean isLastChild, View convertView, ViewGroup parent) 
	{		
		String string = listChild.get(groupPosition).get(childPosition);
		
		//View view = getGenericView(string);
		View view2 = getCheckBoxView(string);
		//TextView textView = (TextView) view; 
		CheckBox checkBox = (CheckBox) view2;
		if(this._posGroup==groupPosition && 
		           this._posChild==childPosition)       	
		        {
		        	//textView.setTextColor(Color.WHITE);
		        	checkBox.setTextColor(Color.BLACK);
		        }
		return view2;
	}


	//group method stub
	@Override
	public Object getGroup(int groupPosition) {
		//Log.v("LH", listGroup.get(groupPosition));
		return listGroup.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		//Log.v("LH", "GroupCount: " + listGroup.size());
		return listGroup.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		Log.v("LH", "GroupID: " + groupPosition);
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent) {		
		String string = listGroup.get(groupPosition);
		View view = getGenericView(string);
		view.setBackgroundColor(Color.GRAY);
		//Log.v("LH","@getGroupView: " + string);
		return view;
	}

	//View stub to create Group/Children's View
	public TextView getGenericView(String s) {
        // Layout parameters for the ExpandableListView
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, 64);

        lp.height=36;
        TextView text = new TextView(activity);
        text.setLayoutParams(lp);
        // Center the text vertically
        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        // Set the text starting position
        text.setPadding(36, 0, 0, 0);
        text.setTextColor(Color.WHITE);        
        text.setText(s);
                
        return text;
    }
	// TODO 维护
	public CheckBox getCheckBoxView(String str){
		
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 62);
		lp.height = 36;
		CheckBox checkBox = new CheckBox(activity);
		checkBox.setLayoutParams(lp);
		checkBox.setPadding(8, 0, 0, 0);
		checkBox.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		checkBox.setTextColor(Color.BLACK);
		checkBox.setText(str);
		checkBox.setButtonDrawable(R.drawable.grape_btn_check);
		return checkBox;
	}
	
	@Override
	public boolean hasStableIds() {		
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {		
		return true;
	}		
}