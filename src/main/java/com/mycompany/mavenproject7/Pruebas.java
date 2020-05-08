/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import Data.DriverConection;
import java.sql.Connection;

/**
 *
 * @author manue
 */
public class Pruebas {
    public static void main(String[] args) {
        Connection con =  DriverConection.GetConnection();
        
    }
}
