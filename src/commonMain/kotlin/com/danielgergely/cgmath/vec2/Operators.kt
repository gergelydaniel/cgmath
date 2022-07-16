package com.danielgergely.cgmath.vec2

import kotlin.math.sqrt

public operator fun Vec2.times(f: Float): Vec2 = Vec2(x * f, y * f)

public operator fun Vec2.div(f: Float): Vec2 = times(1f / f)

public operator fun Vec2.plus(rhs: Vec2): Vec2 = Vec2(x + rhs.x, y + rhs.y)

public operator fun Vec2.minus(rhs: Vec2): Vec2 = Vec2(x - rhs.x, y - rhs.y)

public operator fun Vec2.unaryMinus(): Vec2 = Vec2(-x, -y)

public operator fun Vec2.timesAssign(f: Float) {
    this.x *= f
    this.y *= f
}

public operator fun Vec2.plusAssign(rhs: Vec2) {
    x += rhs.x
    y += rhs.y
}

public operator fun Vec2.minusAssign(rhs: Vec2) {
    x -= rhs.x
    y -= rhs.y
}

public infix fun Vec2.dot(rhs: Vec2): Float = x * rhs.x + y * rhs.y

public fun Vec2.normalize(): Vec2 = this / length

public val Vec2.length: Float
    get() = sqrt(x * x + y * y)

public operator fun Float.times(vec2: Vec2): Vec2 = Vec2(this * vec2.x, this * vec2.y)
