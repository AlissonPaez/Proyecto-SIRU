import sede_principal.datos.*;
import sede_principal.negocio.*;
import sede_principal.presentacion.*;

public class App {

    public static void main(String[] args) {
        BDAcademica bdAcademica = new BDAcademica();
        RepositorioUsuarios repoUsuarios = new RepositorioUsuarios();
        PasarelaExterna pasarelaExterna = new PasarelaExterna();
        ServicioFirmaDigital servicioFirmaDigital = new ServicioFirmaDigital();
        RepositorioDocsFirmados repoDocsFirmados = new RepositorioDocsFirmados();
        LogAuditoria logAuditoria = new LogAuditoria();

        GestorAutenticacion gestorAutenticacion = new GestorAutenticacion(repoUsuarios);
        MotorReglas motorReglas = new MotorReglas(bdAcademica);
        ModuloPasarelaPagos moduloPagos = new ModuloPasarelaPagos(pasarelaExterna, bdAcademica);
        GestorMatriculas gestorMatriculas = new GestorMatriculas(moduloPagos, bdAcademica, motorReglas);
        GeneradorDocumentosLegales generadorDocumentos =
            new GeneradorDocumentosLegales(bdAcademica, servicioFirmaDigital, repoDocsFirmados);
        PortalVerificacionDocumentos portal =
            new PortalVerificacionDocumentos(repoDocsFirmados, logAuditoria);

        repoUsuarios.registrarUsuario("alumno@example.com", "1234");

        try {
            String token = gestorAutenticacion.iniciarSesion("alumno@example.com", "1234");
            System.out.println("Sesión iniciada. Token: " + token);

            System.out.println(gestorMatriculas.abrirPeriodo("2026-07-01", "2026-08-31"));
            System.out.println(gestorMatriculas.matricularEstudiante("EST123", "GRUPO1"));

            String diplomaId = generadorDocumentos.generarDiploma("EST123", "ING-INF", "2026-06-30");
            System.out.println("Diploma generado: " + diplomaId);

            String resultado = portal.verificarDocumento(diplomaId);
            System.out.println("Verificación: " + resultado);

            System.out.println("Log Auditoría: " + logAuditoria.consultarLog());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}