package mirrg.beryllium.logging.loggers;

import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;
import mirrg.beryllium.logging.LogSink;

public class LogSinkVoid extends LogSink
{

	@Override
	public void println(String tag, String string, Optional<EnumLogLevel> oLogLevel)
	{

	}

	@Override
	public void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel)
	{

	}

}
