package de.dfki.util.xml;

import de.dfki.util.ios.IOSIndentWriter;

/**
 * @author Not me
 */
public interface XMLWriteable {

    // Write a writeable object in XML to an indent writer 
    public void writeXML(final IOSIndentWriter writer) throws XMLWriteError;
}
