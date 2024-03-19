package org.jetbrains.assignment;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationControllerTest {

    @Test
    void testMoveRobot_withEmptyMoves() {
        List<Coordinate> coordinates = LocationController.moveRobot(Collections.emptyList());
        assertEquals(1, coordinates.size());
        assertEquals(0, coordinates.get(0).getX());
        assertEquals(0, coordinates.get(0).getY());
    }

    @Test
    void testMoveRobot_withOneMove() {
        List<Movement> movements = new ArrayList<>();
        movements.add(new Movement(Direction.EAST, 1));
        List<Coordinate> coordinates = LocationController.moveRobot(movements);
        assertEquals(2, coordinates.size());
        assertEquals(0, coordinates.get(0).getX());
        assertEquals(0, coordinates.get(0).getY());
        assertEquals(1, coordinates.get(1).getX());
        assertEquals(0, coordinates.get(1).getY());
    }

    @Test
    void testMoveRobot_withTwoMove() {
        List<Movement> movements = new ArrayList<>();
        movements.add(new Movement(Direction.EAST, 1));
        movements.add(new Movement(Direction.NORTH, 3));
        List<Coordinate> coordinates = LocationController.moveRobot(movements);
        assertEquals(3, coordinates.size());
        assertEquals(0, coordinates.get(0).getX());
        assertEquals(0, coordinates.get(0).getY());
        assertEquals(1, coordinates.get(1).getX());
        assertEquals(0, coordinates.get(1).getY());
        assertEquals(1, coordinates.get(2).getX());
        assertEquals(3, coordinates.get(2).getY());
    }
}
