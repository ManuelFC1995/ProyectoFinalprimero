/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import CONTROLLER.Controller;
import Data.DriverConection;
import Enum.Estado;
import Enum.posicion;
import Modelo.Futbolista;
import Modelo.DAO.FutbolistaDAO;
import Modelo.Jugador;
import Modelo.Portero;
import Utilities.JugadoresGUI;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author manue
 */
public class Pruebas {
    public static void main(String[] args) throws SQLException {
     
      Controller c= new Controller();
      c.CrearEquipo();
  
    }
}
