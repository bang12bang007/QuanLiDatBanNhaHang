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
import entity.NhanVien;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 *
 * @author Laptop
 */
public class AppUtils {
    public final static Font FONT = new Font("name",1,1);
    private final static Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    
    public static Connection connect() {
        Connection con = null;
        try {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=qlnhDB;encrypt=false";
                String user = "sa";
                String password = "123";
                con = DriverManager.getConnection(url, user, password);
                if(con != null) {
                    System.out.println("connect successfully!");
                }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return con;
    }
    
    public static <T> boolean insert(T t, String SQL) {
        Connection con = connect();
        String json = GSON.toJson(t);
	try {
            Map<String, Object> map = GSON.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
            int parameterIndex = 1;
            PreparedStatement pstms = con.prepareStatement(SQL);
            for(Map.Entry<String, Object> entry : map.entrySet()) {
                pstms.setObject(parameterIndex++, entry.getValue());
            }
            return pstms.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //mặc định columnStart = 1
    public static <T> T getEntity(Class<T> clazz, ResultSet myRs,int columnStart) throws SQLException {
        Map<String, Object> properties = new LinkedHashMap<>();
        int columnCount = myRs.getMetaData().getColumnCount();

        // Lấy dữ liệu từ ResultSet và đưa vào Map properties
        while (myRs.next()) {
            for (int i = columnStart; i <= columnCount; i++) {
                String columnName = myRs.getMetaData().getColumnName(i);
                Object value = myRs.getObject(i);
                columnName = columnName.substring(0, 1).toLowerCase() + columnName.substring(1);
                properties.put(columnName, value);
            }
        }
        // Chuyển Map properties thành JSON
        String json = GSON.toJson(properties);
        // Chuyển JSON thành đối tượng của lớp clazz
        try {
            T obj = GSON.fromJson(json, clazz);
            return obj;
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return null;
    }
    
    public static <T> boolean updateById(T t, String SQL, String id) {
        Connection con = connect();
        String json = GSON.toJson(t);
        Map<String, Object> map = GSON.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
        int parameterIndex = 1;
	try {
            PreparedStatement pstms = con.prepareStatement(SQL);
            for(Map.Entry<String, Object> entry : map.entrySet()) {
                if(!id.equals(entry.getValue())) {
                    pstms.setObject(parameterIndex++, entry.getValue());
                }
            }
            pstms.setString(parameterIndex, id);
            return pstms.execute();
        } catch (Exception e) {
        }
        return false;
    }
    
    public static boolean deleteOneById(String id, String SQL) {
        Connection con = connect();
        try {
            PreparedStatement pstms = con.prepareStatement(SQL);
            pstms.setString(1, id);
            return pstms.execute();
        } catch (Exception e) {
        }
        return false;
    }
}
