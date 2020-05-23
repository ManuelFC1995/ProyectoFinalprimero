/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Enum.Estado;
import Enum.posicion;
import Modelo.Futbolista;
import Modelo.DAO.FutbolistaDAO;
import Modelo.DAO.PorteroDAO;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Portero;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author manue
 */
public class JugadoresGUI {
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



    public static void PorterosNumber() throws SQLException {
        PorteroDAO d = new PorteroDAO();
        ArrayList<Portero> porteros;
        porteros = (ArrayList<Portero>) d.SelectPorteros();
        int n = 0;
        for (Portero p : porteros) {
            n++;
            if(p.getEstado().equals(Estado.Disponible)){
              System.out.println(n+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion());   
            }
            if(p.getEstado().equals(Estado.Alineado)){
                    System.out.println(ANSI_BLACK+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion()+ANSI_RESET);   
            }
           
        }
    }

    public static void DefensasNumber() throws SQLException {
        FutbolistaDAO d = new FutbolistaDAO();
        ArrayList<Futbolista> Futbolistas;
        Futbolistas = (ArrayList<Futbolista>) d.SelectFutbolistas(QUERYS.SelectDefensas);
        int n = 0;
        for (Futbolista p : Futbolistas) {
            n++;
            if(p.getEstado().equals(Estado.Disponible))
            System.out.println(n+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion());
               if(p.getEstado().equals(Estado.Alineado))
                    System.out.println(ANSI_BLACK+n+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion()+ANSI_RESET);
        }
    }

    public static void MediosNumber() throws SQLException {
        FutbolistaDAO d = new FutbolistaDAO();
        ArrayList<Futbolista> Futbolistas;
        Futbolistas = (ArrayList<Futbolista>) d.SelectFutbolistas(QUERYS.SelectCentrocampistas);
        int n = 0;
        for (Futbolista p : Futbolistas) {
            n++;
            if(p.getEstado()==Estado.Disponible)
            System.out.println(n+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion());
               if(p.getEstado()==Estado.Alineado)
                    System.out.println(ANSI_BLACK+n+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion()+ANSI_RESET);
        }
    }

    public static void delanterosNumber() throws SQLException {
        FutbolistaDAO d = new FutbolistaDAO();
        ArrayList<Futbolista> Futbolistas;
        Futbolistas = (ArrayList<Futbolista>) d.SelectFutbolistas(QUERYS.SelectDelanteros);
        int n = 0;
        for (Futbolista p : Futbolistas) {
            n++;
             if(p.getEstado()==Estado.Disponible)
            System.out.println(n+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion());
               if(p.getEstado()==Estado.Alineado)
                    System.out.println(ANSI_BLACK+n+"." + "  " + p.getNombre() +"  "+ p.getPuntuacion()+ANSI_RESET);
        }
    }

    public static void ShowPorteros() throws SQLException {
        PorteroDAO d = new PorteroDAO();
        ArrayList<Portero> porteros;
        porteros = (ArrayList<Portero>) d.SelectPorteros();
        for (Portero p : porteros) {
            System.out.println(p.getNombre() + p.getPuntuacion()+ SUBBLANCO+"   PT"+ANSI_RESET);
        }
    }

    public static void ShowFutbolistas(String Query) throws SQLException {
      
        FutbolistaDAO f = new FutbolistaDAO();
        
        ArrayList<Futbolista> futbolistas;
        futbolistas = (ArrayList<Futbolista>) f.SelectFutbolistas(Query);
        for (Futbolista ft : futbolistas) {
            if(ft.getPosicion()==posicion.Defensa)
            System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBAMARILLO+"DF"+ANSI_RESET);
        if(ft.getPosicion()==posicion.CentroCampista)
                 System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBVERDE+"MC"+ANSI_RESET);
          if(ft.getPosicion()==posicion.Delantero)
                 System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBROJO+"dc"+ANSI_RESET);
        
            
        }
    }
     public static void ShowFutbolistasGoles(String Query) throws SQLException {
      
        FutbolistaDAO f = new FutbolistaDAO();
        
        ArrayList<Futbolista> futbolistas;
        futbolistas = (ArrayList<Futbolista>) f.SelectFutbolistas(Query);
        for (Futbolista ft : futbolistas) {
            if(ft.getPosicion()==posicion.Defensa)
            System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBAMARILLO+"DF"+ANSI_RESET+"   "+ft.getN_goles()+" Goles");
        if(ft.getPosicion()==posicion.CentroCampista)
                 System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBVERDE+"MC"+ANSI_RESET+"   "+ft.getN_goles()+" Goles");
          if(ft.getPosicion()==posicion.Delantero)
                 System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBROJO+"dc"+ANSI_RESET+"   "+ft.getN_goles()+" Goles");
        
            
        }
    }
        public static void ShowFutbolistasAsistencias(String Query) throws SQLException {
      
        FutbolistaDAO f = new FutbolistaDAO();
        
        ArrayList<Futbolista> futbolistas;
        futbolistas = (ArrayList<Futbolista>) f.SelectFutbolistas(Query);
        for (Futbolista ft : futbolistas) {
            if(ft.getPosicion()==posicion.Defensa)
            System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBAMARILLO+"DF"+ANSI_RESET+"   "+ft.getN_asistencias()+" Asistencias");
        if(ft.getPosicion()==posicion.CentroCampista)
                 System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBVERDE+"MC"+ANSI_RESET+"   "+ft.getN_asistencias()+" Asistencias");
          if(ft.getPosicion()==posicion.Delantero)
                 System.out.println(ft.getNombre() + ft.getPuntuacion() +SUBROJO+"dc"+ANSI_RESET+"   "+ft.getN_asistencias()+" Asistencias");
        
            
        }
    }
        
   
    public static String PrintPosicion(posicion p){
        String result="";
        if(p==posicion.Defensa)
            result=SUBAMARILLO+"DF"+ANSI_RESET;
         if(p==posicion.CentroCampista)
            result=SUBVERDE+"MC"+ANSI_RESET;
          if(p==posicion.Defensa)
            result=SUBROJO+"DC"+ANSI_RESET;
          
          return result;
        
    }
    
    public static void SHOWCARTAPORTERO(Portero p){
        
        if(p.getPuntuacion()>89)
        System.out.println(SUBAMARILLO+" ________________________________________"+ANSI_RESET+"\n"+
                "|  "+p.getNombre()+"      "+SUBBLANCO+"PT"+ANSI_RESET+"                   "+p.getPuntuacion()+ANSI_YELLOW+"   \n"
               +"|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+p.getNacionalidad()+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ "Palmares: "+p.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+"Partidos Jugados: "+p.getN_Partidos()+"                 \n"+SUBAMARILLO+
                " ________________________________________"+ANSI_RESET
                );
                 
             if(p.getPuntuacion()<90 && p.getPuntuacion()>70)
        System.out.println(SUBMORADO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+p.getNombre()+"         "+SUBBLANCO+"PT"+ANSI_RESET+"                       "+p.getPuntuacion()+ANSI_PURPLE+" \n"
               +"|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+p.getNacionalidad()+ANSI_PURPLE+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+p.getN_titulos()+" Titulos conseguidos"+ANSI_PURPLE+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+p.getN_Partidos()+ANSI_PURPLE+"                 \n"+
                SUBMORADO+" ________________________________________"+ANSI_RESET
                );
               if(p.getPuntuacion()<71)
        System.out.println(SUBBLANCO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+p.getNombre()+"        "+SUBBLANCO+"PT"+ANSI_RESET+"                        "+p.getPuntuacion()+" \n"
               +"|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+p.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+p.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+p.getN_Partidos()+"                 \n"+
               SUBBLANCO+ " ________________________________________"+ANSI_RESET
                );
    }
      public static void SHOWCARTADefensa(Futbolista f){
          String Posicion=PrintPosicion(f.getPosicion());
                    if(f.getPuntuacion()>89)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                    "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBAMARILLO+"DF"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
                                        if(f.getPuntuacion()>70 && f.getPuntuacion()<90)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                   "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBAMARILLO+"DF"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
                                                            if(f.getPuntuacion()<71)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                   "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBAMARILLO+"DF"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
               }
        public static void SHOWCARTAMedio(Futbolista f){
          String Posicion=PrintPosicion(f.getPosicion());
                    if(f.getPuntuacion()>89)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                   "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBVERDE+"MC"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
                                        if(f.getPuntuacion()>70 && f.getPuntuacion()<90)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                  "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBVERDE+"MC"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
                                                            if(f.getPuntuacion()<71)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                   "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBVERDE+"MC"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
               }
             public static void SHOWCARTADELANTERO(Futbolista f){
          String Posicion=PrintPosicion(f.getPosicion());
                    if(f.getPuntuacion()>89)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                   "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBROJO+"DC"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
                                        if(f.getPuntuacion()>70 && f.getPuntuacion()<90)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                   "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBROJO+"DC"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
                                                            if(f.getPuntuacion()<71)
        System.out.println(SUBAMARILLO+" ________________________________________"+"\n"+ANSI_RESET+
                "|  "+f.getNombre()+"                   "+f.getPuntuacion()+"       \n"
               +"|                                   "+SUBROJO+"DC"+ANSI_RESET+"\n"+
                "|                                        "+"|\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+f.getNacionalidad()+ANSI_YELLOW+ "                                "+"\n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+ "Palmares: "+f.getN_titulos()+" Titulos conseguidos"+"      \n"+
                "|                                        "+"|\n"+
                "|  "+ANSI_RESET+"Partidos Jugados: "+f.getN_Partidos()+"                 \n"+
               SUBAMARILLO+ " ________________________________________"+ANSI_RESET
                );
               }
    }

