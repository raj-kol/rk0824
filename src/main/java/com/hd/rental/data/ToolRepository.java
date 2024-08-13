package com.hd.rental.data;

import com.hd.rental.model.PriceInfo;
import com.hd.rental.model.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class ToolRepository {
    private final List<Tool> tools;

    public ToolRepository() {
        tools = new ArrayList<>();
        initializeTools();
    }

    private void initializeTools() {
        PriceInfo ladderPrice = new PriceInfo("Ladder", 1.99f, true, true, false);
        PriceInfo chainsawPrice = new PriceInfo("Chainsaw", 1.49f, true, false, true);
        PriceInfo jackhammerPrice = new PriceInfo("Jackhammer", 2.99f, true, false, false);

        tools.add(new Tool("CHNS", "Chainsaw", "Stihl", chainsawPrice));
        tools.add(new Tool("LADW", "Ladder", "Werner", ladderPrice));
        tools.add(new Tool("JAKD", "Jackhammer", "DeWalt", jackhammerPrice));
        tools.add(new Tool("JAKR", "Jackhammer", "Ridgid", jackhammerPrice));
    }

    public Optional<Tool> finByCode(String toolCode) {
        return tools.stream()
                .filter(tool -> tool.getCode().equals(toolCode))
                .findFirst();
    }
}
