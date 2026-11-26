package com.org.allabolag4j;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public record FinancialReport(
        String year,
        String period,
        String periodStart,
        String periodEnd,
        String currency,
        List<AccountLine> accounts
) {

    static FinancialReport from(JsonNode node) {
        List<AccountLine> lines = new ArrayList<>();

        for (JsonNode account : node.path("accounts")) {
            String amount = account.path("amount").isNull() ? null : account.path("amount").asText();
            lines.add(new AccountLine(account.path("code").asText(null), amount));
        }

        return new FinancialReport(
                node.path("year").asText(null),
                node.path("period").asText(null),
                node.path("periodStart").asText(null),
                node.path("periodEnd").asText(null),
                node.path("currency").asText(null),
                lines
        );
    }
}

