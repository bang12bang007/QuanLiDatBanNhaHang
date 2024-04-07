/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import component.Loading;
import component.OrderCard;
import entity.HoaDon;
import entity.NhanVien;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import view.UIUpdatable;

/**
 *
 * @author Laptop
 */
public class AppUtils {

    public final static Font FONT = new Font("name", 1, 1);
    public static NhanVien NHANVIEN = null;

    public static void setUI(JPanel mainJPanel, JPanel jComponent) {
        mainJPanel.removeAll();
        mainJPanel.add(jComponent);
        mainJPanel.repaint();
        mainJPanel.revalidate();
    }

    public static void setLoading(JPanel mainJPanel, boolean state, Loading loading, JPanel jpanel) {
        if (state) {
            mainJPanel.remove(jpanel);
            mainJPanel.add(loading);
            mainJPanel.repaint();
            mainJPanel.revalidate();
        } else {
            mainJPanel.remove(loading);
            mainJPanel.add(jpanel);
        }
        mainJPanel.repaint();
        mainJPanel.revalidate();
    }

    public static void setLoadingForTable(JScrollPane mainJPanel, boolean state, Loading loading, JPanel gD_Ban) {
        if (state) {
            loading.setPreferredSize(new Dimension(mainJPanel.getWidth(), mainJPanel.getHeight()));
            mainJPanel.setViewportView(loading);
            mainJPanel.repaint();
            mainJPanel.revalidate();
        } else {
            mainJPanel.setViewportView(gD_Ban);
        }
        mainJPanel.repaint();
        mainJPanel.revalidate();
    }

    /**
     *
     * @param <T>
     * @param mainJPanel
     * @param jpanel
     */
    public static <T extends JPanel & UIUpdatable> void run(JPanel mainJPanel, T jpanel) {
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loading loading = new Loading();
                utils.AppUtils.setLoading(mainJPanel, true, loading, jpanel);

                jpanel.setUI();

                Timer hideTimer = new Timer(1500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        utils.AppUtils.setLoading(mainJPanel, false, loading, jpanel);
                    }
                });
                hideTimer.setRepeats(false);
                hideTimer.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void saveStorage(NhanVien nhanVien) {
        NHANVIEN = nhanVien;
    }
}
