package view.manager.application;

import java.awt.Color;
import java.awt.EventQueue;

import static java.awt.Frame.MAXIMIZED_BOTH;

import javax.swing.JFrame;
import javax.swing.UIManager;

import component.Background;
import menu.FormManager;
import raven.popup.GlassPanePopup;
import utils.AppUtils;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class GD_QuanLy extends JFrame {

    public GD_QuanLy() {
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
        FormManager.showForm(new view.manager.application.GD_BaoCao()); // Giả sử DashboardForm là một lớp JPanel đã được định nghĩa
    }

    public void run() {
        FlatLaf.registerCustomDefaultsSource("view.manager.themes");
        UIManager.put("defaultFont", utils.AppUtils.getFont(13f, AppUtils._NORMAL_)); // Giả sử AppUtils là một lớp tiện ích đã được định nghĩa
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> new GD_QuanLy().setVisible(true));
    }
}
