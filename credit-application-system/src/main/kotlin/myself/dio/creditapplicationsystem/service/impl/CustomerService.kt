package myself.dio.creditapplicationsystem.service.impl

import myself.dio.creditapplicationsystem.entity.Customer
import myself.dio.creditapplicationsystem.exception.BusinessException
import myself.dio.creditapplicationsystem.repository.CustomerRepository
import myself.dio.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository): ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow{
            throw BusinessException("Id $id not found")
        }


    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }


}