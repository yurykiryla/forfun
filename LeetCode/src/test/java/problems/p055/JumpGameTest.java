package problems.p055;

import org.junit.jupiter.api.BeforeEach;

import problems.p055.JumpGame;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    private JumpGame jumpGame;

    @BeforeEach
    public void init() {
        jumpGame = new JumpGame();
    }

    @org.junit.jupiter.api.Test
    void canJump() {
        int[] array = {2, 3, 1, 1, 4};
        assertTrue(jumpGame.canJump(array));
    }

    @org.junit.jupiter.api.Test
    void cannotJump() {
        int[] array = {3, 2, 1, 0, 4};
        assertFalse(jumpGame.canJump(array));
    }
}