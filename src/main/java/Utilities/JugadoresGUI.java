/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Modelo.Futbolista;
import Modelo.DAO.FutbolistaDAO;
import Modelo.DAO.PorteroDAO;
import Modelo.Portero;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manue
 */
public class JugadoresGUI {
   
    public static void PorterosALL() throws SQLException{
         PorteroDAO d=new PorteroDAO();
   ArrayList<Portero> porteros;
        porteros = (ArrayList<Portero>) d.SelectPorteros();
        int n=0;
        for(Portero p:porteros){
           n++;
            System.out.println(n+""+p);
        }
    }
     public static void ShowPorteros() throws SQLException{
         PorteroDAO d=new PorteroDAO();
   ArrayList<Portero> porteros;
        porteros = (ArrayList<Portero>) d.SelectPorteros();
        for(Portero p:porteros){
            System.out.println(p.getNombre()+p.getPuntuacion());
        }
    }
     public static void ShowFutbolistas() throws SQLException{
         FutbolistaDAO f=new FutbolistaDAO();
         ArrayList<Futbolista> futbolistas;
         futbolistas=(ArrayList<Futbolista>) f.SelectFutbolistas(QUERYS.SelectFutbolistas);
         for(Futbolista ft:futbolistas){
             System.out.println(ft.getNombre()+ft.getPuntuacion()+ft.getPosicion());
         }
     }
}
