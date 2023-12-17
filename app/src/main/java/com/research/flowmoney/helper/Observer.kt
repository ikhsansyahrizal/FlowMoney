package com.research.flowmoney.helper

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Observer: DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("learn lifecycle", "onCreate: CObserver ")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("learn lifecycle","onStart: SObserver")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("learn lifecycle", "onPause: PObserver")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("learn lifecycle", "onResume: RObserver")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("learn lifecycle", "onStop: STObserver")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("learn lifecycle", "onDestroy: DObserver")
    }
}