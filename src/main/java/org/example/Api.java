package org.example;

import com.google.gson.*;
import org.jetbrains.annotations.*;

import java.net.*;
import java.net.http.*;
import java.util.*;

public class Api  {



    public static Countries[] apiResult() throws Exception  {
        String url = "https://restcountries.com/v2/all?fields=name,population,capital,area,region,subregion,language,nativeName,";

        Countries[] country = new Countries[] {};
        Gson gson = new Gson();
        //String jsonRequest = gson.toJson(url);

       try {
           HttpRequest getRequest = HttpRequest.newBuilder()
                   .uri(new URI("https://restcountries.com/v2/all?fields=name,population,capital,area,region,subregion,nativeName"))
                   .header("Authorization", "")

                   .build();

           HttpClient httpClient = HttpClient.newHttpClient();
           HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());


           country = gson.fromJson(getResponse.body(), Countries[].class);
       }
       catch (Exception e){
           throw new Exception(e);
       }
        return country;

    } // Returns the country of the Parameter capital


    public static String getCountryRandom() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> countryNames = new ArrayList<>();
        Random randomIndex = new Random();

        for (Countries s: country){
            countryNames.add(s.getName());
        }

        return countryNames.get(randomIndex.nextInt(countryNames.size()));
    }


    public static String getSubregionFromCountryName(String CountryName) throws Exception {

        Countries[] country = apiResult();
        StringBuilder subRegion = new StringBuilder();

        for (Countries s: country){
            if (CountryName.equalsIgnoreCase(s.getName())){
                subRegion.append(s.getSubregion());
            }
        }
        return subRegion.toString();
    }

    public static String getNativeNameRandom() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> nativeName = new ArrayList<>();
        Random randomIndex = new Random();

        for (Countries s: country){
            nativeName.add(s.getNativeName());
        }

        return nativeName.get(randomIndex.nextInt(nativeName.size()));
    }

    public static String getNativeNameFromCountryName(String CountryName) throws Exception {

        Countries[] country = apiResult();
        StringBuilder nativeName = new StringBuilder();

        for (Countries s: country){
            if (CountryName.equalsIgnoreCase(s.getName())){
                nativeName.append(s.getNativeName());
            }
        }
        return nativeName.toString();
    }

    public static String getAreaString(String country) throws Exception {

        Countries[] countryApi = apiResult();
        StringBuilder area = new StringBuilder();

        for (Countries s: countryApi){
            if (country.equalsIgnoreCase(s.getName())){
                area.append(s.getArea());
            }
        }
        return area.toString();
    }


    @NotNull
    public static String getRegionString(String country) throws Exception {

        Countries[] countryApi = apiResult();
        StringBuilder region = new StringBuilder();

        for (Countries s: countryApi){
            if (country.equalsIgnoreCase(s.getName())){
                region.append(s.getRegion());
            }
        }
        return region.toString();
    }
    @NotNull
    public static String getCountryAreaFromName(String country) throws Exception { // Returns the parameter country's Capital

        Countries[] countryApi = apiResult();
        StringBuilder area = new StringBuilder();

        for (Countries s: countryApi){
            if (country.equalsIgnoreCase(s.getName())){
                area.append(s.getArea());
            }
        }
        return area.toString();
    }


    public static String getCountryCapitalFromName(String country) throws Exception { // Returns the parameter country's Capital

        Countries[] countryApi = apiResult();
        StringBuilder capital = new StringBuilder();

        for (Countries s: countryApi){
            if (country.equalsIgnoreCase(s.getName())){
                capital.append(s.getCapital());
            }
        }
        return capital.toString();
    }

    public static String getPopulationString(String country) throws Exception {

        Countries[] countryApi = apiResult();
        StringBuilder population = new StringBuilder();

        for (Countries s: countryApi){
            if (country.equalsIgnoreCase(s.getName())){
                population.append(s.getPopulation());
            }
        }
        return population.toString();
    }
    @NotNull
    public static ArrayList<String> countryNamesArrayList() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> countryNames = new ArrayList<>();

        for (Countries s: country){
            countryNames.add(s.getName());
        }

        return countryNames;
    }
    @NotNull
    public static ArrayList<String> countryCapitalArrayList() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> capital = new ArrayList<>();

        for (Countries s: country){
            capital.add(s.getCapital());
        }

        return capital;
    }
    @NotNull
    public static ArrayList<String> getRegionsArrayList() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> regions = new ArrayList<>();

        for (Countries s: country){
            regions.add(s.getRegion());
        }

        return regions;
    }

    public static ArrayList<String> getSubRegionArray() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> subRegions = new ArrayList<>();

        for (Countries s: country){
            subRegions.add(s.getSubregion());
        }

        return subRegions;
    }



    public static ArrayList<String> getCountryCapitalArray() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> capitals = new ArrayList<>();

        for (Countries s: country){
            capitals.add(s.getCapital());
        }

        return capitals;
    }



    public static ArrayList<String> getPopulationArray() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> populations = new ArrayList<>();

        for (Countries s: country){
            populations.add(s.getPopulation());
        }

        return populations;
    }

    public static ArrayList<String> getAreaArray() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> area = new ArrayList<>();

        for (Countries s: country){
            area.add(s.getArea());
        }

        return area;
    }

    public static ArrayList<String> getNativeNameArray() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> nativeName = new ArrayList<>();

        for (Countries s: country){
            nativeName.add(s.getNativeName());
        }

        return nativeName;
    }



}
