/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;
import Prog2.vista.ExcepcioReserva;
import java.time.LocalDateTime;
import java.util.*;

public class Gimnas implements InGimnas{
    String nom;
    ArrayList<Servei> llistaServeis = new ArrayList<>();
    ArrayList<Soci> llistaSocis = new ArrayList<>();
    LlistaReserves llistaReserves = new LlistaReserves();
    
    public Gimnas(String nom) {
       this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
                }

    @Override
    public int getNumServeis() {
        return llistaServeis.size();
    }

    @Override
    public void afegirSoci(String nom_, String dni_) {
        Soci soci = new Soci(nom_,dni_);
        llistaSocis.add(soci);
    }

    @Override
    public void afegirPistaTenis(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusSuperficie_, String tipusXarxa_) {
        PistaTenis pistaTenis = new PistaTenis(nom_,idServei_,iluminada_,tipusTanca_,mida_,tipusSuperficie_,tipusXarxa_);
        llistaServeis.add(pistaTenis);
    }

    @Override
    public void afegirPistaFutbol(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusPorteries_, int numPorteries_) {
        PistaFutbol pistaFutbol = new PistaFutbol(nom_,idServei_,iluminada_,tipusTanca_,mida_,tipusPorteries_,numPorteries_);
        llistaServeis.add(pistaFutbol);
    }

    @Override
    public void afegirSalaFitness(String nom_, String idServei_, int numMaquines_, boolean monitor_) {
        SalaFitness salaFitness = new SalaFitness(nom_,idServei_,numMaquines_,monitor_);
        llistaServeis.add(salaFitness);
    }

    @Override
    public float calculMidaTotalPistes(){
        float medidaTotal= 0;
        Iterator<Servei> iterator = llistaServeis.iterator();
        while(iterator.hasNext()){
            Servei servei = iterator.next();
            if(servei instanceof PistaTenis){
                PistaTenis pistaTenis = (PistaTenis) servei; 
                medidaTotal += pistaTenis.mida; 
            } else if(servei instanceof PistaFutbol){
                PistaFutbol pistaFutbol = (PistaFutbol) servei; 
                medidaTotal += pistaFutbol.mida; 
            }
        }
        return medidaTotal; 
    }

    @Override
    public int calculServeisOperatius() {
        int serveisOperatius = 0;
        // Iterar sobre la lista de servicios y contar los servicios operativos
        Iterator<Servei> iterator = llistaServeis.iterator();
        while(iterator.hasNext()) {
            Servei servei = iterator.next();
            if (servei.correcteFuncionament()) {
                serveisOperatius++;
            }
        }
        
        return serveisOperatius;
    }
    
    public Servei buscarServei(String idServei){
        Iterator<Servei> iterator = llistaServeis.iterator();
        while(iterator.hasNext()){
            Servei servei = iterator.next();
            if(servei.getIdServei().equals(idServei)){
                return servei; 
            }
        }
        return null; 
    }
    
    public Soci buscarSoci(String dni){
        Iterator<Soci> iterator = llistaSocis.iterator(); 
        while(iterator.hasNext()){
            Soci soci = iterator.next(); 
            if(soci.dni_.equals(dni)){
                return soci; 
            }
        }
        return null; 
    }
    
    @Override
    public void afegirReserva(String idServei_, String dni_, LocalDateTime data_) throws ExcepcioReserva {
        Servei servei = buscarServei(idServei_);
        if (servei == null) {
            throw new ExcepcioReserva("El servei amb identificador " + idServei_ + " no existeix.");
        }
        
        Soci soci = buscarSoci(dni_);
        if (soci == null) {
            throw new ExcepcioReserva("El soci amb DNI " + dni_ + " no existeix.");
        }

        if (llistaReserves.serveiDisponible(servei, data_)) {
            throw new ExcepcioReserva("El servei amb identificador " + idServei_ + " no està disponible en la data demanada " + data_ + " pel soci " + soci.getNom() + " amb DNI: " + dni_ + ".");
        } else {
        llistaReserves.afegirReserva(servei, soci, data_);
    }
}

}