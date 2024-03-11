package ru.bar.birza.service

import org.springframework.stereotype.Service
import ru.bar.birza.model.Asset
import ru.bar.birza.repository.AssetRepository
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.random.Random

@Service
class AssetServiceImpl(val assetRepository: AssetRepository): AssetService {
  override fun get(ticker: String): Asset {
    return assetRepository.findById(ticker).get()
  }

  override fun save(asset: Asset): Asset {
    return assetRepository.save(asset)
  }

  override fun list(): List<Asset> {
    return assetRepository.findAll().toList()
  }

  // NOT FOR REAL
  fun randomTick(ticker: String) {
    val asset = get(ticker)
    val randomFactor = Random.nextInt(100)
    if (randomFactor == 50) { return } // price not changed
    val multiplier = BigDecimal.ONE + BigDecimal.ONE/BigDecimal(randomFactor-50)
    asset.buyPriceUsd = (asset.buyPriceUsd * multiplier).setScale(2, RoundingMode.UP)
    asset.selPriceUsd = (asset.selPriceUsd * multiplier).setScale(2, RoundingMode.DOWN)
    save(asset)
  }

  override fun randomTickAll() {
    for (asset in list()) {
      randomTick(asset.ticker)
    }
  }

}