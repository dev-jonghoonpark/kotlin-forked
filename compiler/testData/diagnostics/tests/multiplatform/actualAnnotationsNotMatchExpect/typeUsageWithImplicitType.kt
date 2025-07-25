// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
@Target(AnnotationTarget.TYPE)
annotation class Ann

expect fun foo(): @Ann Int

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
actual fun foo() = 1

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, expect, functionDeclaration, integerLiteral */
