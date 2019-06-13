package com.baeldung.pattern.hexagonal;

public class StockBrokerImpl implements StockBroker {

    private TradeBookRepository tradebookRepository;

    public String addOrder(String stockCode, String action, double price, int volume) {
        String statusCode = "0";

        TradeBook tradeBook = tradebookRepository.get(stockCode, action, price);
        if (tradeBook != null) {
            // if there's a trade book entry, increase the volume
            tradeBook.setVolume(tradeBook.getVolume() + volume);
        } else {
            // if not found, then create a new trade book
            tradebookRepository.add(stockCode, action, price, volume);
            statusCode = "1";
        }
        return statusCode;
    }

    void setTradeBookRepository(TradeBookRepository tradebookRepository) {
        this.tradebookRepository = tradebookRepository;
    }
}
