package myself.dio.creditapplicationsystem.controller

import myself.dio.creditapplicationsystem.dto.CustomerDto
import myself.dio.creditapplicationsystem.dto.CustomerUpdateDto
import myself.dio.creditapplicationsystem.dto.CustomerView
import myself.dio.creditapplicationsystem.entity.Customer
import myself.dio.creditapplicationsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : CustomerView{
        val customer : Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView{
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }
}