package ar.com.grupoesfera.csd.pois.unitarias.controladores;

import ar.com.grupoesfera.csd.pois.controladores.BuscarControlador;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BuscarControladorTest {
    @InjectMocks
    private BuscarControlador controlador;

    /*@Test
    public void poiMasCercano(){
        // Ejecucion
        ResponseEntity<Poi> respuesta = controlador.obtengoElPoiMasCercano(-34.59031266097366, -58.44338422577147);
        // Verificacion
        Assertions.assertEquals("El Codo", respuesta.getBody().getNombre());
    }
    @Test
    public void poisMasCercanos1(){
        ResponseEntity<List<Poi>> respuesta = controlador.obtengoLosPoiCercanos(-34.59031266097366, -58.44338422577147, 150);
        Assertions.assertEquals(respuesta.getBody().get(0).getNombre(), "El Codo");
        Assertions.assertEquals(respuesta.getBody().get(1).getNombre(), "El Groso");
    }
    @Test
    public void poisMasCercanos2(){
        ResponseEntity<List<Poi>> respuesta = controlador.obtengoLosPoiCercanos(-34.59031266097366, -58.44338422577147, 250);
        Assertions.assertEquals(respuesta.getBody().get(0).getNombre(), "El Codo");
        Assertions.assertEquals(respuesta.getBody().get(1).getNombre(), "Anchoita");
        Assertions.assertEquals(respuesta.getBody().get(2).getNombre(), "Don Juan");
        Assertions.assertEquals(respuesta.getBody().get(3).getNombre(), "El Groso");
    }
    @Test
    public void poisMasCercanos3(){
        ResponseEntity<List<Poi>> respuesta = controlador.obtengoLosPoiCercanos(-34.59031266097366, -58.44338422577147, 30);
        Assertions.assertTrue(respuesta.getBody().isEmpty());
    }*/

}
