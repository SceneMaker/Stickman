package de.dfki.common;

/**
 * Created by alvaro on 9/12/16.
 */
public abstract class XMLCommandParser {

    protected StickmansOnStage onStage;

    public XMLCommandParser(StickmansOnStage stage) {
        onStage = stage;
    }

    public abstract void parseStickmanXMLCmd(String cmd);
}
