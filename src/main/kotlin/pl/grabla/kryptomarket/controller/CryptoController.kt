package pl.grabla.kryptomarket.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pl.grabla.kryptomarket.exceptions.UserNotFoundException
import pl.grabla.kryptomarket.model.User
import pl.grabla.kryptomarket.model.Wallet
import pl.grabla.kryptomarket.repository.UserRepository
import pl.grabla.kryptomarket.repository.WalletRepository

@RestController
class CryptoController {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var walletRepository: WalletRepository

    @GetMapping("/users")
    fun getUsers(): List<User>{
        return userRepository.findAll()
    }

    @PostMapping("/user")
    fun addUser(@RequestParam("firstName") firstName:String,
                @RequestParam("lastName") lastName:String): User{
        val wallet = Wallet(btc = 5.0, usd = 1250.0)
        walletRepository.save(wallet)

        val user = User(firstName = firstName, lastName = lastName, wallet = wallet)
        userRepository.save(user)
        return user
    }

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id:Long):User{
        return userRepository.
                findById(id).
                orElseThrow { throw UserNotFoundException("can't find user such id") }
    }

}