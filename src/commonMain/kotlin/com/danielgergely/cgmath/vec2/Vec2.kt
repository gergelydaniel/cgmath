package com.danielgergely.cgmath.vec2

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class Vec2 internal constructor(val array: FloatArray) {
    inline var x: Float
        get() = array[0]
        set(value) {
            array[0] = value
        }

    inline var y: Float
        get() = array[1]
        set(value) {
            array[1] = value
        }

    operator fun component1() = array[0]
    operator fun component2() = array[1]
}


fun Vec2(x: Float, y: Float): Vec2 = Vec2(floatArrayOf(x, y))

fun Vec2(other: Vec2): Vec2 = Vec2(other.array.copyOf())