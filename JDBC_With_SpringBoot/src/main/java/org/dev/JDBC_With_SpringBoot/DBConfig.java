package org.dev.JDBC_With_SpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class DBConfig {

    @Bean //  is to with methods
    public Connection connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_With_SpringBoot ", "root" ,"jyotiram@123");
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }
}
