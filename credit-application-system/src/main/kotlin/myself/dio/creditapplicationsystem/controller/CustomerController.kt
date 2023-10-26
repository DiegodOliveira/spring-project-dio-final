package myself.dio.creditapplicationsystem.controller

import myself.dio.creditapplicationsystem.dto.CustomerDto
import myself.dio.creditapplicationsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController (
    private val customerService: CustomerService
){

    @PostMapping
    fun saveCustomer(customerDto: CustomerDto): String{
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${customerDto.email} saved!"
    }
}