package com.example.exploscreenshottesting.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exploscreenshottesting.ui.theme.ExploScreenShotTestingTheme

@Composable
fun SimpleUserButton(
    label: String,
    icon: ImageVector,
    backgroundColor: Color = Color(0xFF192A56).copy(0.5f),
    labelColor: Color = Color(0xFF192A56).copy(0.5f),
    iconColor: Color = Color(0xFF192A56).copy(0.5f),
    onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(2.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(8.dp),
        onClick = { }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = label)
    }
}

@Preview
@Composable
fun PreviewSimpleUserButton() {
    ExploScreenShotTestingTheme {
        SimpleUserButton(
            label = "Ajouter",
            icon = Icons.Default.Add,
            backgroundColor = Color.Blue,
            labelColor = Color.White,
            iconColor = Color.White,
            onClick = {}
        )
    }
}