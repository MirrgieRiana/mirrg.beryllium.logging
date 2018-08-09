package mirrg.beryllium.logging.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;
import mirrg.beryllium.logging.ILogger;

public class OutputStreamLogging extends OutputStreamDecodeBase
{

	private ILogger logger;
	private Optional<EnumLogLevel> oLogLevel = Optional.empty();

	public OutputStreamLogging(ILogger logger)
	{
		super();
		this.logger = logger;
	}

	public OutputStreamLogging(ILogger logger, String charset)
	{
		super(charset);
		this.logger = logger;
	}

	public OutputStreamLogging(ILogger logger, Charset charset)
	{
		super(charset);
		this.logger = logger;
	}

	public void setLogLevel(EnumLogLevel loglevel)
	{
		oLogLevel = Optional.ofNullable(loglevel);
	}

	@Override
	protected void println(String string) throws IOException
	{
		logger.println(string, oLogLevel);
	}

}
