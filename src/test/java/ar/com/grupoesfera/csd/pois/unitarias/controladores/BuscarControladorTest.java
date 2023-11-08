package ar.com.grupoesfera.csd.pois.unitarias.controladores;

import ar.com.grupoesfera.csd.pois.controladores.BuscarControlador;
import ar.com.grupoesfera.csd.pois.controladores.HealthcheckControlador;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;

public class BuscarControladorTest {
    @InjectMocks
    private BuscarControlador controlador;

    @Test
    public void poiMasCercano(){
        // Ejecucion
        ResponseEntity<Poi> respuesta = controlador.obtengoElPoiMasCercano(-34.59031266097366, -58.44338422577147);

        // Verificacion
        Assertions.assertEquals("El Codo", respuesta.getBody().getNombre());
    }

}
