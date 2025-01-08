package com.example.travelapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelapp.ui.theme.BackgroundGray
import com.example.travelapp.ui.theme.IconGray
import com.example.travelapp.ui.theme.PrimaryPurple
import com.example.travelapp.ui.theme.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var selectedScreen by remember { mutableStateOf("home") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = BackgroundGray,
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                colors = TopAppBarColors(
                    containerColor = BackgroundGray,
                    scrolledContainerColor = BackgroundGray,
                    navigationIconContentColor = Color.Transparent,
                    actionIconContentColor = Color.Transparent,
                    titleContentColor = Color.Black
                ),
                title = {},
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.menu),
                        contentDescription = "menu",
                        tint = PrimaryPurple,
                        modifier = Modifier.size(36.dp)
                    )
                },
                actions = {
                    Image(
                        painterResource(R.drawable.pfp),
                        contentDescription = null,
                        modifier = Modifier.size(46.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                contentColor = IconGray
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { selectedScreen = "home" },
                        colors = IconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = if (selectedScreen == "home") Color.White else IconGray,
                            disabledContentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                            .background(if (selectedScreen == "home") PrimaryPurple else Color.Transparent)
                    ) {
                        Icon(painterResource(R.drawable.home), contentDescription = "home")
                    }

                    IconButton(
                        onClick = { selectedScreen = "briefcase" },
                        colors = IconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = if (selectedScreen == "briefcase") Color.White else IconGray,
                            disabledContentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                            .background(if (selectedScreen == "briefcase") PrimaryPurple else Color.Transparent)
                    ) {
                        Icon(painterResource(R.drawable.briefcase), contentDescription = null)
                    }

                    IconButton(
                        onClick = { selectedScreen = "bookmark" },
                        colors = IconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = if (selectedScreen == "bookmark") Color.White else IconGray,
                            disabledContentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                            .background(if (selectedScreen == "bookmark") PrimaryPurple else Color.Transparent)
                    ) {
                        Icon(painterResource(R.drawable.bookmark), contentDescription = null)
                    }

                    IconButton(
                        onClick = { selectedScreen = "user" },
                        colors = IconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = if (selectedScreen == "user") Color.White else IconGray,
                            disabledContentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                            .background(if (selectedScreen == "user") PrimaryPurple else Color.Transparent)
                    ) {
                        Icon(painterResource(R.drawable.user), contentDescription = null)
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            HomeScreen()
        }
    }
}

@Preview
@Composable
fun test() {
    App()
}