
package Modelo;

import Enum.Estado;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;




 public abstract  class Jugador implements Comparable<Jugador> {
private int id;
private String Nombre;
private String Nacionalidad;
private int nacimiento;
private int puntuacion;
private String clubes;
private int n_Titulos;
private String Titulos;
private String Titulos_individuales;
private int N_Partidos;
private Estado estado;

    public Jugador(String Nombre, String Nacionalidad, int nacimiento, int puntuacion, String clubes, int n_Titulos, String Titulos, String Titulos_individuales, int N_Partidos) {
        this.Nombre = Nombre;
        this.Nacionalidad = Nacionalidad;
        this.nacimiento = nacimiento;
        this.puntuacion = puntuacion;
        this.clubes = clubes;
        this.n_Titulos = n_Titulos;
        this.Titulos = Titulos;
        this.Titulos_individuales = Titulos_individuales;
        this.N_Partidos = N_Partidos;
        this.estado=estado.Disponible;
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

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getClubes() {
        return clubes;
    }

    public void setClubes(String clubes) {
        this.clubes = clubes;
    }

    public int getN_Titulos() {
        return n_Titulos;
    }

    public void setN_Titulos(int n_Titulos) {
        this.n_Titulos = n_Titulos;
    }

    public String getTitulos() {
        return Titulos;
    }

    public void setTitulos(String Titulos) {
        this.Titulos = Titulos;
    }

    public String getTitulos_individuales() {
        return Titulos_individuales;
    }

    public void setTitulos_individuales(String Titulos_individuales) {
        this.Titulos_individuales = Titulos_individuales;
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
