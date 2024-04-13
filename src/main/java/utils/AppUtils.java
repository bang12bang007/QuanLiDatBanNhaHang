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
import component.Loading;
import entity.NhanVien;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static DecimalFormat tien_format = new DecimalFormat("###,###.0 VNĐ");
    public static String _NORMAL_ = "src/main/java/font/OpenSans-VariableFont_wdth,wght.ttf";
    public static String _BOLD_ = "src/main/java/font/OpenSans_Condensed-Bold.ttf";
    public static String _ITALIC_ = "src/main/java/font/OpenSans-Italic-VariableFont_wdth,wght.ttf";
    public static Font getFont(float a, String b) {
        File fontStyle = new File(b);
        Font font = null;
        try {
            font = FONT.createFont(FONT.TRUETYPE_FONT, fontStyle).deriveFont(a);
        } catch (Exception e) {
        }
        return font;
    }
   
    
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
//Update de loading muot nhu sunsil

    public static void setUI(JPanel mainJPanel, Supplier<JPanel> componentSupplier) {
//        mainJPanel.removeAll();
//        mainJPanel.add(jComponent);
//        mainJPanel.repaint();
//        mainJPanel.revalidate();
        mainJPanel.removeAll();
        Loading loading = new Loading();
        mainJPanel.add(loading, BorderLayout.CENTER);
        mainJPanel.repaint();
        mainJPanel.revalidate();

        SwingWorker<JPanel, Void> worker = new SwingWorker<JPanel, Void>() {
            @Override
            protected JPanel doInBackground() throws Exception {
                // Thực hiện công việc lâu dài ở đây, trả về JPanel hoặc null
                return componentSupplier.get();
            }

            @Override
            protected void done() {
                try {
                    mainJPanel.removeAll();
                    JPanel resultPanel = get(); // Nhận kết quả từ công việc lâu dài
                    if (resultPanel != null) {
                        mainJPanel.add(resultPanel);
                    } else {
                        // Xử lý trường hợp không có kết quả
                    }
                    mainJPanel.repaint();
                    mainJPanel.revalidate();
                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        };
        worker.execute();
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
