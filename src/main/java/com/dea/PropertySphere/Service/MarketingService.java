package com.dea.PropertySphere.Service;

import com.dea.PropertySphere.Model.MarketingModel;
import com.dea.PropertySphere.Repo.MarketingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketingService {

    @Autowired
    MarketingRepo marketingRepo;


    public MarketingModel saveProposal(MarketingModel marketingModel) {
        return marketingRepo.save(marketingModel);
    }
    public Optional<MarketingModel> getProposalById(int proposalID) {
        if (marketingRepo.findById(proposalID).isEmpty()) {
            System.out.println("Proposal Not Found!!!");
            return Optional.empty();
        } else {
            return marketingRepo.findById(proposalID);
        }
    }

    public void deleteProposal(int proposalID) {
        if (marketingRepo.findById(proposalID).isEmpty()) {
            System.out.println("Proposal Not Exists");
        } else {
            marketingRepo.deleteById(proposalID);
            System.out.println("Proposal(" + proposalID + ") Deleted ");
        }
    }

    public MarketingModel updateProposal(int proposalID, MarketingModel updatedProposal) {
        Optional<MarketingModel> existingProposalOptional = marketingRepo.findById(proposalID);

        if (existingProposalOptional.isPresent()) {
            MarketingModel existingProposal = existingProposalOptional.get();
            existingProposal.setProposalName(updatedProposal.getProposalName());
            return marketingRepo.save(existingProposal);
        } else {
            System.out.println("Proposal Not Found!!!");
            return null;
        }
    }
}
