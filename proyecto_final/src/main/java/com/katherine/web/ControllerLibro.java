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
public class ControllerLibro {
    
   @RequestMapping (value = "/libro/{titulo)/{autor}/{editorial}/{id_autor}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String insertar(@PathVariable  String titulo, @PathVariable String autor, @PathVariable String editorial, @PathVariable int id_autor){ 
 try { 
 DAOLibroImpl d=new DAOLibroImpl();
 d.agregarLibro(new Libro(titulo, autor, editorial, new Autor(id_autor)));
 return "Libro agregado correctamente"; 
 } catch (Exception e) { 
 return "El libro no existe"; 
 } 
 }
 
 @RequestMapping (value = "/libro/{titulo)/{autor}/{editorial}/{id_autor}", method = RequestMethod.PUT, headers = {"Accept=text/html"}) 
 public @ResponseBody String actualizar(@PathVariable  String titulo, @PathVariable String autor, @PathVariable String editorial, @PathVariable int id_autor){
 try {
 DAOLibroImpl d=new DAOLibroImpl();
 d.actualizarLibro(new Libro(titulo, autor, editorial, new Autor(id_autor))); 
 return "Libro actualizado correctamente"; 
 } catch (Exception e) { 
 return "Error al actualizar el libro"; 
 } 
 } 
 @RequestMapping (value = "/libro/{id_libro}", method = RequestMethod.DELETE, headers = {"Accept=text/html"}) 
 public @ResponseBody String eliminar(@PathVariable int id_libro){ 
 try {
 DAOLibroImpl d=new DAOLibroImpl();
 d.borrarLibro(new Libro(id_libro)); 
 return "El libro con id" + id_libro + "se ha eliminado"; 
 } catch (Exception e) { 
 return "Error al borrar el libro buscado"; 
 } 
 } 
 @RequestMapping (value = "/libro", method = RequestMethod.GET, headers = {"Accept=Application/json"}) 
 public @ResponseBody String buscarTodosLibro() throws IOException{ 
 ObjectMapper mapper1 = new ObjectMapper(); 
 return mapper1.writeValueAsString(DAOLibroImpl.buscarTodosLibro()); 
 } 
 @RequestMapping (value = "/libro/{id_libro}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String buscarPorId (@PathVariable int id_libro){ 
 return DAOLibroImpl.buscarPorId(id_libro).toString(); 
 } 
}
