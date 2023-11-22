package ar.com.grupoesfera.csd.pois.controladores;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.repositorio.RepositorioDePoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BuscarControlador {
    @Autowired
    RepositorioDePoi repositorioDePoi;

    List<Poi> listaPoi = new ArrayList<>();
    @GetMapping("/buscar")
    public ResponseEntity<Poi> obtengoElPoiMasCercano(double latitud, double longitud){
        listaPoi = repositorioDePoi.findAll();
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
    @GetMapping("/guardar")
    public String guardarPoi(double latitud, double longitud, String nombre, String descripcion){
        Poi nuevoPoi = new Poi(latitud, longitud, nombre, descripcion);
        repositorioDePoi.save(nuevoPoi);
        return "OK";
    }

    @GetMapping("/crearIntinerario")
    public List<Poi> crearIntinerario(double latitud, double longitud, double radio){
        List<Poi> listaIntinerario = new ArrayList<>();
        List<Poi> listaPoi = obtengoLosPoiCercanos(latitud, longitud,radio).getBody();
        double distanciaMenor = -1;
        double distancia;
        int poiMenor = 0;
        while (listaIntinerario.size() < listaPoi.size()){
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
        }
        return listaIntinerario;
    }
}
