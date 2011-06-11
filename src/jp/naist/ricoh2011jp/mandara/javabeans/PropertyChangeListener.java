package jp.naist.ricoh2011jp.mandara.javabeans;

/**
 * A "PropertyChange" event gets fired whenever a bean changes a "bound" property. 
 * You can register a PropertyChangeListener with a source bean so as to be notified of any bound property updates.
 * @author Kazuki-h
 */
public interface PropertyChangeListener {
	
	/**
	 * This method gets called when a bound property is changed.
	 * @param evt
	 */
	void propertyChange(PropertyChangeEvent evt);
}
