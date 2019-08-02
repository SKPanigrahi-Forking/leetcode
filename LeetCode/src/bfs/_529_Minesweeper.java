package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Problem:
 * 
 * Let's play the minesweeper game (Wikipedia, online game)! You are given a 2D
 * char matrix representing the game board. 'M' represents an unrevealed mine,
 * 'E' represents an unrevealed empty square, 'B' represents a revealed blank
 * square that has no adjacent (above, below, left, right, and all 4 diagonals)
 * mines, digit ('1' to '8') represents how many mines are adjacent to this
 * revealed square, and finally 'X' represents a revealed mine.
 * 
 * Now given the next click position (row and column indices) among all the
 * unrevealed squares ('M' or 'E'), return the board after revealing this
 * position according to the following rules:
 * 
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * 
 * If an empty square ('E') with no adjacent mines is revealed, then change it
 * to revealed blank ('B') and all of its adjacent unrevealed squares should be
 * revealed recursively.
 * 
 * If an empty square ('E') with at least one adjacent mine is revealed, then
 * change it to a digit ('1' to '8') representing the number of adjacent mines.
 * 
 * Return the board when no more squares will be revealed. Example 1: Input:
 * 
 * [['E', 'E', 'E', 'E', 'E'],
 * 
 * ['E', 'E', 'M', 'E', 'E'],
 * 
 * ['E', 'E', 'E', 'E', 'E'],
 * 
 * ['E', 'E', 'E', 'E', 'E']]
 * 
 * Click : [3,0]
 * 
 * Output:
 * 
 * [['B', '1', 'E', '1', 'B'],
 * 
 * ['B', '1', 'M', '1', 'B'],
 * 
 * ['B', '1', '1', '1', 'B'],
 * 
 * ['B', 'B', 'B', 'B', 'B']]
 * 
 * Note: The range of the input matrix's height and width is [1,50]. The click
 * position will only be an unrevealed square ('M' or 'E'), which also means the
 * input board contains at least one clickable square. The input board won't be
 * a stage when game is over (some mines have been revealed). For simplicity,
 * not mentioned rules should be ignored in this problem. For example, you don't
 * need to reveal all the unrevealed mines when the game is over, consider any
 * cases that you will win the game or flag any squares.
 *
 * Solution:
 * 
 * If click on a mine ('M'), mark it as 'X', stop further search.
 * 
 * If click on an empty cell ('E'), depends on how many surrounding mine:
 * 
 * 2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop
 * further search.
 * 
 * 2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
 * 
 */
public class _529_Minesweeper {
	private int[][] POINTS = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	public char[][] updateBoard(char[][] board, int[] click) {
		if (board == null || click == null) {
			return null;
		}
		char c = board[click[0]][click[1]];
		if (c == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}
		int rows = board.length;
		int cols = board[0].length;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(click[0] * cols + click[1]);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int row = cur / cols;
			int col = cur % cols;
			int count = 0;
			for (int i = 0; i < POINTS.length; i++) {
				int newRow = row + POINTS[i][0];
				int newCol = col + POINTS[i][1];
				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 'M') {
					count++;
				}
			}
			if (count > 0) {
				board[row][col] = (char) (count + '0');
			} else {
				board[row][col] = 'B';
				for (int i = 0; i < POINTS.length; i++) {
					int newRow = row + POINTS[i][0];
					int newCol = col + POINTS[i][1];
					if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 'E') {
						board[newRow][newCol] = 'B';
						queue.offer(newRow * cols + newCol);
					}
				}
			}

		}
		return board;
	}
}
