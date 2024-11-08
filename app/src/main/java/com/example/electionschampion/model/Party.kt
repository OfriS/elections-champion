package com.example.electionschampion.model

import com.example.electionschampion.common.BALAD_PARTY_SYMBOL
import com.example.electionschampion.common.HADASH_TAAL_PARTY_SYMBOL
import com.example.electionschampion.common.ISRAELI_LABOR_PARTY_PARTY_SYMBOL
import com.example.electionschampion.common.LIKUD_PARTY_SYMBOL
import com.example.electionschampion.common.MERETZ_PARTY_SYMBOL
import com.example.electionschampion.common.NATIONAL_UNITY_PARTY_SYMBOL
import com.example.electionschampion.common.RELIGIOUS_ZIONIST_PARTY_PARTY_SYMBOL
import com.example.electionschampion.common.SHAS_PARTY_SYMBOL
import com.example.electionschampion.common.THE_JEWISH_HOME_PARTY_SYMBOL
import com.example.electionschampion.common.UNITED_TORAH_JUDAISM_PARTY_SYMBOL
import com.example.electionschampion.common.YESH_ATID_PARTY_SYMBOL
import com.example.electionschampion.common.YISRAEL_BEITEINU_PARTY_SYMBOL

enum class Party(val partySymbol: String) {
    YESH_ATID(YESH_ATID_PARTY_SYMBOL),
    LIKUD(LIKUD_PARTY_SYMBOL),
    NATIONAL_UNITY(NATIONAL_UNITY_PARTY_SYMBOL),
    MERETZ(MERETZ_PARTY_SYMBOL),
    ISRAELI_LABOR_PARTY(ISRAELI_LABOR_PARTY_PARTY_SYMBOL),
    RELIGIOUS_ZIONIST_PARTY(RELIGIOUS_ZIONIST_PARTY_PARTY_SYMBOL),
    SHAS(SHAS_PARTY_SYMBOL),
    YISRAEL_BEITEINU(YISRAEL_BEITEINU_PARTY_SYMBOL),
    BALAD(BALAD_PARTY_SYMBOL),
    HADASH_TAAL(HADASH_TAAL_PARTY_SYMBOL),
    UNITED_TORAH_JUDAISM(UNITED_TORAH_JUDAISM_PARTY_SYMBOL),
    THE_JEWISH_HOME(THE_JEWISH_HOME_PARTY_SYMBOL),
}