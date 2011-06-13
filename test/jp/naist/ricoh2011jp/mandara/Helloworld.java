package jp.naist.ricoh2011jp.mandara;

import junit.framework.TestCase;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Helloworld extends TestCase {
	
	public void testHelloWorld() {
		Context cx = Context.enter();
		Scriptable scope = cx.initStandardObjects();
		String s = "java.lang.System.out.println('Hello World!');";
		Object result = cx.evaluateString(scope, s, "<cmd>", 1, null);
		assertEquals("undefined", Context.toString(result));
	}
}
