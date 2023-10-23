package com.MySchoolsKids.SchoolsKidsbackend.controller;

import com.MySchoolsKids.SchoolsKidsbackend.model.School;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/school")
public class FindSchoolController {
    @GetMapping("/findSchool")
    public ResponseEntity<Object> findSchools(@RequestParam("latitude") double latitude,
                                              @RequestParam("longitude") double longitude,
                                              @RequestParam("schoolType") String schoolType,
                                              @RequestParam("schoolStatus") String schoolStatus,
                                              @RequestParam("distance") double distance) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                "https://data.education.gouv.fr/api/explore/v2.1/catalog/datasets/fr-en-annuaire-education/records?",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        School[] allSchools = objectMapper.readValue(response.getBody(), School[].class);

        List<School> filteredSchools = Arrays.stream(allSchools)
                .filter(school -> school.getTypeEstablishment().equals(schoolType)
                        && school.getStatutePublicPrivate().equals(schoolStatus)
                        && calculateDistance(latitude, longitude, school.getLatitude(), school.getLongitude()) <= distance)
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredSchools);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Rayon de la Terre en kilomètres

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}
