package ar.com.grupoesfera.csd.pois.aceptacion.pasos;

import ar.com.grupoesfera.csd.pois.aceptacion.configuracion.ContextoCompartido;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PedidosHTTPPasos {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContextoCompartido contextoCompartido;

    @When("el cliente hace un GET a {string}")
    public void elClienteHaceUnGETA(String ruta) throws Exception {
        ResultActions resultado = mockMvc.perform(get(ruta));
        this.contextoCompartido.agregarResultado(resultado);
    }
    @Given("dado que estoy ubicado en latitud {string} y longitud {string}")
    public void ubicacionActual(String latitud, String longitud){

    }
    @Then("recibe la respuesta {string}")
    public void recibeRespuestaPoi(String respuestaEsperada){
        //Assertions.assertEquals(respuestaEsperada, respuesta.getBody().getNombre());
    }

    @Then("recibe la respuesta con codigo de estado {int} y contenido")
    public void recibeLaRespuestaConCodigoDeEstadoYContenido(int codigoDeEstado, String respuesta) throws Exception {

        ResultActions resultado = this.contextoCompartido.obtenerResultado();

        resultado.andExpect(status().is(codigoDeEstado))
                .andExpect(json()
                        .when(Option.IGNORING_ARRAY_ORDER)
                        .isEqualTo(respuesta)
                );
    }

    /*@Given("dado que estoy ubicado en latitud {string} y longitud {string} y un {int}")
    public void dadoQueEstoyUbicadoEnLatitudYLongitudYUnRadio(String arg0, String arg1, int radio) {
        ResponseEntity<List<Poi>> respuesta = controlador.obtengoLosPoiCercanos(-34.59031266097366, -58.44338422577147, 150);
    }*/
}
