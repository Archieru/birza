package ru.bar.birza.service

import org.springframework.stereotype.Service
import ru.bar.birza.model.Asset

@Service
interface AssetService {
  fun get(ticker: String): Asset
  fun save(asset: Asset): Asset
  fun list(): List<Asset>
  fun randomTickAll()
}