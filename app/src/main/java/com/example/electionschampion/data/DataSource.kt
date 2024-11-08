package com.example.electionschampion.data

import com.example.electionschampion.common.PLACE_NAME_KEY
import com.example.electionschampion.common.POPULATION_KEY
import com.example.electionschampion.common.TOTAL_VOTES_KEY
import com.example.electionschampion.model.Party
import com.example.electionschampion.model.PlaceResult
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.io.readCSV
import java.io.InputStream

object DataSource {
    private val results: MutableList<PlaceResult> = mutableListOf()

    /**
     * Loads the games data from the provided CSV file stream.
     *
     * @param data Stream with the CSV containing the elections data.
     *
     * TODO: Handle failure in reading data.
     */
    fun load(data: InputStream) {
        val df = DataFrame.readCSV(data)
        for (row in df) {

            // Iterate over all parties in the game and count votes for the current place.
            val placeResults: MutableMap<Party, Int> = mutableMapOf()
            for (party in Party.entries) {
                placeResults[party] = row[party.partySymbol] as Int
            }

            // Construct the data class for the current place.
            results.add(
                PlaceResult(
                    placeName = row[PLACE_NAME_KEY] as String,
                    population = row[POPULATION_KEY] as Int,
                    totalVotes = row[TOTAL_VOTES_KEY] as Int,
                    results = placeResults
                )
            )
        }
    }

    /**
     * Returns the election results.
     *
     *  NOTICE! May only be called after [DataSource.load] is called successfully.
     */
    fun getResults() : List<PlaceResult> {
        return results
    }
}