package com.heinhtetoo.getgo.extensions

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.heinhtetoo.getgo.utils.OnSnapPositionChangeListener
import com.heinhtetoo.getgo.utils.SnapOnScrollListener

fun RecyclerView.attachSnapHelperWithListener(
    snapHelper: SnapHelper,
    behavior: SnapOnScrollListener.Behavior = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL,
    onSnapPositionChangeListener: OnSnapPositionChangeListener
) {
    if (this.onFlingListener == null) {
        snapHelper.attachToRecyclerView(this)
    }
    val snapOnScrollListener =
        SnapOnScrollListener(snapHelper, onSnapPositionChangeListener, behavior)
    addOnScrollListener(snapOnScrollListener)
}