# Code Documentation for Tictactoe

Author: Vyshak umeshan
Date: 19th February 2023

## Overview
This program is a simple implementation of Tic Tac Toe game using java. It provides GUI where two players can take turns clicking on a 3×3 grid to place their respective markers (X or O). The first player to place three markers in a row (horizontally, vertically or diagonally) wins the game. If no player wins, the game is considered a draw. The game disables all grids on the player’s win and displays the winner’s name. The game is reset by the restart button.

## Classes
###### Tictactoe Class
This is the main class of the program. It extends the JFrame class and implements the ActionListener interface. It creates the game board and handles the user interactions with it. 
## Fields
###### Private Fields
•	private JButton cell - a reference to a JButton object that represents a cell in the game board.
•	private JButton reset - a reference to a JButton object that represents the reset button.
•	private int i, j, x = 100, y = 100 - integer values that represent the row and column indices for the game board and the x and y coordinates of the top-left corner of each cell.
•	private String player1, player2, curr_player, icon, msg = "", clickedBtnNum - string values that represent the names of the two players, the current player, the icon representing the current player's move, the message to be displayed, and the number of the button that was clicked.
•	private String cells [] [] - a two-dimensional array of strings that represents the state of the game board.
•	private JLabel display - a reference to a JLabel object that displays messages to the user.
•	private boolean over = false, draw = true - boolean values that represent whether the game is over and whether it is a draw.
###### Public Fields
None
## Constructors
###### Tictactoe()
This is the constructor for the Tictactoe class. It sets up the game board, creates the player names, and initializes the game state.
## Methods
###### Private Methods
•	private String getPlayerName(String message) - This method creates a dialog box that prompts the user to enter their name and returns the name entered by the user. It takes a string message as input that is displayed in the dialog box.
•	private void switchPlayer() - This method switches the current player between player 1 and player 2.
•	private void updateCellList(String num, String txt) - This method updates the state of the game board by setting the cell corresponding to the button clicked to the current player's icon.
•	private void setIcon() - This method sets the current player's icon to "X" or "O".
•	private void checkGameState() - This method checks the state of the game to see if it is over or if it is a draw.
•	private void resetState() - This method resets the game to its initial state.
•	private void toggleButtons(boolean state) - This method enables or disables the buttons on the game board depending on the state of the game.
•	private void dispMsg(String message) - This method displays a message to the user.
###### Public Methods
•	public void actionPerformed(ActionEvent e) - This is a required method of the ActionListener interface. It is called when a button is clicked and handles the user's input.
•	public static void main (String args[]) - This is the main method of the program. It creates a new instance of the Tictactoe class and sets up the game window.
