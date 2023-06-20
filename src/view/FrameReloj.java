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

import java.awt.Color;

public class FrameReloj extends javax.swing.JFrame {
    private final PanelReloj panelReloj;
    public FrameReloj() {
        initComponents();
        this.panelReloj = new PanelReloj();
        this.panelReloj.setBackground(new Color(249, 250, 249, 255));
        this.panelReloj.setBounds(0, 0, 300, 300);

        this.add(panelReloj);
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrameReloj().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
