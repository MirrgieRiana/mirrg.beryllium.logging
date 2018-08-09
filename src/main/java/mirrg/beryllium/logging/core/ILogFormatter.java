package mirrg.beryllium.logging.core;

import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;

public interface ILogFormatter
{

	public String format(String tag, String string, Optional<EnumLogLevel> oLogLevel);

}
