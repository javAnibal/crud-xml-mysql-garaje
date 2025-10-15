package appMain;

import controller.GarajeController;
import model.Coche;
import utils.GarajeException;
import view.GarajeView;

import java.nio.file.Path;

public class AppMain {


    private static final String RUTA_FICHERO = Path.of(System.getProperty("user.dir"), "data", "garaje.xml").toString();

    public static void main(String[] args) {


        GarajeController garajeController = new GarajeController();
        GarajeView garajeView = new GarajeView();

        //Creando Objetos
        Coche c1 = new Coche(1, "8910JCY", "Nissan", "Pulsar");
        Coche c2 = new Coche(2, "1234ABC", "Honda", "Civic");

        //Agregando los coches

        garajeController.agregarCoche(c1);
        garajeController.agregarCoche(c2);

        try {

            garajeController.guardarGarajeEnXML(RUTA_FICHERO);
            garajeView.mostrarGaraje(garajeController.getGaraje());

            //  garajeController.cargarDesdeXML(RUTA_FICHERO);
            //  garajeView.mostrarGaraje(garajeController.getGaraje());


        } catch (GarajeException e) {
            System.err.println("Error al guardar el fichero " + e.getMessage());
        }


    }
}
