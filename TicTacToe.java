import java.util.Scanner;
public class TicTacToe {
    static boolean gameNotOver = true;
    public static void main(String[] args) {
        Player playerX;
        Player playerO;
        AI playerAIO;
        Board boardObject = new Board();
        boardObject.printBoard();
        Scanner sc = new Scanner(System.in);
        boolean notValidInput = true;
        String userInput = "";
        boolean isAIGame;
        
        while(notValidInput){
            System.out.println("Type AI for a game against the computer and HUMAN against human");
            String input = sc.nextLine();

            if(input.equals("HUMAN")){
                userInput = input;
                notValidInput = false;
            }

            else if(input.equals("AI")){
                userInput = input;
                notValidInput = false;
            }

            else{
                System.out.println("Enter valid Input");
            }
        }
        
        if(userInput.equals("HUMAN")){
            playerX = new Player();
            playerO = new Player();
            isAIGame = false;

            while(gameNotOver){
        
                playerX.makeMove(boardObject);
                boardObject.printBoard();
                if(boardObject.checkWinningCondition("X").equals("X")){
                    System.out.println("Player X won!");
                    System.exit(0);
                }
    
                playerO.makeMove(boardObject);
               
                boardObject.printBoard();
                if(boardObject.checkWinningCondition("O").equals("O")){
                    System.out.println("Player O won!");
                    System.exit(0);
                }

                if(boardObject.checkWinningCondition("X").equals("tie") || boardObject.checkWinningCondition("O").equals("tie")){
                    System.out.println("It is a tie!");
                    System.exit(0);
                }
            }
            
        }
        else{
            playerX = new Player();
            playerAIO = new AI(); //AI Player

            while(gameNotOver){
        
                playerX.makeMove(boardObject);
                boardObject.printBoard();
                if(boardObject.checkWinningCondition("X").equals("X")){
                    System.out.println("Player X won!");
                    System.exit(0);
                }
    
                playerAIO.bestMove(boardObject);
               
                boardObject.printBoard();
                if(boardObject.checkWinningCondition("O").equals("O")){
                    System.out.println("Player O won!");
                    System.exit(0);
                }

                if(boardObject.checkWinningCondition("O").equals("tie")){
                    System.out.println("There is a tie!");
                    System.exit(0);
                }
            }
        }
        /** 
        while(gameNotOver){
        
            playerX.makeMove(boardObject);
            boardObject.printBoard();
            if(boardObject.checkWinningCondition()){
                System.out.println("Player X won!");
                System.exit(0);
            }

            playerAIO.makeMove();
           
            boardObject.printBoard();
            if(boardObject.checkWinningCondition()){
                System.out.println("Player O won!");
                System.exit(0);
            }
        }*/
    }
}
