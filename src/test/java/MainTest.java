import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testWinningRow() {
        char[][] board = {
                {'X', 'X', 'X'},
                {' ', 'O', ' '},
                {'O', ' ', ' '}
        };
        assertTrue(Main.checkWinner(board, 'X'));
    }

    @Test
    public void testNoWinner() {
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };
        assertFalse(Main.checkWinner(board, 'X'));
        assertFalse(Main.checkWinner(board, 'O'));
    }

    @Test
    public void testWinningDiagonal() {
        char[][] board = {
                {'O', 'X', 'X'},
                {' ', 'O', ' '},
                {'X', ' ', 'O'}
        };
        assertTrue(Main.checkWinner(board, 'O'));
    }
}