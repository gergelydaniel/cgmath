package com.danielgergely.cgmath.vec4

import kotlin.jvm.JvmInline

@JvmInline
public value class Vec4 internal constructor(public val array: FloatArray) {
    public inline var x: Float
        get() = array[0]
        set(value) {
            array[0] = value
        }

    public inline var y: Float
        get() = array[1]
        set(value) {
            array[1] = value
        }

    public inline var z: Float
        get() = array[2]
        set(value) {
            array[2] = value
        }

    public inline var w: Float
        get() = array[3]
        set(value) {
            array[3] = value
        }

    public operator fun component1(): Float = array[0]
    public operator fun component2(): Float = array[1]
    public operator fun component3(): Float = array[2]
    public operator fun component4(): Float = array[3]
}

public fun Vec4(x: Float, y: Float, z: Float, w: Float): Vec4 = Vec4(floatArrayOf(x, y, z, w))

public fun Vec4(other: Vec4): Vec4 = Vec4(other.array.copyOf())
