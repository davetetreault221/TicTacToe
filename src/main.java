
//@author Dave Tetreault

import java.util.Scanner;

public class main {


    public static void main(String args[])
    {

        //Starting the game
        //*******************************************
        TicTacToe game = new TicTacToe();
        game.printBoard();
        Scanner userInput = new Scanner(System.in);
        String playAgain = "yes";
        //*******************************************

        while(playAgain.equals("yes")) {

            //Main Game Running
            //**************************************************************************************
            do {

                System.out.println("It is currently " + game.currentPlayer + "'s turn");

                System.out.print(game.currentPlayer + " Please enter a row: ");
                int row = userInput.nextInt();

                System.out.print(game.currentPlayer + " Please enter a col: ");
                int col = userInput.nextInt();

                if (!game.playMove(row, col, game.currentPlayer)) {
                    //The move was bad
                    System.out.println(game.currentPlayer + " the move is invalid, please try again");
                    System.out.println();
                }


                game.printSpace();
                game.printBoard();

            }
            while (!game.checkWinner() && !game.checkFullBoard());
            //**************************************************************************************


            //Game Over
            //**************************************************************************************
            if (game.checkFullBoard() && !game.checkWinner()) {
                //The game is a tie
                System.out.println("The Game was a tie!");
            }

            if (game.checkWinner()) {
                game.playerSwitch();
                System.out.println(game.currentPlayer + " you have won the game!");
            }


            System.out.println("Would you like to play again? (Yes/No)");
            userInput.nextLine();
            playAgain = userInput.nextLine().toLowerCase();

            if(playAgain.equals("yes")) {

                game.setBoard();
                game.printBoard();
            }
            else
            {
                System.out.println("Thank you for playing!");
            }
            //**************************************************************************************
        }

    }
}
