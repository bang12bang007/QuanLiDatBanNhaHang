/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

/**
 *
 * @author dmx
 */
public class Food extends javax.swing.JPanel {

    /**
     * Creates new form Food
     */
    public Food() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFood = new component.MyButton();
        panelFood = new component.PanelRound();
        jLabelTen = new javax.swing.JLabel();
        jLabelGia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(83, 86, 99));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/GaChienBo.png"))); // NOI18N
        btnFood.setColor(new java.awt.Color(31, 29, 43));
        btnFood.setColorClick(new java.awt.Color(234, 124, 105));
        btnFood.setColorOver(new java.awt.Color(234, 124, 105));
        btnFood.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFood.setPreferredSize(new java.awt.Dimension(90, 90));
        btnFood.setRadius(210);
        btnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodActionPerformed(evt);
            }
        });
        add(btnFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 210, 210));

        panelFood.setBackground(new java.awt.Color(31, 29, 43));
        panelFood.setRoundBottomLeft(15);
        panelFood.setRoundBottomRight(15);
        panelFood.setRoundTopLeft(15);
        panelFood.setRoundTopRight(15);

        jLabelTen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTen.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTen.setText("500.000 VNĐ");
        jLabelTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGia.setText("CƠM GÀ CHIÊN BƠ");
        jLabelGia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelFoodLayout = new javax.swing.GroupLayout(panelFood);
        panelFood.setLayout(panelFoodLayout);
        panelFoodLayout.setHorizontalGroup(
            panelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelGia, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(jLabelTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelFoodLayout.setVerticalGroup(
            panelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFoodLayout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabelGia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        add(panelFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 270, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFoodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnFood;
    private javax.swing.JLabel jLabelGia;
    private javax.swing.JLabel jLabelTen;
    private component.PanelRound panelFood;
    // End of variables declaration//GEN-END:variables
}
