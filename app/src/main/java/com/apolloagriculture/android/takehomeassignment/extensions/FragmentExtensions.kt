package com.apolloagriculture.android.takehomeassignment.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.apolloagriculture.android.takehomeassignment.R
import com.apolloagriculture.android.takehomeassignment.core.Event
import com.google.android.material.snackbar.Snackbar


fun Fragment.showSnackbar(text: String, duration: Int) {
    activity?.let {
        val snackbar = Snackbar.make(
            it.findViewById(R.id.container),
            text,
            duration
        )
        val view = snackbar.view
        view.setBackgroundColor(resources.getColor(R.color.snackbarColor))
        snackbar.show()
    }
}

fun Fragment.setupSnackbar(owner: LifecycleOwner, event: LiveData<Event<Int>>, duration: Int) {
    event.observe(owner, { e ->
        e.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackbar(it.getString(res), duration) }
        }
    })
}
