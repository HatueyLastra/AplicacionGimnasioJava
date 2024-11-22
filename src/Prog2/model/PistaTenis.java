/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;

/**
 *
 * @author Hatuey
 */
public class PistaTenis extends Pista {
    String tipusSuperficie;
    String tipusXarxa;
    
    public PistaTenis(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusSuperficie_, String tipusXarxa_){
        super.nom = nom_;
        super.idServei = idServei_;
        super.iluminada = iluminada_;
        super.tipusTanca = tipusTanca_;
        super.mida = mida_;
        this.tipusSuperficie = tipusSuperficie_;
        this.tipusXarxa = tipusXarxa_;
    }
    
    @Override
    public boolean correcteFuncionament() {
        // Este método debería ser implementado según los criterios específicos de PistaTenis
        return !tipusXarxa.equals("Sense");
    }
}
