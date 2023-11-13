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
    @GetMapping("/ping")
    public ResponseEntity<Pong> obtengoElPongDeLaAplicacion(){
        return ResponseEntity.ok(new Pong());
    }
}
