package org.test;

public class Iislands {


	static int rows;
	static int cols;
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		rows = grid.length;
		cols = grid[0].length;

		int islands = 0;

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < cols; ++c) {
				if(grid[r][c] == '1') {
					DFSMarking(grid, r, c);
					islands++;
				}
			}
		}
		return islands;
	}



	private static void DFSMarking(char[][] grid, int r, int c) {
		if(r<0 || c<0 || r> rows||c>cols ||grid[r][c]!='1') return;
		grid[r][c]='2';
		DFSMarking(grid, r+1, c);
		DFSMarking(grid, r-1, c);
		DFSMarking(grid, r, c+1);
		DFSMarking(grid, r, c-1);
	}



	public static void main(String[] args) {
		char grid[][] = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		numIslands(grid);
	}
}
