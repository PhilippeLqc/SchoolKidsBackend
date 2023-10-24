package com.MySchoolsKids.SchoolsKidsbackend.response;

import com.MySchoolsKids.SchoolsKidsbackend.model.School;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolApiResponse {

    private List<School> results;
    public List<School> getResults() {
        return results;
    }

    public void setResults(List<School> results) {
        this.results = results;
    }

}