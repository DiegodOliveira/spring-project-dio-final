package myself.dio.creditapplicationsystem.repository

import myself.dio.creditapplicationsystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}