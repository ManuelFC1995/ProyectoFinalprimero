/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Enum.Estado;
import Enum.posicion;

/**
 *
 * @author manue
 */
public class Futbolista extends Jugador {
 private  int n_goles;
 private int n_asistencias;
 private posicion posicion;

    public int getN_goles() {
        return n_goles;
    }

    public void setN_goles(int n_goles) {
        this.n_goles = n_goles;
    }

    public int getN_asistencias() {
        return n_asistencias;
    }

    public void setN_asistencias(int n_asistencias) {
        this.n_asistencias = n_asistencias;
    }

    public posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(posicion posicion) {
        this.posicion = posicion;
    }

    public Futbolista(int n_goles, int n_asistencias, posicion posicion, String Nombre, String Nacionalidad, int puntuacion, int N_titulos, int N_Partidos, Estado estado) {
        super(Nombre, Nacionalidad, puntuacion, N_titulos, N_Partidos, estado);
        this.n_goles = n_goles;
        this.n_asistencias = n_asistencias;
        this.posicion = posicion;
    }

   
    
  

  
    public Futbolista() {
    }
    
    
    
    public void CambiaPosicion(posicion p){
        this.posicion=p;
    }

    @Override
    public String toString() {
        return "Futbolista{" + "n_goles=" + n_goles + ", n_asistencias=" + n_asistencias + ", posicion=" + posicion + '}';
    }
    
}
