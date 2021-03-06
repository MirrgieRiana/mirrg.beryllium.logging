package mirrg.beryllium.logging.loggers.text;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;
import mirrg.beryllium.logging.LogSink;

public abstract class LogSinkTextBase extends LogSink
{

	public ILogFormatter formatter = ILogFormatter.DEFAULT;

	@Override
	public abstract void println(String tag, String string, Optional<EnumLogLevel> oLogLevel);

	@Override
	public void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel)
	{
		StringWriter out = new StringWriter();
		e.printStackTrace(new PrintWriter(out));
		println(tag, out.toString(), oLogLevel);
	}

}
