/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mz-hafizha
 */
public class AmilModel {
    public static int id;
    public static String username;
    public static String password;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        AmilModel.username = username;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        AmilModel.id = id;
    }
    
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        AmilModel.password = password;
    }
    
    
}
