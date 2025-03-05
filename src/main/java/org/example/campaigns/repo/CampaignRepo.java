package org.example.campaigns.repo;

import org.example.campaigns.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepo extends JpaRepository<Campaign, Integer> {
}
