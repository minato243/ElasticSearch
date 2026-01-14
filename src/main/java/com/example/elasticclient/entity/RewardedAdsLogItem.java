package com.example.elasticclient.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RewardedAdsLogItem extends LogItem {
    public String placement;
    public String subPlacement;

    public RewardedAdsLogItem() {
    }

    public RewardedAdsLogItem(String gameId, String eventType, String userId, String platform, String country, String gameVersion, int level,
            int loggedDay, Date accountCreatedDate, Date date, String placement, String subPlacement) {
        super(gameId, eventType, userId, platform, gameVersion, country, level, loggedDay, accountCreatedDate, date);
        this.placement = placement;
        this.subPlacement = subPlacement;
    }
}
