package mirrg.beryllium.logging.loggers.text;

import java.io.PrintWriter;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;

public class LogSinkPrintWriter extends LogSinkTextBase
{

	private PrintWriter out;

	public LogSinkPrintWriter(PrintWriter out)
	{
		this.out = out;
	}

	@Override
	public void println(String tag, String string, Optional<EnumLogLevel> oLogLevel)
	{
		out.println(formatter.format(tag, string, oLogLevel));
	}

}
