package service;


import pojo.CashAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

public class CashAccountService implements TradeAccountService{
    private TradeAccountRepository tradeAccountRepository;

    public CashAccountService(TradeAccountRepository tradeAccountRepository) {
        this.tradeAccountRepository  = tradeAccountRepository;
    }

    public void createTradeAccount(CashAccount account) {
        this.tradeAccountRepository.createTradeAccount(account);
    }

    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) this.tradeAccountRepository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(CashAccount account) {
        this.tradeAccountRepository.updateTradeAccount(account);
    }

    public void deleteTradeAccount(String id) {
        this.tradeAccountRepository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount cashAccount = retrieveTradeAccount(id);
        cashAccount.setCashBalance(cashAccount.getCashBalance().add(amount));
        updateTradeAccount(cashAccount);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount cashAccount = retrieveTradeAccount(id);
        cashAccount.setCashBalance(cashAccount.getCashBalance().subtract(amount));
        updateTradeAccount(cashAccount);
    }
}
