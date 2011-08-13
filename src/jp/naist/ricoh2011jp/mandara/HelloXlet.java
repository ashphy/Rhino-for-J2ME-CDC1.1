package jp.naist.ricoh2011jp.mandara;

import java.io.IOException;

import jp.co.ricoh.dsdk.panel.Container;
import jp.co.ricoh.dsdk.panel.Frame;
import jp.co.ricoh.dsdk.panel.LabelArea;
import jp.co.ricoh.dsdk.panel.event.ActionEvent;
import jp.co.ricoh.dsdk.panel.event.ActionListener;
import jp.co.ricoh.dsdk.xlet.UnavailableContainerException;
import jp.co.ricoh.dsdk.xlet.Xlet;
import jp.co.ricoh.dsdk.xlet.XletContext;
import jp.co.ricoh.dsdk.xlet.XletStateChangeException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class HelloXlet implements Xlet, ActionListener {

	private Frame rootContainer;

	public synchronized void initXlet(XletContext context)
		throws XletStateChangeException {

		Env.setContext(context);
		
		String[] args = (String[]) context.getXletProperty(XletContext.ARGS);
		String str = "Rhino for MFP";
		if (args != null && args.length > 0) {
			str = args[0];
		}
		try {
			Container parent = context.getContainer();
			while(!(parent instanceof Frame)){
				parent = parent.getParent();
				if(parent == null)
					break;
			}
			if(parent == null){
				return;
			}
			rootContainer = (Frame)parent;

            createGUI(str);
		} catch (UnavailableContainerException ex) {
			throw new XletStateChangeException(ex.getMessage());

        }catch (Exception ex){
            throw new XletStateChangeException(ex.getMessage());
            
        }
	}
	/**
	 *	活性化。
	 *	活性化処理を行います。活性化時は、オペパネに"Actived"状態を表示します。
	 */
	public synchronized void startXlet() throws XletStateChangeException {
		String hello = null;
		try {
			System.out.println("[Rhino for MFP]Load hello.js");
			hello = JSReader.readFromJar("hello.js");
			System.out.println(hello);
			Context cx = Context.enter();
			Scriptable scope = cx.initStandardObjects();
			Object result = cx.evaluateString(scope, hello, "<cmd>", 1, null);
			System.out.println(Context.toString(result));
			Context.exit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *	停止。
	 *	停止処理を行います。停止時は、オペパネに"Paused"状態を表示します。 
	 */
	public synchronized void pauseXlet() {
	}

	/**
	 *	終了処理。
	 *	HelloXletの終了処理を行います。終了処理は、リソースの開放などを行いますが、
	 *	dsdkパッケージクラスに関しては、XletManagerが自動的に開放処理を行うため、
	 *	明示する必要はありません。条件付終了(unconditional=false)の場合は、終了を
	 *	拒否します。 
	 */
	public synchronized void destroyXlet(boolean arg0)
		throws XletStateChangeException {
	}
	/**
	 *	GUI作成。
	 *	initXletメソッドから呼び出され、オペパネにＧＵＩを作成します。
	 *	
	 *[処理内容]
	 *	(1) Xletアプリケーションの名前を表示するメッセージ
	 *	(2) Lableを表示するメッセージ
     *  (3) PanelSizeを表示するメッセージ
	 *	(4) Xletアプリケーションの状態を表示するメッセージ
	 *	(5) 状態遷移ボタンの作成と追加。
	 *	(6) Endボタンの作成と追加
	 * @param str	オペパネに表示するメッセージ文字列
	 */
	private void createGUI(String str) {
		LabelArea titleMsg = new LabelArea(str);		//(1)
		titleMsg.setBounds(240, 15, 150, 50);
		rootContainer.add(titleMsg);
	}
	
	public void actionPerformed(ActionEvent arg0) {
	}
}