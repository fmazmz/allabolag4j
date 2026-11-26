package com.org.allabolag4j.wrapper;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SwedishFinancialCode {
    ADI("ADI", "Övriga rörelseintäkter", "Other operating income", Category.INCOME_STATEMENT),
    ADK("ADK", "Övriga finansiella kostnader", "Other financial expenses", Category.INCOME_STATEMENT),
    ADR("ADR", "Övrig omsättning", "Other revenue", Category.INCOME_STATEMENT),
    AK("AK", "Aktiekapital", "Share capital", Category.BALANCE_SHEET),
    ANT("ANT", "Anställda", "Employees", Category.FINANCIAL_KEY_FIGURES),
    AVK_EGET_KAPITAL("avk_eget_kapital", "Avkastning eget kapital (%)", "Return on equity (%)", Category.FINANCIAL_KEY_FIGURES),
    AVK_TOTALT_KAPITAL("avk_totalt_kaptial", "Räntabilitet på totalt kapital (%)", "Return on total assets (%)", Category.FINANCIAL_KEY_FIGURES),
    AWA("AWA", "Aktiverat arbete för egen räkning", "Capitalized internal work", Category.INCOME_STATEMENT),
    BE("BE", "Lagerförändring", "Change in inventory", Category.INCOME_STATEMENT),
    CPE("CPE", "Personalkostnader per anställd, Tkr", "Personnel expenses per employee (TSEK)", Category.FINANCIAL_KEY_FIGURES),
    DR("DR", "Årets resultat", "Profit for the year", Category.INCOME_STATEMENT),
    EBITDA("EBITDA", "EBITDA", "EBITDA", Category.FINANCIAL_KEY_FIGURES),
    EK("EK", "Avskrivningar och nedskrivningar", "Depreciation and impairments", Category.INCOME_STATEMENT),
    EKA("EKA", "Soliditet (%)", "Equity ratio (%)", Category.FINANCIAL_KEY_FIGURES),
    FI("FI", "Finansiella intäkter", "Financial income", Category.INCOME_STATEMENT),
    FK("FK", "Finansiella kostnader", "Financial expenses", Category.INCOME_STATEMENT),
    FSD("FSD", "Bokslutsdispositioner", "Appropriations", Category.INCOME_STATEMENT),
    GG("GG", "Skuldsättningsgrad", "Debt-to-equity ratio", Category.FINANCIAL_KEY_FIGURES),
    IAC("IAC", "Jämförelsestörande poster", "Non-recurring items", Category.INCOME_STATEMENT),
    KB("KB", "Koncernbidrag", "Group contribution", Category.INCOME_STATEMENT),
    KBP("KBP", "Kassa och bank", "Cash and cash equivalents", Category.BALANCE_SHEET),
    LG("LG", "Leverantörsskulder", "Accounts payable", Category.BALANCE_SHEET),
    LONER_OVRIGA("loner_ovriga", "Löner övriga", "Other salaries", Category.SALARIES_AND_DIVIDENDS),
    LONER_STYRELSE_VD("loner_styrelse_vd", "Löner styrelse och VD", "Salaries, board of directors and CEO", Category.SALARIES_AND_DIVIDENDS),
    ORS("ORS", "Resultat före skatt", "Profit before tax", Category.INCOME_STATEMENT),
    RESULTAT_E_AVSKRIVNINGAR("resultat_e_avskrivningar", "Rörelseresultat efter avskrivningar", "Operating profit after depreciation", Category.INCOME_STATEMENT),
    RESULTAT_E_FINANSNETTO("resultat_e_finansnetto", "Resultat efter finansnetto", "Profit after net financial items", Category.INCOME_STATEMENT),
    RG("RG", "Kassalikviditet (%)", "Cash ratio (%)", Category.FINANCIAL_KEY_FIGURES),
    RPE("RPE", "Omsättning per anställd, Tkr", "Revenue per employee (TSEK)", Category.FINANCIAL_KEY_FIGURES),
    SAP("SAP", "Avsättningar", "Provisions", Category.BALANCE_SHEET),
    SDI("SDI", "Omsättning", "Revenue", Category.INCOME_STATEMENT),
    SED("SED", "Summa tillgångar", "Total assets", Category.BALANCE_SHEET),
    SEK("SEK", "Eget kapital", "Equity", Category.BALANCE_SHEET),
    SF("SF", "Kundfordringar", "Accounts receivable", Category.BALANCE_SHEET),
    SFA("SFA", "Anläggningstillgångar", "Non-current assets", Category.BALANCE_SHEET),
    SGE("SGE", "Summa eget kapital och skulder", "Total equity and liabilities", Category.BALANCE_SHEET),
    SI("SI", "Nettoomsättning", "Net sales", Category.INCOME_STATEMENT),
    SIA("SIA", "Immateriella anläggningstillgångar", "Intangible non-current assets", Category.BALANCE_SHEET),
    SIK("SIK", "Fritt eget kapital", "Free equity", Category.BALANCE_SHEET),
    SKG("SKG", "Kortfristiga skulder", "Current liabilities", Category.BALANCE_SHEET),
    SKGKI("SKGKI", "Kortfristiga skulder till kreditinstitut", "Current liabilities to credit institutions", Category.BALANCE_SHEET),
    SKO("SKO", "Skatt på årets resultat", "Income tax on profit for the year", Category.INCOME_STATEMENT),
    SLG("SLG", "Långfristiga skulder till kreditinstitut", "Non-current liabilities to credit institutions", Category.BALANCE_SHEET),
    SOM("SOM", "Omsättningstillgångar", "Current assets", Category.BALANCE_SHEET),
    SUB("SUB", "Föreslagen utdelning", "Dividend", Category.SALARIES_AND_DIVIDENDS),
    SUMMA_FINANSIELLA_ANLTILLG("summa_finansiella_anltillg", "Finansiella anläggningstillgångar", "Financial non-current assets", Category.BALANCE_SHEET),
    SUMMA_LANGFRISTIGA_SKULDER("summa_langfristiga_skulder", "Långfristiga skulder", "Non-current liabilities", Category.BALANCE_SHEET),
    SUMMA_RORELSEKOSTNADER("summa_rorelsekostnader", "Rörelsekostnader", "Operating expenses", Category.INCOME_STATEMENT),
    SV("SV", "Varulager", "Inventory", Category.BALANCE_SHEET),
    SVD("SVD", "Materiella anläggningstillgångar", "Tangible non-current assets", Category.BALANCE_SHEET),
    TR("TR", "Vinstmarginal (%)", "Profit margin (%)", Category.FINANCIAL_KEY_FIGURES),
    UTR("UTR", "Obeskattade reserver", "Untaxed reserves", Category.BALANCE_SHEET);

    public enum Category {
        INCOME_STATEMENT,
        BALANCE_SHEET,
        FINANCIAL_KEY_FIGURES,
        SALARIES_AND_DIVIDENDS
    }

    private final String code;
    private final String swedishName;
    private final String englishName;
    private final Category category;

    SwedishFinancialCode(
            String code,
            String swedishName,
            String englishName,
            Category category
    ) {
        this.code = code;
        this.swedishName = swedishName;
        this.englishName = englishName;
        this.category = category;
    }

    public String code() {
        return code;
    }

    public String swedishName() {
        return swedishName;
    }

    public String englishName() {
        return englishName;
    }

    public Category category() {
        return category;
    }

    private static final Map<String, SwedishFinancialCode> BY_CODE =
            Arrays.stream(values())
                    .collect(Collectors.toUnmodifiableMap(
                            SwedishFinancialCode::code,
                            Function.identity()
                    ));

    public static SwedishFinancialCode fromCode(String code) {
        return BY_CODE.get(code);
    }
}
