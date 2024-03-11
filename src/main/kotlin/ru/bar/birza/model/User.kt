package ru.bar.birza.model

import jakarta.persistence.Id
import java.math.BigDecimal

data class User(
  @Id
  val name: String,
  var balanceUsd: BigDecimal,
  val assets: MutableMap<Asset, BigDecimal>
)
