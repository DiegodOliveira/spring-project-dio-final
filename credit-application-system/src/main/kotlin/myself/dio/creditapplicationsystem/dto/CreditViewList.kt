package myself.dio.creditapplicationsystem.dto

import myself.dio.creditapplicationsystem.entity.Credit
import java.math.BigDecimal
import java.util.*

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int
){
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments
    )
}
