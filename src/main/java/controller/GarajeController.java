package controller;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Coche;
import model.Garaje;
import utils.GarajeException;

import java.io.File;


/**
 * @GarajeController -> es la clase que controla la lógica de mi programa
 * Sirve como intermediario central entre la interfaz usuario y lógica de los datos
 */
public class GarajeController {

    private Garaje garaje;

    public GarajeController() {
        this.garaje = new Garaje(); // -> Nos aseguramos por la arquitectura del MCV tener inmediatamente una instancia del modelo - Cuando se crea el controlador
    }

    public Garaje getGaraje() {
        return garaje;
    }

    //Siguiendo la arquitectura -> El controlador es quien debe trabajar la lógica por lo cual este mét-do llama al met-do de la clase garage
    public void agregarCoche(Coche coche) {
        garaje.agregarCoche(coche);
    }

    //================= MÉT-ODO PRINCIPAL =================

    public void guardarGarajeEnXML(String rutaArchivo) throws GarajeException {


        try{

            File archivo = new File(rutaArchivo);
            // 💡 CREAR EL DIRECTORIO PADRE SI NO EXISTE
            File directorioPadre = archivo.getParentFile();
            if (directorioPadre != null && !directorioPadre.exists()) {
                directorioPadre.mkdirs();
            }

            // 1) -> Creamos el contexto [ -Clase raíz- ]
            JAXBContext context = JAXBContext.newInstance(Garaje.class);

            // 2) -> Crear el Marshaller [ -Objeto  a -> XML- ]
            Marshaller marshaller = context.createMarshaller();

            // 3) -> Formato de salida [ -Indentación- ]
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // 4) -> Realizar el Marshalling [ -Guardar- ]
            marshaller.marshal(garaje, new File(rutaArchivo));

        } catch (JAXBException ex) {
            throw new GarajeException("Error al guardar el garaje en XML: " + ex.getMessage());

        }
    }

}
