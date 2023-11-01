package ar.com.grupoesfera.csd.pois.controladores;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.Pong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class HealthcheckControlador {
    List<Poi> listaPoi = new ArrayList<>();
    public HealthcheckControlador(){
        listaPoi.add(new Poi(-34.590262367384796, -58.44421345722231, "El Codo", "Parrilla"));
        listaPoi.add(new Poi(-34.589288024462725, -58.44537701779933, "Anchoita", "Restaurante"));
        listaPoi.add(new Poi(-34.5883248237654, -58.444465132614845, "Don Juan", "Pizzeria"));
    }
    @GetMapping("/buscar")
    public ResponseEntity<Poi> obtengoElPoiMasCercano(double latitud, double longitud){
        return ResponseEntity.ok(new Poi(234, 234, "Test", "Se devuelva"));
    }
    @GetMapping("/ping")
    public ResponseEntity<Pong> obtengoElPongDeLaAplicacion(){
        return ResponseEntity.ok(new Pong());
    }
}
