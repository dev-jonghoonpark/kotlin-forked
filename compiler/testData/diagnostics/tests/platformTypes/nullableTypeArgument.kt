// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
import java.util.ArrayList

fun foo() {
    val list = ArrayList<String?>()

    for (s in list) {
        s<!UNSAFE_CALL!>.<!>length
    }
}

/* GENERATED_FIR_TAGS: flexibleType, forLoop, functionDeclaration, javaFunction, localProperty, nullableType,
propertyDeclaration */
