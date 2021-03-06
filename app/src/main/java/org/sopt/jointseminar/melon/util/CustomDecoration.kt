package org.sopt.jointseminar.melon.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        if (pos == 0) outRect.left = 20
        outRect.right = 10
    }
}
