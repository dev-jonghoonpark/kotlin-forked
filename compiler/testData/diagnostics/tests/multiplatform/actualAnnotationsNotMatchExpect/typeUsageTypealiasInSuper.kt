// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
@Target(AnnotationTarget.TYPE)
annotation class Ann

interface I

expect class Foo: @Ann I

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
typealias ITypealias = I

actual class Foo : ITypealias

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, interfaceDeclaration,
typeAliasDeclaration */
