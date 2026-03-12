package servicios;

import org.springframework.stereotype.Service;
import interfaces.InterfazContactoSim;
import modelo.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Implementación del servicio que maneja solicitudes de simulación.
 */
@Service
public class ContactoSimImpl implements InterfazContactoSim {

    // Lista de entidades ficticias
    private final List<Entidad> entities;

    // Mapa que almacena temporalmente solicitudes usando token como clave
    private final Map<Integer, DatosSolicitud> solicitudes;

    private final Random random;

    public ContactoSimImpl() {
        this.entities = new ArrayList<>();
        this.solicitudes = new HashMap<>();
        this.random = new Random();

        // Creamos algunas entidades de ejemplo
        entities.add(new Entidad(1, "Entidad Alfa", "Descripción de la Entidad Alfa"));
        entities.add(new Entidad(2, "Entidad Beta", "Descripción de la Entidad Beta"));
        entities.add(new Entidad(3, "Entidad Gamma", "Descripción de la Entidad Gamma"));
    }

    /**
     * Recibe una solicitud y devuelve un token aleatorio.
     * La solicitud se almacena temporalmente en memoria.
     */
    @Override
    public int solicitarSimulation(DatosSolicitud sol) {
        int token = random.nextInt(1000); // Genera un token aleatorio
        solicitudes.put(token, sol);       // Almacena la solicitud
        return token;
    }

    /**
     * Por ahora no implementamos descarga de resultados.
     */
    @Override
    public DatosSimulation descargarDatos(int ticket) {
        return null;
    }

    /**
     * Devuelve la lista de entidades disponibles.
     */
    @Override
    public List<Entidad> getEntities() {
        return entities;
    }

    /**
     * Comprueba si un ID de entidad es válido (existe en nuestra lista ficticia)
     */
    @Override
    public boolean isValidEntityId() {
        return true; // Para simplificar, asumimos que cualquier ID es válido por ahora
    }
}