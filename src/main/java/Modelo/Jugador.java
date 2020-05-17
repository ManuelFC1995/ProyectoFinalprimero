
package Modelo;

import Enum.Estado;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;




 public abstract  class Jugador implements Comparable<Jugador> {
private  int id;
private String Nombre;
private String Nacionalidad;
private static int contador;
private int puntuacion;
private int N_titulos;
private int N_Partidos;
private Estado estado;

    public Jugador(String Nombre, String Nacionalidad, int puntuacion, int N_titulos, int N_Partidos, Estado estado) {
       id=contador++;
        this.Nombre = Nombre;
        this.Nacionalidad = Nacionalidad;
        this.puntuacion = puntuacion;
        this.N_titulos = N_titulos;
        this.N_Partidos = N_Partidos;
        this.estado = estado;
        contador++;
    }



    public Jugador() {
        this.id=contador++;
        this.Nombre="";
        this.Nacionalidad="";
        this.puntuacion = 0;
        this.N_titulos=0;
        this.N_Partidos = N_Partidos;
        this.estado=estado.Disponible;
        contador++;
    }
    
    

    public Estado getEstado() {
        return estado;
    }
    

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
 


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

 
 

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getN_titulos() {
        return N_titulos;
    }

    public void setN_titulos(int N_titulos) {
        this.N_titulos = N_titulos;
    }

 





    public int getN_Partidos() {
        return N_Partidos;
    }

    public void setN_Partidos(int N_Partidos) {
        this.N_Partidos = N_Partidos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Jugador o) {
    return   this.puntuacion-o.puntuacion;
    }




}
