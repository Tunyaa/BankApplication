
package com.superbank.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BalanceControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    public BalanceControllerTest() {
    }

    @Test
    public void testGetBalance() {
    }

    @Test
    public void testAddMoney() {
    }

    @Test
    public void testTransfer() {
    }

    @Test
    public void testHandle() {
    }
    
}
