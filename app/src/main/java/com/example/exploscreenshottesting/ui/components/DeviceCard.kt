package com.example.exploscreenshottesting.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exploscreenshottesting.Models.DeviceDataItem
import com.example.exploscreenshottesting.R
import com.example.exploscreenshottesting.ui.theme.ExploScreenShotTestingTheme

@Composable
fun DeviceCard(device: DeviceDataItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(14.dp)) {
            Image(
                painter = painterResource(id = device.image),
                modifier = Modifier
                    .size(100.dp),
                contentDescription = "Device image"
            )
            Column(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(top = 6.dp)
            ) {
                Text(
                    text = device.name,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    ),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Version OS : ${device.osVersion}",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 12.sp
                    ),
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = device.releaseYear,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 12.sp
                    ),
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            IconButton(
                onClick = {},
                modifier = Modifier.background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp)
                )
            ) {
                Icon(imageVector = Icons.Default.Add, tint = MaterialTheme.colorScheme.onPrimary, contentDescription = "")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp)
            .padding(vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SimpleUserButton(
                label = "Activer",
                icon = Icons.Default.Check,
                backgroundColor = Color.Blue.copy(0.4f),
                labelColor = Color.White,
                iconColor = Color.White,
                onClick = {}
            )
            SimpleUserButton(
                label = "Localiser",
                icon = Icons.Default.LocationOn,
                backgroundColor = Color.Blue.copy(0.7f),
                labelColor = Color.White,
                iconColor = Color.White,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    ExploScreenShotTestingTheme {
        Column {
            DeviceCard(DeviceDataItem("Iphone 15 Pro", "17", "2023", R.drawable.iphone_15_pro))
        }
    }
}