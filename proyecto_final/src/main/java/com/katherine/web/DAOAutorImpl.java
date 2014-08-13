package com.katherine.web;

import java.util.ArrayList;
import org.hibernate.Query;

public class DAOAutorImpl extends DAO {

        
public void agregarAutor(Autor x) { 
         begin(); 
         getSession().save(x); 
         commit(); 
         close(); 
     } 
      
     public void borrarAutor(Autor x){ 
         begin(); 
         getSession().delete(x); 
        commit(); 
         close(); 
     } 
      
     public void actualizarAutor(Autor x){ 
         begin(); 
         getSession().update(x); 
         commit(); 
         close(); 
     } 
      
     public ArrayList<Autor> buscarTodosAutor() { 
         begin(); 
         Query q = getSession().createQuery("from Autor"); 
         ArrayList<Autor> xx = (ArrayList<Autor>)q.list(); 
         commit(); 
         close(); 
         return xx;  
     } 
      
        
     public Autor buscarPorId(int id){ 
         begin(); 
        Query q = getSession().createQuery("from Autor where id = :id"); 
         q.setInteger("id",id); 
         Autor xx = (Autor)q.uniqueResult(); 
         commit(); 
         close(); 
         return xx; 
     } 
      
 } 

    

