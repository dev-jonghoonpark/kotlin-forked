// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// OPT_IN: kotlin.contracts.ExperimentalContracts
// DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER

import kotlin.contracts.*

fun <T> myRun(block: () -> T): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}

fun foo(x: Int): Int = x + 1

fun typeMismatchInLambda(y: String): Int {
    val x = myRun { foo(<!ARGUMENT_TYPE_MISMATCH!>y<!>) }
    return x
}

/* GENERATED_FIR_TAGS: additiveExpression, contractCallsEffect, contracts, functionDeclaration, functionalType,
integerLiteral, lambdaLiteral, localProperty, nullableType, propertyDeclaration, typeParameter */
