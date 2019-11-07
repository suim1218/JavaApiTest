package apitest.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUserName {

    public String Select() {
        Connection conn;
        Statement stmt;
        String userName = "";

        try {
            conn = MySQLUtil.getConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT username FROM auth_user where id='2'";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                userName = rs.getString("username");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userName;

    }
}