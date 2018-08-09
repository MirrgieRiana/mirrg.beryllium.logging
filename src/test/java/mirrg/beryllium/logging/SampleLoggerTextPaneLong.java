package mirrg.beryllium.logging;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import mirrg.beryllium.logging.core.LogSinkTextPane;

public class SampleLoggerTextPaneLong
{

	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();

		ILogDistributor logDistributor = ILogDistributor.of(ILogSink.fromPrintStream(System.out));
		ILogger logger = logDistributor.logger("Test");

		frame.setLayout(new BorderLayout());
		LogSinkTextPane logSinkTextPane = new LogSinkTextPane(50);
		logDistributor.registerLogSink(logSinkTextPane);
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
