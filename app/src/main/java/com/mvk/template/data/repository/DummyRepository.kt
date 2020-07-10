package com.mvk.template.data.repository

import com.mvk.database.db.DatabaseService
import com.mvk.network.NetworkService
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

}