package pl.grabla.kryptomarket.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.grabla.kryptomarket.model.User

@Repository
interface UserRepository: JpaRepository<User, Long> {
}