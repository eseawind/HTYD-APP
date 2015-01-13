package util.function;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class Network 
{
	public static boolean isWifi(Context mContext) 
	{
		ConnectivityManager connectivityManager = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) 
		{
			return true;
		}
		return false;
	}
    
    public static boolean isNetwork(Context context) 
    {
		ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) 
		{
			return false;
		}
		else 
		{
			NetworkInfo activeNetInfo = connectivity.getActiveNetworkInfo();
			if (activeNetInfo != null && activeNetInfo.getState() == NetworkInfo.State.CONNECTED) 
			{
				if (activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) 
				{
					WifiManager wifi_service = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
					WifiInfo wifiInfo = wifi_service.getConnectionInfo();
					if ("CMCC".equals(wifiInfo.getSSID())) 
					{
						return false;
					}
				}
				return true;
			} 
			else 
			{
				return false;
			}
		}
	}
}
