
package com.superbank.bank.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TransferBalance {
    
    private Long to;
    private Long from;
    private BigDecimal amount;

    

    
    
    
}
