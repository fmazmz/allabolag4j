package com.org.allabolag4j.wrapper;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public record FinancialReport(
        String year,
        String period,
        String periodStart,
        String periodEnd,
        String currency,
        List<AccountLine> accounts
) {

    public FinancialReport {
        accounts = List.copyOf(accounts);
    }

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

    public Optional<AccountLine> line(String code) {
        for (AccountLine account : accounts) {
            if (code.equals(account.code())) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }

    public String amount(String code) {
        return line(code).map(AccountLine::amount).orElse(null);
    }

    public Map<String, String> amountsByCode() {
        Map<String, String> byCode = new HashMap<>();
        for (AccountLine account : accounts) {
            if (account.code() != null) {
                byCode.put(account.code(), account.amount());
            }
        }
        return Collections.unmodifiableMap(byCode);
    }
}

