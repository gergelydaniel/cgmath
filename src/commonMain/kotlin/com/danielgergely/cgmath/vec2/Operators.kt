package com.danielgergely.cgmath.vec2

import kotlin.math.sqrt

operator fun Vec2.times(f: Float) = Vec2(x * f, y * f)

operator fun Vec2.div(f: Float) = times(1f / f)

operator fun Vec2.plus(rhs: Vec2): Vec2 = Vec2(x + rhs.x, y + rhs.y)

operator fun Vec2.minus(rhs: Vec2): Vec2 = Vec2(x - rhs.x, y - rhs.y)

operator fun Vec2.unaryMinus(): Vec2 = Vec2(-x, -y)

operator fun Vec2.timesAssign(f: Float) {
    this.x *= f
    this.y *= f
}

operator fun Vec2.plusAssign(rhs: Vec2) {
    x += rhs.x
    y += rhs.y
}

operator fun Vec2.minusAssign(rhs: Vec2) {
    x -= rhs.x
    y -= rhs.y
}

infix fun Vec2.dot(rhs: Vec2) = x * rhs.x + y * rhs.y

fun Vec2.normalize() = this / length

val Vec2.length: Float
    get() = sqrt(x * x + y * y)

operator fun Float.times(vec2: Vec2) = Vec2(this * vec2.x, this * vec2.y)