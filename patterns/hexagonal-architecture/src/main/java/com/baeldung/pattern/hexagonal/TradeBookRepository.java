package com.baeldung.pattern.hexagonal;

interface TradeBookRepository {

    boolean add(String stockCode, String action, double price, int volume);

    TradeBook get(String stockCode, String action, double price);

}
