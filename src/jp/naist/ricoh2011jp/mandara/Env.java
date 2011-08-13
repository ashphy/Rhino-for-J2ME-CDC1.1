package jp.naist.ricoh2011jp.mandara;

import jp.co.ricoh.dsdk.xlet.XletContext;

/**
 * 環境情報を管理するクラス
 * @author Kazuki Hamasaki
 */
public class Env {
	
	/** Xlet context */
	private static XletContext context = null;

	/**
	 * Return Xlet context
	 * 
	 * @return Xlet context
	 */
	public static XletContext getContext() {
		return context;
	}

	/**
	 * Set the xlet context
	 * 
	 * @param context Xlet context
	 */
	public static void setContext(XletContext context) {
		Env.context = context;
	}

	
	/**
	 * Get the directory path
	 * 
	 * @param type direcotry type
	 */
	public static String getDirPath(String type) {
		return (String) context.getXletProperty(type);
	}
}
