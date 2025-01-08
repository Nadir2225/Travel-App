package com.example.travelapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.ui.theme.StrokeGray
import com.example.travelapp.ui.theme.TextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Good Morning, Shreya....",
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Make plan for weekend",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your name") },
            placeholder = { Text("Name") },
            modifier = Modifier.padding(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedPlaceholderColor = TextGray,
                unfocusedPlaceholderColor = TextGray,
                focusedLabelColor = TextGray,
                unfocusedLabelColor = TextGray,
                focusedTextColor = Color.Black,
                focusedBorderColor = StrokeGray,
                unfocusedBorderColor = StrokeGray
            )
        )
    }
}

@Preview()
@Composable
fun HomeTest() {
    HomeScreen()
}