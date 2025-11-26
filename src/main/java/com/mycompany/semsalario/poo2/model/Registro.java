/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semsalario.poo2.model;

/**
 *
 * @author jp
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {
    private int id;
    private String name;
    private String date;
    private String time;
    private String type;
    private float value;
    private String description;

    public Registro(String name, String date, String time, String type, float value, String description) {
        this.id = 0;
        this.name = name;
        this.date = date;
        this.time = time;
        this.type = type;
        this.value = value;
        this.description = description;
    }
    
    public Registro(float value, String type) {
        this.id = 0;
        this.date = LocalDate.now().toString();
        this.time = LocalTime.now().withNano(0).toString();
        this.type = type;
        this.value = value;
        this.description = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public float getValue() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate() {
        this.date = LocalDate.now().toString();
    }

    public void setTime() {
        this.time = LocalTime.now().toString();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(float value) {
        this.value = value;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }
  }
