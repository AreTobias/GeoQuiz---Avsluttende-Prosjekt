package org.example;

public class Countries {



    private String name;
    private String population;
    private String capital;
    private String area;
    private String region;
    private String subregion;
    private  String language;
    private String nativeName;

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeNames(String nativeNames) {
        this.nativeName = nativeNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() { return this.capital;  }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



    @Override
    public String toString() {
        return "Countries{" +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", subregion='" + subregion + '\'' +
                ", region='" + region + '\'' +
                ", population='" + population + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}