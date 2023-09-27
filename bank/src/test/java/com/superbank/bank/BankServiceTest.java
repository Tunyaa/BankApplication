
package com.superbank.bank;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankServiceTest {

    private BalanceRepository balanceRepository = new BalanceRepository();
    private BankService bankService = new BankService(balanceRepository);
    
    public BankServiceTest() {
    }
    
    @Test
    public void testGetBallance() {
        final BigDecimal balance = bankService.getBallance(1L);
        assertEquals(balance, BigDecimal.TEN);
    }
    
    @Test
    public void testAddMoney() {
        final BigDecimal balance = bankService.addMoney(1L, BigDecimal.ONE);        
        assertEquals(balance, BigDecimal.valueOf(11));        
    }
    
    @Test
    public void testMakeTransfer() {
    }
    
}
