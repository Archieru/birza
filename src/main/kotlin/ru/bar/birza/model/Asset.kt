package ru.bar.birza.model

import jakarta.persistence.Id
import java.math.BigDecimal

data class Asset(
  @Id
  val ticker: String,
  var buyPriceUsd: BigDecimal,
  var selPriceUsd: BigDecimal
) {
  constructor(ticker: String, buyPriceUsd: Double, sellPriceUsd: Double): this(ticker, BigDecimal(buyPriceUsd), BigDecimal(sellPriceUsd))
  constructor(ticker: String, buyPriceUsd: Int, sellPriceUsd: Int): this(ticker, BigDecimal(buyPriceUsd), BigDecimal(sellPriceUsd))
}
