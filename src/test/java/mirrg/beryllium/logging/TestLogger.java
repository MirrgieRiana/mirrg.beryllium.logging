package mirrg.beryllium.logging;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.junit.jupiter.api.Test;

import mirrg.beryllium.logging.core.LogSinkTextPane;
import mirrg.beryllium.logging.io.OutputStreamLogging;

public class TestLogger
{

	@Test
	public void test_fromPrintWriter() throws Exception
	{
		StringWriter out = new StringWriter();
		PrintWriter out2 = new PrintWriter(out);
		ILogSink logSink = ILogSink.fromPrintWriter(out2);
		ILogger logger = logSink.logger("Test");
		logger.fatal("001");
		logger.error("002");
		logger.warn("003");
		logger.info("004");
		logger.debug("005");
		logger.trace("006");
		assertTrue(out.toString().matches(""
			+ ".{23} \\[FATAL] \\[Test] 001" + System.lineSeparator()
			+ ".{23} \\[ERROR] \\[Test] 002" + System.lineSeparator()
			+ ".{23} \\[WARN]  \\[Test] 003" + System.lineSeparator()
			+ ".{23} \\[INFO]  \\[Test] 004" + System.lineSeparator()
			+ ".{23} \\[DEBUG] \\[Test] 005" + System.lineSeparator()
			+ ".{23} \\[TRACE] \\[Test] 006" + System.lineSeparator()));
	}

	@Test
	public void test_LogSinkTextPane() throws Exception
	{
		JFrame frame = new JFrame();
		frame.setLayout(new CardLayout());
		LogSinkTextPane logSink = new LogSinkTextPane(8);
		logSink.fatal("Test", "001");
		logSink.fatal("Test", "001");
		logSink.fatal("Test", "001");
		logSink.fatal("Test", "001");
		logSink.fatal("Test", "001");
		logSink.error("Test", "002");
		logSink.warn("Test", "003");
		logSink.info("Test", "004");
		logSink.debug("Test", "005");
		logSink.trace("Test", "006");
		logSink.scrollPane.setPreferredSize(new Dimension(300, 200));
		frame.add(logSink.component);
		Thread.sleep(1000);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		if (!logSink.textPane.getText().matches(""
			+ ".{23} \\[FATAL] \\[Test] 001" + System.lineSeparator()
			+ ".{23} \\[FATAL] \\[Test] 001" + System.lineSeparator()
			+ ".{23} \\[FATAL] \\[Test] 001" + System.lineSeparator()
			+ ".{23} \\[ERROR] \\[Test] 002" + System.lineSeparator()
			+ ".{23} \\[WARN]  \\[Test] 003" + System.lineSeparator()
			+ ".{23} \\[INFO]  \\[Test] 004" + System.lineSeparator()
			+ ".{23} \\[DEBUG] \\[Test] 005" + System.lineSeparator()
			+ ".{23} \\[TRACE] \\[Test] 006")) {
			fail();
		}
		Thread.sleep(1000);
		frame.dispose();
	}

	@Test
	public void test_OutputStreamLogging() throws Exception
	{
		ArrayList<String> strings = new ArrayList<>();

		test0(strings, "UTF-8");
		test0(strings, "Shift-JIS");
		test0(strings, "Unicode");

		{
			try (PrintStream out2 = new PrintStream(new OutputStreamLogging(new ILogSink() {
				@Override
				public void println(String tag, String string, Optional<EnumLogLevel> oLogLevel)
				{
					strings.add("[" + tag + "] " + string);
				}

				@Override
				public void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel)
				{

				}
			}.logger("Test"), "Unicode"), true, "Unicode")) {

				out2.println("abc");
				assertEquals(1, strings.size());
				assertEquals("[Test] abc", strings.get(0));
				strings.clear();

				out2.println("def");
				assertEquals(1, strings.size());
				assertEquals("[Test] def", strings.get(0));
				strings.clear();

				out2.println("ghi");
				assertEquals(1, strings.size());
				assertEquals("[Test] ghi", strings.get(0));
				strings.clear();

			}

			assertEquals(1, strings.size());
			assertEquals("[Test] ", strings.get(0));
			strings.clear();
		}

	}

	private void test0(ArrayList<String> strings, String charset) throws UnsupportedEncodingException
	{
		try (PrintStream out2 = new PrintStream(new OutputStreamLogging(new ILogSink() {
			@Override
			public void println(String tag, String string, Optional<EnumLogLevel> oLogLevel)
			{
				strings.add("[" + tag + "] " + string);
			}

			@Override
			public void println(String tag, Throwable e, Optional<EnumLogLevel> oLogLevel)
			{

			}
		}.logger("Test"), charset), true, charset)) {

			out2.print("あいうえお\nかきく\rけ\r\nこ");
			out2.flush();
			assertEquals(3, strings.size());
			assertEquals("[Test] あいうえお", strings.get(0));
			assertEquals("[Test] かきく", strings.get(1));
			assertEquals("[Test] け", strings.get(2));
			strings.clear();

		}

		assertEquals(1, strings.size());
		assertEquals("[Test] こ", strings.get(0));
		strings.clear();
	}

}
