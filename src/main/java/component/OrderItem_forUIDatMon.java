/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import LIB.FadeEffect;
import entity.Mon;
import icon.FontAwesome;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import jiconfont.swing.IconFontSwing;
import view.Form_DatBan;
import view.Form_HuyMon;
import view.GD_DatMon;

/**
 *
 * @author Laptop
 */
public class OrderItem_forUIDatMon extends javax.swing.JPanel {

    /**
     * Creates new form OrderItem
     */
//    Text or Button
    private String type = "TEXT";
    private String[] data;
    private DecimalFormat tien_format = new DecimalFormat("###,###.0 VNĐ");
    private Double tongTien = 0.0;
    private Double gia;
    private List<Mon> orders;
    private GD_DatMon datMon;
    private boolean initialized = false;

    public OrderItem_forUIDatMon(GD_DatMon datMon, Mon mon, int width, int index, String[] data, List<Mon> orders) {
        this.data = data;
        this.gia = mon.getGia();
        this.orders = orders;
        this.datMon = datMon;
        initComponents();
        setBackground(index % 2 != 0 ? new Color(83, 86, 99) : new Color(31, 29, 43));
        setPreferredSize(new Dimension(width, 50));
        push(data);

        soLuong.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTextField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTextField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Sự kiện này không được sử dụng cho JTextField
                checkTextField();
            }
        });
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialized = true;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public ArrayList<Integer> getListQuantity() {
        ArrayList<Integer> listQuantity = new ArrayList<Integer>();
        for (int i = 0; i < datMon.getPanelOrder().getComponentCount(); i++) {
            OrderItem_forUIDatMon item = (OrderItem_forUIDatMon) datMon.getPanelOrder().getComponent(i);
            JTextField quantity = (JTextField) item.panelRound1.getComponent(0);
            try {
                int SL = Integer.parseInt(quantity.getText().trim());
                listQuantity.add(SL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listQuantity;
    }

    ;
    
    public void updateTongTien() {
        double tong = 0.0;
        for (int i = 0; i < orders.size(); i++) {
            tong += orders.get(i).getGia() * datMon.getList_quantity().get(i);
        }
        if (tong != 0) {
            datMon.setLabelTongTien(tien_format.format(tong));
        } else {
            datMon.setLabelTongTien("0,0 VNĐ");
        }
    }

    public void setType(String type) {
        this.type = type;
        push(data);
    }

    public void push(String[] data) {
        tenMon.setText("  " + data[0]);
        soLuong.setText(" " + data[1]);
        donGia.setText(" " + data[2]);
        setLastItem(data[3]);
    }

    private void setLastItem(String data) {
        if (type.equals("BUTTON")) {
            IconFontSwing.register(FontAwesome.getIconFont());
            huy.setIcon(IconFontSwing.buildIcon(FontAwesome.TRASH, 30, Color.white));
            increase.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 15, Color.white));
            decrease.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS, 15, Color.white));
        } else {
            huy.setText(" " + data);
        }
    }

//    public OrderItem(int index) {
//        initComponents();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tenMon = new javax.swing.JLabel();
        panelRound1 = new component.PanelRound();
        soLuong = new javax.swing.JTextField();
        increase = new javax.swing.JLabel();
        decrease = new javax.swing.JLabel();
        donGia = new javax.swing.JLabel();
        huy = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        tenMon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tenMon.setForeground(new java.awt.Color(255, 255, 255));
        add(tenMon);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255,0));
        panelRound1.setLayout(new java.awt.GridLayout(1, 0));

        soLuong.setBackground(new java.awt.Color(204, 255, 255,0));
        soLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        soLuong.setForeground(new java.awt.Color(255, 255, 255));
        soLuong.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        soLuong.setBorder(null);
        soLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soLuongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soLuongMouseExited(evt);
            }
        });
        soLuong.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                soLuongInputMethodTextChanged(evt);
            }
        });
        soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soLuongActionPerformed(evt);
            }
        });
        panelRound1.add(soLuong);

        increase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                increaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                increaseMouseExited(evt);
            }
        });
        panelRound1.add(increase);

        decrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                decreaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                decreaseMouseExited(evt);
            }
        });
        panelRound1.add(decrease);

        add(panelRound1);

        donGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        donGia.setForeground(new java.awt.Color(255, 255, 255));
        add(donGia);

        huy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        huy.setForeground(new java.awt.Color(255, 255, 255));
        huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                huyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                huyMouseExited(evt);
            }
        });
        add(huy);
    }// </editor-fold>//GEN-END:initComponents

    private void huyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huyMouseClicked
        // TODO add your handling code here:
        if (type.equals("BUTTON")) {
            JFrame jFrame = new JFrame();
            jFrame.setUndecorated(true);
            jFrame.setExtendedState(MAXIMIZED_BOTH);
            jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Form_HuyMon form_HuyMon = new Form_HuyMon(jFrame,this);
            jFrame.add(form_HuyMon,BorderLayout.CENTER);
            jFrame.setBackground(new Color(0, 0, 0, 0));
            FadeEffect.fadeInFrame(jFrame, 8, 0.1f);
            jFrame.setVisible(true);
        }
    }//GEN-LAST:event_huyMouseClicked
    
    private void huyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huyMouseEntered
        // TODO add your handling code here:
//        thanhTien.setFont(new Font("Jetbrains Mono", Font.BOLD, 20));

        if (type.equals("BUTTON")) {
            IconFontSwing.register(FontAwesome.getIconFont());
            huy.setIcon(IconFontSwing.buildIcon(FontAwesome.TRASH, 30, new Color(234, 124, 105)));
        }
    }//GEN-LAST:event_huyMouseEntered

    private void huyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huyMouseExited
        // TODO add your handling code here:
//        thanhTien.setFont(new Font("Jetbrains Mono", Font.BOLD, 14));
        if (type.equals("BUTTON")) {
            IconFontSwing.register(FontAwesome.getIconFont());
            huy.setIcon(IconFontSwing.buildIcon(FontAwesome.TRASH, 30, Color.white));
        }
    }//GEN-LAST:event_huyMouseExited

    private void increaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseMouseEntered
        // TODO add your handling code here:
        increase.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 15, new Color(234, 124, 105)));
    }//GEN-LAST:event_increaseMouseEntered

    private void increaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseMouseClicked
        // TODO add your handling code here:
        increase.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 15, new Color(234, 124, 105)));
        try {
            int quantity = Integer.parseInt(soLuong.getText().trim());
            quantity++;
            soLuong.setText(" " + Integer.toString(quantity));
            tongTien = quantity * gia;
            donGia.setText("  " + tien_format.format(tongTien));
            datMon.setList_quantity(getListQuantity());
            updateTongTien();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_increaseMouseClicked

    private void increaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseMouseExited
        // TODO add your handling code here:
        increase.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 15, Color.white));
    }//GEN-LAST:event_increaseMouseExited

    private void decreaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseMouseClicked
        // TODO add your handling code here:
        decrease.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS, 15, new Color(234, 124, 105)));
        try {
            int quantity = Integer.parseInt(soLuong.getText().trim());
            if (quantity > 1) {
                quantity--;
            }
            soLuong.setText(" " + Integer.toString(quantity));
            tongTien = quantity * gia;
            donGia.setText("  " + tien_format.format(tongTien));
            datMon.setList_quantity(getListQuantity());
            updateTongTien();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_decreaseMouseClicked

    private void decreaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseMouseEntered
        // TODO add your handling code here:
        decrease.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS, 15, new Color(234, 124, 105)));
    }//GEN-LAST:event_decreaseMouseEntered

    private void decreaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseMouseExited
        // TODO add your handling code here:
        decrease.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS, 15, Color.white));
    }//GEN-LAST:event_decreaseMouseExited

    private void soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuongActionPerformed

    private void soLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_soLuongInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuongInputMethodTextChanged

    private void soLuongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soLuongMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuongMouseExited
    public void checkTextField() {
        try {
            if (initialized) {
                if (!soLuong.getText().trim().equals("")) {
                    Integer.parseInt(soLuong.getText().trim());
                    datMon.setList_quantity(getListQuantity());
                    updateTongTien();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(datMon, "Số Lượng nhập phải vào phải là số");
            soLuong.requestFocus();
        }
    };
    public void updateForDelete(){
        int quantity = 0;
        soLuong.setText(" "+Integer.toString(quantity));
        tongTien = quantity*gia;
        donGia.setText("  0,0VNĐ");
        datMon.setList_quantity(getListQuantity());
        updateTongTien();
    }
    private void soLuongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soLuongMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuongMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel decrease;
    private javax.swing.JLabel donGia;
    private javax.swing.JLabel huy;
    private javax.swing.JLabel increase;
    private component.PanelRound panelRound1;
    private javax.swing.JTextField soLuong;
    private javax.swing.JLabel tenMon;
    // End of variables declaration//GEN-END:variables

}
