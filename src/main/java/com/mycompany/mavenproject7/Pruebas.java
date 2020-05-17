/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import Data.DriverConection;
import Enum.Estado;
import Enum.posicion;
import Modelo.Futbolista;
import Modelo.DAO.FutbolistaDAO;
import Modelo.Jugador;
import Utilities.JugadoresGUI;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author manue
 */
public class Pruebas {
    public static void main(String[] args) throws SQLException {
        Connection con =  DriverConection.GetConnection();
   JugadoresGUI.ShowFutbolistas();
       FutbolistaDAO fd = new FutbolistaDAO();
       Futbolista f=new Futbolista(0, 0, posicion.CentroCampista, "Nombre", "Nacionalidad", 0, 0, 0, Estado.Disponible);
      f.setId(44);
       fd.insertFutbolista(f);
          JugadoresGUI.ShowFutbolistas();
       
  
    }
}
