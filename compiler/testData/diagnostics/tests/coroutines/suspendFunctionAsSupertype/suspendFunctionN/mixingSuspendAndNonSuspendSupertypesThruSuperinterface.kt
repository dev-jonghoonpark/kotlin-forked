// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +SuspendFunctionAsSupertype
// SKIP_TXT
// DIAGNOSTICS: -CONFLICTING_INHERITED_MEMBERS, -CONFLICTING_OVERLOADS, -ABSTRACT_MEMBER_NOT_IMPLEMENTED, -FUN_INTERFACE_WRONG_COUNT_OF_ABSTRACT_MEMBERS

import kotlin.coroutines.*

interface ISuper: () -> Unit

class C: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SuspendFunction0<Unit>, ISuper<!> {
    override suspend fun invoke() {
    }
}

fun interface FI: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SuspendFunction0<Unit>, ISuper<!> {
}

interface I: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SuspendFunction0<Unit>, ISuper<!> {
}

object O: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SuspendFunction0<Unit>, ISuper<!> {
    override suspend fun invoke() {
    }
}

interface SISuper: SuspendFunction0<Unit>

class C1: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, () -> Unit<!> {
    override suspend fun invoke() {
    }
}

fun interface FI1: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, () -> Unit<!> {
}

interface I1: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, () -> Unit<!> {
}

object O1: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, () -> Unit<!> {
    override suspend fun invoke() {
    }
}

class C2: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, ISuper<!> {
    override suspend fun invoke() {
    }
}

fun interface FI2: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, ISuper<!> {
}

interface I2: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, ISuper<!> {
}

object O2: <!MIXING_SUSPEND_AND_NON_SUSPEND_SUPERTYPES!>SISuper, ISuper<!> {
    override suspend fun invoke() {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funInterface, functionDeclaration, functionalType, interfaceDeclaration,
objectDeclaration, operator, override, suspend */
