package com.k0d4black.theforce.remote.planet.data

import com.k0d4black.theforce.remote.core.isSuccessfulAndNotNull
import com.k0d4black.theforce.remote.planet.mappers.PlanetDetailsResponseMapper
import com.k0d4black.theforce.shared.extensions.enforceHttps
import com.k0d4black.theforce.shared.planets.Planet
import com.k0d4black.theforce.shared.planets.PlanetsDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlanetsRemoteDataSource(
    private val apiService: PlanetApiService,
    private val planetDetailsResponseMapper: PlanetDetailsResponseMapper
) : PlanetsDataSource {

    override suspend fun getCharacterPlanet(characterUrl: String): Flow<Planet> = flow {
        val planetUrlResponse = apiService.getPlanetUrl(characterUrl = characterUrl.enforceHttps())
        if (!planetUrlResponse.isSuccessfulAndNotNull()) return@flow

        val planetDetailsResponse = apiService.getPlanetDetails(
            planetUrl = planetUrlResponse.body()!!.homeworldUrl.enforceHttps()
        )
        if (!planetDetailsResponse.isSuccessfulAndNotNull()) return@flow

        val planet = planetDetailsResponseMapper.mapToDomain(
            planetDetailsResponse = planetDetailsResponse.body()!!
        )
        emit(value = planet)
    }
}