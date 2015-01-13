package main.dialog;

import java.util.ArrayList;
import java.util.List;

import main.adapter.Main_WorkFlow_Send_Fragment_Dialog_ELAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import platform.impl.Yh;
import util.config.Dlyh;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.example.aqscgkpt.R;

@SuppressLint("NewApi")
public class workflow_send_fragment_dialog extends DialogFragment {

	public List<String> group;
	public List<List<String>> child;
	public ExpandableListView elv;

	private Yh yh;

	public void getDataInfo() throws JSONException {
//		yh = new Yh();
//		JSONArray jsonAllYh = yh.getAllYhxx(getActivity());
//		String strBMMC = jsonAllYh.getJSONObject(0).getString("BMMC");
//		
//		String strYhmc = jsonAllYh.getJSONObject(0).getString("YHMC");
//		Dlyh.getBmmc(getActivity());
		group = new ArrayList<String>();
//		group.clear();
		group.add("同信公司");
		group.add("陡电本部");
		group.add("天建本部");
		group.add("北京中盛博方公司");
//
		List<String> item1 = new ArrayList<String>();
//		for (int i = 0; i < jsonAllYh.length(); i++) {
//			if(Dlyh.getBmmc(getActivity()).equals(jsonAllYh.getJSONObject(i).getString("BMMC"))){
//				String strYhmc2 = jsonAllYh.getJSONObject(i).getString("YHMC");
//				item1.add(strYhmc2);
//			}
//			
//		}
		item1.add("朱百林");
		item1.add("李志平");
		item1.add("聂超");
		List<String> item2 = new ArrayList<String>();
		item2.add("鲍强");
		item2.add("高名记");
		List<String> item3 = new ArrayList<String>();
		item3.add("许海亮");
		item3.add("苗强");
		item3.add("毛永云");
		item3.add("李海春");
		
		List<String> item4 = new ArrayList<String>();
		item4.add("许海亮");
		item4.add("苗强");

		child = new ArrayList<List<String>>();
		child.add(item1);
		child.add(item2);
		child.add(item3);
		child.add(item4);

	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("发送窗口");
		builder.setIcon(android.R.drawable.ic_dialog_info);
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View view = inflater.inflate(
				R.layout.main_workflow_send_fragment_dialog, null);
		elv = (ExpandableListView) view.findViewById(R.id.Elv_Send);
		try {
			getDataInfo();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main_WorkFlow_Send_Fragment_Dialog_ELAdapter adapter = new Main_WorkFlow_Send_Fragment_Dialog_ELAdapter(
				getActivity(), group, child);
		elv.setAdapter(adapter);
		// 遍历所有group,将所有项设置成默认展开
		int groupCount = elv.getCount();
		for (int i = 0; i < groupCount; i++) {
			elv.expandGroup(i);
		};
		builder.setCancelable(true);
		builder.setView(view);
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});
		builder.setNegativeButton("取消", null);
		return builder.show();
	}
}
