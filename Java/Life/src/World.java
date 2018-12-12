/****************************************************************************
// Copyright (c) 2018, Construx Software, Inc., All Rights Reserved.
//
// This code is the exclusive property of Construx Software, Inc. It may ONLY 
// be used by learners during Construx's workshops or by individuals who are 
// being coached by Construx on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Construx Software, Inc.
// ***************************************************************************/

/**
 * @author melvinperez
 *
 */
public class Life {
	private static final int DEAD_CELL = 0;
	private static final int LIVE_CELL = 1;
	private int[][] matrix;
	private int numberOfRows;
	private int numberOfColumns;

	public Life(int numberOfRows, int numberOfColumns) {
		matrix = new int[numberOfRows + 2][numberOfColumns + 2];
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
	}

	public void setLiveCellAt(int row, int column) {
		matrix[row][column] = LIVE_CELL;
	}

	public void tick() {
		int[][] nextGeneration = new int[numberOfRows + 2][numberOfColumns + 2];

		for (int row = 1; row < this.numberOfRows + 1; row++) {
			for (int column = 1; column < this.numberOfColumns + 1; column++) {
				if (isAlive(row, column)) {
					if (liveNeighbors(row, column) == 2 || liveNeighbors(row, column) == 3)
						nextGeneration[row][column] = LIVE_CELL;
					else
						nextGeneration[row][column] = DEAD_CELL;
				} else if (liveNeighbors(row, column) == 3) {
					nextGeneration[row][column] = LIVE_CELL;
				}
			}
		}

		this.matrix = nextGeneration.clone();
	}

	private int liveNeighbors(int currentRow, int currentColumn) {
		int liveNeighbors = 0;

		for (int row = currentRow - 1; row <= currentRow + 1; row++) {
			for (int column = currentColumn - 1; column <= currentColumn + 1; column++) {
				if (row == currentRow && column == currentColumn)
					continue;
				if (isAlive(row, column))
					liveNeighbors++;
			}
		}
		return liveNeighbors;
	}

	public Boolean isAlive(int row, int column) {
		return matrix[row][column] == LIVE_CELL;
	}

	/**
	 * @return
	 */
	public String dashboard() {
		StringBuilder lifeBoard = new StringBuilder();
		for (int row = 1; row < this.numberOfRows + 1; row++) {
			for (int column = 1; column < this.numberOfColumns + 1; column++) {
				lifeBoard.append("|");
				if (matrix[row][column] == LIVE_CELL)
					lifeBoard.append("*");
				else
					lifeBoard.append(".");
			}
			lifeBoard.append("|\n");
		}
		return lifeBoard.toString();
	}
}
