package com.programming.stacksQueues;

/*
 * https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 */
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class RottenOranges {

	public static void main(String[] args) {
		int arr[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
		System.out.println("Minimum time required to rot all oranges : " + getMinRotTime(arr, arr.length, arr[0].length));
	}

	public static int getMinRotTime(int[][] mat, int rows, int cols) {
		int totalTime = 0;
		// Create a queue that will hold rotten oranges
		// separated by a delimiter after each time unit
		Queue<Point> q = new LinkedList<>();

		// Insert all the oranges that are rotten initially
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == 2)
					q.add(new Point(i, j));
			}
		}

		// add the delimiter to mark the rotten oranges
		// for first time unit
		q.add(new Point(-1, -1));

		while (!q.isEmpty()) {
			// Flag that holds whether any oranges were rotten in the
			// current time frame
			boolean flag = false;
			// Loop while the delimiter is not reached
			while (!isDelimiter(q.peek())) {
				Point temp = q.remove();
				// Check for the right orange
				if (isValid(temp.x + 1, temp.y, rows, cols)
						&& mat[temp.x + 1][temp.y] == 1) {
					if (flag == false) {
						flag = true;
						totalTime++;
					}
					// Add the right orange to the queue
					q.add(new Point(temp.x + 1, temp.y));
					// Make the right orange rotten
					mat[temp.x + 1][temp.y] = 2;

				}
				// Check for left orange
				if (isValid(temp.x - 1, temp.y, rows, cols)
						&& mat[temp.x - 1][temp.y] == 1) {
					if (flag == false) {
						flag = true;
						totalTime++;
					}
					// Add the right orange to the queue
					q.add(new Point(temp.x - 1, temp.y));
					// Make the left orange rotten
					mat[temp.x - 1][temp.y] = 2;
				}
				// Check for upper orange
				if (isValid(temp.x, temp.y - 1, rows, cols)
						&& mat[temp.x][temp.y - 1] == 1) {
					if (flag == false) {
						flag = true;
						totalTime++;
					}
					// Add the right orange to the queue
					q.add(new Point(temp.x, temp.y - 1));
					// Make the right orange rotten
					mat[temp.x][temp.y - 1] = 2;
				}

				// Check for lower orange
				if (isValid(temp.x, temp.y + 1, rows, cols)
						&& mat[temp.x][temp.y + 1] == 1) {
					if (flag == false) {
						flag = true;
						totalTime++;
					}
					// Add the right orange to the queue
					q.add(new Point(temp.x, temp.y + 1));
					// Make the right orange rotten
					mat[temp.x][temp.y + 1] = 2;
				}
			}

			// Remove the delimiter
			q.remove();
			// If some rotten oranges were added to the queue
			// add a delimiter
			if (!q.isEmpty())
				q.add(new Point(-1, -1));
		}

		// Return total time only in case all the oranges were rotten
		return checkOranges(mat, rows, cols) == true ? totalTime : -1;
	}

	private static boolean checkOranges(int[][] mat, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	private static boolean isValid(int i, int j, int rows, int cols) {
		return (i >= 0 && j >= 0 && i < rows && j < cols);
	}

	private static boolean isDelimiter(Point peek) {
		return (peek.x==-1 && peek.y==-1);
	}

}
