package pl.fis.java.lbdcinemafinal.cinema_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.fis.java.lbdcinemafinal.cinema_service.repos.CustomLocationRepository;

@RestController
public class CustomEndpoint
{
	@Autowired
	private CustomLocationRepository repo;
	
	@RequestMapping(path = "/cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> test()
	{
		return new ResponseEntity<>(repo.fetchCities(), HttpStatus.OK);
	}
}
