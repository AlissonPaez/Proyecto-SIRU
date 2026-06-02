package sede_principal.datos;

/**
 * Servicio encargado de aplicar la firma digital a documentos legales
 * (actas y diplomas) antes de su emisión oficial.
 * Depende de: RepositorioDocsFirmados (capa de datos)
 */
public class ServicioFirmaDigital {

    // Aplica la firma digital al documento indicado usando las credenciales
    // del firmante autorizado.
    // Retorna el documento firmado en formato byte[] listo para almacenar.
    // Lanza FirmaDigitalException si el proceso de firma falla.
    public byte[] firmarDocumento(String idDocumento, String idFirmante, byte[] contenidoDocumento) {
        throw new UnsupportedOperationException("Por implementar");
    }

    // Verifica que la firma digital de un documento existente es válida
    // y que el contenido no ha sido alterado desde su emisión.
    // Retorna true si la firma es válida, false si fue alterada.
    public boolean verificarFirma(String idDocumento, byte[] contenidoDocumento) {
        throw new UnsupportedOperationException("Por implementar");
    }

    // Verifica que el firmante indicado tiene autorización para firmar
    // documentos legales (actas o diplomas).
    // Lanza FirmanteNoAutorizadoException si no tiene autorización.
    public boolean validarFirmante(String idFirmante) {
        throw new UnsupportedOperationException("Por implementar");
    }
}