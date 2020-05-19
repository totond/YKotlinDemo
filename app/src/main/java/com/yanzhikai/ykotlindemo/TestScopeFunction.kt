package com.yanzhikai.ykotlindemo

import android.util.Log

/**
 * author: jacketyan
 * date: 2020/5/11
 */
object TestScopeFunction {

    const val TAG = "jky"

    fun run(){
        testTakeIf().divider()
        testWithoutTakeIf().divider()
        testTakeUnless().divider()
        testRun().divider()
        testLet().divider()
        testApply().divider()
        testAlso().divider()
    }

    fun testRun() {
        val result = "yan".run {
            "strLen = ${length + 100}"
        }
        Log.i(TAG, "testLet: $result")
    }

    fun testLet() {
        val result = "yan".let {
            "strLen = ${it.length + 100}"
        }
        Log.i(TAG, "testLet: $result")
    }

    fun testApply() {
        val result = "yan".apply {
            Log.i(TAG, "testApply: length = ${length + 100}")
        }
        Log.i(TAG, "testApply: $result")
    }

    fun testAlso() {
        val result = "yan".also {
            Log.i(TAG, "testApply: length = ${it.length + 100}")
        }
        Log.i(TAG, "testAlso: $result")
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


    private fun Unit.divider() {
        Log.i(TAG, "--------------------------------------------------------------")
    }
}