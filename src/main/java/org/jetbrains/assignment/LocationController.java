package org.jetbrains.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {

    // Expose an endpoint that does the following:
    // Receives a list of movement operations in JSON format as an input and outputs the coordinates recorded after each move as a JSON document. Assume that the initial location for the robot is always at (0, 0).
    //Example of a curl command to test your implementation:
    //curl --header "Content-Type: application/json" \
    //--request POST \
    //--data '[{"direction":"EAST","steps":1},{"direction":"NORTH","steps":3},{"direction":"EAST","steps":3},
    //         {"direction":"SOUTH","steps":5},{"direction":"WEST","steps":2}]' \
    //http://localhost:8080/locations
    //Result:
    //
    //[{"x":0,"y":0},{"x":1,"y":0},{"x":1,"y":3},{"x":4,"y":3},{"x":4,"y":-2},{"x":2,"y":-2}]
    //  Receives a list of movement operations in JSON format as an input and outputs the coordinates recorded after each move as a JSON document.
    //  Assume that the initial location for the robot is always at (0, 0).
    @PostMapping("/locations")
    @ResponseBody
    public static List<Coordinate> moveRobot(@RequestBody List<Movement> movements) {
        int x = 0;
        int y = 0;
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(x, y));
        for (Movement movement : movements) {
            switch (movement.getDirection()) {
                case EAST:
                    x += movement.getSteps();
                    break;
                case WEST:
                    x -= movement.getSteps();
                    break;
                case NORTH:
                    y += movement.getSteps();
                    break;
                case SOUTH:
                    y -= movement.getSteps();
                    break;
            }
            coordinates.add(new Coordinate(x, y));
        }
        return coordinates;
    }

}
