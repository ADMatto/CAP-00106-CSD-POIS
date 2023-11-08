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
        listaPoi.add(new Poi(-34.590262367384796, -58.44421345722231, "El Groso", "Parrilla"));
    }
    @GetMapping("/buscar")
    public ResponseEntity<Poi> obtengoElPoiMasCercano(double latitud, double longitud){
        double distanciaMenor = -1;
        double distancia;
        int poiMenor = 0;
        for (Poi poi:listaPoi){
            // d=√((x_2-x_1)²+(y_2-y_1)²)
            distancia = Math.sqrt(Math.pow(poi.getLatitud()-latitud, 2)+Math.pow(poi.getLongitud()-longitud, 2));
            if (distanciaMenor == -1 ){
                distanciaMenor = distancia;
            } else if (distancia < distanciaMenor){
                distanciaMenor = distancia;
                poiMenor = listaPoi.indexOf(poi);
            } else if (distancia == distanciaMenor){
                if (listaPoi.get(poiMenor).getNombre().compareTo(poi.getNombre())> 0){
                    poiMenor = listaPoi.indexOf(poi);
                }
            }
        }
        return ResponseEntity.ok(listaPoi.get(poiMenor));
    }
    @GetMapping("/buscarPoiCercanos")
    public ResponseEntity<List<Poi>> obtengoLosPoiCercanos(double latitud, double longitud, double radio){
        List<Poi> poiCercanos = new ArrayList<>();
        double distancia;
        for (Poi poi:listaPoi){
            // d=√((x_2-x_1)²+(y_2-y_1)²)
            distancia = Math.sqrt(Math.pow(poi.getLatitud()-latitud, 2)+Math.pow(poi.getLongitud()-longitud, 2));
            if (distancia*100000 <= radio) {
                poiCercanos.add(poi);
            }
        }
        return ResponseEntity.ok(poiCercanos);
    }
    @GetMapping("/ping")
    public ResponseEntity<Pong> obtengoElPongDeLaAplicacion(){
        return ResponseEntity.ok(new Pong());
    }
}
