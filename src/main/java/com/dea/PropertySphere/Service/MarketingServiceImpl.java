package com.dea.PropertySphere.Service;

import com.dea.PropertySphere.Model.MarketingModel;
import com.dea.PropertySphere.Repo.MarketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketingServiceImpl implements MarketingService {

    @Autowired
    MarketingRepository marketingRepository;


    public MarketingModel saveProposal(MarketingModel marketingModel) {
        return marketingRepository.save(marketingModel);
    }
    public Optional<MarketingModel> getProposalById(int proposalID) {
        if (marketingRepository.findById(proposalID).isEmpty()) {
            System.out.println("Proposal Not Found!!!");
            return Optional.empty();
        } else {
            return marketingRepository.findById(proposalID);
        }
    }

    public void deleteProposal(int proposalID) {
        if (marketingRepository.findById(proposalID).isEmpty()) {
            System.out.println("Proposal Not Exists");
        } else {
            marketingRepository.deleteById(proposalID);
            System.out.println("Proposal(" + proposalID + ") Deleted ");
        }
    }

    public MarketingModel updateProposal(int proposalID, MarketingModel updatedProposal) {
        Optional<MarketingModel> existingProposalOptional = marketingRepository.findById(proposalID);

        if (existingProposalOptional.isPresent()) {
            MarketingModel existingProposal = existingProposalOptional.get();
            existingProposal.setProposalName(updatedProposal.getProposalName());
            return marketingRepository.save(existingProposal);
        } else {
            System.out.println("Proposal Not Found!!!");
            return null;
        }
    }
}
