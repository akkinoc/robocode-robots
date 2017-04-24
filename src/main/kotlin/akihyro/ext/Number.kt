package akihyro.ext

import robocode.util.Utils.isNear

/**
 * 近似かどうか比較する。
 *
 * @receiver 数値。
 * @param other 比較する数値。
 * @return 近似かどうか。
 */
infix fun Number.nears(other: Number) = isNear(this.toDouble(), other.toDouble())
