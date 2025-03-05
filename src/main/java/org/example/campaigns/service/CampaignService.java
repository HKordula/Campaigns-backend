package org.example.campaigns.service;

import org.example.campaigns.dto.CampaignDto;

import java.util.List;

public interface CampaignService {
    CampaignDto addCampaign(CampaignDto campaignDto);

    CampaignDto getCampaignById(Integer id);

    List<CampaignDto> getAllCampaigns();

    CampaignDto updateCampaign(Integer id, CampaignDto updatedCampaign);

    void deleteCampaign(Integer id);
}