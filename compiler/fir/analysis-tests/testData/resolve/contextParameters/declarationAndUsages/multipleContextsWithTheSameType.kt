// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ContextParameters

class A {
    fun foo(a: String): String { return a }
}

context(ctx: T)
fun <T> implicit(): T = ctx

context(a: A)
fun foo() { }

context(a: A, a2: A)
fun test() {
    a.foo("")
    a2.foo("")
    <!AMBIGUOUS_CONTEXT_ARGUMENT!>foo<!>()
    <!AMBIGUOUS_CONTEXT_ARGUMENT!>implicit<!><A>().foo("")
}

context(a: A, a2: A)
val property: String
    get() {
        a.foo("")
        a2.foo("")
        <!AMBIGUOUS_CONTEXT_ARGUMENT!>foo<!>()
        return <!AMBIGUOUS_CONTEXT_ARGUMENT!>implicit<!><A>().foo("")
    }

fun inTypePosition(a: context(A, A) ()-> Unit) {}

fun usage(){
    with(A()) {
        test()
        property
        foo()
    }
    inTypePosition {
        <!AMBIGUOUS_CONTEXT_ARGUMENT!>implicit<!><A>().foo("")
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionDeclarationWithContext, functionalType, getter,
lambdaLiteral, nullableType, propertyDeclaration, propertyDeclarationWithContext, stringLiteral, typeParameter,
typeWithContext */
