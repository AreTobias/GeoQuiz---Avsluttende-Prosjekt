package org.example;

public class Countries {



    private String name;
    private String capital;
    private String subregion;
    private String region;
    private String population;
    private String area;
    private String currencies;
    private String nativeNames;

    public String getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    public String getNativeNames() {
        return nativeNames;
    }

    public void setNativeNames(String nativeNames) {
        this.nativeNames = nativeNames;
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