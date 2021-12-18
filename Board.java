public class Board {
    static String winner;
    static String[][] myBoard;

    public Board(){
       generateBoard();
    }

    //Initialises Board
    public static void generateBoard(){
        myBoard = new String[3][3];

        for(int row = 0; row < 3;row++){
            for(int col = 0; col < 3;col++){
                myBoard[row][col] = " ";
            }
        }
    }

    public static boolean areThereRemainingMoves(){
        for(int i = 0;i < 3; i++){
            for(int j = 0;j < 3; j++){
                if(myBoard[i][j] == " "){
                    return true;
                }
            }
        }
        return false;
    }

    //Prints Board
    public void printBoard(){
        System.out.println(" "+0 + "    " + 1 + "    " + 2);
        for(int row = 0;row < 3;row++){
            System.out.print(row);
            for(int col = 0;col < 3;col++){
                
                if(col != 2){
                    if(myBoard[row][col] != null){
                        System.out.print("   "+myBoard[row][col]+"|");
                    }
                    else{
                        System.out.print("    "+"|");
                    }
                }

                else{
                    if(myBoard[row][col] != null){
                        System.out.print("   "+myBoard[row][col]);
                    }
                    else{
                        System.out.print(" ");
                    }
                }    
            }
            System.out.println();

            if(row != 2){
                System.out.println(" "+"----|----|----");
            }
            
        }
    }

    public String checkWinningCondition(String player){

        int winCounter = 0;
        String previousValue = "A";
        //Left Right Conditions
        for(int row = 0; row < 3;row++){
            for(int col = 0; col < 3;col++){
                if(myBoard[row][col].equals(player)){
                    if(winCounter == 0){
                        previousValue = myBoard[row][col];
                        winCounter++;
                    }
                    else{
                        if(myBoard[row][col].equals(previousValue)){
                            winCounter++;
                        }
                    }
                }
            }
            if(winCounter == 3){
                return player;
            }
            else{
                winCounter = 0;
                previousValue = "A";
            }
        }
        //Top Down conditions
        for(int col = 0;col < 3;col++){
            for(int row = 0;row < 3;row++){

                if(myBoard[row][col].equals(player)){
                    if(winCounter == 0){
                        previousValue = myBoard[row][col];
                        winCounter++;
                    }

                    else{
                        if(myBoard[row][col].equals(previousValue)){
                            winCounter++;
                        }
                    }
                }
            }

            if(winCounter == 3){
                return player;
            }
            else{
                winCounter = 0;
                previousValue = "A";
            }
        }

        //Diagonals
        for(int sameIndex = 0; sameIndex < 3; sameIndex++){
            if(myBoard[sameIndex][sameIndex].equals(player)){
                if(winCounter == 0){
                    previousValue = myBoard[sameIndex][sameIndex];
                    winCounter++;
                }
                else{
                    if(myBoard[sameIndex][sameIndex].equals(previousValue)){
                        winCounter++;
                    }
                }
            }
        }

        if(winCounter == 3){
            return player;
        }
        else{
            winCounter = 0;
            previousValue = "A";
        }

        for(int opposingIndex = 2; opposingIndex >= 0; opposingIndex--){
            if(myBoard[opposingIndex][2-opposingIndex].equals(player)){
                if(winCounter == 0){
                    previousValue = myBoard[opposingIndex][2-opposingIndex];
                    winCounter++;
                }
                else{
                    if(myBoard[opposingIndex][2-opposingIndex].equals(previousValue)){
                        winCounter++;
                    }
                }
            }
        }

        if(winCounter == 3){
            return player;
        }
        else if(winCounter != 3 && areThereRemainingMoves() == false){
            return "tie";
        }
        else{
            return "No Win";
        }
    }
}
