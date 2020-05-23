/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Data.DriverConection;
import Enum.Estado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Enum.posicion;
import Modelo.Futbolista;
import java.sql.PreparedStatement;


public class FutbolistaDAO {

    Connection conexion = DriverConection.GetConnection();

    final String cargarAllFutbolistas = "select * from Futbolistas order by puntuacion desc";

    final String InsertarFutbolista = "INSERT INTO FUTBOLISTAS (nombre,nacionalidad,puntuacion,"
            + " n_titulos,n_partidos,n_goles,n_asistencias,posicion)"
            + "posicion) VALUES(?, ?, ?, ?, ?, ?, ?,?)";

    public List<Futbolista> SelectFutbolistas(String Query) throws SQLException {

        ArrayList<Futbolista> ListaFutbolistas = new ArrayList<>();

        if (conexion != null) {

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Query);
            try {

                while (rs != null && rs.next()) {
                    Futbolista p = new Futbolista(0, 0, posicion.CentroCampista, "", "", 0, 0, 0, Estado.Disponible);
                    int id = rs.getInt(1);
                    String Nombre = rs.getString(2);
                    String Nacionalidad = rs.getString(3);
                    int Puntuacion = rs.getInt(4);
                    int n_Titulos = rs.getInt(5);
                    int N_Partidos = rs.getInt(6);
                    Estado estado = Estado.Disponible;
                    int goles = rs.getInt(7);
                    int asistencias = rs.getInt(8);
                    int posicionInt = rs.getInt(9);
                    posicion posicion1;
                    if (posicionInt == 1) {
                        posicion1 = posicion.Defensa;
                    }
                    if (posicionInt == 2) {
                        posicion1 = posicion.CentroCampista;
                    }
                    if (posicionInt == 3) {
                        posicion1 = posicion.Delantero;
                    } else {
                        posicion1 = null;
                    }
                    p.setId(id);
                    p.setNombre(Nombre);
                    p.setNacionalidad(Nacionalidad);
                    p.setPuntuacion(Puntuacion);
                    p.setN_titulos(n_Titulos);
                    p.setN_Partidos(N_Partidos);
                    p.setEstado(estado);
                    p.setN_goles(goles);
                    p.setN_asistencias(asistencias);
                    p.setPosicion(posicion1);
                    ListaFutbolistas.add(p);
                }
            } finally {
                rs.close();
                st.close();
            }
        }
        return ListaFutbolistas;
    }

    public void insertDefensa(Futbolista futbolista) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(InsertarFutbolista);
           
            ps.setString(1, futbolista.getNombre());
            ps.setString(2, futbolista.getNacionalidad());
            ps.setInt(3, futbolista.getPuntuacion());
            ps.setInt(4, futbolista.getN_titulos());
            ps.setInt(5, futbolista.getN_Partidos());
            ps.setInt(6, futbolista.getN_goles());
            ps.setInt(7, futbolista.getN_asistencias());
           
                ps.setInt(8, 1);
       
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
      public void inserMC(Futbolista futbolista) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(InsertarFutbolista);
           
            ps.setString(1, futbolista.getNombre());
            ps.setString(2, futbolista.getNacionalidad());
            ps.setInt(3, futbolista.getPuntuacion());
            ps.setInt(4, futbolista.getN_titulos());
            ps.setInt(5, futbolista.getN_Partidos());
            ps.setInt(6, futbolista.getN_goles());
            ps.setInt(7, futbolista.getN_asistencias());
           
                ps.setInt(8, 2);
       
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
        public void inserDC(Futbolista futbolista) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(InsertarFutbolista);
           
            ps.setString(1, futbolista.getNombre());
            ps.setString(2, futbolista.getNacionalidad());
            ps.setInt(3, futbolista.getPuntuacion());
            ps.setInt(4, futbolista.getN_titulos());
            ps.setInt(5, futbolista.getN_Partidos());
            ps.setInt(6, futbolista.getN_goles());
            ps.setInt(7, futbolista.getN_asistencias());
           
                ps.setInt(8, 3);
       
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public Futbolista GetFutbolista(int id) throws SQLException {
        Futbolista p = new Futbolista();
        Statement st = null;
        ResultSet rs = null;
        try {
            if (conexion != null) {

                st = conexion.createStatement();
                rs = st.executeQuery("select * from futbolistas where id=" + id);
                while (rs != null && rs.next()) {

                    int ID = rs.getInt(1);
                    String Nombre = rs.getString(2);
                    String Nacionalidad = rs.getString(3);
                    int Puntuacion = rs.getInt(4);
                    int n_Titulos = rs.getInt(5);
                    int N_Partidos = rs.getInt(6);
                    Estado estado = Estado.Disponible;
                    int goles = rs.getInt(7);
                    int asistencias = rs.getInt(8);
                    int posicionInt = rs.getInt(9);
                    posicion posicion1;
                    if (posicionInt == 1) 
                        posicion1 = posicion.Defensa;
                    
                    if (posicionInt == 2) 
                        posicion1 = posicion.CentroCampista;
                   
                    if (posicionInt == 3) {
                        posicion1 = posicion.Delantero;
                    } else {
                        posicion1 = null;
                    }

                    p.setId(id);
                    p.setNombre(Nombre);
                    p.setNacionalidad(Nacionalidad);
                    p.setPuntuacion(Puntuacion);
                    p.setN_titulos(n_Titulos);
                    p.setN_Partidos(N_Partidos);
                    p.setEstado(estado);
                    p.setN_goles(goles);
                    p.setN_asistencias(asistencias);
                    p.setPosicion(posicion1);

                }
            }

        } finally {
            if(conexion!=null){
            rs.close();
            st.close();
            }
        }
        return p;
    }

    public void DeleteFutbolista(Futbolista f) throws SQLException {
          Statement st=null;
       
         try{
           if (conexion != null) {

             st = conexion.createStatement();
          
             st.executeUpdate("DELETE FROM Futbolistas WHERE ID="+f.getId());
           }
         
     }finally{
           if (conexion != null){
               st.close();
           }         
                   }
    }

    public void updateFutbolistaMedia(Futbolista f,int media) throws SQLException {
                 Statement st=null;
       
         try{
           if (conexion != null) {

             st = conexion.createStatement();
          
             st.executeUpdate("UPDATE  PORTEROS SET PUNTUACION="+media+" WHERE id="+f.getId());
           }
         
     }finally{
           if (conexion != null){
               st.close();
           }         
     }
    }
    public void updateDefensaPosicion(Futbolista f ,posicion p) throws SQLException{
        Statement st=null;
        try{
            if (conexion != null){
         
                    
             st = conexion.createStatement();
          
             st.executeUpdate("UPDATE  PORTEROS SET POSICION=1 WHERE id="+f.getId());
                }
            
        }finally{
                       if (conexion != null){
               st.close();
        }
        }
    }
      public void updateMedioPosicion(Futbolista f ,posicion p) throws SQLException{
        Statement st=null;
        try{
            if (conexion != null){
              
                    
             st = conexion.createStatement();
          
             st.executeUpdate("UPDATE  PORTEROS SET POSICION=2 WHERE id="+f.getId());
                
            } 
        }finally{
                       if (conexion != null){
               st.close();
        }
        }
    }
        public void updateDCPosicion(Futbolista f ,posicion p) throws SQLException{
        Statement st=null;
        try{
            if (conexion != null){
              
                    
             st = conexion.createStatement();
          
             st.executeUpdate("UPDATE  PORTEROS SET POSICION=3 WHERE id="+f.getId());
                
            } 
        }finally{
                       if (conexion != null){
               st.close();
        }
        }
    }
}
