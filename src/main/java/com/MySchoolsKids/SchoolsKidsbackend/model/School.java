package com.MySchoolsKids.SchoolsKidsbackend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class School {
    @JsonProperty("identifiant_de_l_etablissement")
    private String identifiantEtablissement;

    @JsonProperty("nom_etablissement")
    private String nomEtablissement;

    @JsonProperty("type_etablissement")
    private String typeEtablissement;

    @JsonProperty("statut_public_prive")
    private String statutPublicPrive;

    @JsonProperty("adresse_1")
    private String adresse1;

    @JsonProperty("adresse_2")
    private String adresse2;

    @JsonProperty("adresse_3")
    private String adresse3;

    @JsonProperty("code_postal")
    private String codePostal;

    @JsonProperty("code_commune")
    private String codeCommune;

    @JsonProperty("nom_commune")
    private String nomCommune;

    @JsonProperty("code_departement")
    private String codeDepartement;

    @JsonProperty("code_academie")
    private String codeAcademie;

    @JsonProperty("code_region")
    private String codeRegion;

    @JsonProperty("ecole_maternelle")
    private int ecoleMaternelle;

    @JsonProperty("ecole_elementaire")
    private int ecoleElementaire;

    @JsonProperty("voie_generale")
    private String voieGenerale;

    @JsonProperty("voie_technologique")
    private String voieTechnologique;

    @JsonProperty("voie_professionnelle")
    private String voieProfessionnelle;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("fax")
    private String fax;

    @JsonProperty("web")
    private String web;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("restauration")
    private int restauration;

    @JsonProperty("hebergement")
    private int hebergement;

    @JsonProperty("ulis")
    private int ulis;

    @JsonProperty("apprentissage")
    private String apprentissage;

    @JsonProperty("segpa")
    private String segpa;

    @JsonProperty("section_arts")
    private String sectionArts;

    @JsonProperty("section_cinema")
    private String sectionCinema;

    @JsonProperty("section_theatre")
    private String sectionTheatre;

    @JsonProperty("section_sport")
    private String sectionSport;

    @JsonProperty("section_internationale")
    private String sectionInternationale;

    @JsonProperty("section_europeenne")
    private String sectionEuropeenne;

    @JsonProperty("lycee_agricole")
    private String lyceeAgricole;

    @JsonProperty("lycee_militaire")
    private String lyceeMilitaire;

    @JsonProperty("lycee_des_metiers")
    private String lyceeDesMetiers;

    @JsonProperty("post_bac")
    private String postBac;

    @JsonProperty("appartenance_education_prioritaire")
    private String appartenanceEducationPrioritaire;

    @JsonProperty("greta")
    private String greta;

    @JsonProperty("siren_siret")
    private String sirenSiret;

    @JsonProperty("nombre_d_eleves")
    private int nombreEleves;

    @JsonProperty("fiche_onisep")
    private String ficheOnisep;

    @JsonProperty("position")
    private Position position;

    @JsonProperty("type_contrat_prive")
    private String typeContratPrive;

    @JsonProperty("libelle_departement")
    private String libelleDepartement;

    @JsonProperty("libelle_academie")
    private String libelleAcademie;

    @JsonProperty("libelle_region")
    private String libelleRegion;

    @JsonProperty("coordx_origine")
    private double coordxOrigine;

    @JsonProperty("coordy_origine")
    private double coordyOrigine;

    @JsonProperty("epsg_origine")
    private String epsgOrigine;

    @JsonProperty("nom_circonscription")
    private String nomCirconscription;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("precision_localisation")
    private String precisionLocalisation;

    @JsonProperty("date_ouverture")
    private String dateOuverture;

    @JsonProperty("date_maj_ligne")
    private String dateMajLigne;

    @JsonProperty("etat")
    private String etat;

    @JsonProperty("ministere_tutelle")
    private String ministereTutelle;

    @JsonProperty("multi_uai")
    private int multiUai;

    @JsonProperty("rpi_concentre")
    private int rpiConcentre;

    @JsonProperty("rpi_disperse")
    private String rpiDisperse;

    @JsonProperty("code_nature")
    private int codeNature;

    @JsonProperty("libelle_nature")
    private String libelleNature;

    @JsonProperty("code_type_contrat_prive")
    private String codeTypeContratPrive;

    @JsonProperty("pial")
    private String pial;

    @JsonProperty("etablissement_mere")
    private String etablissementMere;

    @JsonProperty("type_rattachement_etablissement_mere")
    private String typeRattachementEtablissementMere;

    @JsonProperty("code_zone_animation_pedagogique")
    private String codeZoneAnimationPedagogique;

    @JsonProperty("libelle_zone_animation_pedagogique")
    private String libelleZoneAnimationPedagogique;

    // Getters and setters for the fields
@Data
    public static class Position {
        @JsonProperty("lon")
        private double lon;

        @JsonProperty("lat")
        private double lat;

        // Getters and setters for lon and lat
    }
}