import java.util.ArrayList;
import java.math.*;
public class AI extends Player{

    int bestScore = -100000;
    int[] bestMove = new int[2];
    static ArrayList<int[]> remainingMoveLists;
    public AI(){
        super();
    }



    public void bestMove(Board boardObject){
        // AI to make its turn
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {0,0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Is the spot available?
                if (boardObject.myBoard[i][j] == " ") {
                    

                    Board.myBoard[i][j] = "O";
                    int score = miniMax(boardObject, 0, "X");

                    System.out.println("Move:"+i+","+j);
                    System.out.println("score:"+score);
                    System.out.println(" ");
                    
                    boardObject.myBoard[i][j] = " ";

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
            }
            }
        }
        System.out.println("best score:"+bestScore);
        boardObject.myBoard[bestMove[0]][bestMove[1]] = "O";
    }


    static int miniMax(Board boardObject,int depth, String isMax){
        String player;
        if(isMax.equals("O")){
            player = "O"; //O is maximising state
        }
        else{
            player = "X"; //X is minimising state
        }
        String result = boardObject.checkWinningCondition(player);
        

        if(!result.equals("No Win")){
            int score;
            if(result.equals("O")){
                score = 10;
            }
            else if(result.equals("X")){
                score = -10;
            }
            else{
                score = 0;
            }
            //System.out.println("Result:"+result);
            return score; 
        }

        if(isMax.equals("O")){
            //Maximising player
            int bestScore = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){

                    if (boardObject.myBoard[i][j].equals(" ")) {
                        boardObject.myBoard[i][j] = "O";

                        int score = miniMax(boardObject, depth + 1, "X");
                        boardObject.myBoard[i][j] = " ";

                        bestScore = Math.max(score, bestScore);
                        
                      }
                }
            }
            return bestScore;
        }

        else{

            //Minimising player
            int bestScore = Integer.MAX_VALUE;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if (boardObject.myBoard[i][j].equals(" ")) {
                        boardObject.myBoard[i][j] = "X";
                        int score = miniMax(boardObject, depth + 1, "O");

                        
                        boardObject.myBoard[i][j] = " ";
                        bestScore = Math.min(score, bestScore);  
                      }
                }
            }
            return bestScore;
        }

        
    }

}