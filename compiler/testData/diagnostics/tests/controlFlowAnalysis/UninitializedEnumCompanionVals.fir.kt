// RUN_PIPELINE_TILL: FRONTEND
// SKIP_TXT

enum class A(val z: Any) {
    Y(<!UNINITIALIZED_ENUM_COMPANION!>x<!>);

    companion object {
        val x = A.Y.ordinal
    }
}

enum class B(val z: Any) {
    Y(<!UNINITIALIZED_ENUM_COMPANION!>B<!>.x);

    companion object {
        val x = B.Y.ordinal
    }
}

/* GENERATED_FIR_TAGS: companionObject, enumDeclaration, enumEntry, objectDeclaration, primaryConstructor,
propertyDeclaration */
