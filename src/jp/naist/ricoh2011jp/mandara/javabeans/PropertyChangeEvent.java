package jp.naist.ricoh2011jp.mandara.javabeans;

import java.util.EventObject;

/**
 * A "PropertyChange" event gets delivered whenever a bean changes a "bound" or "constrained" property. A PropertyChangeEvent object is sent as an argument to the PropertyChangeListener and VetoableChangeListener methods.
 * Normally PropertyChangeEvents are accompanied by the name and the old and new value of the changed property. If the new value is a primitive type (such as int or boolean) it must be wrapped as the corresponding java.lang.* Object type (such as Integer or Boolean).
 * Null values may be provided for the old and the new values if their true values are not known.
 * An event source may send a null object as the name to indicate that an arbitrary set of if its properties have changed. In this case the old and new values should also be null.
 * 
 * @author Kazuki-h
 */
public class PropertyChangeEvent extends EventObject {

	private static final long serialVersionUID = 295203419106580795L;

	String propertyName;
    Object oldValue;
    Object newValue;
    Object propagationId;

    /**
     * Constructs a new PropertyChangeEvent.
     * @param source
     * @param propertyName
     * @param oldValue
     * @param newValue
     */
    public PropertyChangeEvent(Object source, String propertyName, Object oldValue, Object newValue) {
        super(source);

        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Sets the new value for the property, expressed as an Object.
     * @return
     */
    public Object getNewValue() {
        return newValue;
    }
    

    /**
     * Gets the old value for the property, expressed as an Object.
     * @return
     */
    public Object getOldValue() {
        return oldValue;
    }
    
    /**
     * The "propagationId" field is reserved for future use.
     * @return
     */
    public Object getPropagationId() {
        return propagationId;
    }
    
    /**
     * Gets the programmatic name of the property that was changed.
     * @return
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the propagationId object for the event.
     * @param propagationId
     */
    public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
    }
}