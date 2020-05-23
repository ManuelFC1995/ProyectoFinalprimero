/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;

/**
 *
 * @author manue
 */
public class Partido {



   



 Equipo Local;
 Equipo Visitante;
    public Partido() {
    }

    public Partido(Equipo Local, Equipo Visitante) {
        this.Local = Local;
        this.Visitante = Visitante;
    }
   
   

  

    


             
          public void SimularPartido() throws SQLException {

        int e1Media = Local.CalculaMedia();
        int e2Media = Visitante.CalculaMedia();
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
               System.out.println(Local.getNombre()+"  "+golesE1+ " - "+GolesE2+"  "+Visitante.getNombre());
             
           }
            

  
    
}
