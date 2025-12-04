package com.zybooks.csc436_scheduling_app.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.zybooks.csc436_scheduling_app.data.model.SchoolClass
import com.zybooks.csc436_scheduling_app.navigation.AppScreen
import com.zybooks.csc436_scheduling_app.ui.components.ClassCard
import com.zybooks.csc436_scheduling_app.ui.viewmodel.HomeScreenViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Home(vm: HomeScreenViewModel) {

    var classes by remember {
        mutableStateOf<List<SchoolClass>>(emptyList())
    }

    LaunchedEffect(Unit) {
        classes = vm.classesToday()
    }

    println("CLASSES HERE $classes")

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            AppScreen.HOME.title,
            textAlign = TextAlign.Center,
            fontSize = 80.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        )

        LazyColumn {
            items(classes) { sc ->
                ClassCard(schoolClass = sc)
            }
        }
    }
}