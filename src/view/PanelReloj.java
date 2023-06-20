//------------------------------------------------------------------------------
// Autor: Rolando Pedro Gabriel
// Fecha de creación: 16/06/2023
// Fecha de actualización:
// Descripción: Desarrollo de una aplicación Java para simular un cronómetro. 
//              Esta clase codifica la capa de la vista para ejecutar los boto-
//              nes que utilizaba para defencia profesional controller para 
//              establecer comunicación entre la entidad y la vista.
//------------------------------------------------------------------------------
package view;

import controller.TiempoController;
import entity.Tiempo;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PanelReloj extends javax.swing.JPanel {
    // Declaración de variables de la clase PanelReloj
    private Thread hilo;
    private Tiempo tiempo;
    private TiempoController tiempoController;    
   
    // Variable de tipo PanelReloj con propiedad estatic
    private static PanelReloj este;
    
    // Variables para los íconos de iniciar, detener.
    private final ImageIcon iconPlay1;
    private final ImageIcon iconPlay2;
    private final ImageIcon iconStop;
    
    // Permite manipular los eventos del hilo, para iniciar y parar. También 
    // permite el cambio de los íconos en un mismo botón.
    private boolean booleanIniciarParar = false;
    
    // Valida que la creación de los objetos se realice una sola vez.
    private boolean booleanIniciar = false;

    public PanelReloj() {
        initComponents();
        este = this;
        iconPlay1 = new ImageIcon("src/images/play1.png");
        iconPlay2 = new ImageIcon("src/images/play2.png");
        iconStop = new ImageIcon("src/images/stop.png");
        
        this.tiempo = new Tiempo();
        this.tiempoController = new TiempoController(este.tiempo);   
        this.btnIniciarParar.setIcon(this.iconPlay2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelHMS = new javax.swing.JLabel();
        btnIniciarParar = new javax.swing.JButton();

        jLabelHMS.setBackground(new java.awt.Color(0, 153, 153));
        jLabelHMS.setFont(new java.awt.Font("Digital Display", 0, 24)); // NOI18N
        jLabelHMS.setForeground(new java.awt.Color(89, 198, 239));
        jLabelHMS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHMS.setText("00:00:00");

        btnIniciarParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play1.png"))); // NOI18N
        btnIniciarParar.setContentAreaFilled(false);
        btnIniciarParar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarPararMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarPararMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarPararMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelHMS, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnIniciarParar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabelHMS, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciarParar)
                .addGap(74, 74, 74))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPararMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarPararMouseClicked
        if (!this.booleanIniciarParar) {
            if (!this.booleanIniciar) {
                // Esto se realiza una sola vez.
                this.tiempo = new Tiempo();
                this.tiempoController = new TiempoController(este.tiempo);             
                booleanIniciar = true;
            } 
            // Se crea el hilo con el controllador como parámetro.
            this.hilo = new Thread(este.tiempoController);
            // Se inicia el hilo
            this.hilo.start();
            
            this.btnIniciarParar.setIcon(this.iconStop);
            booleanIniciarParar = true;
        } else {
            this.hilo.stop();
            booleanIniciarParar = false;
            this.btnIniciarParar.setIcon(this.iconPlay1);
        }
    }//GEN-LAST:event_btnIniciarPararMouseClicked

    private void btnIniciarPararMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarPararMouseExited
        if (!booleanIniciarParar) {
            this.btnIniciarParar.setIcon(this.iconPlay2);
        }
    }//GEN-LAST:event_btnIniciarPararMouseExited

    private void btnIniciarPararMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarPararMouseEntered
        if (!booleanIniciarParar) {
            this.btnIniciarParar.setIcon(this.iconPlay1);
        }
    }//GEN-LAST:event_btnIniciarPararMouseEntered

    public static void ejecutarCronometro() throws InterruptedException {
        // if ternarios para colocar un cero a la izquiera cuando los valores
        // son menores a diez, para mostrar dos valores en la vista.
        String segundos = este.tiempo.getSegundo() < 10 ? "0" 
                + String.valueOf(este.tiempo.getSegundo()) 
                : String.valueOf(este.tiempo.getSegundo());
        
        String minutos = este.tiempo.getMinuto() < 10 ? "0" 
                + String.valueOf(este.tiempo.getMinuto()) 
                : String.valueOf(este.tiempo.getMinuto());
        
        String horas = este.tiempo.getHora() < 10 ? "0" 
                + String.valueOf(este.tiempo.getHora()) 
                : String.valueOf(este.tiempo.getHora());

        este.jLabelHMS.setText(horas + ":" + minutos + ":" + segundos);

        // Se llama a un contener despues de que se le añadieron componentes a
        // la interfaz.
        este.revalidate();
        // Se redibujan los componentes.
        este.repaint();
    }

    /**
     * Método propia del JPanel. En este método se carga la imágen de fondo del 
     * JPanel que simula la carátula de un cronómetro.
     * @param g objeto de Graphics para trabjar con los pixeles del JPanel.
     */
    @Override
    public void paint(Graphics g) {
        // Se obtiene la dimensión del JPanel
        Dimension height = this.getSize();

        // Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon Img = new ImageIcon(getClass().getResource("/images/caratula.jpg"));

        // Se dibuja la imagen que tenemos en el paquete images //dentro de un panel
        g.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

        // Aplica transparente al fondo
        setOpaque(false);
        super.paintComponent(g);
        super.paint(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarParar;
    private javax.swing.JLabel jLabelHMS;
    // End of variables declaration//GEN-END:variables
}
