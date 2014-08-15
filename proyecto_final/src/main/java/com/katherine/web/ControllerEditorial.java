package com.katherine.web;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/") 
public class ControllerEditorial {
    
    @RequestMapping (value = "/editorial/{nombre}/{direccion}/{telefono}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String insertar(@PathVariable  String nombre, @PathVariable String direccion, @PathVariable String telefono){ 
 try { 
 DAOEditorialImpl d=new DAOEditorialImpl();
 d.agregarEditorial(new Editorial(nombre, direccion, telefono));
 return "Editorial agregado correctamente"; 
 } catch (Exception e) { 
 return "El Editorial no existe"; 
 } 
 }
 
 @RequestMapping (value = "/editorial/{nombre}/{direccion}/{telefono}", method = RequestMethod.PUT, headers = {"Accept=text/html"}) 
 public @ResponseBody String actualizar(@PathVariable  String nombre, @PathVariable String direccion, @PathVariable String telefono){
 try {
 DAOEditorialImpl d=new DAOEditorialImpl();
 d.actualizarEditorial(new Editorial(nombre, direccion, telefono)); 
 return "Editorial actualizado correctamente"; 
 } catch (Exception e) { 
 return "Error al actualizar la editorial"; 
 } 
 } 
 @RequestMapping (value = "/editorial/{id_editorial}", method = RequestMethod.DELETE, headers = {"Accept=text/html"}) 
 public @ResponseBody String eliminar(@PathVariable int id_editorial){ 
 try {
 DAOEditorialImpl d=new DAOEditorialImpl();
 d.borrarEditorial(new Editorial(id_editorial)); 
 return "La editorial con id" + id_editorial + "se ha eliminado"; 
 } catch (Exception e) { 
 return "Error al borrar la editorial buscado"; 
 } 
 } 
 @RequestMapping (value = "/editorial", method = RequestMethod.GET, headers = {"Accept=Application/json"}) 
 public @ResponseBody String buscarTodosEditorial() throws IOException{ 
 ObjectMapper mapper1 = new ObjectMapper(); 
 return mapper1.writeValueAsString(DAOEditorialImpl.buscarTodosEditorial()); 
 } 
 @RequestMapping (value = "/editorial/{id_editorial}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String buscarPorId (@PathVariable int id_editorial){ 
 return DAOEditorialImpl.buscarPorId(id_editorial).toString(); 
 } 
}
