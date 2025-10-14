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
    private final List<Coche> cochesRegistrados;



    public Garaje() {
        this.cochesRegistrados = new ArrayList<>();
    }


    public List<Coche> getCochesRegistrados() {
        return cochesRegistrados;
    }

    public void agregarCoche(Coche coche){
        this.cochesRegistrados.add(coche);

    }
}
