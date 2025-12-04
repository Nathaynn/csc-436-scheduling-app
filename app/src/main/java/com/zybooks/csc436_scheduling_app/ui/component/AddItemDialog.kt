package com.zybooks.csc436_scheduling_app.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AddItemDialog(
    title: String,
    onDismiss: () -> Unit,
    onSubmit: (
        name: String,
        location: String,
        startDate: String,
        endDate: String,
        startTime: String,
        endTime: String,
        days: List<String>
    ) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }

    val dayNames = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val selectedDays = remember { mutableStateListOf<String>() }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {

                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
                OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") })
                OutlinedTextField(value = startDate, onValueChange = { startDate = it }, label = { Text("Start Date") })
                OutlinedTextField(value = endDate, onValueChange = { endDate = it }, label = { Text("End Date") })
                OutlinedTextField(value = startTime, onValueChange = { startTime = it }, label = { Text("Start Time") })
                OutlinedTextField(value = endTime, onValueChange = { endTime = it }, label = { Text("End Time") })

                Text("Days", style = MaterialTheme.typography.labelLarge)

                // ⭐ FIX: WRAPS DAYS CORRECTLY ⭐
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    dayNames.forEach { day ->
                        AssistChip(
                            onClick = {
                                if (selectedDays.contains(day)) selectedDays.remove(day)
                                else selectedDays.add(day)
                            },
                            label = { Text(day) },
                            shape = RoundedCornerShape(8.dp),
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = if (selectedDays.contains(day))
                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                                else
                                    MaterialTheme.colorScheme.surfaceVariant
                            )
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                onSubmit(name, location, startDate, endDate, startTime, endTime, selectedDays)
                onDismiss()
            }) {
                Text("Add")
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) { Text("Cancel") }
        }
    )
}
