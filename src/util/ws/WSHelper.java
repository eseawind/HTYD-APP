package util.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.R.string;

public class WSHelper 
{
	//Webservice参数
	private static final String m_NAMESPACE = "http://tempuri.org/";
	private static String m_URL = "http://110.80.33.60:118/YxzcService/Gzp/Gzp.asmx";
	
	public WSHelper() 
	{
	}	
	
	public static String GetResponse(String strMethodName)
	{
		String result;		
		result = "";
		
		final String methodName;		
		methodName = strMethodName;
		//1
		final HttpTransportSE ht = new HttpTransportSE(m_URL);
		ht.debug = true;
		//2
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		//3
		SoapObject soapObject = new SoapObject(m_NAMESPACE, strMethodName);
		//4
		//参数
		//5		
		envelope.bodyOut = soapObject;
		envelope.dotNet = true;
			
		
		FutureTask<String> task = new FutureTask<String>(
		new Callable<String>() 
		{
			@Override
			public String call() throws Exception
			{
				//6
				ht.call(m_NAMESPACE + methodName, envelope);				
				//7
				if ( envelope.getResponse() != null)
				{
					SoapObject myDetail =(SoapObject) envelope.bodyIn;			
					return (String)myDetail.toString();
				}
				return null;
			}
		});		
		new Thread(task).start();
		try
		{
			result = task.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;		
	}
	
	public static String GetResponse(String strMethodName,List<BasicNameValuePair> params)	
	{
		int i;
		int len;		
		i = 0;
		len = params.size();
		
		String result;		
		result = "";
		
		final String methodName;		
		methodName = strMethodName;
		//1
		final HttpTransportSE ht = new HttpTransportSE(m_URL);
		ht.debug = true;
		//2
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		//3
		SoapObject soapObject = new SoapObject(m_NAMESPACE, strMethodName);
		//4
		for(i=0 ; i<len ; i++)
		{                 
			soapObject.addProperty(params.get(i).getName(),params.get(i).getValue());             
		}
		//5		
		envelope.bodyOut = soapObject;
		envelope.dotNet = true;
			
		
		FutureTask<String> task = new FutureTask<String>(
		new Callable<String>() 
		{
			@Override
			public String call() throws Exception
			{
				//6
				ht.call(m_NAMESPACE + methodName, envelope);				
				//7
				if ( envelope.getResponse() != null)
				{
					SoapObject myDetail =(SoapObject) envelope.bodyIn;	
					
					return (String)myDetail.getProperty(0).toString();
				}
				return null;
			}
		});		
		new Thread(task).start();
		try
		{
			result = task.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;	
	}
}
