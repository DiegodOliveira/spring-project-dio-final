package myself.dio.creditapplicationsystem.service

import myself.dio.creditapplicationsystem.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long): Customer
}