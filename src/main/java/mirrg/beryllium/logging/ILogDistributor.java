package mirrg.beryllium.logging;

import mirrg.beryllium.logging.core.LogDistributor;

public interface ILogDistributor extends ILogSink
{

	public void registerLogSink(ILogSink logSink);

	public static ILogDistributor of(ILogSink... logSinks)
	{
		LogDistributor logDistributor = new LogDistributor();
		for (ILogSink logSink : logSinks) {
			logDistributor.registerLogSink(logSink);
		}
		return logDistributor;
	}

}
