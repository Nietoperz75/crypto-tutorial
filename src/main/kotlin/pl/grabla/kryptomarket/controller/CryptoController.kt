package pl.grabla.kryptomarket.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.grabla.kryptomarket.CryptoFacade
import pl.grabla.kryptomarket.exceptions.UserNotFoundException
import pl.grabla.kryptomarket.model.User
import pl.grabla.kryptomarket.model.Wallet
import pl.grabla.kryptomarket.repository.UserRepository
import pl.grabla.kryptomarket.repository.WalletRepository

@RestController
class CryptoController {

    @Autowired
    lateinit var cryptoFacade: CryptoFacade

    @GetMapping("/users")
    fun getUsers(): List<User>{
        return cryptoFacade.getUsers()
    }

    @PostMapping("/user")
    fun addUser(@RequestParam("firstName") firstName:String,
                @RequestParam("lastName") lastName:String): User{


        return cryptoFacade.addUser(firstName, lastName)
    }

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id:Long):User{
        return cryptoFacade.getUser(id)
    }

    @PostMapping("/user/{id}/sell/btc")
    fun sellBtc(@PathVariable id: Long, @RequestParam("amount") amount:Double): Wallet{
        return cryptoFacade.sellBtc(id, amount)
    }

    @PostMapping("/user/{id}/buy/btc")
    fun buyBtc(@PathVariable id: Long, @RequestParam("amount") amount:Double):Wallet{
        return cryptoFacade.buyBtc(id, amount)
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long){
        return cryptoFacade.deleteUser(id)
    }



}