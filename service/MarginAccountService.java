package service;


import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

public class MarginAccountService implements TradeAccountService{

    private TradeAccountRepository tradeAccountRepository;

    public MarginAccountService(TradeAccountRepository tradeAccountRepository) {
        this.tradeAccountRepository = tradeAccountRepository;
    }
    public void createTradeAccount(MarginAccount account) {
        this.tradeAccountRepository.createTradeAccount(account);
    }

    public MarginAccount retrieveTradeAccount(String id) {
        return (MarginAccount) this.tradeAccountRepository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(MarginAccount account) {
        this.tradeAccountRepository.updateTradeAccount(account);
    }

    public void deleteTradeAccount(String id) {
        this.tradeAccountRepository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        MarginAccount marginAccount = retrieveTradeAccount(id);
        marginAccount.setMargin(marginAccount.getMargin().add(amount));
        updateTradeAccount(marginAccount);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount marginAccount = retrieveTradeAccount(id);
        marginAccount.setMargin(marginAccount.getMargin().subtract(amount));
        updateTradeAccount(marginAccount);
    }
}