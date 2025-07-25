// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
class Item(val name: String, val rating: Int): Comparable<Item> {
    public override fun compareTo(other: Item): Int {
        return compareBy(this, other, { rating }, { name })
    }
}

// from standard library
fun <T : Any> compareBy(a: T?, b: T?,
                               vararg functions: T.() -> Comparable<*>?): Int = throw Exception()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, lambdaLiteral, nullableType, operator, override,
primaryConstructor, propertyDeclaration, starProjection, thisExpression, typeConstraint, typeParameter, vararg */
