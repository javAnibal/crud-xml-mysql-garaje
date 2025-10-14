package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "garaje") // -> Elemento raíz

public class Garaje {

    @XmlElementWrapper(name = "coches") // -> Elemento Padre
    @XmlElement(name = "coche") // -> Elemento hijo
    private final List<Garaje> cochesRegistrados;



    public Garaje() {
        this.cochesRegistrados = new ArrayList<>();
    }


    public List<Garaje> getCochesRegistrados() {
        return cochesRegistrados;
    }
}
