// FIR_IDENTICAL
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
// FILE: common.kt
expect interface Base<T> {
    fun foo():T
}
class DelegatedImpl<T : Base<T>>(val a: T) : Base<T> by a

// MODULE: platform()()(common)
// FILE: platform.kt
actual interface Base<T> {
    actual fun foo(): T
    fun bar():T
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, inheritanceDelegation,
interfaceDeclaration, nullableType, primaryConstructor, propertyDeclaration, typeConstraint, typeParameter */
