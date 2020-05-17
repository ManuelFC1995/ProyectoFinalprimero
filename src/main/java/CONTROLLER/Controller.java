/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import Modelo.DAO.FutbolistaDAO;
import Modelo.DAO.PorteroDAO;
import Modelo.Futbolista;
import Modelo.Jugador;
import Modelo.Portero;
import Utilities.QUERYS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class Controller {
    PorteroDAO pDao= new PorteroDAO();
    FutbolistaDAO fDAo= new FutbolistaDAO();
  
    
    public ArrayList<Portero> ListPorterosPuntuacion() throws SQLException{
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
            Utilities.JugadoresGUI.ShowPorteros();
            return p;
        }
        
        public void CrearPortero(){
            
        }
}
