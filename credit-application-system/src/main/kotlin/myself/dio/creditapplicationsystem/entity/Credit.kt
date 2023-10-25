package myself.dio.creditapplicationsystem.entity

import myself.dio.creditapplicationsystem.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class Credit(
    val creditCode: UUID = UUID.randomUUID(),
    val creditValue: BigDecimal = BigDecimal.ZERO,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int = 0,
    val status: Status = Status.IN_PROGRESS,
    val costumer: Customer? = null,
    val id: Long? = null
)
