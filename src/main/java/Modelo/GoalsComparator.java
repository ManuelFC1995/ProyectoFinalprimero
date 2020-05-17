/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Comparator;

/**
 *
 * @author manue
 */
public class GoalsComparator implements Comparator<Futbolista> {

   

    @Override
    public int compare(Futbolista o1, Futbolista o2) {
      return o1.getN_goles()-o2.getN_goles();
    }
    
}
