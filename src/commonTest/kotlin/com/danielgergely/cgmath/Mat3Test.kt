package com.danielgergely.cgmath

import com.danielgergely.cgmath.mat3.Mat3
import com.danielgergely.cgmath.mat3.times
import com.danielgergely.cgmath.mat3.timesAssign
import com.danielgergely.cgmath.vec2.Vec2
import com.danielgergely.cgmath.vec3.Vec3
import kotlin.test.Test
import kotlin.test.assertTrue

class Mat3Test {
    @Test
    fun mat3Multiply() {
        val m1 = Mat3.from(
            floatArrayOf(
                1f, 2f, 3f,
                4f, 5f, 6f,
                7f, 8f, 9f
            )
        )

        val m2 = Mat3.from(
            floatArrayOf(
                10f, 20f, 30f,
                40f, 50f, 60f,
                70f, 80f, 90f
            )
        )

        val expected = Mat3.from(
            floatArrayOf(
                300f, 360f, 420f,
                660f, 810f, 960f,
                1020f, 1260f, 1500f
            )
        )

        val result = m1 * m2

        assertTrue { result closeTo expected }
    }

    @Test
    fun mat3SelfMultiply() {
        val m1 = Mat3.from(
            floatArrayOf(
                1f, 2f, 3f,
                4f, 5f, 6f,
                7f, 8f, 9f
            )
        )

        val m2 = Mat3.from(
            floatArrayOf(
                10f, 20f, 30f,
                40f, 50f, 60f,
                70f, 80f, 90f
            )
        )

        val expected = Mat3.from(
            floatArrayOf(
                300f, 360f, 420f,
                660f, 810f, 960f,
                1020f, 1260f, 1500f
            )
        )

        m1.timesAssign(m2)

        assertTrue { m1 closeTo expected }
    }

    @Test
    fun mat3TimesVec3() {
        val m = Mat3.from(
            floatArrayOf(
                0f, 3f, 6f,
                1f, 4f, 7f,
                2f, 5f, 8f
            )
        )

        val v = Vec3(11f, 13f, 17f)

        val result = m * v

        val expected = Vec3(47f, 170f,293f )

        assertTrue { result closeTo expected }
    }


    @Test
    fun mat3TimesVec2() {
        val m = Mat3.from(
            floatArrayOf(
                0f, 3f, 6f,
                1f, 4f, 7f,
                2f, 5f, 8f
            )
        )

        val v = Vec2(11f, 13f)

        val result = m * v

        val expected = Vec2(15f, 90f)

        assertTrue { result closeTo expected }
    }
}