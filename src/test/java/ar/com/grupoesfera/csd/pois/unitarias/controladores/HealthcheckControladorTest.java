package ar.com.grupoesfera.csd.pois.unitarias.controladores;

import ar.com.grupoesfera.csd.pois.controladores.HealthcheckControlador;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.Pong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class HealthcheckControladorTest {

    @InjectMocks
    private HealthcheckControlador controlador;

    @Test
    public void seDevuelveUnPongAlConsultarElPing(){

        ResponseEntity<Pong> respuesta = controlador.obtengoElPongDeLaAplicacion();

        Pong cuerpo = respuesta.getBody();

        assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
        assertThat(cuerpo).isNotNull();
        assertThat(cuerpo.getMensaje()).isEqualTo("pong");
    }

    @Test
    public void poiMasCercano(){
        // Ejecucion
        ResponseEntity<Poi> respuesta = controlador.obtengoElPoiMasCercano(-34.59026795901409, -58.443649741046286);

        // Verificacion
        Assertions.assertEquals("El Codo", respuesta.getBody().getNombre());

    }
}
