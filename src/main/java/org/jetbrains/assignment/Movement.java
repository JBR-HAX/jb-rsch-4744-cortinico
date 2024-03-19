package org.jetbrains.assignment;

public class Movement {

    private Direction direction;
    private int steps;

    public Movement(Direction direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }
}
