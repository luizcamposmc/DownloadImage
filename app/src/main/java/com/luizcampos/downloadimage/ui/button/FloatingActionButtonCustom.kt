package com.luizcampos.downloadimage.ui.button

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

enum class FabType {
    FAB,
    SQUARE_FAB,
    EXTENDED_FAB
}

class FloatingActionButtonCustom (
    private val onClick: () -> Unit,
    private val enable: Boolean = true
) {
    private var fabType = FabType.FAB
    private var fabText: String = ""

    fun fabType(fabType: FabType) : FloatingActionButtonCustom {
        this.fabType = fabType
        return this
    }

    fun fabText(fabText: String) : FloatingActionButtonCustom {
        this.fabText = fabText
        return this
    }

    @Composable
    fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            when (fabType) {
                FabType.FAB -> Fab (
                    onClick = onClick,
                    enable = enable
                )
                FabType.SQUARE_FAB -> SquareFab (
                    onClick = onClick,
                    enable = enable
                )
                FabType.EXTENDED_FAB -> ExtendedFab (
                    onClick = onClick,
                    text = fabText,
                    enable = enable
                )
            }
        }
    }
}

@Composable
fun Fab(onClick: () -> Unit, enable: Boolean) {
    FloatingActionButton(
        onClick = { if (enable) onClick() },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier.padding(20.dp),

    ) {
        IconAdd(enable = enable)
    } // FloatingActionButton
}

@Composable
fun SquareFab(onClick: () -> Unit, enable: Boolean) {
    FloatingActionButton(
        onClick = { if (enable) onClick() },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        shape = RectangleShape
    ) {
        IconAdd(enable = enable)
    } // FloatingActionButton
}

@Composable
fun ExtendedFab(onClick: () -> Unit, text: String, enable: Boolean) {
    ExtendedFloatingActionButton(
        text = { Text(text = text) },
        onClick = { if (enable) onClick() },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        icon = {
            IconAdd(enable = enable)
        } // icon
    ) // ExtendedFloatingActionButton
}

@Composable
fun IconAdd(enable: Boolean) {
    Icon(
        imageVector = Icons.Filled.Add,
        contentDescription = "",
        tint =
        if (enable)
            LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        else MaterialTheme.colors.primaryVariant
    )
}


