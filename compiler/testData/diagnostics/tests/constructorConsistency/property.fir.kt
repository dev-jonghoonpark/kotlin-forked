// RUN_PIPELINE_TILL: BACKEND
class My(x: String) {
    val y: String = foo(x)

    fun foo(x: String) = "$x$y"
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, primaryConstructor, propertyDeclaration */
