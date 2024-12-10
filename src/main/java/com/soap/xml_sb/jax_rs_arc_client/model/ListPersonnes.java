package com.soap.xml_sb.jax_rs_arc_client.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "personnes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListPersonnes {
    @XmlElement(name = "personne")
    private List<Personne> personnes;
    // Getters et Setters
    public List<Personne> getPersonnes() {
        return personnes;
    }
    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
}
