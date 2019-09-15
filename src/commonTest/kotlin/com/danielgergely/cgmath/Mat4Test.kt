package com.danielgergely.cgmath

import com.danielgergely.cgmath.mat4.Mat4
import com.danielgergely.cgmath.mat4.plus
import com.danielgergely.cgmath.mat4.times
import com.danielgergely.cgmath.mat4.timesAssign
import com.danielgergely.cgmath.vec3.Vec3
import com.danielgergely.cgmath.vec4.Vec4
import kotlin.test.Test
import kotlin.test.assertTrue

class Mat4Test {
    @Test
    fun mat4SelfMultiply() {
        // from https://ncalculators.com/matrix/4x4-matrix-multiplication-calculator.htm

        val m1 = Mat4.from(
            floatArrayOf(
                5f, 7f, 9f, 10f,
                2f, 3f, 3f, 8f,
                8f, 10f, 2f, 3f,
                3f, 3f, 4f, 8f
            )
        )

        val m2 = Mat4.from(
            floatArrayOf(
                3f, 10f, 12f, 18f,
                12f, 1f, 4f, 9f,
                9f, 10f, 12f, 2f,
                3f, 12f, 4f, 10f
            )
        )

        val expected = Mat4.from(
            floatArrayOf(
                210f, 267f, 236f, 271f,
                93f, 149f, 104f, 149f,
                171f, 146f, 172f, 268f,
                105f, 169f, 128f, 169f
            )
        )

        m1.timesAssign(m2)

        assertTrue { m1 closeTo expected }
    }

    @Test
    fun mat4Multiply() {
        // from https://ncalculators.com/matrix/4x4-matrix-multiplication-calculator.htm

        val m1 = Mat4.from(
            floatArrayOf(
                5f, 7f, 9f, 10f,
                2f, 3f, 3f, 8f,
                8f, 10f, 2f, 3f,
                3f, 3f, 4f, 8f
            )
        )

        val m2 = Mat4.from(
            floatArrayOf(
                3f, 10f, 12f, 18f,
                12f, 1f, 4f, 9f,
                9f, 10f, 12f, 2f,
                3f, 12f, 4f, 10f
            )
        )

        val expected = Mat4.from(
            floatArrayOf(
                210f, 267f, 236f, 271f,
                93f, 149f, 104f, 149f,
                171f, 146f, 172f, 268f,
                105f, 169f, 128f, 169f
            )
        )

        val result = m1 * m2

        assertTrue { result closeTo expected }
    }


    @Test
    fun mat4Sum() {
        val m1 = Mat4.from(
            floatArrayOf(
                1f, 2f, 3f, 4f,
                5f, 6f, 7f, 8f,
                9f, 10f, 11f, 12f,
                13f, 14f, 15f, 16f
            )
        )

        val m2 = Mat4.from(
            floatArrayOf(
                10f, 20f, 30f, 40f,
                50f, 60f, 70f, 80f,
                90f, 100f, 110f, 120f,
                130f, 140f, 150f, 160f
            )
        )

        val expected = Mat4.from(
            floatArrayOf(
                11f, 22f, 33f, 44f,
                55f, 66f, 77f, 88f,
                99f, 110f, 121f, 132f,
                143f, 154f, 165f, 176f
            )
        )

        val result = m1 + m2

        assertTrue { result closeTo expected }
    }

    @Test
    fun mat4TimesVec3() {
        val mat4 = Mat4.from(
            floatArrayOf(
                1f, 2f, 3f, 4f,
                5f, 6f, 7f, 8f,
                9f, 10f, 11f, 12f,
                13f, 14f, 15f, 16f
            )
        )

        val vec3 = Vec3(10f, 20f, 30f)

        val expected = Vec3(393f, 454f, 515f)

        val result = mat4 * vec3

        assertTrue { result closeTo expected }
    }

    @Test
    fun mat4TimesVec4() {
        val mat4 = Mat4.from(
            floatArrayOf(
                1f, 20f, 3f, 4f,
                5f, 6f, -5f, 8f,
                0f, 10f, 11f, 12f,
                13f, 14f, 15f, 29f
            )
        )

        val v = Vec4(11f, 13f, 17f, 19f)

        val expected = Vec4(323f, 734f, 440f, 903f)

        val result = mat4 * v

        assertTrue { result closeTo expected }
    }
}