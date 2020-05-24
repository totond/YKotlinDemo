package com.yanzhikai.ykotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.contracts.ExperimentalContracts

class MainActivity : AppCompatActivity() {

    @ExperimentalContracts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TestScopeFunction.run()
    }
}
