package org.example.campaigns.mapper;

import org.example.campaigns.dto.CampaignDto;
import org.example.campaigns.entity.Campaign;
import org.example.campaigns.entity.User;

public class CampaignMapper {

    public static CampaignDto mapToCampaignDto(Campaign campaign) {
        return new CampaignDto(
                campaign.getId(),
                campaign.getCampaignName(),
                campaign.getKeywords(),
                campaign.getBidAmount(),
                campaign.getCampaignFund(),
                campaign.getStatus(),
                campaign.getTown(),
                campaign.getRadius(),
                campaign.getUser().getId()
        );
    }

    public static Campaign mapToCampaign(CampaignDto campaignDto, User user) {
        return new Campaign(
                campaignDto.getId(),
                campaignDto.getCampaignName(),
                campaignDto.getKeywords(),
                campaignDto.getBidAmount(),
                campaignDto.getCampaignFund(),
                campaignDto.getStatus(),
                campaignDto.getTown(),
                campaignDto.getRadius(),
                user
        );
    }
}
