package sede_principal.datos;

/**
 * Adaptador que gestiona la comunicación con la pasarela de pagos externa
 * (PSE/Wompi) para procesar los pagos de matrícula.
 * Maneja confirmaciones, fallos y reintentos automáticos.
 * Depende de: PasarelaExterna (servicio externo), BDAcademica
 */
public class PasarelaExterna {

    private static final int MAX_REINTENTOS = 3;

    // Envía la solicitud de cobro a la pasarela externa.
    // Reintenta automáticamente hasta 3 veces si la pasarela no responde.
    // Lanza PagoFallidoException si agota los reintentos sin respuesta.
    // Lanza PagoRechazadoException con el motivo si la pasarela rechaza el cobro.
    public String procesarPago(String idEstudiante, double monto) {
        throw new UnsupportedOperationException("Por implementar");
    }

    // Consulta el estado actual de un pago registrado para el estudiante
    // en el período indicado.
    // Retorna el estado: "confirmado", "pendiente" o "fallido".
    public String consultarEstadoPago(String idEstudiante, String periodo) {
        throw new UnsupportedOperationException("Por implementar");
    }

    // Intenta reenviar el cobro de un pago que quedó en estado fallido.
    // Lanza PagoPendienteException si ya existe un reintento activo.
    // Lanza PagoFallidoException si se agotan los reintentos.
    public String reintentarPago(String idEstudiante, double monto) {
        throw new UnsupportedOperationException("Por implementar");
    }
}