// RUN_PIPELINE_TILL: BACKEND
// FILE: Base.java

public class Base {
    public String getSomething() {
        return "";
    }
}

// FILE: Derived.kt

class Derived : Base() {
    override fun getSomething(): String = "42"
}

fun test() {
    val d = Derived()
    val res1 = d.something // Should be Ok
    val res2 = d.getSomething() // Should be Ok
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaProperty, javaType, localProperty, override,
propertyDeclaration, stringLiteral */
