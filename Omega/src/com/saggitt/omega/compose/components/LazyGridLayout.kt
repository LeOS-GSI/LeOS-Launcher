package com.saggitt.omega.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

class LazyGridLayout(
    val minWidth: Dp,
    private val gapWidth: Dp,
    private val density: Density
) {
    private val _numColumns = mutableStateOf(0)
    val numColumns: State<Int> = _numColumns

    @Composable
    fun onSizeChanged() = Modifier.onSizeChanged {
        with(density) {
            val minWidth = minWidth.roundToPx()
            val gapWidth = gapWidth.roundToPx()
            val availableWidth = (it.width - minWidth).coerceAtLeast(0)
            val additionalCols = availableWidth / (minWidth + gapWidth)
            _numColumns.value = 1 + additionalCols
        }
    }
}