/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;

public class Soci {
    String nom_;
    String dni_;
    
    Soci(String nom_,String dni_) {
        this.nom_ = nom_;
        this.dni_ = dni_;
    }
    
    public String getNom(){
        return nom_; 
    }
    
    public String getDni(){
        return dni_; 
    }
    
    public String toString(){
        return "Soci{" +
                "dni='" + dni_ + '\'' +
                ",nom='" + nom_ + '\'' + '}';
    }
}
