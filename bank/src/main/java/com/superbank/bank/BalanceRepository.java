
package com.superbank.bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.val;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceRepository {
    
    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.TEN));
    // - Получить балланс
    public BigDecimal getBalanceForId(Long accountId) {
        //SELECT
        return storage.get(accountId);
    }

//    public BigDecimal save(Long to, BigDecimal amount) {
//        //INSERT
//        BigDecimal currentBalance = storage.get(to);
//        if (currentBalance == null) {   // Если нет записи, создаём новую
//            storage.put(to, amount);
//            return amount;
//        }else{                          // Если запись есть, добавляем amount
//            final BigDecimal updatedBalance = currentBalance.add(amount);
//            storage.put(to, updatedBalance);
//            return updatedBalance;
//        }
//    }
    
    public void save(Long id, BigDecimal amount){
        storage.put(id, amount);
    }
}
