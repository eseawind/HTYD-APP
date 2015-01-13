package czp;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import czp.bean.CzpCzxBean;
import czp.bean.CzpZpBean;

public class CzpDownloader<Token> extends HandlerThread {

	private static final String TAG = "CzpDownloader";
	private static final int MESSAGE_DOWNLOAD = 0;
	private Context context;

	private Handler mHandler;

	private Map<Token, String> requestMap = Collections
			.synchronizedMap(new HashMap<Token, String>());
	private Map<Token,Boolean> downloadedMap = new HashMap<Token, Boolean>();

	private Handler mResponseHandler;
	private Listener<Token> mListener;

	public interface Listener<Token> {
		void onCzpAllDownloaded(Token token, CzpZpBean mBean);
	}

	public CzpDownloader(Context context, Handler responseHandler) {
		super(TAG);
		this.context = context;
		mResponseHandler = responseHandler;
	}

	public void setListener(Listener<Token> listener) {
		mListener = listener;
	}

	@SuppressLint("HandlerLeak")
	@Override
	protected void onLooperPrepared() {
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case MESSAGE_DOWNLOAD:
					@SuppressWarnings("unchecked")
					Token token = (Token) msg.obj;
					handleRequest(token);
				}
			}
		};
	}

	private void handleRequest(final Token token) {
		final String id = requestMap.get(token);
		if (id == null)
			return;
		try {
			if(requestMap.containsKey(token) && downloadedMap.containsKey(token) && downloadedMap.get(token)){
				Log.i("fanjishuo____handleRequest", "requestMap.containsKey(token)");
				return;
			}
			final CzpZpBean mBean = CzpDataOperator.getCzpAllByID(context, id);
			List<CzpCzxBean> czxList = CzpDataOperator.getCzpCzxListByID(context, id, "19");
			mBean.setCzxList(czxList);
			mResponseHandler.post(new Runnable() {
				@Override
				public void run() {
					if (requestMap.get(token) != id)
						return;
					if(mBean != null)
						downloadedMap.put(token, true);
					mListener.onCzpAllDownloaded(token, mBean);
				}
			});
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("fanjishuo____handleRequest", "catch e");
		}
	}

	public void queueCzpAll(Token token, String czpid) {
		requestMap.put(token, czpid);
		mHandler.obtainMessage(MESSAGE_DOWNLOAD, token).sendToTarget();
	}
	
	public void clearQueue(){
		mHandler.removeMessages(MESSAGE_DOWNLOAD);
		requestMap.clear();
	}
}
