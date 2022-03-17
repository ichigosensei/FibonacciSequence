# FibonacciSequence

A problem was given to define the runtime efficiency of each recursive and iterative Fibonacci function. Then put the results in a chart with time in the Y axis and inputs on the X axis. (Please use nanosecond.  long startTime = System.nanoTime(); This chart must not be hand written.)


# Design Documentation
  
The Recursive Function for Fibonacci executes like this: Checks if the number is either 0 or 1 then initiates a return. If not, it repeats until all the functions returns to 0 or 1.

     public static long fiboRecursive (long n) { // Recursive Method
		if (n == 0) {
			return n;

		} if (n == 1) {
			return n;
		} else

			return fiboRecursive (n - 1) + fiboRecursive (n -2);
	}

The Recursive Function Example:

![image](https://user-images.githubusercontent.com/97814957/158715912-404f70c2-ee60-47c3-8e49-27ec44c8439b.png)

  Then Iterative Function for Fibonacci is also created.
  
    public static long fiboIterative (long n) { // Iterative Method
	
		int iterativeNumber;
		int iNum = 0;
		int newIterativeNum = 1;

		for (int i = 1; i < n; i++) {
			iterativeNumber = iNum;
			iNum = newIterativeNum;
			newIterativeNum = iterativeNumber + iNum;

		} return newIterativeNum;

# Graphing and Output

 The Graphing of The Recursive vs. Iterative Fibonacci Functions start with a creation of a Frame and Main Panel which will produce the output in the form of a line graph called "Recursive vs. Iterative Fibonacci".
 
          FibonacciSequence mainPanel = new FibonacciSequence(fiboTimes); // Creating the main panel for the graph

		      JFrame fsgGraph = new JFrame("Recursive vs. Iterative Fibonacci"); // Naming the Frame Window for the Graph
		      fsgGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      fsgGraph.getContentPane().add(mainPanel);
		      fsgGraph.pack();
		      fsgGraph.setLocationByPlatform(true);
		      fsgGraph.setVisible(true);
          
 From there you will need to input the time in nanoseconds for both the Recursive and Iterative functions and show it in the graph. I produced this output when running the code. 
 
 <img width="498" alt="graph" src="https://user-images.githubusercontent.com/97814957/158716983-c5c7ec3f-5c55-4125-bd08-433e8c0e7263.PNG">
