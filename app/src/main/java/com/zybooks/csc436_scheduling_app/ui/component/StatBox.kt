package com.zybooks.csc436_scheduling_app.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatBox(
    title: String,
    count: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFF7F7F7), RoundedCornerShape(16.dp))
            .padding(vertical = 12.dp, horizontal = 20.dp)
    ) {
        Text(
            text = count.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}
