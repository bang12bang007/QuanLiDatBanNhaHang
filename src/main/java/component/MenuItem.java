/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import entity.Mon;
import icon.FontAwesome;
import java.awt.Color;
import java.awt.Dimension;
import jiconfont.swing.IconFontSwing;
import javax.swing.Icon;
import view.Form_XemThucDon;
import static utils.AppUtils.*;
/**
 *
 * @author Laptop
 */
public class MenuItem extends javax.swing.JPanel {

    /**
     * Creates new form MenuItem
     */
    private Form_XemThucDon form;
    private String type;
    private int width;
    private String[] data;
    private Mon mon;

    public MenuItem(int width, String[] data, Mon mon) {
        initComponents();
        this.width = width;
        this.mon = mon;
        this.data = data;
        this.setBackground(Color.BLUE);
        wrapper.setBackground(new Color(83, 86, 99));
        right.setBackground(new Color(83, 86, 99));
        soLuong.setBackground(new Color(0, 0, 0, 0));
//        tenMon.setPreferredSize(new Dimension(200, 45));
        this.setPreferredSize(new Dimension(width, 45));
        push(data);
    }

    public void push(String[] data) {
        tenMon.setText("  " + data[0] + "");
        soLuong.setText(data[1]);
    }

    private Icon getIconByType() {
        if (type.equals("THEM_MON")) {
            soLuong.setEditable(false);
            return IconFontSwing.buildIcon(FontAwesome.PLUS, 12, Color.WHITE);
        } else if (type.equals("HUY_MON")) {
            soLuong.setEditable(true);
            return IconFontSwing.buildIcon(FontAwesome.XING, 12, Color.WHITE);
        }
        return null;
    }

    public void setType(String type) {
        this.type = type;
        myButton1.setIcon(getIconByType());
    }

    public String[] getData() {
        return this.data;
    }

    public void setData(String[] data) {
        this.data = data;
        push(data);
    }

    public int getSoLuong() {
        if (type.equals("THEM_MON")) {
            return 1;
        }
        return Integer.parseInt(soLuong.getText());
    }

    public Mon getMon() {
        return mon;
    }

    public void setMon(Mon mon) {
        this.mon = mon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wrapper = new javax.swing.JPanel();
        tenMon = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        myButton1 = new component.MyButton();
        soLuong = new javax.swing.JTextField();

        wrapper.setLayout(new java.awt.GridLayout(1, 0));

        tenMon.setFont(utils.AppUtils.getFont(18f, _NORMAL_)
        );
        tenMon.setForeground(new java.awt.Color(255, 255, 255));
        wrapper.add(tenMon);

        myButton1.setColor(new java.awt.Color(31, 29, 43));
        myButton1.setColorClick(new java.awt.Color(234, 124, 105));
        myButton1.setColorOver(new java.awt.Color(234, 124, 105));
        myButton1.setFont(utils.AppUtils.getFont(18f, _NORMAL_)
        );
        myButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        myButton1.setMinimumSize(new java.awt.Dimension(25, 25));
        myButton1.setRadius(8);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        soLuong.setFont(utils.AppUtils.getFont(18f, _NORMAL_)
        );
        soLuong.setBorder(null);
        soLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                soLuongKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soLuongKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addComponent(soLuong)
        );

        wrapper.add(right);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        if (type.equals("THEM_MON")) {
            form.themMon(new MenuItem(width, new String[]{data[0], 1 + ""}, mon));
        } else if (type.equals("HUY_MON")) {
            form.huyMon(this);
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void soLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soLuongKeyReleased
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            form.onChange();
            soLuong.requestFocus();
        }
    }//GEN-LAST:event_soLuongKeyReleased

    private void soLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soLuongKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_soLuongKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton myButton1;
    private javax.swing.JPanel right;
    private javax.swing.JTextField soLuong;
    private javax.swing.JLabel tenMon;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables

    public void setForm(Form_XemThucDon form) {
        this.form = form;
    }
}
