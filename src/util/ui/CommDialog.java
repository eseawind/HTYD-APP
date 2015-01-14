package util.ui;


import com.example.aqscgkpt.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class CommDialog 
{
	/*
	 * DialogType
	 * 0、简单窗口，带标题、双按钮
	 * 1、简单窗口，带标题，带提示内容、带确定按钮
	 * 2、简单窗口，带标题，带提示内容、带确定按钮
	 * 3、自定义窗口，带标题，带输入框内容、双按钮
	 * 4、单选列表窗口，带标题，双按钮
	 * 5、多选列表窗口，带标题，双按钮
	 */
	public String Title;
	public String Message;
	public int DialogType;
	public String[] ArrayItems;
	public boolean[] bArrayItems;
	
	public CommDialog()
	{
		Title = "提示";
		Message = "确定要关闭吗？";
		DialogType = 0;
		ArrayItems = null;
		bArrayItems = null;
	}

	public void ShowDialog(Context context)
	{
		AlertDialog.Builder dialog;
		final EditText Et_DialogEditText;
		LayoutInflater inflater;
		View Dialog_EditText;
		
		switch (DialogType) 
		{  
			case 0:				
				dialog= new AlertDialog.Builder(context);
				dialog.setMessage(Message);
				dialog.setCancelable(false);
				dialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						
					}  
				});
				dialog.show();
				
				break;
			case 1:				
				dialog= new AlertDialog.Builder(context);
				dialog.setTitle(Title);
				dialog.setIcon(android.R.drawable.ic_dialog_info);
				dialog.setMessage(Message);
				dialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						
					}  
				});
				dialog.show();
				
				break;
			case 2:
				dialog= new AlertDialog.Builder(context);
				dialog.setTitle(Title);
				dialog.setIcon(android.R.drawable.ic_dialog_info);
				dialog.setMessage(Message);
				dialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						
					}  
				});	
				dialog.setNegativeButton("取消", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						dialog.cancel();
					}  
				});
				dialog.show();
				
				break;
			case 3:								
				dialog= new AlertDialog.Builder(context);
				dialog.setTitle(Title);
				dialog.setIcon(android.R.drawable.ic_dialog_info);
				inflater = LayoutInflater.from(context);
				Dialog_EditText = inflater.inflate(R.layout.util_dialog_edittext, null);
				dialog.setView(Dialog_EditText);
				Et_DialogEditText = (EditText)Dialog_EditText.findViewById(R.id.Et_DialogEditText);
				
				dialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
				{
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						String strDialogEditTex;
						
						strDialogEditTex = Et_DialogEditText.getText().toString();
						/*
					     Intent intent = new Intent();
					     Bundle bundle = new Bundle();
					     bundle.putString("search", searchC);
					     intent.putExtras(bundle);
					     intent.setClass(ViewResultActivity.this, SearchResult.class);
					     ViewResultActivity.this.startActivity(intent);
					    */
					}  
				});	
				dialog.setNegativeButton("取消", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						dialog.cancel();
					}  
				});
				dialog.show();
				
				break;
			case 4:								
				dialog= new AlertDialog.Builder(context);
				dialog.setTitle(Title);
				dialog.setIcon(android.R.drawable.ic_dialog_info);
				dialog.setSingleChoiceItems(ArrayItems,0,new DialogInterface.OnClickListener()
				{ 
					public void onClick(DialogInterface dialog, int which)
					{ 
						dialog.dismiss(); 
					}
				});	
				dialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						
					}  
				});	
				dialog.setNegativeButton("取消", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						dialog.cancel();
					}  
				});
				dialog.show();
				
				break;
			case 5:								
				dialog= new AlertDialog.Builder(context);
				dialog.setTitle(Title);
				dialog.setIcon(android.R.drawable.ic_dialog_info);
				dialog.setMultiChoiceItems(ArrayItems, bArrayItems, new DialogInterface.OnMultiChoiceClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) 
					{   
						bArrayItems[which] = isChecked;
						
					}
				});
				dialog.setPositiveButton("确认", new DialogInterface.OnClickListener()
				{   
					@Override   
					public void onClick(DialogInterface dialog, int which) 
					{   
						StringBuilder stringBuilder = new StringBuilder();   
						for (int i = 0; i < bArrayItems.length; i++) 
						{   
							if (bArrayItems[i] == true)   
							{   
								stringBuilder.append(ArrayItems[i] + "、");   
							}   
						}   
					}   
				});
				dialog.setNegativeButton("取消", new DialogInterface.OnClickListener()
				{  
					@Override 
					public void onClick(DialogInterface dialog, int which) 
					{  
						dialog.cancel();
					}  
				});
				dialog.show();
				
				break;
		}
	}	
}

