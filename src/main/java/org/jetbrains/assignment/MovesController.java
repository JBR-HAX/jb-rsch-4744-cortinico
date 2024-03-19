package org.jetbrains.assignment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovesController {

    // Receives a list of locations and outputs a list of robot moves to visit all locations. Assume that the starting location of the robot is the first in the input list.
    //
    //Example of a curl command to test your implementation:
    //
    //curl --header "Content-Type: application/json" \
    //  --request POST \
    //  --data '[{"x": 0, "y": 0}, {"x": 1, "y": 0}, {"x": 1, "y": 3}, {"x": 0, "y": 3}, {"x": 0, "y": 0}]' \
    //  http://localhost:8080/moves
    //Result:
    //
    //[{"direction":"EAST","steps":1},{"direction":"NORTH","steps":3},{"direction":"WEST","steps":1},{"direction":"SOUTH","steps":3}]
    @PostMapping("/moves")
    @ResponseBody
    public static List<Movement> getMoves(@RequestBody List<Coordinate> coordinates) {
        List<Movement> moves = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (Coordinate coordinate : coordinates) {
            int xDiff = coordinate.getX() - x;
            int yDiff = coordinate.getY() - y;
            if (xDiff > 0) {
                moves.add(new Movement(Direction.EAST, xDiff));
            } else if (xDiff < 0) {
                moves.add(new Movement(Direction.WEST, -xDiff));
            }
            if (yDiff > 0) {
                moves.add(new Movement(Direction.NORTH, yDiff));
            } else if (yDiff < 0) {
                moves.add(new Movement(Direction.SOUTH, -yDiff));
            }
            x = coordinate.getX();
            y = coordinate.getY();
        }
        return moves;
    }

}
