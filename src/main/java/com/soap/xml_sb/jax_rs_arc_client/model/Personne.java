package com.soap.xml_sb.jax_rs_arc_client.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personne")
@XmlAccessorType(XmlAccessType.FIELD)
public class Personne {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "nom")
    private String nom;
    @XmlElement(name = "age")
    private int age;

    public Personne() {
    }

    public Personne(int id, String nom, int age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
