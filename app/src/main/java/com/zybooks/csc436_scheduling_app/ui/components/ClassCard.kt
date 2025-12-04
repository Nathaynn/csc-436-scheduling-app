package com.zybooks.csc436_scheduling_app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zybooks.csc436_scheduling_app.data.model.SchoolClass
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ClassCard(
    schoolClass: SchoolClass,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = schoolClass.name,
                style = MaterialTheme.typography.titleMedium
            )

            schoolClass.location?.let {
                Text(
                    text = "Location: $it",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            // Format the time however you want
            val timeFormat = remember { SimpleDateFormat("h:mm a", Locale.getDefault()) }
            val start = timeFormat.format(schoolClass.startTime)
            val end = timeFormat.format(schoolClass.endTime)

            Text(
                text = "$start - $end",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Days: " + schoolClass.days.days.joinToString(", "),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}