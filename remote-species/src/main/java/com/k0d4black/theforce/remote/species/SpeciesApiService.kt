package com.k0d4black.theforce.remote.species

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface SpeciesApiService {

    @GET
    suspend fun getSpecieDetails(@Url specieUrl: String): Response<SpecieDetailsResponse>

    @GET
    suspend fun getSpecieUrls(@Url characterUrl: String): Response<SpecieUrlsResponse>
}