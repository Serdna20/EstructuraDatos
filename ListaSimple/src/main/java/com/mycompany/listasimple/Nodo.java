/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasimple;

/**
 *
 * @author SCIS2-22
 */
public class Nodo {

    /**
     * @return the enlace
     */
    public Nodo getEnlace() {
        return enlace;
    }

    /**
     * @param enlace the enlace to set
     */
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the averageGrade
     */
    public float getAverageGrade() {
        return averageGrade;
    }

    /**
     * @param averageGrade the averageGrade to set
     */
    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }
    
    private String name;
    private int age;
    private float averageGrade;
    private Nodo enlace;
    
}
