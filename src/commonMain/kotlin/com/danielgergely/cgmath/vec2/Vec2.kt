package com.danielgergely.cgmath.vec2

import kotlin.jvm.JvmInline

@JvmInline
public value class Vec2 internal constructor(public val array: FloatArray) {
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

    public operator fun component1(): Float = array[0]
    public operator fun component2(): Float = array[1]
}


public fun Vec2(x: Float, y: Float): Vec2 = Vec2(floatArrayOf(x, y))

public fun Vec2(other: Vec2): Vec2 = Vec2(other.array.copyOf())
