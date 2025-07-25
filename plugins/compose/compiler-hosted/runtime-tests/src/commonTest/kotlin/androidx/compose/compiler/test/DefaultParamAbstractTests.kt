// K2_ONLY

/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.compiler.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mock.Text
import androidx.compose.runtime.mock.compositionTest
import androidx.compose.runtime.mock.validate
import kotlin.test.Test

class DefaultParamAbstractTests {
    @Test
    fun defaultParamInterfaceImpl() = compositionTest {
        val instance = DefaultParamAbstractInterfaceImpl()
        compose {
            instance.Content()
            instance.ComposedContent()
            instance.Content { Text("provided") }
        }

        validate {
            Text("default")
            Text("default")
            Text("provided")
        }
    }

    @Test
    fun defaultParamClsImpl() = compositionTest {
        val instance = DefaultParamAbstractImpl()
        compose {
            instance.Content()
            instance.ComposedContent()
            instance.Content { Text("provided") }
        }

        validate {
            Text("default")
            Text("default")
            Text("provided")
        }
    }

    @Test
    fun defaultParamReturn() = compositionTest {
        val instance = DefaultParamReturnImpl()
        compose {
            Text("${instance.value()}")
            Text("${instance.value(1)}")
        }

        validate {
            Text("0")
            Text("1")
        }
    }
}

private interface DefaultParamAbstractInterface {
    @Composable
    fun Content(
        content: @Composable () -> Unit = @Composable { ComposedContent() },
    )

    @Composable
    fun ComposedContent() {
        Text("default")
    }
}

private class DefaultParamAbstractInterfaceImpl : DefaultParamAbstractInterface {
    @Composable
    override fun Content(content: @Composable () -> Unit) {
        content()
    }
}

private abstract class DefaultParamAbstract {
    @Composable
    abstract fun Content(
        content: @Composable () -> Unit = @Composable { ComposedContent() },
    )

    @Composable
    fun ComposedContent() {
        Text("default")
    }
}

private class DefaultParamAbstractImpl : DefaultParamAbstract() {
    @Composable
    override fun Content(content: @Composable () -> Unit) {
        content()
    }
}

private abstract class DefaultParamReturn {
    @Composable
    abstract fun value(param: Int = 0): Int
}

private class DefaultParamReturnImpl : DefaultParamReturn() {
    @Composable
    override fun value(param: Int): Int {
        return param
    }
}
