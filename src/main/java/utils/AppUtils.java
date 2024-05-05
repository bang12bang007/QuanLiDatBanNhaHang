/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Font;
import component.Loading;
import dao.imlp.BanDAO;
import entity.NhanVien;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.JScrollPane;

/**
 *
 * @author Laptop
 */
public class AppUtils {
//    public static BanDAO BANDAO = new BanDAO();

    public static NhanVien NHANVIEN = null;
    public static DecimalFormat tien_format = new DecimalFormat("###,### VNĐ");
    public static String _NORMAL_ = "src/main/java/font/OpenSans-VariableFont_wdth,wght.ttf";
    public static String _BOLD_ = "src/main/java/font/OpenSans_Condensed-ExtraBold.ttf";
    public static String _ITALIC_ = "src/main/java/font/OpenSans-Italic-VariableFont_wdth,wght.ttf";

    public static Font getFont(float a, String b) {
        try {
            File fontStyle = new File(b);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(a);
            return font;
        } catch (Exception e) {
        }

        return null;
    }

    public static void setUI(JPanel mainJPanel, Supplier<JPanel> componentSupplier) {
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

    public static void saveStorage(NhanVien nhanVien) {
        NHANVIEN = nhanVien;
    }

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
