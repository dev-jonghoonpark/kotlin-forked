// RUN_PIPELINE_TILL: FRONTEND
// CHECK_TYPE

interface B<T>
interface G<T>: B<T>

fun f(p: B<<!UNRESOLVED_REFERENCE!>Foo<!>>): Any {
    val v = p as G
    return checkSubtype<G<*>>(v)
}

/* GENERATED_FIR_TAGS: asExpression, classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
infix, interfaceDeclaration, localProperty, nullableType, propertyDeclaration, starProjection, typeParameter,
typeWithExtension */
