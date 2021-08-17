package ru.job4j.chess.firuges.black;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {
    @Test
    public void whetCheckPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void whenCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack = bishopBlack.copy(Cell.D2);
        assertThat(bishopBlack.position(), is(Cell.D2));
    }

    @Test
    public void whenWayIsDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, cells);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMove() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.C2);
    }

    @Test
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertFalse("Not a diagonale", bishopBlack.isDiagonal(bishopBlack.position(), Cell.A1));
    }
}