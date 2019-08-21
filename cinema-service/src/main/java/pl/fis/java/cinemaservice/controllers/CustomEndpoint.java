package pl.fis.java.cinemaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.java.cinemaservice.entities.Location;
import pl.fis.java.cinemaservice.services.CustomDaoHandler;

import java.util.List;


@RestController
public class CustomEndpoint {
    @Autowired
    private CustomDaoHandler customDaoHandler;

    @RequestMapping(path = "/cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> fetchCities() {
        return new ResponseEntity<>(customDaoHandler.fetchCities(), HttpStatus.OK);
    }

    @RequestMapping(path = "/locations/default", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getNearestLocation(@RequestParam(name = "latitude") String latitudeParam,
                                                             @RequestParam(name = "longitude") String longitudeParam) {
        Double latitude = null;
        Double longitude = null;
        try {
            latitude = Double.parseDouble(latitudeParam);
            longitude = Double.parseDouble(longitudeParam);
        } catch (NumberFormatException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Location location = customDaoHandler.fetchNearestLocation(latitude, longitude);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
}
