package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInRepository {
    private final static String FIND_ACCOUNT = "SELECT * FROM tai_khoan WHERE user_name = ? AND password = ?";

    public Account findByUsernameAndPassword(String username, String password) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ACCOUNT);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Account(
                        resultSet.getInt("ma_tai_khoan"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"),
                        resultSet.getInt("ma_vai_tro"),
                        resultSet.getTimestamp("ngay_tao_tk").toLocalDateTime(),
                        resultSet.getBoolean("is_delete")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
