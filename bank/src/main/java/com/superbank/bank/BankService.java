package com.superbank.bank;

import com.superbank.bank.model.TransferBalance;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankService {

    private final BalanceRepository repository;

    public BigDecimal getBallance(Long accountId) {
        BigDecimal balance = repository.getBalanceForId(accountId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    // - Добавить на счёт
    public BigDecimal addMoney(Long to, BigDecimal amount) {
        //----------------to - Чей аккаунт, amount - Сколько
        BigDecimal currentBalance = repository.getBalanceForId(to);
        if (currentBalance == null) {   // Если нет записи, создаём новую
            repository.save(to, amount);
            return amount;
        }else{                          // Если запись есть, добавляем amount
            final BigDecimal updatedBalance = currentBalance.add(amount);
            repository.save(to, updatedBalance);
            return updatedBalance;
        }
    }

    // - Сделать перевод
    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal fromBalance = repository.getBalanceForId(transferBalance.getFrom());
        BigDecimal toBalance = repository.getBalanceForId(transferBalance.getTo());
        // - Если From или To не существует - Ошибка
        if (fromBalance == null || toBalance == null) {
            throw new IllegalArgumentException("No customers");
        } else if (transferBalance.getAmount().compareTo(fromBalance) > 0) {// - Если сумма перевода, больше чем сумма на счёте  
            throw new IllegalArgumentException("No money");
        } else {// - Иначе выполнить перевод
            BigDecimal updateFromBalance = fromBalance.subtract(transferBalance.getAmount());
            BigDecimal updateToBalance = toBalance.add(transferBalance.getAmount());
            repository.save(transferBalance.getFrom(), updateFromBalance);
            repository.save(transferBalance.getTo(), updateFromBalance);
        }
        
    }

}
