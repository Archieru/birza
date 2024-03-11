package ru.bar.birza.repository

import org.springframework.data.repository.CrudRepository
import ru.bar.birza.model.Asset

interface AssetRepository: CrudRepository<Asset, String> {
}