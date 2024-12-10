package com.soap.xml_sb.jax_rs_arc_client.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Permet à JAXB de sérialiser cette classe en XML
public class Reponse {
    private boolean status;
    private String message;

    @XmlElement // Indique que cet attribut sera inclus dans le XML
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
