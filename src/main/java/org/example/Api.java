package org.example;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Api  {



    public static Countries[] apiResult() throws Exception  {
        String url = "https://restcountries.com/v2/all?fields=name,population,capital,area,region,subregion,language,nativeName,";

        Countries[] country = new Countries[] {};
        Gson gson = new Gson();
        //String jsonRequest = gson.toJson(url);

       try {
           HttpRequest getRequest = HttpRequest.newBuilder()
                   .uri(new URI("https://restcountries.com/v2/all?fields=name,population,capital,area,currencies,region,subregion,language,nativeName"))
                   .header("Authorization", "PMAK-642eba4d7d25703cc5178dd4-24fa0d513a60ab03a22a8f9a8de054a9d7")
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

    public static String getCountryNameFromCapital(String capitalInput) throws Exception{

        Countries[] country = apiResult();
        StringBuilder name = new StringBuilder();

        for (Countries s: country){
            if (capitalInput.equalsIgnoreCase(s.getCapital())){
                name.append(s.getName());
            }
        }

        return name.toString();
    }

    public static String getCountryRandom() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> countryNames = new ArrayList<>();
        Random randomIndex = new Random();

        for (Countries s: country){
            countryNames.add(s.getName());
        }

        return countryNames.get(randomIndex.nextInt(countryNames.size()));
    }


    public static String getCapitalRandom() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> countryCapital = new ArrayList<>();
        Random randomIndex = new Random();

        for (Countries s: country){
            countryCapital.add(s.getCapital());
        }

        return countryCapital.get(randomIndex.nextInt(countryCapital.size()));
    }

    public static String getSubRegionRandom() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> subRegion = new ArrayList<>();
        Random randomIndex = new Random();

        for (Countries s: country){
            subRegion.add(s.getSubregion());
        }

        return subRegion.get(randomIndex.nextInt(subRegion.size()));
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

    public static int getPopulationRandom() throws Exception {

        Countries[] country = apiResult();
        ArrayList<Integer> countryPopulation = new ArrayList<>();
        Random randomIndex = new Random();

        for (Countries s: country){
            countryPopulation.add(Integer.parseInt(s.getPopulation()));
        }

        return countryPopulation.get(randomIndex.nextInt(countryPopulation.size()));
    }

    public static String getAreaRandom() throws Exception {

        Countries[] country = apiResult();
        ArrayList<String> countryArea = new ArrayList<>();
        Random randomIndex = new Random();

        for (Countries s: country){
            countryArea.add(s.getArea());
        }

        return countryArea.get(randomIndex.nextInt(countryArea.size()));
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

    public static String getCountryPopulationFromName(String country) throws Exception { // Returns the parameter country's Capital

        Countries[] countryApi = apiResult();
        StringBuilder population = new StringBuilder();

        for (Countries s: countryApi){
            if (country.equalsIgnoreCase(s.getName())){
                population.append(s.getPopulation());
            }
        }
        return population.toString();
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
    public static Set<String> getRegionsArrayList() throws Exception {

        Countries[] country = apiResult();
        Set<String> regions = new HashSet<>();

        for (Countries s: country){
            regions.add(s.getRegion());
        }

        return regions;
    }

    public static Set<String> getSubRegionArray() throws Exception {

        Countries[] country = apiResult();
        Set<String> subRegions = new HashSet<>();

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
