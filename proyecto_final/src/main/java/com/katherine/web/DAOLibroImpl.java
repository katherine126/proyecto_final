
package com.katherine.web;

import static com.katherine.web.DAO.close;
import static com.katherine.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOLibroImpl extends DAO{
    
    public static void agregarLibro(Libro y) { 
         begin(); 
         getSession().save(y); 
         commit(); 
         close(); 
     } 
      
     public static void borrarLibro(Libro y){ 
         begin(); 
         getSession().delete(y); 
        commit(); 
         close(); 
     } 
      
     public static void actualizarLibro(Libro y){ 
         begin(); 
         getSession().update(y); 
         commit(); 
         close(); 
     } 
      
     public static ArrayList<Libro> buscarTodosLibro() { 
         begin(); 
         Criteria q = getSession().createCriteria(Libro.class); 
         ArrayList<Libro> yy = (ArrayList<Libro>)q.list(); 
         commit(); 
         close(); 
         return yy;  
     } 
      
        
     public static Libro buscarPorId(int id){ 
         begin(); 
        Query q = getSession().createQuery("from Libro where id = :id"); 
         q.setInteger("id",id); 
         Libro yy = (Libro)q.uniqueResult(); 
         commit(); 
         close(); 
         return yy; 
     } 
    
}
