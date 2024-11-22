/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2.model;
import java.util.*;
import Prog2.vista.ExcepcioReserva;
import java.time.LocalDateTime; 

public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> llista; 
    
    public LlistaReserves() {
        this.llista = new ArrayList<>();
    }
    
   public boolean serveiDisponible(Servei servei, LocalDateTime data) {
    Iterator<Reserva> iterator = llista.iterator();

    while(iterator.hasNext()) {
        Reserva reserva = iterator.next();
        LocalDateTime dataFinalExistente = reserva.getData().plusMinutes(reserva.getServei().getTempsSlotReserva());
        LocalDateTime dataFinalNovaReserva = data.plusMinutes(servei.getTempsSlotReserva());

        // Verificar si el servicio funciona correctamente antes de comprobar la disponibilidad!
        if (servei.correcteFuncionament() && data.isBefore(dataFinalExistente) && dataFinalNovaReserva.isAfter(reserva.getData()) && reserva.getServei().getIdServei().equals(servei.getIdServei())) {
            return true;
            }
        }
        return false;
    }
    
    @Override
    public void afegirReserva(Servei servei, Soci soci, LocalDateTime data) throws ExcepcioReserva {
        // Verificar si el servicio está disponible antes de intentar agregar la reserva
        if (serveiDisponible(servei, data)) {
            // Crear la reserva y agregarla a la lista de reservas
            Reserva reserva = new Reserva(servei, soci, data); 
            llista.add(reserva);
        } else {
            // Lanzar una excepción si el servicio no está disponible
            throw new ExcepcioReserva("El servei amb identificador " + servei.getIdServei() +
                    " no està disponible en la data demanada " + data +
                    " pel soci " + soci.getNom() + "amb DNI: " + soci.getDni() +".");
        }
    }
    
}

