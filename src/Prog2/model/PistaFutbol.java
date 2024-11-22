/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;

public class PistaFutbol extends Pista{
    String tipusPorteries;
    int numPorteries;
        public PistaFutbol(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusPorteries_, int numPorteries_){
        super.nom = nom_;
        super.idServei = idServei_;
        super.iluminada = iluminada_;
        super.tipusTanca = tipusTanca_;
        super.mida = mida_;
        this.tipusPorteries= tipusPorteries_;
        this.numPorteries = numPorteries_; 
    }
        
    @Override
    public boolean correcteFuncionament() {
        return numPorteries > 2;
    }
        
}
