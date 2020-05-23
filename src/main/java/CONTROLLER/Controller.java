/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import Enum.Estado;
import Enum.posicion;
import Modelo.DAO.FutbolistaDAO;
import Modelo.DAO.PorteroDAO;
import Modelo.Equipo;
import Modelo.Futbolista;
import Modelo.Jugador;
import Modelo.Portero;
import Utilities.QUERYS;
import Utilities.UIUtilities;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class Controller {
        public static final String ANSI_RESET = "\u001B[0m";
    public static final String SUBBLANCO="\u001B[47;30m";
    
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public final static String SUBAMARILLO="\u001B[43;30m";
public final static String SUBMORADO="\033[45;30m";
public final static String SUBVERDE="\u001B[42;30m";
public final static String SUBROJO="\033[41;34m";
public static final String ANSI_BLACK = "\u001B[30m";
    PorteroDAO pDao= new PorteroDAO();
    FutbolistaDAO fDAo= new FutbolistaDAO();
  
    
    public  ArrayList<Portero> ListPorterosPuntuacion() throws SQLException{
       ArrayList<Portero> aux = new ArrayList<>();
       aux=(ArrayList<Portero>) pDao.SelectPorteros();
       return aux;
   }
    public ArrayList<Portero> ListaPorterosCriterio(Comparator c) throws SQLException{
         ArrayList<Portero> aux = new ArrayList<>();
       aux=(ArrayList<Portero>) pDao.SelectPorteros();
       aux.sort(c);
       return aux;
    }
    
    public ArrayList<Jugador> ListAllJugadores() throws SQLException{
        ArrayList<Jugador> aux = new ArrayList<>();
        ArrayList<Portero> p = new ArrayList<>();
        ArrayList<Futbolista> j = new ArrayList<>();
        try {
            p = (ArrayList<Portero>) pDao.SelectPorteros();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            j = (ArrayList<Futbolista>) fDAo.SelectFutbolistas(QUERYS.SelectFutbolistas);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        aux.addAll(j);
        aux.addAll(p);

        return aux;
    }
    
    public ArrayList<Futbolista> ListDefensasPuntuacion() throws SQLException{
        ArrayList<Futbolista> aux=new ArrayList<>();
        aux=(ArrayList<Futbolista>) fDAo.SelectFutbolistas(QUERYS.SelectDefensas);
        return aux;
    }
    
    public ArrayList<Futbolista> ListMediosPuntuacion() throws SQLException{
        ArrayList<Futbolista> aux=new ArrayList<>();
        aux=(ArrayList<Futbolista>) fDAo.SelectFutbolistas(QUERYS.SelectCentrocampistas);
        return aux;
    }
    public ArrayList<Futbolista> ListDelanterosPuntuacion() throws SQLException{
        ArrayList<Futbolista> aux=new ArrayList<>();
        aux=(ArrayList<Futbolista>) fDAo.SelectFutbolistas(QUERYS.SelectDelanteros);
        return aux;
    }
    
        public ArrayList<Jugador> ListAllJugadoresCriterio(Comparator c) throws SQLException{
        ArrayList<Jugador> aux = new ArrayList<>();
        ArrayList<Portero> p = new ArrayList<>();
        ArrayList<Futbolista> j = new ArrayList<>();
        try {
            p = (ArrayList<Portero>) pDao.SelectPorteros();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            j = (ArrayList<Futbolista>) fDAo.SelectFutbolistas(QUERYS.SelectFutbolistas);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        aux.addAll(j);
        aux.addAll(p);
aux.sort(c);
        return aux;
    }
        public Portero ChosePortero() throws SQLException{
            
            Portero p = new Portero();
            Utilities.JugadoresGUI.PorterosNumber();
           ArrayList<Portero> porteros=(ArrayList<Portero>) pDao.SelectPorteros();
            
            int opcion=UIUtilities.getInt();
         int contador=0;
            for(Portero pt:porteros){
               contador ++;
                  boolean result=false;
            do{ 
              
               if(contador==opcion){
                   if(pt.getEstado().equals(Estado.Disponible)){
                   p=pt;
                   break;
                   }
                   if(pt.getEstado().equals(Estado.Alineado)){
                       result=false;
                   }
               }
            }while(result=false);
            }
            return p;
        }
         public Futbolista Chosedefensa() throws SQLException{
            Futbolista f = new Futbolista();
            Utilities.JugadoresGUI.DefensasNumber();
           ArrayList<Futbolista> futbolistas= (ArrayList<Futbolista>) 
                   fDAo.SelectFutbolistas(QUERYS.SelectDefensas);
            
            int opcion=UIUtilities.getInt();
         int contador=0;
            for(Futbolista ft:futbolistas){
               contador ++;
                boolean result=false;
            do{ 
              
               if(contador==opcion){
                   if(ft.getEstado().equals(Estado.Disponible)){
                   f=ft;
                   break;
                   }
                   if(ft.getEstado().equals(Estado.Alineado)){
                       result=false;
                       System.out.println("El defensa ya fue alineado");
                   }
               }
            }while(result=false);
            }
            return f;
        }
           public Futbolista ChoseMedio() throws SQLException{
            Futbolista f = new Futbolista();
            Utilities.JugadoresGUI.MediosNumber();
           ArrayList<Futbolista> futbolistas= (ArrayList<Futbolista>) 
                   fDAo.SelectFutbolistas(QUERYS.SelectCentrocampistas);
            
            int opcion=UIUtilities.getInt();
         int contador=0;
            for(Futbolista ft:futbolistas){
               contador ++;
               if(contador==opcion){
                   f=ft;
                   break;
               }
            }
            return f;
        }
               public Futbolista ChoseDelantero() throws SQLException{
            Futbolista f = new Futbolista();
            Utilities.JugadoresGUI.delanterosNumber();
           ArrayList<Futbolista> futbolistas= (ArrayList<Futbolista>) 
                   fDAo.SelectFutbolistas(QUERYS.SelectDelanteros);
            
            int opcion=UIUtilities.getInt();
         int contador=0;
            for(Futbolista ft:futbolistas){
               contador ++;
               if(contador==opcion){
                   f=ft;
                   break;
               }
            }
            return f;
        }
        
     
        public void CrearJugador() throws SQLException{
         Futbolista j=   UIUtilities.CrearFutbolista();
         if(j.getPosicion().equals(posicion.Defensa))
             fDAo.insertDefensa(j);
           if(j.getPosicion().equals(posicion.CentroCampista))
             fDAo.inserMC(j);
            if(j.getPosicion().equals(posicion.Delantero))
             fDAo.inserDC(j);
                     
         
        }
        public void ActualizarPortero() throws SQLException{
            Portero p = new Portero();
            p=ChosePortero();
            System.out.println("Cambiar media de "+p.getPuntuacion()+" a:");
            int nuevaM;
             boolean result = true;
            do{
                nuevaM=UIUtilities.getInt();
            if(nuevaM <0 || nuevaM>99){
                System.out.println("Media no valida");
                result=false;
            }
            
            }while(result=false);
            pDao.updatePOrteroMedia(p, nuevaM);
            
        }
        
        public void ActualizardefensaMEDIA() throws SQLException{
            Futbolista f=new Futbolista();
            f=Chosedefensa();
               System.out.println("Cambiar media de "+f.getPuntuacion()+" a:");
            int nuevaM;
             boolean result = true;
            do{
                nuevaM=UIUtilities.getInt();
            if(nuevaM <0 || nuevaM>99){
                System.out.println("Media no valida");
                result=false;
            }
            
            }while(result=false);
            fDAo.updateFutbolistaMedia(f, nuevaM);
            
        }
                public void ActualizarCentrocMEDIA() throws SQLException{
            Futbolista f=new Futbolista();
            f=ChoseMedio();
               System.out.println("Cambiar media de "+f.getPuntuacion()+" a:");
            int nuevaM;
             boolean result = true;
            do{
                nuevaM=UIUtilities.getInt();
            if(nuevaM <0 || nuevaM>99){
                System.out.println("Media no valida");
                result=false;
            }
            
            }while(result=false);
            fDAo.updateFutbolistaMedia(f, nuevaM);
            
        }
      public void ActualizDelanteroMEDIA() throws SQLException{
            Futbolista f=new Futbolista();
            f=ChoseDelantero();
               System.out.println("Cambiar media de "+f.getPuntuacion()+" a:");
            int nuevaM;
             boolean result = true;
            do{
                nuevaM=UIUtilities.getInt();
            if(nuevaM <0 || nuevaM>99){
                System.out.println("Media no valida");
                result=false;
            }
            
            }while(result=false);
            fDAo.updateFutbolistaMedia(f, nuevaM);
            
        }
          public void ActualizarJugadorPosicion(Futbolista f) throws SQLException{
         
               System.out.println("Cambiar media de "+f.getPosicion()+" a:");
            posicion Posicion= UIUtilities.getPosicion();
            f.setPosicion(Posicion);
 
            
        }
          
          public  Equipo Equipo343() throws SQLException{
              System.out.println("Nombre Equipo:");
              String Nombre= UIUtilities.getString();
              Equipo e= new Equipo(Nombre);
              System.out.println("Elija Portero:");
              Portero p = new Portero();
              p=ChosePortero();
              e.AlienaPortero(p);
              p.setEstado(Estado.Alineado);
              System.out.println("Elije a tus 3 Defensas");
              Futbolista j1= new  Futbolista();
              j1=Chosedefensa();
              j1.setEstado(Estado.Alineado);
              e.AlineaJugador(j1);
               Futbolista j2= new  Futbolista();
              j2=Chosedefensa();
              e.AlineaJugador(j2);
               j2.setEstado(Estado.Alineado);
               Futbolista j3= new  Futbolista();
              j3=Chosedefensa();
              e.AlineaJugador(j3);
              j3.setEstado(Estado.Alineado);
              System.out.println("Elige a tus 4 CentreoCampistas:");
               Futbolista j4= new  Futbolista();
               j4=ChoseMedio();
               e.AlineaJugador(j4);
                j4.setEstado(Estado.Alineado);
                Futbolista j5= new  Futbolista();
               j5=ChoseMedio();
               e.AlineaJugador(j5);
                j5.setEstado(Estado.Alineado);
                 Futbolista j6= new  Futbolista();
               j6=ChoseMedio();
               e.AlineaJugador(j6);
                j6.setEstado(Estado.Alineado);
                 Futbolista j7= new  Futbolista();
               j7=ChoseMedio();
               e.AlineaJugador(j7);
                j7.setEstado(Estado.Alineado);
               System.out.println("Elije a tus 3 Delanteros:");
               Futbolista j8=new Futbolista();
               j8=ChoseDelantero();
               e.AlineaJugador(j8);
                j8.setEstado(Estado.Alineado);
                Futbolista j9=new Futbolista();
               j9=ChoseDelantero();
               e.AlineaJugador(j9);
                j9.setEstado(Estado.Alineado);
                Futbolista j10=new Futbolista();
               j10=ChoseDelantero();
               e.AlineaJugador(j10);
                j10.setEstado(Estado.Alineado);
               
                  System.out.println(e.getNombre()+"F.C\n"+
                  "PT "+ p.getNombre()+"      Puntuacion MEDIA="+e.CalculaMedia()+"\n"+
                    SUBAMARILLO+   "DF"+ ANSI_RESET+  j1.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF"+ ANSI_RESET+   j2.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF "+ ANSI_RESET+   j3.getNombre()+"\n"
                  +
                       SUBVERDE+   "MC "+ ANSI_RESET+   j4.getNombre()+"\n"
                  +
                       SUBVERDE+   "MC "+ ANSI_RESET+   j5.getNombre()+"\n"
                  +
                      SUBVERDE+   "MC "+ ANSI_RESET+     j6.getNombre()+"\n"
                    +
                      SUBVERDE+   "MC "+ ANSI_RESET+     j7.getNombre()+"\n"
                  +
                       SUBROJO+   "DC "+ ANSI_RESET+    j8.getNombre()+"\n"
                    +
                      SUBROJO+   "DC "+ ANSI_RESET+     j9.getNombre()+"\n"
                  +
                     SUBROJO+   "DC "+ ANSI_RESET+      j10.getNombre()+"\n");
               
            
              
              
              return e;
          }
          
           public  Equipo Equipo433() throws SQLException{
              System.out.println("Nombre Equipo:");
              String Nombre= UIUtilities.getString();
              Equipo e= new Equipo(Nombre);
              System.out.println("Elija Portero:");
             
              Portero p = new Portero();
              p=ChosePortero();
              e.AlienaPortero(p);
               System.err.println("Elije a tus 4 defensas:");
            UIUtilities.clearScreen();
               Futbolista j1= new  Futbolista();
              j1=Chosedefensa();
              e.AlineaJugador(j1);
              UIUtilities.clearScreen();
              
               Futbolista j2= new  Futbolista();
              j2=Chosedefensa();
              e.AlineaJugador(j2);
              UIUtilities.clearScreen();
               Futbolista j3= new  Futbolista();
              j3=Chosedefensa();
              e.AlineaJugador(j3);
              UIUtilities.clearScreen();
               Futbolista j4= new  Futbolista();
               j4=Chosedefensa();
               e.AlineaJugador(j4);
               UIUtilities.clearScreen();
               System.out.println("Elije tus 3 CentroCampistas:"); 
                Futbolista j5= new  Futbolista();
               j5=ChoseMedio();
               e.AlineaJugador(j5);
               UIUtilities.clearScreen();
               
                 Futbolista j6= new  Futbolista();
               j6=ChoseMedio();
               e.AlineaJugador(j6);
               UIUtilities.clearScreen();
                 Futbolista j7= new  Futbolista();
               j7=ChoseMedio();
               e.AlineaJugador(j7);
               UIUtilities.clearScreen();
               System.out.println("Elije tus 3 Delanteros");
               Futbolista j8=new Futbolista();
               j8=ChoseDelantero();
               e.AlineaJugador(j8);
               UIUtilities.clearScreen();
                Futbolista j9=new Futbolista();
               j9=ChoseDelantero();
               e.AlineaJugador(j9);
               UIUtilities.clearScreen();
                Futbolista j10=new Futbolista();
               j10=ChoseDelantero();
               e.AlineaJugador(j10);
               UIUtilities.clearScreen();
                System.out.println(e.getNombre()+"      Puntuacion MEDIA="+e.CalculaMedia()+"F.C\n"+
                  "PT"+ p.getNombre()+"\n"+
                    SUBAMARILLO+   "DF"+ ANSI_RESET+  j1.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF"+ ANSI_RESET+   j2.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF"+ ANSI_RESET+   j3.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF"+ ANSI_RESET+   j4.getNombre()+"\n"
                  +
                       SUBVERDE+   "MC"+ ANSI_RESET+   j5.getNombre()+"\n"
                  +
                      SUBVERDE+   "MC"+ ANSI_RESET+     j6.getNombre()+"\n"
                    +
                      SUBVERDE+   "MC"+ ANSI_RESET+     j7.getNombre()+"\n"
                  +
                       SUBROJO+   "DC"+ ANSI_RESET+    j8.getNombre()+"\n"
                    +
                      SUBROJO+   "DC"+ ANSI_RESET+     j9.getNombre()+"\n"
                  +
                     SUBROJO+   "DC"+ ANSI_RESET+      j10.getNombre()+"\n");
               
               
               
               
            
              
              
              return e;
          }
           
           
              public  Equipo Equipo442() throws SQLException{
              System.out.println("Nombre Equipo:");
              String Nombre= UIUtilities.getString();
              Equipo e= new Equipo(Nombre);
              System.out.println("Elija Portero:");
             
              Portero p = new Portero();
              p=ChosePortero();
              e.AlienaPortero(p);
               System.err.println("Elije a tus 4 defensas:");
            UIUtilities.clearScreen();
               Futbolista j1= new  Futbolista();
              j1=Chosedefensa();
              e.AlineaJugador(j1);
              UIUtilities.clearScreen();
               Futbolista j2= new  Futbolista();
              j2=Chosedefensa();
              e.AlineaJugador(j2);
              UIUtilities.clearScreen();
               Futbolista j3= new  Futbolista();
              j3=Chosedefensa();
              e.AlineaJugador(j3);
              UIUtilities.clearScreen();
               Futbolista j4= new  Futbolista();
               j4=Chosedefensa();
               e.AlineaJugador(j4);
               UIUtilities.clearScreen();
               System.out.println("Elije tus 4 CentroCampistas:"); 
                Futbolista j5= new  Futbolista();
               j5=ChoseMedio();
               e.AlineaJugador(j5);
               UIUtilities.clearScreen();
               
                 Futbolista j6= new  Futbolista();
               j6=ChoseMedio();
               e.AlineaJugador(j6);
               UIUtilities.clearScreen();
                 Futbolista j7= new  Futbolista();
               j7=ChoseMedio();
               e.AlineaJugador(j7);
               UIUtilities.clearScreen();
              
               Futbolista j8=new Futbolista();
               j8=ChoseMedio();
               e.AlineaJugador(j8);
                System.out.println("Elije tus 2 Delanteros");
                UIUtilities.clearScreen();
               
                Futbolista j9=new Futbolista();
               j9=ChoseDelantero();
               e.AlineaJugador(j9);
               UIUtilities.clearScreen();
               
                Futbolista j10=new Futbolista();
               j10=ChoseDelantero();
               e.AlineaJugador(j10);
               UIUtilities.clearScreen();
               
                  System.out.println(e.getNombre()+"F.C\n"+
                  "PT"+ p.getNombre()+"      Puntuacion MEDIA="+e.CalculaMedia()+"\n"+
                    SUBAMARILLO+   "DF "+ ANSI_RESET+  j1.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF "+ ANSI_RESET+   j2.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF "+ ANSI_RESET+   j3.getNombre()+"\n"
                  +
                       SUBAMARILLO+   "DF "+ ANSI_RESET+   j4.getNombre()+"\n"
                  +
                       SUBVERDE+   "MC "+ ANSI_RESET+   j5.getNombre()+"\n"
                  +
                      SUBVERDE+   "MC "+ ANSI_RESET+     j6.getNombre()+"\n"
                    +
                      SUBVERDE+   "MC "+ ANSI_RESET+     j7.getNombre()+"\n"
                  +
                       SUBVERDE+   "MC "+ ANSI_RESET+    j8.getNombre()+"\n"
                    +
                      SUBROJO+   "DC "+ ANSI_RESET+     j9.getNombre()+"\n"
                  +
                     SUBROJO+   "DC "+ ANSI_RESET+      j10.getNombre()+"\n");
               
               
            
              
              
              return e;
          }
           
         public Equipo CrearEquipo() throws SQLException{
             System.out.println("Elija su Alineacion");
             System.out.println("1. 3-4-3");
                 System.out.println("2. 4-3-3");
                     System.out.println("3. 4-4-2");
                     System.out.println("Volver");
                         int opcion;  
                         Equipo Result= new Equipo("");
                   
                         opcion = UIUtilities.getInt();
                         
                  switch (opcion){
                         case 1: Result=Equipo343();
                         break;
                         case 2:
                          Result=Equipo433();
                          break;
                          case 3: 
                          Result=Equipo442();
                          break;
                          case 4:
                              UIUtilities.clearScreen();
                     }
                   
             return Result;
         }  
           
          public void SimularPartido(Equipo E1, Equipo E2) throws SQLException {

        int e1Media = E1.CalculaMedia();
        int e2Media = E2.CalculaMedia();
        int golesE1 = 0;
        int GolesE2 = 0;

        if (e1Media * Math.random() * 1 > 40) {
            golesE1++;
        }
        if (e1Media * Math.random() * 1 > 50) {
            golesE1++;
        }
        if (e1Media * Math.random() * 1 > 60) {
            golesE1++;
        }
        if (e1Media * Math.random() * 1 > 65) {
            golesE1++;
        }
        if (e1Media * Math.random() * 1 > 70) {
            golesE1++;
        }
        if (e1Media * Math.random() * 1 > 80) {
            golesE1++;
        }

        if (e1Media * Math.random() * 1 > 90) {
            golesE1++;
        }

        if (e2Media * Math.random() * 1 > 40) {
            GolesE2++;
        }
        if (e2Media * Math.random() * 1 > 50) {
            GolesE2++;
        }

        if (e2Media * Math.random() * 1 > 60) {
            GolesE2++;
        }

        if (e2Media * Math.random() * 1 > 65) {
            GolesE2++;
        }

        if (e2Media * Math.random() * 1 > 70) {
            GolesE2++;
        }
        if (e2Media * Math.random() * 1 > 80) {
            GolesE2++;
        }
        if (e2Media * Math.random() * 1 > 90)
            GolesE2++;
          
          
               System.out.println("RESUlTADO:");
               System.out.println(E1.getNombre()+"  "+golesE1+ " - "+GolesE2+"  "+E2.getNombre());
             
           }
            
        
        public void deletePortero(Portero p) throws SQLException{
            pDao.DeletePortero(p);
        }
        public void deleteJugador(Futbolista f) throws SQLException{
            fDAo.DeleteFutbolista(f);
        }
        
        public void crearPortero() throws SQLException{
          Portero p=  UIUtilities.CrearPortero();
          pDao.insertPortero(p);
        }
       
}
