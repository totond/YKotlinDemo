package com.yanzhikai.ykotlindemo

import android.util.Log
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * author: jacketyan
 * date: 2020/5/11
 */
object TestScopeFunction {

    const val TAG = "jky"

    fun run() {
        logCostTime {
            val a = 1 + 1
            print(a)
        }

        val aTime = System.nanoTime()
        val b = 1 + 1
        print(b)
        Log.i(TAG, "costTime: ${System.nanoTime() - aTime}")


        testTakeIf().divider()
        testWithoutTakeIf().divider()
        testTakeUnless().divider()
        testRun().divider()
        testLet().divider()
        testApply().divider()
        testAlso().divider()
        testWith().divider()
    }

    fun testRun() {
        val result = "yan".run {
            "strLen = ${length + 100}"
        }
        Log.i(TAG, "testRun: $result")
    }

    fun testLet() {
        val result = "yan".let {
            "strLen = ${it.length + 100}"
        }
        Log.i(TAG, "testLet: $result")
    }

    fun testApply() {
        val result = "yan".apply {
            "strLen = ${length + 100}"
        }
        Log.i(TAG, "testApply: $result")
    }

    fun testAlso() {
        val result = "yan".also {
            "strLen = ${it.length + 100}"
        }
        Log.i(TAG, "testAlso: $result")
    }

    fun testWith() {
        val result = with("yan") {
            "strLen = ${length + 100}"
        }
        Log.i(TAG, "testWith: $result")
    }

    fun testTakeIf() {
        val name = "yanzhikai"
        name.indexOf("yan")
//            .let {
//                Log.i(TAG, "testTakeIf: it = $it")
//                if (it >= 0) {
//                    Log.i(TAG, "testTakeIf: has yan")
//                } else {
//                    Log.i(TAG, "testTakeIf: no yan")
//                }
//            }
            .takeIf {
                Log.i(TAG, "testTakeIf: it = $it")
                it >= 0
            }
            ?.let {
                Log.i(TAG, "testTakeIf: has yan")
            }/*?: Log.i(TAG, "testTakeIf: no yan")*/
        Log.i(TAG, "testTakeIf: $name")
    }

    fun testWithoutTakeIf() {
        val name = "yanzhikai"
        val hasYan = name.indexOf("yan")
        Log.i(TAG, "testWithoutTakeIf: hasYan = $hasYan")
        if (hasYan >= 0) {
            Log.i(TAG, "testWithoutTakeIf: has yan")
        }
        Log.i(TAG, "testWithoutTakeIf: $name")
    }

    fun testTakeUnless() {
        val name = "yanzhikai"
        name.indexOf("yan")
            .takeUnless {
                Log.i(TAG, "testTakeUnless: it = $it")
                it < 0
            }
            ?.let {
                Log.i(TAG, "testTakeUnless: has yan")
            }
        Log.i(TAG, "testTakeUnless: $name")
    }

    fun testLogCost() {
        logCostTime {
            val a = 2 + 3
        }
    }


    private fun Unit.divider() {
        Log.i(TAG, "--------------------------------------------------------------")
        kotlin.run { }
    }

    public inline fun <R> logCostTime(noinline receiver: () -> R): R {
        val aTime = System.nanoTime()
        val result = receiver.invoke()
        Log.i(TAG, "costTime: ${System.nanoTime() - aTime}")
        return result
    }
}