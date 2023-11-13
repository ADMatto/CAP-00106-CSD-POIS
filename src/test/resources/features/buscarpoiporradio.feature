Feature:
  Como usuario, quiero conocer todos los puntos de
  interés que se encuentran a una distancia
  determinada de mi ubicación actual, para poder
  decidir a qué sitio ir.

  Scenario Outline: Dada una ubicacion y un determinado radio, debe devolver los poi dentro de ese radio
    Given dado que estoy ubicado en latitud "-34.59031266097366" y longitud "-58.44338422577147" y un <radio>
    When el cliente hace un GET a "/buscarPoiCercanos"
    Then recibe la respuesta <listaEsperada>

    Examples:
      |radio  | listaEsperada                    |
      |150    | "El Codo,Anchoita"            |
      |250    | "El Codo,Anchoita,Don Juan"|
      |30     | ""                               |