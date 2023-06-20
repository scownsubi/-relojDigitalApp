//------------------------------------------------------------------------------
// Autor: Rolando Pedro Gabriel
// Fecha de creación: 16/06/2023
// Fecha de actualización:
// Descripción: Desarrollo de una aplicación Java para simular un cronómetro. 
//              esta clase codifica la capa controller para establecer comunica-
//              entre la entidad y la vista.
//------------------------------------------------------------------------------

package controller;

import entity.Tiempo;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.PanelReloj;

public class TiempoController implements Runnable {
    // Declaración de los atributo de la clase TiempoController
    private final Tiempo tiempo;

    /**
     * Este constructor recibe un objeto de tipo Tiempo para para establecer
     * su valor a la variable tiempo de la clase.
     * @param tiempo objeto de tipo tiempo.
     */
    public TiempoController(Tiempo tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Método para iniciar el cronómetro con sus respectivas variables: horas, 
     * minutos y Segundos.
     * @throws java.lang.InterruptedException
     */
    public void start() throws InterruptedException {
        if (this.tiempo.getSegundo() + 1 == 60) {
            if (this.tiempo.getMinuto() + 1 == 60) {
                this.tiempo.setHora(this.tiempo.getHora() + 1);
                this.tiempo.setMinuto(0);
            } 
            this.tiempo.setMinuto(this.tiempo.getMinuto() + 1);         
            this.tiempo.setSegundo(0);
        }
        this.tiempo.setSegundo(this.tiempo.getSegundo()+1);
        
        // Dado que este método es invocado dentro del método run, aquí se 
        // se estable el tiempo de espera para la ejecución del hilo.
        Thread.sleep(1000);
    }   

    /**
     * Este método es propiamente de la interfaz Runnable y permite poner en 
     * ejecución un hilo.
     */
    @Override
    public void run() {
        while(true) {
            try {
                // Este metodo valida los límite de los valores de los segundos,
                // los minutos y las horas.
                this.start();
                // Este método puede ser invocado mediante la clase PanelReloj,
                // por lo que el método fue declarado como método estátio en la 
                // clase PanelReloj.
                 PanelReloj.ejecutarCronometro();
            } catch (InterruptedException ex) {
                Logger.getLogger(TiempoController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }                          
        }
    }
}
