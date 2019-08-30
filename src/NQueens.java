public class NQueens {
    int size;
    int[][] board;

    public NQueens(int size){
        this.size = size;
        this.board = new int[size][size];
    }

    /**
     * Utility function that prints the solution
     * @param board Dimensions of the board
     */
    public void printSolution(int board[][]){
        for(int i=0; i < size; i++){
            for(int j=0; j<size; j++){
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean canPlaceQueen(int row, int col){
        int i, j;

        // Check for queens in the same row to the left of board[row][col]
        for(i=0; i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        // Check for queens in upper diagonal relative to board[row][col]
        for(i=row,j=col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        for(i=row,j=col; i < size && j>= 0; i++, j-- ){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    // Place queens
    boolean placeNQueens(int col) throws Exception{
        if(size < 1){
            throw new Exception("Board size cannot be smaller than 1");
        }
        // Base case: If all queens are placed, return true
        if(col >= size){
            return true;
        }

        // Try to place a queen in all rows one by one
        for(int i=0; i < size; i++){
            // Check if queen can be placed on board[i][col]
            if(canPlaceQueen(i, col)){
                // Place a queen at board[i][col]
                board[i][col] = 1;

                // recursively call function to place rest of queens
                if(placeNQueens(col+1)){
                    return true;
                }
                /* If placing queen at board[i][col] doesn't lead to solution,
                   remove queen from board[i][col] (backtrack) */
                board[i][col] = 0;
            }
        }
        return false;
    }


    public static void main(String[] args){
        NQueens queens = new NQueens(5);
        try{
            queens.placeNQueens(0);
        } catch (Exception e){
            System.out.println("Mistakes were made");
        }
        queens.printSolution(queens.board);

    }
}
