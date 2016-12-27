package com.demo.rest;

import com.demo.model.Location;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by elena.miovska on 27.12.2016 г..
 */
@RestController
@RequestMapping("/location")
@Api(description = "Resource to expose all available location endpoints", tags = {"LocationResource"})
public class LocationResource {

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "Save new location", notes = "The posted latitude and longitude must belong to the macedonian region")
    public String saveLocation(Location location) {
        return "Saving location with id " + location.getId();
    }

    @RequestMapping(value = "/user/nearest", method = RequestMethod.GET)
    @ApiOperation(value = "Get user nearest location", notes = "The nearest location according to the current detected location of the user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Location.class),
            @ApiResponse(code = 404, message = "Location not found. We are not able to detect the user current location")
    })
    public Location getNearestLocation() {
        return new Location(1L, "Skopje", "41.9973", "21.4280");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Location updateLocation(@ApiParam(value = "Location id", required = true) @PathVariable("id") Long id,
                                   @ApiParam(value = "Location new name", required = true) @RequestParam String name) {
        return new Location(1L, name, "41.9973", "21.4280");
    }

    @RequestMapping(value = "/user/current/{cachedValue}", method = RequestMethod.GET)
    @ApiOperation(value = "Get user current location", notes = "If the cachedValue is true then the cached value is return, otherwise the location is fetching from the location services")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Location.class),
            @ApiResponse(code = 404, message = "We are not able to detect the user current location")
    })
    public Location getUserCurrentLocation(
            @ApiParam(required = true) @PathVariable("cachedValue") boolean cachedValue) {
        return new Location(1L, "Skopje", "41.9973", "21.4280");
    }
}
