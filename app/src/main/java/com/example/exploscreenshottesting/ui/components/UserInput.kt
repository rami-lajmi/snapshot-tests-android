package com.example.exploscreenshottesting.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exploscreenshottesting.ui.theme.ExploScreenShotTestingTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInput(
    label: String?,
    placeholder: String?,
    icon: ImageVector,
    modifier: Modifier = Modifier
        .padding(top = 10.dp, start = 5.dp, end = 20.dp),
    labelColor: Color = Color(0xFF192A56).copy(0.5f),
    iconColor: Color = Color(0xFF192A56).copy(0.5f),
    focusRequester: FocusRequester,
    textState: String,
    onValueChanged: (String) -> Unit,
    onClick: () -> Unit) {
        var isLastNameTextFieldFocused by remember { mutableStateOf(false) }
        val maxLength = 110
        TextField(
            value = textState,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(60.dp)
                .border(
                    border = BorderStroke(1.dp, Color(0xFFced6e0).copy(0.5f)),
                    shape = RoundedCornerShape(10.dp)
                )
                .focusRequester(focusRequester)
                .onFocusChanged { isLastNameTextFieldFocused = it.isFocused },
            placeholder = {
                Text(
                    text = placeholder ?: "N/A",
                    textAlign = TextAlign.Start,
                    color = Color.Gray.copy(0.6f)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = Color.Gray.copy(0.6f)
                )
            },
            onValueChange = {
                if (it.length <= maxLength)
                    onValueChanged(it)
            },
            singleLine = true,
            trailingIcon = {
                if (textState.isNotEmpty() && isLastNameTextFieldFocused) {
                    IconButton(onClick = { onValueChanged("") }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null,
                            tint = Color.Gray.copy(0.5f)
                        )
                    }
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFc7ecee).copy(0.4f),
                cursorColor = Color.Black,
                disabledLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
}

@Preview
@Composable
fun PreviewUserInput() {
    var textValue: String by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    ExploScreenShotTestingTheme {
        UserInput(
            label = "",
            placeholder = "Je cherche un appareil",
            icon = Icons.Default.Search,
            focusRequester = focusRequester,
            textState = textValue,
            onValueChanged = { newValue ->
                textValue = newValue
            },
            onClick = {}
        )
    }
}