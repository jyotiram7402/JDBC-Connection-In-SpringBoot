package org.dev.JDBC_With_SpringBoot.repository;

import org.dev.JDBC_With_SpringBoot.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PersonRepository {
    @Autowired
    private  Connection connection;
//    Setter dependency injection
    public PersonRepository(Connection connection){
        this.connection =connection;
        try {
            createPersonTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static Logger logger = LoggerFactory.getLogger("PersonRepository.class");
    public void createPerson(Person person) throws SQLException {
        //1)  connection
        // statements-> commands what i want to run on db
        // executed it
        // mysql -u root -p password
        // inserting the data into db
        Statement statement = connection.createStatement();
        Boolean result = statement.execute("insert into person(id, firstName, lastName, dob, age) VALUES(1,'fname', 'lname', '1990-01-01' ,23)");
        logger.info("result of the insertion statemnet is {}"  , result);

    }
    public void createPersonTable() throws SQLException {
        Statement statement = connection.createStatement();
        boolean result = statement.execute("CREATE TABLE IF NOT EXISTS person (id int NOT NULL, firstName varchar(30) ,lastName varchar(30),dob varchar(15), age int , PRIMARY KEY(id))");
        logger.info("create table has been executed with the result {}" ,result);
    }
}
