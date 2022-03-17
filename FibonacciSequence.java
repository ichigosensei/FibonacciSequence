//Created By: Trinidad, Strawberry Ann
//Date: March 16, 2022
//Subject: Software Development
//Notes: I was unable to complete the required line graphing since the output did not match the computations within the sequence...
//... I am aware of uncompleted work submitted. 

package SoftwareDevelopment;

//Importing needed packages for graph
import javax.swing.*;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class FibonacciSequence extends JPanel {
	
	//Setting how the graph will look
	private static final int totalNumTime = 50;
	   private static final int frameLength = 800;
	   private static final int frameWidth = 650;
	   private static final int graphLines = 30;
	   private static final Color graphColor = Color.black;
	   private static final Color graphPointColor = Color.red;
	   private static final Stroke graphingLines = new BasicStroke(2f);
	   private static final int pointDiameter = 10;
	   private static final int pointCenter = 10;
	   private static List<Integer> fiboGraph;

	   public FibonacciSequence(List<Integer> fiboGraph) {
	      this.fiboGraph = fiboGraph;
	   }

	public static long fiboRecursive (long n) { // Recursive Method
		if (n == 0) {
			return n;

		} if (n == 1) {
			return n;
		} else

			return fiboRecursive (n - 1) + fiboRecursive (n -2);
	}

	public static long fiboIterative (long n) { // Iterative Method
	
		int iterativeNumber;
		int iNum = 0;
		int newIterativeNum = 1;

		for (int i = 1; i < n; i++) {
			iterativeNumber = iNum;
			iNum = newIterativeNum;
			newIterativeNum = iterativeNumber + iNum;

		} return newIterativeNum;
	}
	
	@Override
	   protected void paintComponent(Graphics fiboSequence) { //creating the X and Y axis points
	      super.paintComponent(fiboSequence);
	      Graphics2D fiboGraphing = (Graphics2D)fiboSequence;
	      fiboGraphing.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	      double axisX = ((double) getWidth() - 2 * graphLines) / (fiboGraph.size() - 1);
	      double axisY = ((double) getHeight() - 2 * graphLines) / (totalNumTime - 1);

	      List<Point> graphPoints = new ArrayList<Point>();
	      for (int i = 0; i < fiboGraph.size(); i++) {
	         int pg1 = (int) (i * axisX + graphLines);
	         int pg2 = (int) ((totalNumTime - fiboGraph.get(i)) * axisY + graphLines);
	         graphPoints.add(new Point(pg1, pg2));
	      }

	      // Drawing the X and Y axis
	      fiboGraphing.drawLine(graphLines, getHeight() - graphLines, graphLines, graphLines);
	      fiboGraphing.drawLine(graphLines, getHeight() - graphLines, getWidth() - graphLines, getHeight() - graphLines);

	      
	      for (int i = 0; i < pointCenter; i++) { 
	         int g1 = graphLines;
	         int g2 = pointDiameter + graphLines;
	         int g3 = getHeight() - (((i + 1) * (getHeight() - graphLines * 2)) / pointCenter + graphLines);
	         int g4 = g3;
	         fiboGraphing.drawLine(g1, g3, g2, g4);
	      }

	      
	      for (int i = 0; i < fiboGraph.size() - 1; i++) {
	         int p1 = (i + 1) * (getWidth() - graphLines * 2) / (fiboGraph.size() - 1) + graphLines;
	         int p2 = p1;
	         int p3 = getHeight() - graphLines;
	         int p4 = p3 - pointDiameter;
	         fiboGraphing.drawLine(p1, p3, p2, p4);
	      }

	      Stroke frameGraph = fiboGraphing.getStroke();
	      fiboGraphing.setColor(graphColor);
	      fiboGraphing.setStroke(graphingLines);
	      for (int i = 0; i < graphPoints.size() - 1; i++) {
	         int gp1 = graphPoints.get(i).x;
	         int gp2 = graphPoints.get(i).y;
	         int gp3 = graphPoints.get(i + 1).x;
	         int gp4 = graphPoints.get(i + 1).y;
	         fiboGraphing.drawLine(gp1, gp2, gp3, gp4);         
	      }

	      fiboGraphing.setStroke(frameGraph);      
	      fiboGraphing.setColor(graphPointColor);
	      for (int i = 0; i < graphPoints.size(); i++) {
	         int xPoint = graphPoints.get(i).x - pointDiameter / 2;
	         int yPoint = graphPoints.get(i).y - pointDiameter / 2;;
	         int pointGraph1 = pointDiameter;
	         int pointGraph2 = pointDiameter;
	         fiboGraphing.fillOval(xPoint, yPoint, pointGraph1, pointGraph2);
	      }
	   }

	   @Override
	   public Dimension getPreferredSize() { // Getting the frame length and width
	      return new Dimension(frameLength, frameWidth);
	   }

	   private static void fibonacciGraphed() { // Graphing the sequences
		      List<Integer> fiboTimes = new ArrayList<Integer>();
		      Random random = new Random();
		      int maxDataPoints = 50;
		      int maxScore = 4;
		      for (int i = 0; i < maxDataPoints ; i++) {
		    	  fiboTimes.add(random.nextInt(maxScore));
		      }
		      
		      FibonacciSequence mainPanel = new FibonacciSequence(fiboTimes); // Creating the main panel for the graph

		      JFrame fsgGraph = new JFrame("Recursive vs. Iterative Fibonacci"); // Naming the Frame Window for the Graph
		      fsgGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      fsgGraph.getContentPane().add(mainPanel);
		      fsgGraph.pack();
		      fsgGraph.setLocationByPlatform(true);
		      fsgGraph.setVisible(true);
		   }
	public static void main(String[] args) { // Main Start
		
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 fibonacciGraphed();
	         }
	      });
	
		double[] recursiveTimes = new double[50];
		double[] recursiveInputs = new double[50];

		for(int i = 0; i < 50; i++) {
			System.out.println("Graphing: " + i);

			long timeBegins = System.nanoTime();
			fiboRecursive(i);
			long timeEnds = System.nanoTime();
			var totalTimes = timeEnds - timeBegins;

			recursiveInputs[i] = i;
			recursiveTimes[i] = totalTimes;

	}

		double[] iterativeTimes = new double[50];
		double[] iterativeInputs = new double[50];

		for(int i = 0; i < 50; i++) {

			long timeBegins = System.nanoTime();
			fiboIterative(i);
			long timeEnds = System.nanoTime();
			var totalTimes = timeEnds - timeBegins;

			iterativeInputs[i] = i;
			iterativeTimes[i]= totalTimes;

		}

		System.out.println("\nFinalized computations!");

		}
} 