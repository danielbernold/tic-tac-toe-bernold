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
}
