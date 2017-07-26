package com.example.devil.car_project.activities;

/**
 * Created by devil on 4/22/2017.
 */

public class Cars {
    private String name;
    private String address;
    private String car_number;
    private String fitness;
    private String report;
    private String tax;


    public Cars(String name, String address, String car_number, String fitness, String report, String tax){
        this.name=name;
        this.address=address;
        this.car_number=car_number;
        this.fitness=fitness;
        this.report=report;
        this.report=tax;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setCar_number(String car_number){
        this.car_number=car_number;
    }
    public void setFitness(String fitness){
        this.fitness=fitness;
    }
    public void setReport(String report){
        this.report=report;
    }
    public void setTax(String tax){
        this.tax=tax;
    }

    public String getAddress() {
        return address;
    }

    public String getCar_number() {
        return car_number;
    }

    public String getFitness() {
        return fitness;
    }

    public String getName() {
        return name;
    }

    public String getReport() {
        return report;
    }
    public String getTax() {
        return tax;
    }

}
