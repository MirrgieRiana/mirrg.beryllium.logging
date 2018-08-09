package mirrg.beryllium.logging;

import java.util.Optional;

public interface ILogger
{

	public void println(String string, Optional<EnumLogLevel> oLogLevel);

	public default void println(String string)
	{
		println(string, Optional.empty());
	}

	public default void println(String string, EnumLogLevel logLevel)
	{
		println(string, Optional.of(logLevel));
	}

	public default void fatal(String string)
	{
		println(string, EnumLogLevel.FATAL);
	}

	public default void error(String string)
	{
		println(string, EnumLogLevel.ERROR);
	}

	public default void warn(String string)
	{
		println(string, EnumLogLevel.WARN);
	}

	public default void info(String string)
	{
		println(string, EnumLogLevel.INFO);
	}

	public default void debug(String string)
	{
		println(string, EnumLogLevel.DEBUG);
	}

	public default void trace(String string)
	{
		println(string, EnumLogLevel.TRACE);
	}

	public void println(Throwable e, Optional<EnumLogLevel> oLogLevel);

	public default void println(Throwable e)
	{
		println(e, Optional.empty());
	}

	public default void println(Throwable e, EnumLogLevel logLevel)
	{
		println(e, Optional.of(logLevel));
	}

	public default void fatal(Throwable e)
	{
		println(e, EnumLogLevel.FATAL);
	}

	public default void error(Throwable e)
	{
		println(e, EnumLogLevel.ERROR);
	}

	public default void warn(Throwable e)
	{
		println(e, EnumLogLevel.WARN);
	}

	public default void info(Throwable e)
	{
		println(e, EnumLogLevel.INFO);
	}

	public default void debug(Throwable e)
	{
		println(e, EnumLogLevel.DEBUG);
	}

	public default void trace(Throwable e)
	{
		println(e, EnumLogLevel.TRACE);
	}

}
