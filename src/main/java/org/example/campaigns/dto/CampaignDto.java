package org.example.campaigns.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignDto {
    private int id;
    private String campaignName;
    private String keywords;
    private double bidAmount;
    private double campaignFund;
    private String status;
    private String town;
    private int radius;
}
