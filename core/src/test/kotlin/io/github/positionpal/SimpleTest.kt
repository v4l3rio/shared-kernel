package io.github.positionpal

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SimpleTest : FunSpec({

    test("A trivial test that should pass") {
        true shouldBe true
    }
})
