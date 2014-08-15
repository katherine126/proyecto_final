package com.katherine.web;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOEditorialImpl extends DAO{
    
    public static void agregarEditorial(Editorial z) { 
         begin(); 
         getSession().save(z); 
         commit(); 
         close(); 
     } 
      
     public static void borrarEditorial(Editorial z){ 
         begin(); 
         getSession().delete(z); 
         commit(); 
         close(); 
     } 
      
     public static void actualizarEditorial(Editorial z){ 
         begin(); 
         getSession().update(z); 
         commit(); 
         close(); 
     } 
      
     public static ArrayList<Editorial> buscarTodosEditorial() { 
         begin(); 
         Criteria q = getSession().createCriteria(Editorial.class); 
         ArrayList<Editorial> zz = (ArrayList<Editorial>)q.list(); 
         commit(); 
         close(); 
         return zz;  
     } 
      
        
     public static Editorial buscarPorId(int id){ 
         begin(); 
        Query q = getSession().createQuery("from Editorial where id = :id"); 
         q.setInteger("id",id); 
         Editorial zz = (Editorial)q.uniqueResult(); 
         commit(); 
         close(); 
         return zz; 
     } 
    
}
