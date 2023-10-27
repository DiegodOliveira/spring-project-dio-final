package myself.dio.creditapplicationsystem.controller

import myself.dio.creditapplicationsystem.dto.CreditDto
import myself.dio.creditapplicationsystem.entity.Credit
import myself.dio.creditapplicationsystem.service.impl.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/credits")
class CreditController (private val creditService: CreditService){

    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): String{
       val credit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!"
    }
}