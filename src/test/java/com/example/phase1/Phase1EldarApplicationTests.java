package com.example.phase1;

import com.example.phase1.dao.CompanyDAO;
import com.example.phase1.dbdao.CompanyDBDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Phase1EldarApplicationTests {

    CompanyDAO dao = new CompanyDBDAO();

    @Test
    void contextLoads() {
    }


}
