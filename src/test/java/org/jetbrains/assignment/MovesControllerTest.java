package org.jetbrains.assignment;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovesControllerTest {

    @Test
    void testGetMoves_withEmptyCoordinates() {
        List<Movement> moves = MovesController.getMoves(Collections.emptyList());
        assertEquals(0, moves.size());
    }

    @Test
    void testGetMoves_withOneCoordinates() {
        List<Coordinate> coordinates = List.of(new Coordinate(1, 0));
        List<Movement> moves = MovesController.getMoves(coordinates);
        assertEquals(1, moves.size());
        assertEquals(Direction.EAST, moves.get(0).getDirection());
        assertEquals(1, moves.get(0).getSteps());
    }

    @Test
    void testGetMoves_withMultipleCoordinates() {
        List<Coordinate> coordinates = List.of(new Coordinate(1, 0), new Coordinate(1, 3), new Coordinate(0, 3), new Coordinate(0, 0));
        List<Movement> moves = MovesController.getMoves(coordinates);
        assertEquals(4, moves.size());
        assertEquals(Direction.EAST, moves.get(0).getDirection());
        assertEquals(1, moves.get(0).getSteps());
        assertEquals(Direction.NORTH, moves.get(1).getDirection());
        assertEquals(3, moves.get(1).getSteps());
        assertEquals(Direction.WEST, moves.get(2).getDirection());
        assertEquals(1, moves.get(2).getSteps());
        assertEquals(Direction.SOUTH, moves.get(3).getDirection());
        assertEquals(3, moves.get(3).getSteps());
    }
}
