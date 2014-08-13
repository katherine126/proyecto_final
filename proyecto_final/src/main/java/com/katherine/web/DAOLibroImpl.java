
package com.katherine.web;

import static com.katherine.web.DAO.close;
import static com.katherine.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

public class DAOLibroImpl extends DAO{
    
    public void agregarLibro(Libro y) { 
         begin(); 
         getSession().save(y); 
         commit(); 
         close(); 
     } 
      
     public void borrarLibro(Libro y){ 
         begin(); 
         getSession().delete(y); 
        commit(); 
         close(); 
     } 
      
     public void actualizarLibro(Libro y){ 
         begin(); 
         getSession().update(y); 
         commit(); 
         close(); 
     } 
      
     public ArrayList<Libro> buscarTodosLibro() { 
         begin(); 
         Query q = getSession().createQuery("from Libro"); 
         ArrayList<Libro> yy = (ArrayList<Libro>)q.list(); 
         commit(); 
         close(); 
         return yy;  
     } 
      
        
     public Libro buscarPorId(int id){ 
         begin(); 
        Query q = getSession().createQuery("from Libro where id = :id"); 
         q.setInteger("id",id); 
         Libro yy = (Libro)q.uniqueResult(); 
         commit(); 
         close(); 
         return yy; 
     } 
    
}
