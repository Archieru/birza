package ru.bar.birza.service

import org.springframework.stereotype.Service
import ru.bar.birza.model.User
import ru.bar.birza.repository.UserRepository
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class UserServiceImpl(val userRepository: UserRepository, val assetService: AssetService): UserService {
  override fun getUser(name: String): User {
    return userRepository.findById(name).get()
  }

  override fun save(user: User): User {
    return userRepository.save(user)
  }

  override fun topUp(name: String, amount: BigDecimal) {
    val user = getUser(name)
    val newAmount = user.balanceUsd + amount
    user.balanceUsd = newAmount.setScale(2, RoundingMode.DOWN)
    save(user)
  }

  override fun buy(name: String, ticker: String, amount: BigDecimal) {
    val user = getUser(name)
    val asset = assetService.get(ticker)
    val buyPrice = asset.buyPriceUsd * amount
    if (buyPrice < user.balanceUsd) {
      user.balanceUsd -= buyPrice
      user.assets[asset] = user.assets.getOrDefault(asset, BigDecimal.ZERO) + amount
    }
    save(user)
  }

  override fun sell(name: String, ticker: String, amount: BigDecimal) {
    val user = getUser(name)
    val asset = assetService.get(ticker)
    val sellPrice = asset.selPriceUsd * amount
    if (user.assets.containsKey(asset) && user.assets[asset]!! > amount) {
      user.assets[asset] = user.assets[asset]!! - amount
      user.balanceUsd += sellPrice
    }
    save(user)
  }
}