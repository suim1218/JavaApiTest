package apitest.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUserName {
    private Connection conn;
    // 传递sql语句
    private Statement stmt;

    public void Select() {
        try {
            conn = MySQLUtil.getConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT username FROM auth_user";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                String userName = rs.getString("username");

                // 输出数据
                System.out.print(", 用户名: " + userName);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}