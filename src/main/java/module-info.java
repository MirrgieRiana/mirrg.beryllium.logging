module mirrg.beryllium.logging
{
	exports mirrg.beryllium.logging;
	exports mirrg.beryllium.logging.io;
	exports mirrg.beryllium.logging.loggers.text;
	exports mirrg.beryllium.logging.loggers.desktop;

	requires transitive java.desktop; // TODO 依存性除去
	requires static org.junit.jupiter.api;
}
