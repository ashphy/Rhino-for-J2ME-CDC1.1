package jp.naist.ricoh2011jp.mandara.javabeans;

import java.util.EventObject;

public class PropertyChangeEvent extends EventObject {

	private static final long serialVersionUID = 295203419106580795L;

	String propertyName;
    Object oldValue;
    Object newValue;
    Object propagationId;

    public PropertyChangeEvent(Object source, String propertyName, Object oldValue, Object newValue) {
        super(source);

        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
    }

    public Object getPropagationId() {
        return propagationId;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}