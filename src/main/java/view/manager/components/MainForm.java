package view.manager.components;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import view.manager.menu.FormManager;
import view.manager.swing.slider.PanelSlider;
import view.manager.swing.slider.SimpleTransition;
import view.manager.swing.slider.SliderTransition;

/**
 * @author Raven
 */
public class MainForm extends JPanel {

    public MainForm() {
        init();
    }

    private void init() {
        putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5;"
                + "arc:30; background:#535663");
        setLayout(new MigLayout("wrap,fillx", "[fill]", ""));
        header = createHeader();
        panelSlider = new PanelSlider();
        JScrollPane scroll = new JScrollPane(panelSlider);
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "width:10");
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        add(header);
        add(scroll);
    }

    private JPanel createHeader() {
        JPanel panel = new JPanel(new MigLayout("gap rel 0", "grow"));
        panel.setBackground(new Color(83, 86, 99));
        JPanel leftPanel = new JPanel(new MigLayout());
        leftPanel.setBackground(new Color(83, 86, 99));
        JPanel rightPanel = new JPanel(new MigLayout());
        rightPanel.setBackground(new Color(83, 86, 99));

        cmdMenu = createButton(new FlatSVGIcon("view/manager/resources/icon/menu.svg"));
        cmdUndo = createButton(new FlatSVGIcon("view/manager/resources/icon/undo.svg"));
        cmdRedo = createButton(new FlatSVGIcon("view/manager/resources/icon/redo.svg"));
        cmdRefresh = createButton(new FlatSVGIcon("view/manager/resources/icon/refresh.svg"));

        cmdMenu.addActionListener(e -> {
            FormManager.showMenu();
        });
        cmdUndo.addActionListener(e -> {
            FormManager.undo();
        });
        cmdRedo.addActionListener(e -> {
            FormManager.redo();
        });
        cmdRefresh.addActionListener(e -> {
            FormManager.refresh();
        });

        leftPanel.add(cmdMenu);
        leftPanel.add(cmdUndo);
        leftPanel.add(cmdRedo);
        leftPanel.add(cmdRefresh);

        JButton cmdClose = createButton(new ImageIcon("./src/main/java/icon/icon_close.png"));
        cmdClose.addActionListener(e -> {
            FormManager.getFrame().dispose();
            FormManager.getFrame().setVisible(false);
        });
        rightPanel.add(cmdClose);

        panel.add(leftPanel, "align left"); // Căn rightPanel sang trái và chia panel
        panel.add(rightPanel, "align right"); // Căn leftPanel sang phải
        return panel;
    }

    private JButton createButton(Icon icon) {
        JButton button = new JButton(icon);
        button.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Button.toolbar.background;"
                + "arc:10;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");
        return button;
    }

    public void showForm(Component component, SliderTransition transition) {
        checkButton();
        panelSlider.addSlide(component, transition);
        revalidate();
    }

    public void showForm(Component component) {
        showForm(component, SimpleTransition.getDefaultTransition(false));
    }

    public void setForm(Component component) {
        checkButton();
        panelSlider.addSlide(component, null);
    }

    private void checkButton() {
        cmdUndo.setEnabled(FormManager.getForms().isUndoAble());
        cmdRedo.setEnabled(FormManager.getForms().isRedoAble());
        cmdRefresh.setEnabled(FormManager.getForms().getCurrent() != null);
    }

    private JPanel header;
    private JButton cmdMenu;
    private JButton cmdUndo;
    private JButton cmdRedo;
    private JButton cmdRefresh;
    private PanelSlider panelSlider;
}
