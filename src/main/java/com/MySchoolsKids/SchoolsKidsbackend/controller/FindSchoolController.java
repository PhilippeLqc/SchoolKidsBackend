package com.MySchoolsKids.SchoolsKidsbackend.controller;

import com.MySchoolsKids.SchoolsKidsbackend.model.School;
import com.MySchoolsKids.SchoolsKidsbackend.response.SchoolApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/school")
public class FindSchoolController {
    @GetMapping("/findSchool")
    public ResponseEntity<Object> findSchools(
            @RequestParam("lng") double lng,
            @RequestParam("lat") double lat,
            @RequestParam("schoolType") String schoolType,
            @RequestParam("schoolStatus") String schoolStatus,
            @RequestParam("distance") double distance) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

/*TODO: change the api url to the one that we need to use*/
        String apiUrl = "https://data.education.gouv.fr/api/explore/v2.1/catalog/datasets/fr-en-annuaire-education/records?limit=-1";
        /*apiUrl += "&refine=type_etablissement%3A" + schoolType;
        apiUrl += "&refine=statut_public_prive%3A" + schoolStatus;*/

        // need to see the apiurl  in the console
        System.out.println("test api url" + apiUrl);

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        SchoolApiResponse schoolResponse = objectMapper.readValue(response.getBody(), SchoolApiResponse.class);


        List<School> filteredSchools = schoolResponse.getResults().stream()
                .filter(school -> school.getNomEtablissement().contains(schoolType)
                        && school.getStatutPublicPrive().contains(schoolStatus)
                        /*&& calculateDistance(lat, lng, school.getLatitude(), school.getLongitude()) <= distance*/)
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
