package org.example.campaigns.controller;

import lombok.AllArgsConstructor;
import org.example.campaigns.dto.CampaignDto;
import org.example.campaigns.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/campaigns")
public class CampaignController {
    private final CampaignService campaignService;

    // Add Campaign REST API
    @PostMapping
    public ResponseEntity<CampaignDto> addCampaign(@RequestBody CampaignDto campaignDto) {
        CampaignDto savedCampaign = campaignService.addCampaign(campaignDto);
        return new ResponseEntity<>(savedCampaign, HttpStatus.CREATED);
    }

    // Get Campaign REST API
    @GetMapping("/{id}")
    public ResponseEntity<CampaignDto> getCampaignById(@PathVariable Integer id) {
        CampaignDto campaign = campaignService.getCampaignById(id);
        return new ResponseEntity<>(campaign, HttpStatus.OK);
    }

    // Get All Campaigns REST API
    @GetMapping
    public ResponseEntity<List<CampaignDto>> getAllCampaigns() {
        List<CampaignDto> campaigns = campaignService.getAllCampaigns();
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    // Update Campaign REST API
    @PutMapping("/{id}")
    public ResponseEntity<CampaignDto> updateCampaign(@PathVariable Integer id, @RequestBody CampaignDto updatedCampaign) {
        CampaignDto campaign = campaignService.updateCampaign(id, updatedCampaign);
        return new ResponseEntity<>(campaign, HttpStatus.OK);
    }

    // Delete Campaign REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCampaign(@PathVariable Integer id) {
        campaignService.deleteCampaign(id);
        return ResponseEntity.ok("Campaign deleted successfully with id: " + id);
    }
}
