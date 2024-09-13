package com.dea.PropertySphere.Controller;

import com.dea.PropertySphere.Model.MarketingModel;
import com.dea.PropertySphere.Service.MarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/marketing")
public class MarketingController {

    @Autowired
    MarketingService marketingService;

    @PostMapping(value = "/save")
    Void saveProposal(@RequestBody MarketingModel marketingProposal){
        marketingService.saveProposal(marketingProposal);
        System.out.println(marketingProposal.getProposalName() + " Saved!");
        return null;
    }

    @GetMapping(value = "/getProposal")
    Optional<MarketingModel> getProposalById(@RequestParam int marketingId){
        Optional<MarketingModel> marketingProposal = marketingService.getProposalById(marketingId);
        return marketingProposal;
    }

    @DeleteMapping(value = "/deleteProposal/{marketingId}")
    public void deleteProposal(@PathVariable("marketingId") Integer marketingId){
        marketingService.deleteProposal(marketingId);
    }

    @PutMapping(value = "/updateProposal/{marketingId}")
    public MarketingModel updateProposal(@PathVariable("marketingId") Integer marketingId, @RequestBody MarketingModel updatedMarketingProposal){
        return marketingService.updateProposal(marketingId, updatedMarketingProposal);
}}
