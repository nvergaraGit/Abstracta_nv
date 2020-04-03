$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/cel1.feature");
formatter.feature({
  "line": 2,
  "name": "grillaAdmPicking",
  "description": "",
  "id": "grillaadmpicking",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@logingrilla"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Listar reservas filtros m�nimos",
  "description": "",
  "id": "grillaadmpicking;listar-reservas-filtros-m�nimos",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Mostrar datos en grilla",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Se realice la busqueda",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Debe mostrar todos los datos de la base de datos para esas caracteristicas",
  "keyword": "Then "
});
formatter.match({
  "location": "grillaAdminPicking.mostrar_datos_en_grilla()"
});
formatter.result({
  "duration": 6368754443,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.se_realice_la_b_squeda()"
});
formatter.result({
  "duration": 8353349652,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.debe_mostrar_todos_los_datos_de_la_base_de_datos_para_esas_caracter_sticas()"
});
formatter.result({
  "duration": 59240,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Listar reservas con filtros",
  "description": "",
  "id": "grillaadmpicking;listar-reservas-con-filtros",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Filtrar reservas en grilla",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Se realice una busqueda con filtros",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Debe mostrar las reservas con los filtros indicados",
  "keyword": "Then "
});
formatter.match({
  "location": "grillaAdminPicking.filtrar_reservas_en_grilla()"
});
formatter.result({
  "duration": 29020048,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.se_realice_una_b_squeda_con_filtros()"
});
formatter.result({
  "duration": 25741,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.debe_mostrar_las_reservas_con_los_filtros_indicados()"
});
formatter.result({
  "duration": 23625,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Quiebre de producto",
  "description": "",
  "id": "grillaadmpicking;quiebre-de-producto",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "Hacer un quiebre de una reserva",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Se procese a ingresar el quiebre en pantalla DAD",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "Se debe poder ingresar SKU substituto del articulo Quebrado",
  "keyword": "Then "
});
formatter.match({
  "location": "grillaAdminPicking.hacer_un_quiebre_de_una_reserva()"
});
formatter.result({
  "duration": 10851796,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.se_procese_a_ingresar_el_quiebre_en_pantalla_DAD()"
});
formatter.result({
  "duration": 19746,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.se_debe_poder_ingresar_SKU_substituto_del_articulo_Quebrado()"
});
formatter.result({
  "duration": 21862,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Sustituto en blanco",
  "description": "",
  "id": "grillaadmpicking;sustituto-en-blanco",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "Se tiene un quiebre de una reserva",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "No se tenga el SKU substituto del articulo quebrado",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "Se debe poder dejar en blanco el campo SKU Substituto",
  "keyword": "Then "
});
formatter.match({
  "location": "grillaAdminPicking.se_tiene_un_quiebre_de_una_reserva()"
});
formatter.result({
  "duration": 5372124,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.no_se_tenga_el_SKU_substituto_del_articulo_quebrado()"
});
formatter.result({
  "duration": 23273,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.se_debe_poder_dejar_en_blanco_el_campo_SKU_Substituto()"
});
formatter.result({
  "duration": 14810,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Sustituto valido",
  "description": "",
  "id": "grillaadmpicking;sustituto-valido",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "Se requiere ingresar SKU substituto de articulo quebrado",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Se ingrese SKU substituto",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Se debe efectuar validacion para verificar si el SKU es v�lido -Familia y SKU valido-",
  "keyword": "Then "
});
formatter.match({
  "location": "grillaAdminPicking.se_requiere_ingresar_SKU_substituto_de_articulo_quebrado()"
});
formatter.result({
  "duration": 6550218,
  "status": "passed"
});
formatter.match({
  "location": "grillaAdminPicking.se_ingrese_SKU_substituto()"
});
formatter.result({
  "duration": 22920,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});