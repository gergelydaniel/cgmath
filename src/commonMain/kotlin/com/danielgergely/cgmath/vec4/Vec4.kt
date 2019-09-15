package com.danielgergely.cgmath.vec4

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class Vec4 internal constructor(val array: FloatArray) {
    inline var x: Float
        get() = array[0]
        set(value) { array[0] = value }

    inline var y: Float
        get() = array[1]
        set(value) { array[1] = value }

    inline var z: Float
        get() = array[2]
        set(value) { array[2] = value }

    inline var w: Float
        get() = array[3]
        set(value) { array[3] = value }

    operator fun component1() = array[0]
    operator fun component2() = array[1]
    operator fun component3() = array[2]
    operator fun component4() = array[3]
}

fun Vec4(x: Float, y: Float, z: Float, w: Float): Vec4 = Vec4(floatArrayOf(x, y, z, w))

fun Vec4(other: Vec4): Vec4 = Vec4(other.array.copyOf())