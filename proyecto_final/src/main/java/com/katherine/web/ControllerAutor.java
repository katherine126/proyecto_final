
package com.katherine.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/") 


public class ControllerAutor {
    
 @RequestMapping (value = "/cuenta/{total_autor}/{id_autor}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String insertar(@PathVariable float total_venta, @PathVariable int id_autor){ 
 try { 
 DAOAutorImpl.insertar(new Autor(total_venta, new autor(id_autor))); 
 return "Autor agregado correctamente"; 
 } catch (Exception e) { 
 return "El autor no existe"; 
 } 
 }
 
 @RequestMapping (value = "/cuenta/{id_cuenta}/{total_venta}/{id_usuario}", method = RequestMethod.PUT, headers = {"Accept=text/html"}) 
 public @ResponseBody String actualizar(@PathVariable int id_cuenta, @PathVariable float total_venta, @PathVariable int id_usuario){ 
 try { 
 DAOCuentaImpl.actualizar(new Cuenta(id_cuenta,total_venta, new Usuario(id_usuario))); 
 return "Cuenta actualizada correctamente"; 
 } catch (Exception e) { 
 return "Error al actualizar la cuenta"; 
 } 
 } 
 @RequestMapping (value = "/cuenta/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"}) 
 public @ResponseBody String eliminar(@PathVariable int id_cuenta){ 
 try { 
 DAOCuentaImpl.borrar(new Cuenta(id_cuenta)); 
 return "La cuenta con id" + id_cuenta + "se ha eliminado"; 
 } catch (Exception e) { 
 return "Error al borrar la cuenta buscada"; 
 } 
 } 
 @RequestMapping (value = "/cuenta", method = RequestMethod.GET, headers = {"Accept=Application/json"}) 
 public @ResponseBody String buscarTodos () throws IOException{ 
 ObjectMapper mapper1 = new ObjectMapper(); 
 return mapper1.writeValueAsString(DAOCuentaImpl.buscarTodos()); 
 } 
 @RequestMapping (value = "/cuenta/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
 public @ResponseBody String buscarPorId (@PathVariable int id){ 
 return DAOCuentaImpl.buscarId(id).toString(); 
 } 

}
