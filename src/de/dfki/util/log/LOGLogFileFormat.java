package de.dfki.util.log;

//~--- JDK imports ------------------------------------------------------------

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author Not me
 */
public class LOGLogFileFormat extends Formatter {

	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	@Override
	public final String format(final LogRecord record) {

		// Create The Date Of Logging
		Date date = new Date(record.getMillis());

		// Create The Thread Of Logging
		Thread thread = Thread.currentThread();

		// Create The Name Of Logger
		String name = record.getLoggerName();

		// Create The Stack Trace
		Object[] trace = record.getParameters();

		// Create The Method Name
		Object method = trace[2];

		// Create The String For Logging
		String message = record.getLevel() + " to " + "LOGFILE" + " on " + date + " by " + name + " in " + thread
				+ " at " + method;

		// Append The User Message
		message += System.getProperty("line.separator") + record.getMessage() // The
																				// Message
				+ System.getProperty("line.separator") + System.getProperty("line.separator");

		// return The Final Log Message
		return message;
	}
}
