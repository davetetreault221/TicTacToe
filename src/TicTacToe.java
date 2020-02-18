
//@author Dave Tetreault

public class TicTacToe {


    private String board[][] = new String[3][3];

    final String player1 = "Player 1";
    final String player2 = "Player 2";

    String currentPlayer = player1;

    TicTacToe()
    {

        System.out.println("--------------------");
        System.out.println("Welcome to the TicTacToe Game");
        System.out.println();
        System.out.println("The following are the rules on how to play:");
        System.out.println("1. The Rows and Columns entered must be between [0-2] ");
        System.out.println("2. Rows go up and down starting at 0");
        System.out.println("3. Columns go left and right starting at 0");
        System.out.println("Enjoy :)");
        System.out.println("--------------------");
        System.out.println();


        setBoard();
    }

    //Sets the main board
    //********************************************************
    void setBoard()
    {
        //Initialize the board to empty
        for(int i = 0; i < 3; i++)
        {
            for(int z = 0; z < 3; z++)
            {
                board[i][z] = "---";
            }
        }
    }
    //********************************************************


    //Validates a players move
    //********************************************************
    boolean playMove(int row, int col, String player)
    {
       try {

           if (board[row][col].equals("---")) {
               //The Move is valid

               if (player.equals(player1)) {
                   //Place X
                   board[row][col] = "-X-";
                   playerSwitch();
               } else {
                   board[row][col] = "-O-";
                   playerSwitch();

               }

               return true;

           } else {
               return false;
           }
       }
       catch(ArrayIndexOutOfBoundsException e)
       {
           System.out.println("Please enter only digits from [0-2]");
           return false;
       }
    }
    //********************************************************

    void printSpace()
    {
        System.out.println();
        System.out.println();
    }

    //Switches the current player
    //********************************************************
    void playerSwitch()
    {
        if(currentPlayer.equals(player1))
        {
            currentPlayer = player2;
        }
        else
        {
            currentPlayer = player1;
        }
    }
    //********************************************************


    //Prints the board to the screen
    //********************************************************
    void printBoard()
    {
        System.out.println("Current Board Layout");

        System.out.println("--------------------");

        for(int i = 0; i < 3; i++)
        {
            for(int z = 0; z < 3; z++)
            {
                System.out.print(board[i][z]);
                System.out.print("     ");
            }

            System.out.println();
        }

        System.out.println("--------------------");

    }
    //********************************************************

    //Checks if there is a winning situation
    //********************************************************
    boolean checkWinner()
    {
        if(checkDiag() || checkCol() || checkRow())
        {
            return true;
        }

        return false;
    }
    //********************************************************


    //Checks if there is a winner in diagonal
    //********************************************************\
    boolean checkDiag()
    {

        boolean check = true;

        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) )
        {
            for(int i =0; i < 3; i++)
            {
                if(board[i][i].equals("---"))
                {
                    check = false;
                }
            }

            if(check) {
                return true;
            }
        }

        if(board[0][2].equals(board[1][1]) && board[2][0].equals(board[2][0]) )
        {

            for(int i =0; i < 3; i++)
            {
                if(board[i][2-i].equals("---"))
                {
                    check = false;
                }
            }

            if(check) {
                return true;
            }
        }

        return false;
    }
    //********************************************************


    //Checks if there is winner in the rows
    //********************************************************
    boolean checkRow()
    {
        boolean check;

        for(int i = 0; i < 3; i++)
        {

            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]))
            {
                check = true;

                for(int z =0; z < 3; z++)
                {
                    if(board[i][z].equals("---"))
                    {
                        check = false;
                    }
                }

                if(check) {
                    return true;
                }
            }
        }

        return false;
    }
    //********************************************************


    //Checks if there is a winner in the columns
    //********************************************************
    boolean checkCol()
    {

        boolean check;

        for(int i = 0; i < 3; i++)
        {

            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]))
            {
                check = true;

                for(int z =0; z < 3; z++)
                {
                    if(board[z][i].equals("---"))
                    {
                        check = false;
                    }
                }

                if(check) {
                    return true;
                }
            }
        }

        return false;
    }
    //********************************************************


    //Checks if the Board is full
    //********************************************************
    boolean checkFullBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int z = 0; z < 3; z++)
            {
                if(board[i][z].equals("---"))
                {
                    return false;
                }
            }
        }

        return true;
    }
    //********************************************************

}
