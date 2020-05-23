/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilities.UIUtilities;
import java.sql.SQLException;
import CONTROLLER.Controller;
import Modelo.AsistenciasComparator;
import Modelo.Equipo;
import Modelo.Futbolista;
import Modelo.GoalsComparator;
import Modelo.Partido;
import Modelo.Portero;
import Utilities.JugadoresGUI;
import Utilities.QUERYS;
import java.util.Comparator;
/**
 *
 * @author manue
 */
public class INTERFAZ {
  static Controller c = new Controller();
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
                 Equipo e=c.CrearEquipo();
                 UIUtilities.clearScreen();
                 Equipo e2=c.CrearEquipo();
                 Partido p=new Partido(e2, e);
                 p.SimularPartido();
                 
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
        System.out.println("5.TODOS");
        System.out.println("6.volver");
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
                     AllPlayers();
                     break;
                case 6:
                   UIUtilities.clearScreen();
                default:
                    System.out.println("introduce una opcion correcta");
            

        } }
        while (opciones1 != 6);
    }
    
      public static void Porteros() throws SQLException{
           int opciones;
   do{     
        
        System.out.println("1.ListarPorteros");
        System.out.println("2.Actualizar Porteros");
        System.out.println("3.Eliminar Portero");
        System.out.println("4.CrearPortero");
        System.out.println("5.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                Portero p= c.ChosePortero();
                    JugadoresGUI.SHOWCARTAPORTERO(p);
                 
                    System.out.println("");
                     System.out.println("");
                      System.out.println("");
                   break;
                case 2:
                    UIUtilities.clearScreen();
             c.ActualizarPortero();
                    break;
                case 3:
                    UIUtilities.clearScreen();
                 Portero p1=  c.ChosePortero();
                 c.deletePortero(p1);
                  break;
                case 4:
                         UIUtilities.clearScreen();
                  c.crearPortero();
                    System.out.println("Portero Guardado en la Base de datos");
                  break;
                case 5:
                     UIUtilities.clearScreen();
              
                default:
                    System.out.println("introduce una opcion correcta");
            

        } 
   }while (opciones != 5);
    }
      
       public static void Defensas() throws SQLException{
            int opciones;
      do{  
       
        System.out.println("1.Listar Defensas");
        System.out.println("2.Actualizar Defensa");
        System.out.println("3.Eliminar Defensa");
     
        System.out.println("4.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
            Futbolista f1=  c.Chosedefensa();
            JugadoresGUI.SHOWCARTADefensa(f1);
                  
                    break;
                case 2:
                    UIUtilities.clearScreen();
                    Futbolista f2 =c.Chosedefensa();
               c.ActualizarJugadorPosicion(f2);
                    break;
                case 3:
                    UIUtilities.clearScreen();
                    Futbolista f3 =c.Chosedefensa();
                    c.deleteJugador(f3);
                    break;
                case 4:
                         UIUtilities.clearScreen();

                 
              
               
                default:
                    System.out.println("introduce una opcion correcta");
            

        } 
      }
      while (opciones != 4);
    }
       
         public static void Medios() throws SQLException{
             int opciones;
     do{   
      
        System.out.println("1.Listar Centrocampistas");
        System.out.println("2.Actualizar Centrocampista");
        System.out.println("3.Eliminar Centrocampista");
      
        System.out.println("4.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                   Futbolista f1=c.ChoseMedio();
                   JugadoresGUI.SHOWCARTAMedio(f1);
                    break;
                case 2:
                    UIUtilities.clearScreen();
                   UIUtilities.clearScreen();
                    Futbolista f =c.ChoseMedio();
               c.ActualizarJugadorPosicion(f);
                    break;
                case 3:
                    UIUtilities.clearScreen();
                    UIUtilities.clearScreen();
                    Futbolista fd =c.ChoseMedio();
                    c.deleteJugador(fd);
                    break;
                case 4:
                         UIUtilities.clearScreen();

            
                 
                default:
                    System.out.println("introduce una opcion correcta");
            

        }}
     while (opciones != 4);
    }
            public static void Delanteros() throws SQLException{
        
        int opciones;
        do{
        System.out.println("1.Listar Delanteros");
        System.out.println("2.Actualizar Delantero");
        System.out.println("3.Eliminar Delantero");
     
        System.out.println("4.volver");
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                  Futbolista f1=c.ChoseDelantero();
                  JugadoresGUI.SHOWCARTADELANTERO(f1);
                    break;
                case 2:
                    UIUtilities.clearScreen();
                  UIUtilities.clearScreen();
                    Futbolista f =c.ChoseDelantero();
               c.ActualizarJugadorPosicion(f);
                    break;
                case 3:
                    UIUtilities.clearScreen();
                     UIUtilities.clearScreen();
                    Futbolista fd =c.ChoseDelantero();
                    c.deleteJugador(fd);
                    break;
                case 4:
                         UIUtilities.clearScreen();

               
               
                default:
                    System.out.println("introduce una opcion correcta");
            

        } 
        }while (opciones != 4);
    }
        
   public static void AllPlayers() throws SQLException{
        
        int opciones;
        do{
        System.out.println("1.Listar Jugadores");
 
             System.out.println("2.Jugadores Por Goles");
             System.out.println("3.Jugadores Por Asistencias");
        
                    System.out.println("4.Crear Futbolista");
              System.out.println("5.Volver");
              
          opciones = UIUtilities.getInt();
               switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                    JugadoresGUI.ShowFutbolistas(QUERYS.SelectFutbolistas);
                    JugadoresGUI.ShowPorteros();
                    break;
                case 2:
                   UIUtilities.clearScreen();
                  JugadoresGUI.ShowFutbolistas(QUERYS.SelectFutbolistasGoles);
                    break;
                     case 3:
                     UIUtilities.clearScreen();
                JugadoresGUI.ShowFutbolistas(QUERYS.SelectFutbolistasAsistencias);
                    break;
          
                   
                case 4:
                    UIUtilities.clearScreen();
               c.CrearJugador();
                    break;
              
                case 5:
                     UIUtilities.clearScreen();
                default:
                    System.out.println("introduce una opcion correcta");
            

        } 
        }while (opciones != 5);
    }

    private static void Actualizardefensa() throws SQLException {
       int opciones ;
       do{
           System.out.println("1.Actualizar Puntuacion");
           System.out.println("2.Actualizar Posicion");
            System.out.println("3.Volver");
             opciones = UIUtilities.getInt();
           switch(opciones){
                   
           case 1:
            c.ActualizardefensaMEDIA();
              UIUtilities.clearScreen();
              break;
           case 2:ActualizarPosiciones();
           case 3 :
           default:
                   }
       }while(opciones!=3);
    }

    private static void ActualizarPosiciones() {
        int opciones1 ;
       do{
           System.out.println("1.Actualizar a defensa");
           System.out.println("2.Actualizar a Centrocampista");
            System.out.println("3.Actualizar a Delantero");
            System.out.println("4.Volver");
             opciones1 = UIUtilities.getInt();
           switch(opciones1){
                   
           case 1:

              UIUtilities.clearScreen();
              break;
           case 2:
                 UIUtilities.clearScreen();
                 break;
           case 3 :
                UIUtilities.clearScreen();
                break;
           case 4:
                UIUtilities.clearScreen();
           default:
                   }
       }while(opciones1!=3);
    }

  
    }
        
        
    

