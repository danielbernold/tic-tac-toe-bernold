import java.util.Scanner;

public class Main {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hauptspiel-Schleife (unendlich – Spielende später)
        while (true) {
            printBoard();
            System.out.println("Current Player: " + currentPlayer);

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            // Prüfen, ob Feld frei ist
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                // Spieler wechseln
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Field already taken! Try again.");
            }

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                if (checkWinner(board, currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Spieler wechseln
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    // Spielfeld anzeigen
    public static void printBoard() {
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔▔▔");
    }

    public static boolean checkWinner(char[][] board, char player) {
        // Zeilen & Spalten prüfen
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true; // Zeile
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true; // Spalte
        }
        // Diagonalen prüfen
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }
}
