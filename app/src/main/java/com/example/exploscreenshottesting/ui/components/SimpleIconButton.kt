package com.example.exploscreenshottesting.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exploscreenshottesting.ui.theme.ExploScreenShotTestingTheme


@Composable
fun SimpleIconButton(
    icon: ImageVector
){
    IconButton(
        onClick = {},
        modifier = Modifier
            .padding(4.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(10.dp)
            )

    ) {
        Icon(imageVector = icon, tint = MaterialTheme.colorScheme.onPrimary, contentDescription = "")
    }
}


@Preview
@Composable
fun PreviewSimpleIconButton() {
    ExploScreenShotTestingTheme {
        SimpleIconButton(
            icon = Icons.Default.Add
        )
    }
}