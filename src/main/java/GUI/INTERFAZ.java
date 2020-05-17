/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilities.UIUtilities;
import java.sql.SQLException;

/**
 *
 * @author manue
 */
public class INTERFAZ {
    public static void principal() throws SQLException{
        int opciones;
        System.out.println("MANUEL F.C");
                System.out.println("");
    do{    
        System.out.println("1.CATALOGO JUGADORES");
        System.out.println("2.JUGAR PARTIDO");
         System.out.println("3.SALIR");
        
        
         opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                  Catalogo();
                    break;
                case 2:
                    UIUtilities.clearScreen();
                 
                    break;
              
                case 3:
                    System.out.println("Hasta luego");

                    break;
                default:
                    System.out.println("introduce una opcion correcta");
            

        } }
    while (opciones != 3);
    }
    
    public static void Catalogo() throws SQLException{
        
        int opciones1;
        do{
        System.out.println("1.PORTEROS");
        System.out.println("2.DEFENSAS");
        System.out.println("3.CENTROCAMPISTAS");
        System.out.println("4.DELANTEROS");
        System.out.println("5.volver");
          opciones1 = UIUtilities.getInt();
               switch (opciones1) {
                case 1:
                    UIUtilities.clearScreen();
                  Porteros();
                    break;
                case 2:
                    UIUtilities.clearScreen();
                 Defensas();
                    break;
                case 3:
                    UIUtilities.clearScreen();
                   Medios();
                    break;
                case 4:
                         UIUtilities.clearScreen();
                   Delanteros();
                    break;
                case 5:
                     UIUtilities.clearScreen();
                 
                default:
                    System.out.println("introduce una opcion correcta");
            

        } }
        while (opciones1 != 5);
    }
    
      public static void Porteros() throws SQLException{
        
        int opciones;
        System.out.println("1.ListarPorteros");
        System.out.println("2.Actualizar Porteros");
        System.out.println("3.Eliminar Portero");
        System.out.println("4.CrearPortero");
        System.out.println("5.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                  Utilities.JugadoresGUI.ShowPorteros();
                    break;
                case 2:
                    UIUtilities.clearScreen();
                 
                    break;
                case 3:
                    UIUtilities.clearScreen();
                   
                    break;
                case 4:
                         UIUtilities.clearScreen();

                    break;
                case 5:
                     UIUtilities.clearScreen();
              
                default:
                    System.out.println("introduce una opcion correcta");
            

        } while (opciones != 5);
    }
      
       public static void Defensas(){
            int opciones;
      do{  
       
        System.out.println("1.Listar Defensas");
        System.out.println("2.Actualizar Defensa");
        System.out.println("3.Eliminar Ddefensa");
        System.out.println("4.Crear Defensa");
        System.out.println("5.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                  
                    break;
                case 2:
                    UIUtilities.clearScreen();
                 
                    break;
                case 3:
                    UIUtilities.clearScreen();
                   
                    break;
                case 4:
                         UIUtilities.clearScreen();

                    break;
                case 5:
                     UIUtilities.clearScreen();
               
                default:
                    System.out.println("introduce una opcion correcta");
            

        } 
      }
      while (opciones != 5);
    }
       
         public static void Medios(){
             int opciones;
     do{   
      
        System.out.println("1.Listar Centrocampistas");
        System.out.println("2.Actualizar Centrocampista");
        System.out.println("3.Eliminar Centrocampista");
        System.out.println("4.Crear Centrocampista");
        System.out.println("5.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                  
                    break;
                case 2:
                    UIUtilities.clearScreen();
                 
                    break;
                case 3:
                    UIUtilities.clearScreen();
                   
                    break;
                case 4:
                         UIUtilities.clearScreen();

                    break;
                case 5:
                     UIUtilities.clearScreen();
                 
                default:
                    System.out.println("introduce una opcion correcta");
            

        }}
     while (opciones != 5);
    }
            public static void Delanteros(){
        
        int opciones;
        do{
        System.out.println("1.Listar Delanteros");
        System.out.println("2.Actualizar Delantero");
        System.out.println("3.Eliminar Delantero");
        System.out.println("4.Crear Delantero");
        System.out.println("5.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                  
                    break;
                case 2:
                    UIUtilities.clearScreen();
                 
                    break;
                case 3:
                    UIUtilities.clearScreen();
                   
                    break;
                case 4:
                         UIUtilities.clearScreen();

                    break;
                case 5:
                     UIUtilities.clearScreen();
               
                default:
                    System.out.println("introduce una opcion correcta");
            

        } 
        }while (opciones != 5);
    }
        
   public static void AllPlayers(){
        
        int opciones;
        do{
        System.out.println("1.Listar Jugadores");
         System.out.println("2.Jugadores Por N_Titulos");
             System.out.println("3.Jugadores Por Goles");
             System.out.println("4.Jugadores Por Asistencias");
              System.out.println("5.Jugadores Por n_Partidos");
              System.out.println("6.Volver");
              
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                  
                    break;
                case 2:
                    UIUtilities.clearScreen();
                 
                    break;
                     case 3:
                    UIUtilities.clearScreen();
                  
                    break;
                case 4:
                    UIUtilities.clearScreen();
                 
                    break;
                     case 5:
                    UIUtilities.clearScreen();
                  
                    break;
                case 6:
                    UIUtilities.clearScreen();
                 
                    break;
              
               
                default:
                    System.out.println("introduce una opcion correcta");
            

        } 
        }while (opciones != 6);
    }
        
        
    
}
