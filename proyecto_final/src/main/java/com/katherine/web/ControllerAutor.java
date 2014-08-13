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
public class ControllerAutor {
    
 @RequestMapping (value = "/autor/{nombre}/{apellidoPa}/{apellidoMa}/{id_editorial}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String insertar(@PathVariable  String nombre, @PathVariable String apellidoPa, @PathVariable String apellidoMa, @PathVariable int id_editorial){ 
 try { 
 DAOAutorImpl d=new DAOAutorImpl();
 d.agregarAutor(new Autor(nombre, apellidoPa, apellidoMa, new Editorial(id_editorial)));
 return "Autor agregado correctamente"; 
 } catch (Exception e) { 
 return "El Editorial no existe"; 
 } 
 }
 
 @RequestMapping (value = "/autor/{nombre}/{apellidoPa}/{apellidoMa}/{id_editorial}", method = RequestMethod.PUT, headers = {"Accept=text/html"}) 
 public @ResponseBody String actualizar(@PathVariable  String nombre, @PathVariable String apellidoPa, @PathVariable String apellidoMa, @PathVariable int id_editorial){
 try {
 DAOAutorImpl d=new DAOAutorImpl();
 d.actualizarAutor(new Autor(nombre, apellidoPa, apellidoMa, new Editorial(id_editorial))); 
 return "Autor actualizado correctamente"; 
 } catch (Exception e) { 
 return "Error al actualizar el autor"; 
 } 
 } 
 @RequestMapping (value = "/autor/{id_autor}", method = RequestMethod.DELETE, headers = {"Accept=text/html"}) 
 public @ResponseBody String eliminar(@PathVariable int id_autor){ 
 try {
 DAOAutorImpl d=new DAOAutorImpl();
 d.borrarAutor(new Autor(id_autor)); 
 return "El autor con id" + id_autor + "se ha eliminado"; 
 } catch (Exception e) { 
 return "Error al borrar el autor buscado"; 
 } 
 } 
 @RequestMapping (value = "/autor", method = RequestMethod.GET, headers = {"Accept=Application/json"}) 
 public @ResponseBody String buscarTodosAutor() throws IOException{ 
 ObjectMapper mapper1 = new ObjectMapper(); 
 return mapper1.writeValueAsString(DAOAutorImpl.buscarTodosAutor()); 
 } 
 @RequestMapping (value = "/autor/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String buscarPorId (@PathVariable int id){ 
 return DAOAutorImpl.buscarId(id_autor).toString(); 
 } 

}