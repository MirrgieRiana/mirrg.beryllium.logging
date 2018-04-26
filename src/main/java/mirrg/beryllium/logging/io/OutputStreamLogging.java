package mirrg.beryllium.logging.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;
import mirrg.beryllium.logging.LogSink;

public class OutputStreamLogging extends OutputStreamDecodeBase
{

	private String tag;
	private LogSink logSink;
	private Optional<EnumLogLevel> oLogLevel = Optional.empty();

	public OutputStreamLogging(String tag, LogSink logSink)
	{
		super();
		this.tag = tag;
		this.logSink = logSink;
	}

	public OutputStreamLogging(String tag, LogSink logSink, String charset)
	{
		super(charset);
		this.tag = tag;
		this.logSink = logSink;
	}

	public OutputStreamLogging(String tag, LogSink logSink, Charset charset)
	{
		super(charset);
		this.tag = tag;
		this.logSink = logSink;
	}

	public void setLogLevel(EnumLogLevel loglevel)
	{
		oLogLevel = Optional.ofNullable(loglevel);
	}

	@Override
	protected void println(String string) throws IOException
	{
		logSink.println(tag, string, oLogLevel);
	}

}
