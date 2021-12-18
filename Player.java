import java.util.Scanner;
public class Player{

    static int playerOption = 0;

    String playerType;
    static String[] optionArray = {"X","O"};
    Scanner sc = new Scanner(System.in);

    public Player(){
        playerType = optionArray[playerOption];
        playerOption++;
    }

    public void makeMove(Board board){
        boolean notValid = true;
        while(notValid){
            System.out.println("Player"+" "+playerType+" input row index:");
            int rowIndex = sc.nextInt();

            System.out.println("Now input column index:");
            int colIndex = sc.nextInt();

            if(board.myBoard[rowIndex][colIndex] != "X" && board.myBoard[rowIndex][colIndex] != "O"  && (rowIndex >= 0 && rowIndex <= 2 && colIndex >= 0 && colIndex <= 2)){
                notValid = false;
                board.myBoard[rowIndex][colIndex] = playerType;
            }

            else{
                System.out.println("Not a valid position index. Please try again idiot");
            }
        }
    
    }
}