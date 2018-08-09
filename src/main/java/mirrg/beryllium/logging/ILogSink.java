package mirrg.beryllium.logging;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Optional;

import mirrg.beryllium.logging.core.LogSinkPrintStream;
import mirrg.beryllium.logging.core.LogSinkPrintWriter;

public interface ILogSink
{

	public void println(String tag, String string, Optional<EnumLogLevel> oLogLevel);

	public default void println(String tag, String string)
	{
		println(tag, string, Optional.empty());
	}

	public default void println(String tag, String string, EnumLogLevel logLevel)
	{
		println(tag, string, Optional.of(logLevel));
	}

	public default void fatal(String tag, String string)
	{
		println(tag, string, EnumLogLevel.FATAL);
	}

	public default void error(String tag, String string)
	{
		println(tag, string, EnumLogLevel.ERROR);
	}

	public default void warn(String tag, String string)
	{
		println(tag, string, EnumLogLevel.WARN);
	}

	public default void info(String tag, String string)
	{
		println(tag, string, EnumLogLevel.INFO);
	}

	public default void debug(String tag, String string)
	{
		println(tag, string, EnumLogLevel.DEBUG);
	}

	public default void trace(String tag, String string)
	{
		println(tag, string, EnumLogLevel.TRACE);
	}

	public void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel);

	public default void println(String tag, Throwable e)
	{
		println(tag, e, Optional.empty());
	}

	public default void println(String tag, Throwable e, EnumLogLevel logLevel)
	{
		println(tag, e, Optional.of(logLevel));
	}

	public default void fatal(String tag, Throwable e)
	{
		println(tag, e, EnumLogLevel.FATAL);
	}

	public default void error(String tag, Throwable e)
	{
		println(tag, e, EnumLogLevel.ERROR);
	}

	public default void warn(String tag, Throwable e)
	{
		println(tag, e, EnumLogLevel.WARN);
	}

	public default void info(String tag, Throwable e)
	{
		println(tag, e, EnumLogLevel.INFO);
	}

	public default void debug(String tag, Throwable e)
	{
		println(tag, e, EnumLogLevel.DEBUG);
	}

	public default void trace(String tag, Throwable e)
	{
		println(tag, e, EnumLogLevel.TRACE);
	}

	public default ILogger logger(String tag)
	{
		return new ILogger() {
			@Override
			public void println(String string, Optional<EnumLogLevel> oLogLevel)
			{
				ILogSink.this.println(tag, string, oLogLevel);
			}

			@Override
			public void println(Throwable e, Optional<EnumLogLevel> oLogLevel)
			{
				ILogSink.this.println(tag, e, oLogLevel);
			}
		};
	}

	public static ILogSink fromPrintStream(PrintStream out)
	{
		return new LogSinkPrintStream(out);
	}

	public static ILogSink fromPrintWriter(PrintWriter out)
	{
		return new LogSinkPrintWriter(out);
	}

}
