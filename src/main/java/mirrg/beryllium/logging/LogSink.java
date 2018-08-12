package mirrg.beryllium.logging;

import java.util.Optional;

/**
 * ログの出力先です。
 * 実際にログを取るには、 {@link #logger(String)} を呼び出して得られるロガークラスを経由してください。
 */
public abstract class LogSink
{

	public abstract void println(String tag, String string, Optional<EnumLogLevel> oLogLevel);

	public abstract void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel);

	public final Logger logger(String tag)
	{
		return new Logger(this, tag);
	}

}
