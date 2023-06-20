//------------------------------------------------------------------------------
// Autor: Rolando Pedro Gabriel
// Fecha de creación: 16/06/2023
// Fecha de actualización:
// Descripción: Desarrollo de una aplicación Java para simular un cronómetro. 
//              esta clase iplementa el objeto Tiempo.
//------------------------------------------------------------------------------

package entity;

public class Tiempo {
    // Declaracción de los atributos de la clase Tiempo
    private int segundo;
    private int minuto;
    private int hora;

    // Implementación de los métodos Get y Set
    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    } 
}
