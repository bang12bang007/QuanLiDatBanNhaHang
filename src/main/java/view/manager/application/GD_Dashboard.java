package view.manager.application;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JFrame;
import javax.swing.UIManager;
import view.manager.components.Background;
import view.manager.forms.DashboardForm;
import view.manager.menu.FormManager;
import raven.popup.GlassPanePopup;
import utils.AppUtils;

/**
 *
 * @author Raven
 */
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
        setContentPane(new Background());
        // applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        GlassPanePopup.install(this);
        FormManager.install(this);
        FormManager.showForm(new DashboardForm());
        // applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    public void run() {
        FlatLaf.registerCustomDefaultsSource("view.manager.themes");
        UIManager.put("defaultFont", utils.AppUtils.getFont(13f, AppUtils._NORMAL_));
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> new GD_Dashboard().setVisible(true));
    }

//    public static void main(String[] args) {
//        FlatLaf.registerCustomDefaultsSource("view.manager.themes");
//        UIManager.put("defaultFont", utils.AppUtils.getFont(13f, AppUtils._NORMAL_));
//        FlatMacDarkLaf.setup();
//        EventQueue.invokeLater(() -> new GD_Dashboard().setVisible(true));
//    }
}
