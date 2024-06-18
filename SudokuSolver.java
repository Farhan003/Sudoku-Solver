public class SudokuSolver {
  
    private static final int GRID_SIZE = 9;
    
    public static void main(String[] args) {
      
        int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
          };
      
      printBoard(board);
      
      if (solve(board)) {
        System.out.println("Solved successfully!");
      }
      else {
        System.out.println("Oh hell nah");
      }
      
      System.out.println("");
      printBoard(board);
      
    }
  
  
    private static boolean isInRow(int[][] board, int number, int row) {
      for (int i = 0; i < GRID_SIZE; i++) {
        if (board[row][i] == number) {
          return true;
        }
      }
      return false;
    }
    
    private static boolean isInColumn(int[][] board, int number, int column) {
      for (int i = 0; i < GRID_SIZE; i++) {
        if (board[i][column] == number) {
          return true;
        }
      }
      return false;
    }
    
    private static boolean isInBox(int[][] board, int number, int row, int column) {
      int localBoxRow = row - row % 3;
      int localBoxColumn = column - column % 3;
      
      for (int i = localBoxRow; i < localBoxRow + 3; i++) {
        for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
          if (board[i][j] == number) {
            return true;
          }
        }
      }
      return false;
    }
    
    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
      return !isInRow(board, number, row) &&
          !isInColumn(board, number, column) &&
          !isInBox(board, number, row, column);
    }
    
    private static boolean solve(int[][] board) {
      for (int row = 0; row < GRID_SIZE; row++) {
        for (int column = 0; column < GRID_SIZE; column++) {
          if (board[row][column] == 0) {
            for (int num = 1; num <= GRID_SIZE; num++) {
              if (isValidPlacement(board, num, row, column)) {
                board[row][column] = num;
                
                if (solve(board)) {
                  return true;
                }
                else {
                  board[row][column] = 0;
                }
              }
            }
            return false;
          }
        }
      }
      return true;
    }
    
    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
          if (row % 3 == 0 && row != 0) {
            System.out.println("-----------");
          }
          for (int column = 0; column < GRID_SIZE; column++) {
            if (column % 3 == 0 && column != 0) {
              System.out.print("|");
            }
            System.out.print(board[row][column]);
          }
          System.out.println();
        }
      }
    
  }
  
  
