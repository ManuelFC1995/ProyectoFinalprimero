/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;


import Data.DriverConection;
import Enum.Estado;
import Enum.posicion;
import Modelo.Futbolista;
import Modelo.Portero;
import Utilities.QUERYS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author manue
 */
public class PorteroDAO  {

    public PorteroDAO() {
    }
    Connection conexion = DriverConection.GetConnection();

    public List<Portero> SelectPorteros() throws SQLException {
        Connection conexion = DriverConection.GetConnection();
        ArrayList<Portero> ListaPorteros = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            if (conexion != null) {

                st = conexion.createStatement();
                rs = st.executeQuery("select * from porteros order by puntuacion desc");
                while (rs != null && rs.next()) {
                    Portero p = new Portero("", "", 0, 0, 0, Estado.Disponible);
                    int id = rs.getInt(1);
                    String Nombre = rs.getString(2);
                    String Nacionalidad = rs.getString(3);
                    int Puntuacion = rs.getInt(4);
                    int n_Titulos = rs.getInt(5);
                    int N_Partidos = rs.getInt(6);
                    Estado estado = Estado.Disponible;

                    p.setId(id);
                    p.setNombre(Nombre);
                    p.setNacionalidad(Nacionalidad);
                    p.setPuntuacion(Puntuacion);
                    p.setN_titulos(n_Titulos);
                    p.setN_Partidos(N_Partidos);
                    p.setEstado(estado);
                    ListaPorteros.add(p);
                }
            }

        } finally {
            if (conexion != null) {
                rs.close();
                st.close();
            }
        }
        return ListaPorteros;
    }

     public void insertPortero(Portero Portero) throws SQLException{
         PreparedStatement ps=null;
         try{
             ps=conexion.prepareStatement("INSERT INTO PORTEROS(nombre,nacionalidad,puntuacion,"
              + "n_titulos,n_partidos)VALUES(?,?,?,?,?)");
           
             ps.setString(2, Portero.getNombre());
             ps.setString(3, Portero.getNacionalidad());
             ps.setInt(4, Portero.getPuntuacion());
             ps.setInt(5, Portero.getN_titulos());
             ps.setInt(6, Portero.getN_Partidos());
            if(ps.executeUpdate()==0) {
                  throw new SQLException("NO se ha insertado correctamente");
              }
            }finally {
            if(conexion!=null){
           ps.close();
            }
        }
     }
     
     public Portero GetPortero(int id) throws SQLException{
         Portero p =new Portero();
         Statement st=null;
         ResultSet rs =null;
         try{
           if (conexion != null) {

             st = conexion.createStatement();
             rs = st.executeQuery("select * from porteros where id="+id);
            while (rs != null && rs.next()) {
             
                int ID = rs.getInt(1);
                String Nombre = rs.getString(2);
                String Nacionalidad = rs.getString(3);
                int Puntuacion = rs.getInt(4);
                int n_Titulos = rs.getInt(5);
                int N_Partidos = rs.getInt(6);
                Estado estado = Estado.Disponible;

                p.setId(id);
                p.setNombre(Nombre);
                p.setNacionalidad(Nacionalidad);
                p.setPuntuacion(Puntuacion);
                p.setN_titulos(n_Titulos);
                p.setN_Partidos(N_Partidos);
                p.setEstado(estado);
            } 
           }
        
        }finally{
             if(conexion!=null){
               rs.close();
            st.close();
             }
         }
         return p;
     }
    
      public void DeletePortero(Portero p) throws SQLException{
          Statement st=null;
       
         try{
           if (conexion != null) {

             st = conexion.createStatement();
          
             st.executeUpdate("DELETE FROM PORTEROS WHERE ID="+p.getId());
           }
         
     }finally{
           if (conexion != null){
               st.close();
           }         
                   }
}
     
     public void updatePOrteroMedia(Portero p,int media) throws SQLException{
                 Statement st=null;
       
         try{
           if (conexion != null) {

             st = conexion.createStatement();
          
             st.executeUpdate("UPDATE  PORTEROS SET PUNTUACION="+media+" WHERE id="+p.getId());
           }
         
     }finally{
           if (conexion != null){
               st.close();
           }         
     }

  
}
}
