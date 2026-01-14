package com.example.elasticclient.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IapLogItem extends LogItem {
    public String placement;
    public String subPlacement;
    public String productId;
    public String transactionId;
    public String orderId;
    public String purchaseState;
    public String receipt;
    public String currencyCode;
    public String purchaseToken;
    public float price;

    public IapLogItem() {
    }

    public IapLogItem(String gameId, String eventType, String userId,
            String platform, String gameVersion, String country, int level, int loggedDay, Date accountCreatedDate,
            Date date, String productId, String placement, String subPlacement,
            String transactionId, String orderId, String purchaseState, String receipt, String currencyCode,
            String purchaseToken, float price) {
        super(gameId, eventType, userId, platform, gameVersion, country, level, loggedDay, accountCreatedDate, date);
        this.placement = placement;
        this.subPlacement = subPlacement;
        this.productId = productId;
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.purchaseState = purchaseState;
        this.receipt = receipt;
        this.currencyCode = currencyCode;
        this.purchaseToken = purchaseToken;
        this.price = price;
    }
}
