package pl.fis.java.cinemaservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fis.java.cinemaservice.entities.Location;
import pl.fis.java.cinemaservice.repos.ICustomLocationRepository;
import pl.fis.java.cinemaservice.repos.LocationRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class CustomDaoHandler {

    @Autowired
    private ICustomLocationRepository customLocationRepo;

    @Autowired
    private LocationRepository locationRepository;

    public List<String> fetchCities() {
        return customLocationRepo.fetchCities();
    }

    public Location fetchNearestLocation(Double latitude, Double longitude) {
        Double latitudeSQR = Math.pow(latitude, 2);
        Double longitudeSQR = Math.pow(longitude, 2);

        Iterable<Location> locations = locationRepository.findAll();
        Location finalLocation = null;

        if (locations == null)
            return null;

        Iterator iterator = locations.iterator();
        Double minDistance = null;

        if (iterator.hasNext()) {
            finalLocation = (Location) iterator.next();
            minDistance = Math.sqrt(Math.pow(finalLocation.getLatitude() - latitude, 2) + Math.pow(finalLocation.getLongitude() - longitude, 2));
        }

        for (Location tmpLocation : locations) {
            Double distance = Math.sqrt(Math.pow(tmpLocation.getLatitude() - latitude, 2) + Math.pow(tmpLocation.getLongitude() - longitude, 2));
            if (distance < minDistance) {
                minDistance = distance;
                finalLocation = tmpLocation;
            }
        }
        return finalLocation;
    }
}
