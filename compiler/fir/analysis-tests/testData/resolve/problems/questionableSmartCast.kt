// RUN_PIPELINE_TILL: BACKEND
interface A
interface B

fun foo(x: A) {}
fun foo(x: B) {}

open class C : A, B

fun main(a: A) {
    foo(a)

    val anonymousA: A = object : C() {}
    foo(anonymousA)
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, interfaceDeclaration,
localProperty, propertyDeclaration */
