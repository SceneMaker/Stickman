package de.dfki.common;

/**
 * Created by alvaro on 9/12/16.
 */
public abstract class CommandParser {

    protected StickmansOnStage onStage;
    public CommandParser(StickmansOnStage stage){
        onStage = stage;
    }
    public  abstract void parseStickmanMLCmd(String cmd);
}
