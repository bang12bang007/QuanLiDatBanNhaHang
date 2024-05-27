package view.manager.menu;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import raven.drawer.component.DrawerPanel;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.header.SimpleHeaderStyle;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.drawer.component.menu.SimpleMenuStyle;
import raven.drawer.component.menu.data.Item;
import raven.drawer.component.menu.data.MenuItem;
import view.manager.forms.GD_Dashboard;
import raven.swing.AvatarIcon;
import static utils.AppUtils.*;
import view.manager.forms.GD_QuanLyBan;
import view.manager.forms.GD_QuanLyKhachHang;
import view.manager.forms.GD_QuanLyKhuyenMai;
import view.manager.forms.GD_QuanLyMon;
import view.manager.forms.GD_QuanLyNhanVien;

public class MyDrawerBuilder extends SimpleDrawerBuilder {

    public MyDrawerBuilder() {

    }

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        AvatarIcon icon = new AvatarIcon(getClass().getResource("/images/Avatar.png"), 60, 60, 999);
        icon.setBorder(2);
        return new SimpleHeaderData()
                .setIcon(icon)
                .setTitle(NHANVIEN.getHoTen())
                .setDescription(NHANVIEN.getMaNV())
                .setHeaderStyle(new SimpleHeaderStyle() {

                    @Override
                    public void styleTitle(JLabel label) {
                        label.putClientProperty(FlatClientProperties.STYLE, ""
                                + "[light]foreground:#E1E1E1 ");
                    }

                    @Override
                    public void styleDescription(JLabel label) {
                        label.putClientProperty(FlatClientProperties.STYLE, ""
                                + "[light]foreground:#FAFAFA");
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData();
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {

        MenuItem items[] = new MenuItem[]{
            new Item("Dashboard", "dashboard.svg"),
            new Item("Manager", "email.svg")
            .subMenu("Quản lý Bàn")
            .subMenu("Quản lý Nhân viên")
            .subMenu("Quản lý Khuyến mãi")
            .subMenu("Quản lý Khách hàng")
            .subMenu("Quản lý Món"),
            new Item("Chat", "chat.svg"),
            new Item("Calendar", "calendar.svg"),
            new Item("Advanced UI", "ui.svg")
            .subMenu("Cropper")
            .subMenu("Owl Carousel")
            .subMenu("Sweet Alert"),
            new Item("Forms", "forms.svg")
            .subMenu("Basic Elements")
            .subMenu("Advanced Elements")
            .subMenu("SEditors")
            .subMenu("Wizard"),
            new Item("Charts", "chart.svg")
            .subMenu("Apex")
            .subMenu("Flot")
            .subMenu("Sparkline"),
            new Item("Icons", "icon.svg")
            .subMenu("Feather Icons")
            .subMenu("Flag Icons")
            .subMenu("Mdi Icons"),
            new Item("Special Pages", "page.svg")
            .subMenu("Blank page")
            .subMenu("Faq")
            .subMenu("Invoice")
            .subMenu("Profile")
            .subMenu("Pricing")
            .subMenu("Timeline")
        };

        SimpleMenuOption simpleMenuOption = new SimpleMenuOption() {
            @Override
            public Icon buildMenuIcon(String path, float scale) {
                FlatSVGIcon icon = new FlatSVGIcon(path, scale);
                FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
                colorFilter.add(Color.decode("#969696"), Color.decode("#FAFAFA"), Color.decode("#969696"));
                icon.setColorFilter(colorFilter);
                return icon;
            }
        };

        simpleMenuOption.setMenuStyle(new SimpleMenuStyle() {
            @Override
            public void styleMenuItem(JButton menu, int[] index) {
                menu.putClientProperty(FlatClientProperties.STYLE, ""
                        + "[light]foreground:#FAFAFA;"
                        + "arc:10");
                menu.setPreferredSize(new Dimension(50, 50));
            }

            @Override
            public void styleMenu(JComponent component) {
                component.putClientProperty(FlatClientProperties.STYLE, ""
                        + "background:#1F1D2B");
            }

            @Override
            public void styleLabel(JLabel label) {
                label.putClientProperty(FlatClientProperties.STYLE, ""
                        + "[light]foreground:darken(#FAFAFA,15%);"
                        + "[dark]foreground:darken($Label.foreground,30%)");
            }
        });
        simpleMenuOption.addMenuEvent(new MenuEvent() {
            @Override
            public void selected(MenuAction action, int[] index) {
//                Level 1
                if (index.length == 1) {
                    switch (((Item) items[index[0]]).getName()) {
                        case "Dashboard": {
                            FormManager.showForm(() -> new GD_Dashboard());
                            break;
                        }
                    }
                } //                Level 2
                else if (index.length == 2) {
                    List<Item> _items_ = ((Item) items[index[0]]).getSubMenu();
                    switch (_items_.get(index[1]).getName()) {
                        case "Quản lý Bàn": {
                            FormManager.showForm(new GD_QuanLyBan());
                            break;
                        }
                        case "Quản lý Nhân viên": {
                            FormManager.showForm(new GD_QuanLyNhanVien());
                            break;
                        }
                        case "Quản lý Món": {
                            FormManager.showForm(new GD_QuanLyMon());
                            break;
                        }
                        case "Quản lý Khuyến mãi": {
                            FormManager.showForm(new GD_QuanLyKhuyenMai());
                            break;
                        }
                        case "Quản lý Khách hàng": {
                            FormManager.showForm(new GD_QuanLyKhachHang());
                            break;
                        }
                    }
                }
            }
        });

        simpleMenuOption.setMenus(items)
                .setBaseIconPath("view/manager/resources/menu")
                .setIconScale(0.45f);
        return simpleMenuOption;
    }

    @Override
    public void build(DrawerPanel drawerPanel) {
        drawerPanel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:#1F1D2B");
    }

    @Override
    public int getDrawerWidth() {
        return 270;
    }
}
