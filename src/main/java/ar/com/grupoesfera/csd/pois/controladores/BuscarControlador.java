package ar.com.grupoesfera.csd.pois.controladores;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BuscarControlador {
    List<Poi> listaPoi = new ArrayList<>();
    public BuscarControlador(){
        listaPoi.add(new Poi(-34.590262367384796, -58.44421345722231, "El Codo", "Parrilla"));
        listaPoi.add(new Poi(-34.589288024462725, -58.44537701779933, "Anchoita", "Restaurante"));
        listaPoi.add(new Poi(-34.5883248237654, -58.444465132614845, "Don Juan", "Pizzeria"));
    }
    @GetMapping("/buscar")
    public ResponseEntity<Poi> obtengoElPoiMasCercano(double latitud, double longitud){
        double difLatitud, difLongitud, menorLatitud, menorLongitud;

        for (Poi objeto: listaPoi){
            difLatitud = objeto.getLatitud() - latitud;
            System.out.println("dif Latitud: "+difLatitud);
            difLongitud = objeto.getLongitud() - longitud;
            System.out.println("dif Longitud: "+difLongitud);
        }

        return ResponseEntity.ok(new Poi());
    }
}
