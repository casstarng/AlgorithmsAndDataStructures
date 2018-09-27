package CC;

public class Moderate4 {

    public static boolean someoneWon(int[][] board){
        //Check vertical
        for(int i = 0; i < board[0].length; i++){
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }

        //Check horizontal
        for(int i = 0; i < board.length; i++){
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
        }

        //Check Cross
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;

        return false;
    }

    public static void main(String[] args){
        int[][] board = new int[3][3];
    }
}
