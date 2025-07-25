// RUN_PIPELINE_TILL: FRONTEND
// SKIP_JAVAC
// LANGUAGE: -ProhibitUsingNullableTypeParameterAgainstNotNullAnnotated -PreciseSimplificationToFlexibleLowerConstraint
// RENDER_DIAGNOSTICS_FULL_TEXT
// FILE: SLRUMap.java

import org.jetbrains.annotations.NotNull;
import java.util.List;

public interface SLRUMap<V> {
    void takeV(@NotNull V value);
    <E> void takeE(@NotNull E value);

    void takeVList(@NotNull List<@NotNull V> value);
    <E> void takeEList(@NotNull List<@NotNull E> value);

    public <K> K id(K value) { return null; }
}

// FILE: main.kt

fun <V> SLRUMap<V>.getOrPut(value: V, l: List<V>) {
    takeV(<!NULLABLE_TYPE_PARAMETER_AGAINST_NOT_NULL_TYPE_PARAMETER!>value<!>)
    takeVList(<!NULLABLE_TYPE_PARAMETER_AGAINST_NOT_NULL_TYPE_PARAMETER!>l<!>)

    takeE(<!NULLABLE_TYPE_PARAMETER_AGAINST_NOT_NULL_TYPE_PARAMETER!>value<!>)
    takeEList(<!NULLABLE_TYPE_PARAMETER_AGAINST_NOT_NULL_TYPE_PARAMETER!>l<!>)
    takeE(<!NULLABLE_TYPE_PARAMETER_AGAINST_NOT_NULL_TYPE_PARAMETER!>id(value)<!>)

    if (value != null) {
        takeV(value)
        takeE(value)
        takeE(id(value))
    }
}

fun <V : Any> SLRUMap<V>.getOrPutNN(value: V, l: List<V>) {
    takeV(value)
    takeVList(l)

    takeE(value)
    takeEList(l)
    takeE(id(value))
}

/* GENERATED_FIR_TAGS: dnnType, equalityExpression, flexibleType, funWithExtensionReceiver, functionDeclaration,
ifExpression, javaType, nullableType, smartcast, typeConstraint, typeParameter */
