package com.MySchoolsKids.SchoolsKidsbackend.model;

public class School {
    private String identifiant_de_l_etablissement;
    private String nom_etablissement;
    private String type_etablissement;
    private String statut_public_prive;
    private String adresse_1;
    private String adresse_2;
    private String adresse_3;
    private String code_postal;
    private String code_commune;
    private String nom_commune;
    private String code_departement;
    private String code_academie;
    private String code_region;
    private int ecole_maternelle;
    private int ecole_elementaire;
    private String voie_generale;
    private String voie_technologique;
    private String voie_professionnelle;
    private String telephone;
    private String fax;
    private String web;
    private String mail;
    private int restauration;
    private int hebergement;
    private int ulis;
    private String apprentissage;
    private String segpa;
    private String section_arts;
    private String section_cinema;
    private String section_theatre;
    private String section_sport;
    private String section_internationale;
    private String section_europeenne;
    private String lycee_agricole;
    private String lycee_militaire;
    private String lycee_des_metiers;
    private String post_bac;
    private String appartenance_education_prioritaire;
    private String greta;
    private String siren_siret;
    private int nombre_d_eleves;
    private String fiche_onisep;
    private Position position;
    private String type_contrat_prive;
    private String libelle_departement;
    private String libelle_academie;
    private String libelle_region;
    private double coordx_origine;
    private double coordy_origine;
    private String epsg_origine;
    private String nom_circonscription;
    private double latitude;
    private double longitude;
    private String precision_localisation;
    private String date_ouverture;
    private String date_maj_ligne;
    private String etat;
    private String ministere_tutelle;
    private int multi_uai;
    private int rpi_concentre;
    private String rpi_disperse;
    private int code_nature;
    private String libelle_nature;
    private String code_type_contrat_prive;
    private String pial;
    private String etablissement_mere;
    private String type_rattachement_etablissement_mere;
    private String code_zone_animation_pedagogique;
    private String libelle_zone_animation_pedagogique;

    public School() {

    }

    // Getters and setters
    public Object getTypeEstablishment() {
        return type_etablissement;
    }

    public Object getStatutePublicPrivate() {
        return statut_public_prive;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
