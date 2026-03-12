package servicios;

import org.springframework.stereotype.Service;
import interfaces.InterfazEnviarEmails;
import modelo.Destinatario;

import org.slf4j.Logger;

/**
 * Implementación del servicio de envío de emails.
 */
@Service
public class EnviarEmailsImpl implements InterfazEnviarEmails {

    private final Logger logger;

    // Recibimos el logger mediante inyección de dependencias
    public EnviarEmailsImpl(Logger logger) {
        this.logger = logger;
    }

    /**
     * Simula el envío de un email registrando la acción en el log
     */
    @Override
    public boolean enviarEmail(Destinatario dest, String email) {
    logger.info("Simulando envío de email (versión inicial)");
            return true; 
    }
}