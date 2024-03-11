package ru.bar.birza.service

import ru.bar.birza.model.User
import java.math.BigDecimal

interface UserService {
  fun getUser(name: String): User
  fun save(user: User): User
  fun topUp(name: String, amount: BigDecimal)
  fun buy(name: String, ticker: String, amount: BigDecimal)
  fun sell(name: String, ticker: String, amount: BigDecimal)
}