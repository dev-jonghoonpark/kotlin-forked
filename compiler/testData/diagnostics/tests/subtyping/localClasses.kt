// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -UNUSED_PARAMETER

package p

private fun foo(a: Int) = run {
    class A
    A()
}

private fun foo() = run {
    class A
    A()
}

fun test() {
    var x = foo(1)
    x = <!TYPE_MISMATCH!>foo()<!>
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, integerLiteral, lambdaLiteral, localClass,
localProperty, propertyDeclaration */
