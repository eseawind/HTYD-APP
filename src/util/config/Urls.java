package util.config;

public class Urls {
	public static final String BASIC_URL =  "http://192.168.1.188/YHService/IMobile";//"http://110.80.33.60:8008/IMobile";//
	
	public static final String YH_URL = BASIC_URL + "/Yh.ashx?";//operate=s_id&condition=2
	
	public static final String GZP_URL = BASIC_URL + "/Gzp.ashx?";
	
	public static final String DBTX_URL = BASIC_URL + "/Gztx.ashx?";
	
	public static final String BM_URL = BASIC_URL+"/Bm.ashx?";
	
	public static final String CZP_URL = BASIC_URL+"/CaoZuoPiao.ashx?";
	
	public static final String CODE_URL = BASIC_URL + "/Function.ashx?";
	//public static final String BASIC_URL = "http://api.eoe.name/client";
	
	//public static final String TOP_NEWS_URL = BASIC_URL
			//+ "/news?k=lists&t=top";
	public static final String TOP_NEWS_URL = BASIC_URL
			+ "/getBbsList.php?";
	public static final String DETIAL_NEWS_URL = BASIC_URL
			+ "/getBbsDetial1.php?id=";
	//public static final String TOP_BLOG_URL = BASIC_URL
			//+ "/blog?k=lists&t=top";
	public static final String TOP_BLOG_URL = BASIC_URL
			+ "/getBbsList1.php?";
	//public static final String TOP_WIKI_URL = BASIC_URL
			//+ "/wiki?k=lists&t=top";
	public static final String TOP_WIKI_URL = BASIC_URL
			+ "/getBbsList2.php?";
	/**
	 * ���������ַ
	 */
	public static final String TOP_LIST = BASIC_URL + "/top";
	public static final String BLOGS_LIST = BASIC_URL + "/blog?k=lists";
	public static final String NEWS_LIST = BASIC_URL + "/news?k=lists";
	public static final String WIKI_LIST = BASIC_URL + "/wiki?k=lists";

	/**
	 * searchURL
	 */
	public static final String BASE_SEARCH_URL = BASIC_URL + "/search?";

	//public static final String USER_LOGIN = BASIC_URL + "/key?uname=%s&pwd=%s";
	public static final String USER_LOGIN = BASIC_URL + "/hlogin.php?uname=%s&pwd=%s";

	/**
	 * 1 k 2 act 3 model 4 itemid
	 */
	public static final String DETAILS_ActionBar = BASIC_URL
			+ "/bar?k=%s&act=%s&model=%s&itemid=%s";

	public static final String userlike = "userlike";
	public static final String favorite = "favorite";
	public static final String add = "add";
	public static final String del = "del";
	public static final String like = "like";
	public static final String useless = "useless";
	public static final String news = "news";
	public static final String wiki = "wiki";
	public static final String blog = "blog";

	// ��ȡ�û���Ϣ�ӿ�
	public static final String KEYBindURL = BASIC_URL + "/userinfo?key=%s";

}
