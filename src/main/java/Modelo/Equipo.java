package Modelo;

import Enum.Estado;
import Enum.posicion;

public class Equipo implements Iequipo {

    private String Nombre;
    private Futbolista[] futbolistas = new Futbolista[10];
    private Portero portero;
    private int mediaEquipo;

    public Equipo(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Jugador[] getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(Jugador[] futbolistas) {
        this.futbolistas = (Futbolista[]) futbolistas;
    }

    public boolean AlineDefensa(Futbolista f) {
        boolean result = false;
        if (f != null && f.getPosicion().equals(posicion.Defensa)) {

            for (int i = 0; i <= 10 && result != true; i++) {
                if (futbolistas[i] == null) {
                    futbolistas[i] = f;
                    f.setEstado(Estado.Alineado);
                    result = true;
                }
            }

        }
        return result;
    }

    public boolean AlineaCentroCampista(Futbolista f) {
        boolean result = false;
        if (f != null && f.getPosicion().equals(posicion.CentroCampista)) {

            for (int i = 0; i <= 10 && result != true; i++) {
                if (futbolistas[i] == null) {
                    futbolistas[i] = f;
                     f.setEstado(Estado.Alineado);
                    result = true;
                }
            }

        }
        return result;
    }

    public boolean AlineaDelantero(Futbolista f) {
        boolean result = false;
        if (f != null && f.getPosicion().equals(posicion.Delantero)) {

            for (int i = 0; i <= 10 && result != true; i++) {
                if (futbolistas[i] == null) {
                    futbolistas[i] = f;
                     f.setEstado(Estado.Alineado);
                    result = true;
                }
            }

        }
        return result;
    }

    public boolean AlienaPortero(Portero p) {
        boolean result = false;
        if (p != null && portero == null) {
            portero = p;
             p.setEstado(Estado.Alineado);

            result = true;
        }

        return result;
    }

    public int CalculaMedia() {
        int result = 0;
        for (Futbolista f : futbolistas) {
            result = result + f.getPuntuacion();
        }
        result = result + portero.getPuntuacion();
        result = result / 11;
        return result;
    }

    @Override
    public boolean equipolleno() {
       boolean result=true;
      for(Futbolista f:futbolistas){
        if(f==null) {
            result=false;
            break;
        } 
      }return result;
    }


}
