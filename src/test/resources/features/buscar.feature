Feature: Como usuario, quiero encontrar el punto de
    interés más cercano a mi ubicación actual, para
    saber a qué sitio ir.

    Scenario: Dada una ubicacion debe mostrar el punto de interes mas cercano
        Given dado que estoy ubicado en latitud "-34.59031266097366" y longitud "-58.44338422577147"
        When el cliente hace un GET a "/buscar"
        Then recibe la respuesta "El Codo"

    Scenario: Dada una ubicacion debe mostrar el punto de interes mas cercano alfabeticamente
        Given dado que estoy ubicado en latitud "-34.591341021147144" y longitud "-58.44310964927456"
        When el cliente hace un GET a "/buscar"
        Then recibe la respuesta "El Codo"