package mirrg.beryllium.logging.core;

import java.util.ArrayList;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;
import mirrg.beryllium.logging.ILogDistributor;
import mirrg.beryllium.logging.ILogSink;

public class LogDistributor implements ILogDistributor
{

	private ArrayList<ILogSink> logSinks = new ArrayList<>();

	public void registerLogSink(ILogSink logSink)
	{
		logSinks.add(logSink);
	}

	@Override
	public void println(String tag, String string, Optional<EnumLogLevel> oLogLevel)
	{
		for (ILogSink logSink : logSinks) {
			logSink.println(tag, string, oLogLevel);
		}
	}

	@Override
	public void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel)
	{
		for (ILogSink logSink : logSinks) {
			logSink.println(tag, e, oLogLevel);
		}
	}

}
