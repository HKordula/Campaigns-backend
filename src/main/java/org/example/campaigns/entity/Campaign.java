package org.example.campaigns.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String campaignName;
    @ElementCollection
    private List<String> keywords;
    private double bidAmount;
    private double campaignFund;
    private String status;
    private String town;
    private int radius;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
