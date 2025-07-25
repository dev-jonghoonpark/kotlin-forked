// RUN_PIPELINE_TILL: FRONTEND
fun bar(x: Int): Int = x + 1

fun foo() {
    val x: Int? = null
    while (x == null) {
        bar(<!ARGUMENT_TYPE_MISMATCH!>x<!>)
    }
    bar(x)

    val y: Int? = null
    while (y != null) {
        bar(y)
    }
    bar(<!ARGUMENT_TYPE_MISMATCH!>y<!>)

    val z: Int? = null
    while (z == null) {
        bar(<!ARGUMENT_TYPE_MISMATCH!>z<!>)
        break
    }
    bar(<!ARGUMENT_TYPE_MISMATCH!>z<!>)
}

/* GENERATED_FIR_TAGS: additiveExpression, break, equalityExpression, functionDeclaration, integerLiteral, localProperty,
nullableType, propertyDeclaration, smartcast, whileLoop */
