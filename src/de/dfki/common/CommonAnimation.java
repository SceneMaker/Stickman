package de.dfki.common;

import de.dfki.util.xml.XMLWriteable;

/**
 * Created by alvaro on 9/19/16.
 */
public interface CommonAnimation extends XMLWriteable {
    void setParameter(Object p);
    String getmID();
}
