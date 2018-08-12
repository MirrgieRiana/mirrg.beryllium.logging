package mirrg.beryllium.logging.loggers.text;

import java.io.PrintStream;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;

public class LogSinkPrintStream extends LogSinkTextBase
{

	private PrintStream out;

	public LogSinkPrintStream(PrintStream out)
	{
		this.out = out;
	}

	@Override
	public void println(String tag, String string, Optional<EnumLogLevel> oLogLevel)
	{
		out.println(formatter.format(tag, string, oLogLevel));
	}

}
