package de.dfki.common;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by EmpaT on 29.07.2017.
 */
public class LogFormatter extends Formatter
{
    @Override
    public String format(LogRecord record)
    {
        return ((new StringBuffer())
                .append(record
                        .getLevel())
                .append(": ")
                .append(record.getMessage())
                .append("\n")).toString();
    }
}
