package view.manager.application;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import java.awt.Color;
import java.awt.EventQueue;

import static java.awt.Frame.MAXIMIZED_BOTH;

import javax.swing.JFrame;
import javax.swing.UIManager;

import view.manager.components.Background;
import view.manager.forms.DashboardForm;
import view.manager.menu.FormManager;
import raven.popup.GlassPanePopup;
import utils.AppUtils;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.*;
import java.awt.*;

public class GD_Dashboard extends JFrame {

    public GD_Dashboard() {
        init();
    }

    private void init() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setContentPane(new Background()); // Giả sử Background là một lớp JPanel đã được định nghĩa
        GlassPanePopup.install(this); // Giả sử GlassPanePopup là một lớp tiện ích đã được định nghĩa
        FormManager.install(this); // Giả sử FormManager là một lớp tiện ích đã được định nghĩa
        FormManager.showForm(new DashboardForm()); // Giả sử DashboardForm là một lớp JPanel đã được định nghĩa
    }

    public void run() {
        FlatLaf.registerCustomDefaultsSource("view.manager.themes");
        UIManager.put("defaultFont", utils.AppUtils.getFont(13f, AppUtils._NORMAL_)); // Giả sử AppUtils là một lớp tiện ích đã được định nghĩa
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> new GD_Dashboard().setVisible(true));
    }
}


//    public static void main(String[] args) {
//        FlatLaf.registerCustomDefaultsSource("view.manager.themes");
//        UIManager.put("defaultFont", utils.AppUtils.getFont(13f, AppUtils._NORMAL_));
//        FlatMacDarkLaf.setup();
//        EventQueue.invokeLater(() -> new GD_Dashboard().setVisible(true));
//    }
