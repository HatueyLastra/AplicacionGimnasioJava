/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;

public class SalaFitness extends Servei{
    int numMaquines;
    boolean monitor;
    
    public SalaFitness(String nom_, String idServei_, int numMaquines_, boolean monitor_){
        super.nom = nom_;
        super.idServei = idServei_;
        this.numMaquines = numMaquines_;
        this.monitor = monitor_;
    }
    
    @Override
    public boolean correcteFuncionament() {
        return numMaquines > 0;
    }

}
