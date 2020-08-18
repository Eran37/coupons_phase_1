package com.example.phase1;
import com.example.phase1.exceptions.CouponIdIsIncorrectException;
import com.example.phase1.exceptions.CouponsCompanyIdIsIncorrectException;
import com.example.phase1.exceptions.EmailOrPasswordIsIncorrectException;
import com.example.phase1.test.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Phase1EldarApplication {

    public static void main(String[] args) throws SQLException, EmailOrPasswordIsIncorrectException, CouponIdIsIncorrectException, CouponsCompanyIdIsIncorrectException {
        Test test = new Test();
        Test.testAll();

    }
}
