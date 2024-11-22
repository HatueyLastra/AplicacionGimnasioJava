/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;

public abstract class Servei implements InServeiReservable {
    String nom;
    String idServei;
    long tempsSlotReserva;

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
    

    @Override
    public String getIdServei() {
        return idServei;
    }

    @Override
    public void setIdServei(String id) {
        this.idServei = id;
    }

    @Override
    public long getTempsSlotReserva() {
        // Tiempo predeterminado de reserva. 
        return tempsSlotReserva;
    }

    @Override
    public void setTempsSlotReserva(long tempsSlotReserva) {
        this.tempsSlotReserva = tempsSlotReserva;
    }
    
    @Override
    public abstract boolean correcteFuncionament();
    
    @Override
    public String toString(){
        return "Servei{" +
                "id='" + idServei + '\'' +
                ", nom='" + nom + '\'' +
                ", tempsSlotReserva=" + tempsSlotReserva + '}';
    }

    
    
}
