package mirrg.beryllium.logging.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import mirrg.beryllium.logging.EnumLogLevel;

public class LogFormatterDefault implements ILogFormatter
{

	public static final LogFormatterDefault INSTANCE = new LogFormatterDefault("uuuu/MM/dd HH:mm:ss.SSS");

	private DateTimeFormatter formatter;

	public LogFormatterDefault(String pattern)
	{
		formatter = DateTimeFormatter.ofPattern(pattern);
	}

	@Override
	public String format(String tag, String string, Optional<EnumLogLevel> oLogLevel)
	{
		return String.format("%s %-7s [%s] %s",
			formatter.format(LocalDateTime.now()),
			oLogLevel
				.map(l -> "[" + l.name() + "]")
				.orElse(""),
			tag,
			string);
	}

}
