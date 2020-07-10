package com.mvk.template.data.repository

import com.mvk.network.NetworkService
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService
) {

}