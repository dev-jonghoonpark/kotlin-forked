// RUN_PIPELINE_TILL: FRONTEND
// RENDER_DIAGNOSTICS_FULL_TEXT

fun foo(x: Int) {}

fun n() {
    foo(<!TYPE_MISMATCH!>{ a: String -> 42 }<!>)
}

/* GENERATED_FIR_TAGS: functionDeclaration, integerLiteral, lambdaLiteral */
