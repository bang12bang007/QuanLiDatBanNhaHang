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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private final static Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    public static NhanVien NHANVIEN = null;

    public static Connection connect() {
        Connection con = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=qlnhDB;encrypt=false";
            String user = "sa";
            String password = "123";
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("connect successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void setUI(JPanel mainJPanel, JPanel jComponent) {
        mainJPanel.removeAll();

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Thực hiện công việc lâu dài ở đây
                mainJPanel.add(jComponent);
                return null;
            }

            @Override
            protected void done() {
            }
        };
        worker.execute();
        mainJPanel.repaint();
        mainJPanel.revalidate();
    }

    public static void setLoading(JPanel mainJPanel, boolean state, Loading loading, JPanel jpanel) {
        if (state) {
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Thực hiện công việc lâu dài ở đây
                    mainJPanel.remove(jpanel);
                    return null;
                }
                @Override
                protected void done() {
                }
            };
            worker.execute();
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

    //duccuong1609 : Kiểm tra có chuỗi nhập. Truyền 2 giá trị (chuỗi trong dữ liệu <tên,..>, chuỗi viết tắt/viết tên..)
    public static boolean CheckContainsAbbreviation(String input, String abbreviation) {
        String replace = input.replaceAll("[^a-zA-Z ]", "");
        Pattern pattern = Pattern.compile("\\b(\\w)");
        Matcher matcher = pattern.matcher(replace);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group(1).toLowerCase());
        }
        if (result.toString().contains(abbreviation.toLowerCase()) || input.toLowerCase().contains(abbreviation.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
