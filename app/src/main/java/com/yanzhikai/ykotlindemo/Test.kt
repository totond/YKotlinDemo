package com.yanzhikai.ykotlindemo

import android.util.Log
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@ExperimentalContracts
public inline fun <R> logCostTime(receiver: () -> R): R {
    contract {
        callsInPlace(receiver, InvocationKind.EXACTLY_ONCE)
    }
    val aTime = System.nanoTime()
    val result = receiver.invoke()
    Log.i("jky", "costTime: ${(System.nanoTime() - aTime) / 1000}")

    return result
}