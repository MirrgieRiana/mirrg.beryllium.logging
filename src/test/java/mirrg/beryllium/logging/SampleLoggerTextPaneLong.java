package mirrg.beryllium.logging;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SampleLoggerTextPaneLong
{

	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();

		LogSinkRelay logSink = new LogSinkRelay();
		logSink.addLogSink(new LogSinkPrintStream(System.out));

		TaggedLogger logger = new TaggedLogger("Test", logSink);

		frame.setLayout(new BorderLayout());
		LogSinkTextPane logSinkTextPane = new LogSinkTextPane(50);
		logSink.addLogSink(logSinkTextPane);
		logSinkTextPane.scrollPane.setPreferredSize(new Dimension(300, 200));
		frame.add(logSinkTextPane.component);

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		while (true) {
			logger.info("Line Line Line Line Line Line Line Line Line Line Line Line");
			Thread.sleep(100);
		}
	}

}
