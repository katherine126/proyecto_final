package com.katherine.web;

import java.util.ArrayList;
import org.hibernate.Query;

public class DAOEditorialImpl extends DAO{
    
    public void agregarEditorial(Editorial z) { 
         begin(); 
         getSession().save(z); 
         commit(); 
         close(); 
     } 
      
     public void borrarEditorial(Editorial z){ 
         begin(); 
         getSession().delete(z); 
         commit(); 
         close(); 
     } 
      
     public void actualizarEditorial(Editorial z){ 
         begin(); 
         getSession().update(z); 
         commit(); 
         close(); 
     } 
      
     public ArrayList<Editorial> buscarTodosEditorial() { 
         begin(); 
         Query q = getSession().createQuery("from Editorial"); 
         ArrayList<Editorial> zz = (ArrayList<Editorial>)q.list(); 
         commit(); 
         close(); 
         return zz;  
     } 
      
        
     public Editorial buscarPorId(int id){ 
         begin(); 
        Query q = getSession().createQuery("from Editorial where id = :id"); 
         q.setInteger("id",id); 
         Editorial zz = (Editorial)q.uniqueResult(); 
         commit(); 
         close(); 
         return zz; 
     } 
    
}
