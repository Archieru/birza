package ru.bar.birza.repository

import org.springframework.data.repository.CrudRepository
import ru.bar.birza.model.User

interface UserRepository: CrudRepository<User, String> {
}