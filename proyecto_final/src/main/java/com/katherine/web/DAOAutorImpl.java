package com.katherine.web;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOAutorImpl extends DAO {

        
public static void agregarAutor(Autor x) { 
         begin(); 
         getSession().save(x); 
         commit(); 
         close(); 
     } 
      
     public static void borrarAutor(Autor x){ 
         begin(); 
         getSession().delete(x); 
        commit(); 
         close(); 
     } 
      
     public static void actualizarAutor(Autor x){ 
         begin(); 
         getSession().update(x); 
         commit(); 
         close(); 
     } 
      
     public static ArrayList<Autor> buscarTodosAutor() { 
         begin(); 
         Criteria q = getSession().createCriteria(Autor.class); 
         ArrayList<Autor> xx = (ArrayList<Autor>)q.list(); 
         commit(); 
         close(); 
         return xx;  
     } 
      
        
     public static Autor buscarPorId(int id){ 
         begin(); 
        Query q = getSession().createQuery("from Autor where id = :id"); 
         q.setInteger("id",id); 
         Autor xx = (Autor)q.uniqueResult(); 
         commit(); 
         close(); 
         return xx; 
     } 
      
 } 

    

