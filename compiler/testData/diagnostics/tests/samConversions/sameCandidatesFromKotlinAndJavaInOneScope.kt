// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +SamConversionForKotlinFunctions +SamConversionPerArgument
// DIAGNOSTICS: -UNUSED_PARAMETER,-UNUSED_VARIABLE

// FILE: Action.java
public interface Action<T> {
    void execute(T t);
}

// FILE: Other.java

// It's important that this is Java
public interface Other {
    void pluginManagement(Action<? super Number> pluginManagementSpec);
}

// FILE: test.kt
interface B {
    fun pluginManagement(block: Number.() -> Unit): Unit {}
}

interface C : B, Other

fun test(c: C) {
    c.pluginManagement {
    }
}

/* GENERATED_FIR_TAGS: functionDeclaration, functionalType, interfaceDeclaration, javaType, lambdaLiteral,
typeWithExtension */
