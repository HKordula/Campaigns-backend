package org.example.campaigns.service.impl;

import lombok.AllArgsConstructor;
import org.example.campaigns.dto.CampaignDto;
import org.example.campaigns.entity.Campaign;
import org.example.campaigns.entity.User;
import org.example.campaigns.exception.InsufficientFundsException;
import org.example.campaigns.exception.ResourceNotFoundException;
import org.example.campaigns.mapper.CampaignMapper;
import org.example.campaigns.repo.CampaignRepo;
import org.example.campaigns.repo.UserRepo;
import org.example.campaigns.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepo campaignRepo;
    private final UserRepo userRepo;

    @Override
    public CampaignDto addCampaign(Integer userId, CampaignDto campaignDto) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (user.getEmeraldFunds() < campaignDto.getCampaignFund()) {
            throw new InsufficientFundsException("Not enough funds in your Emerald account.");
        }

        user.setEmeraldFunds(user.getEmeraldFunds() - campaignDto.getCampaignFund());
        userRepo.save(user);

        Campaign campaign = CampaignMapper.mapToCampaign(campaignDto, user);
        Campaign savedCampaign = campaignRepo.save(campaign);

        return CampaignMapper.mapToCampaignDto(savedCampaign);
    }

    @Override
    public CampaignDto getCampaignById(Integer id) {
        Campaign campaign = campaignRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
        return CampaignMapper.mapToCampaignDto(campaign);
    }

    @Override
    public List<CampaignDto> getAllCampaigns() {
        return campaignRepo.findAll()
                .stream()
                .map(CampaignMapper::mapToCampaignDto)
                .toList();
    }

    @Override
    public CampaignDto updateCampaign(Integer id, CampaignDto updatedCampaign) {
        Campaign campaign = campaignRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));

        campaign.setCampaignName(updatedCampaign.getCampaignName());
        campaign.setKeywords(updatedCampaign.getKeywords());
        campaign.setBidAmount(updatedCampaign.getBidAmount());
        campaign.setCampaignFund(updatedCampaign.getCampaignFund());
        campaign.setStatus(updatedCampaign.getStatus());
        campaign.setTown(updatedCampaign.getTown());
        campaign.setRadius(updatedCampaign.getRadius());

        Campaign savedCampaign = campaignRepo.save(campaign);
        return CampaignMapper.mapToCampaignDto(savedCampaign);
    }

    @Override
    public void deleteCampaign(Integer id) {
        Campaign campaign = campaignRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
        campaignRepo.deleteById(id);
    }
}
