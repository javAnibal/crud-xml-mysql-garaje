package model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "garaje") // -> Elemento raíz

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Coche.class)

public class Garaje {

    @XmlElementWrapper(name = "coches") // -> Elemento Padre
    @XmlElement(name = "coche") // -> Elemento hijo
    private List<Coche> cochesRegistrados = new ArrayList<>();


    public Garaje() {
        this.cochesRegistrados = new ArrayList<>();
    }


    public List<Coche> getCochesRegistrados() {
        return cochesRegistrados;
    }


    //M() metodo propio

    public void agregarCoche(Coche coche) {

        this.cochesRegistrados.add(coche);
    }

    public boolean estaVacio() {

        return this.cochesRegistrados.isEmpty();

    }

    @Override
    public String toString() {
        return "Garaje{" +
                "cochesRegistrados=" + cochesRegistrados +
                '}';
    }
}
