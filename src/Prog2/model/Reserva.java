/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;
import java.time.LocalDateTime;

public class Reserva {
    Servei servei; 
    Soci soci;
    LocalDateTime data; 
    
    public Reserva(Servei servei, Soci soci, LocalDateTime data) {
        this.servei = servei;
        this.soci = soci;
        this.data = data;
    }
    
    public LocalDateTime getData(){
        return data; 
    }
    
    public Servei getServei(){
        return servei; 
    }
    
    public Soci getSoci(){
        return soci; 
    }
    
    @Override
    public String toString(){
    return "Reserva{" +
            "servei=" + servei +
            ", soci=" + soci +
            ", data=" + data + '}';
}
}
