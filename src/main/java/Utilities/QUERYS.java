/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author manue
 */
public class QUERYS {
     public  final static String SelectFutbolistas="select * from Futbolistas order by puntuacion desc";
         public  final static String SelectFutbolistasTitulos="select * from Futbolistas order by n_titulos desc";
          public  final static String SelectFutbolistasGoles="select * from Futbolistas order by n_goles desc";
             public  final static String SelectFutbolistasAsistencias="select * from Futbolistas order by n_Asistencias desc";
                    public  final static String SelectFutbolistasPartidos="select * from Futbolistas order by n_partidos desc";
       public   final static String SelectDefensas="select * from Futbolistas where posicion=1 order by puntuacion desc";
       public      final static  String SelectCentrocampistas="select * from Futbolistas where posicion = 2 order by puntuacion desc";
        public        final static String SelectDelanteros="select * from Futbolistas where posicion = 3 order by puntuacion desc";
     
     public final static String InsertarFutbolista="INSERT INTO FUTBOLISTAS (ID,nombre,nacionalidad,puntuacion,"
              + " n_titulos,n_partidos,n_goles,n_asistencias,"
              + "posicion) VALUES(? ,?, ?, ?, ?, ?, ?, ?,?)";
    public  final static String InsertarPortero="INSERT INTO PORTEROS(ID,nombre,nacionalidad,puntuacion,"
              + "n_titulos,n_partidos)VALUES(?,?,?,?,?,?)";
}
