package mirrg.beryllium.logging.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;
import mirrg.beryllium.logging.ILogSink;

public abstract class LogSinkTextBase implements ILogSink
{

	public ILogFormatter formatter = LogFormatterDefault.INSTANCE;

	public abstract void println(String tag, String string, Optional<EnumLogLevel> oLogLevel);

	public void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel)
	{
		StringWriter out = new StringWriter();
		e.printStackTrace(new PrintWriter(out));
		println(tag, out.toString(), oLogLevel);
	}

}
