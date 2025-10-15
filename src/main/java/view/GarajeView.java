package view;

import model.Coche;
import model.Garaje;

public class GarajeView {


    public void mostrarGaraje(Garaje garaje) {

        for (Coche coche : garaje.getCochesRegistrados()) {
            System.out.printf("Matricula: %s | Marca: %s | Modelo: %s%n",
                    coche.getMatricula(), coche.getMarca(), coche.getModelo());

        }

    }

}
