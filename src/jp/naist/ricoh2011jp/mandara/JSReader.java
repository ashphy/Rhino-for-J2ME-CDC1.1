package jp.naist.ricoh2011jp.mandara;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import jp.co.ricoh.dsdk.xlet.XletContext;

/**
 * JS File Reader
 * 
 * @author Kazuki Hamasaki
 */
public class JSReader {

	public static String read(String filename) throws IOException {

		File file = new File(Env.getDirPath(XletContext.HOME) + File.separator
				+ "resources" + File.separator + filename);
		FileReader fileReader = new FileReader(file);
		BufferedReader in = new BufferedReader(fileReader);

		String line = "";
		StringBuffer buf = new StringBuffer();

		while ((line = in.readLine()) != null) {
			buf.append(line);
		}

		return buf.toString();
	}

	public static String readFromJar(String filename) throws IOException {

		URL url = JSReader.class.getResource("/resources/" + filename);
		InputStream is = url.openStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));

		String line = "";
		StringBuffer buf = new StringBuffer();

		while ((line = in.readLine()) != null) {
			System.out.println("[Read Line]" + line);
			buf.append(line);
		}

		return buf.toString();
	}

}
