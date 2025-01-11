package com.example.travelapp.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.models.Transport
import com.example.travelapp.ui.theme.BackgroundGray
import com.example.travelapp.ui.theme.DividerGray
import com.example.travelapp.ui.theme.IconGray
import com.example.travelapp.ui.theme.PrimaryPurple
import com.example.travelapp.ui.theme.StrokeGray
import com.example.travelapp.ui.theme.TextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val columnScrollState = rememberScrollState()
    val transportsScrollState = rememberScrollState()
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    var adults by remember { mutableStateOf(0) }
    var childs by remember { mutableStateOf(0) }
    val transports = listOf(
        Transport("Palaces", R.drawable.palace, "palaces"),
        Transport("Flights", R.drawable.plane, "flights"),
        Transport("Trains", R.drawable.train, "trains"),
        Transport("Buses", R.drawable.bus, "buses"),
        Transport("Taxis", R.drawable.taxi, "taxis")
    )
    var selectedItem by remember { mutableStateOf(transports[0].thisItem) }
    var selectedFlightType by remember { mutableStateOf("one") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(columnScrollState)
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                modifier = Modifier.height(50.dp),
                shape = RoundedCornerShape(8.dp),
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Name") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "Search Icon",
                        tint = TextGray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedPlaceholderColor = TextGray,
                    unfocusedPlaceholderColor = TextGray,
                    focusedLabelColor = TextGray,
                    unfocusedLabelColor = TextGray,
                    focusedTextColor = Color.Black,
                    focusedBorderColor = StrokeGray,
                    unfocusedBorderColor = StrokeGray
                )
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = PrimaryPurple,
                    contentColor = Color.White,
                ),
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(PrimaryPurple)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(painterResource(R.drawable.settings), contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .horizontalScroll(transportsScrollState)
        ) {
            transports.forEach {
                TransportComponent(
                    name = it.name,
                    icon = it.icon,
                    thisItem = it.thisItem,
                    selectedItem = selectedItem
                ) {
                    selectedItem = it.thisItem
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Book your Flight", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 19.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                        .background(if (selectedFlightType == "one") PrimaryPurple else BackgroundGray)
                        .height(36.dp)
                        .weight(1f)
                        .clickable {
                            selectedFlightType = "one"
                        }
                ) {
                    Text("One Ways", color = if (selectedFlightType == "one") Color.White else TextGray, modifier = Modifier.align(Alignment.Center))
                }
                Box(
                    modifier = Modifier
                        .background(if (selectedFlightType == "round") PrimaryPurple else BackgroundGray)
                        .height(36.dp)
                        .weight(1f)
                        .clickable {
                            selectedFlightType = "round"
                        }
                ) {
                    Text("Round Trip", color = if (selectedFlightType == "round") Color.White else TextGray, modifier = Modifier.align(Alignment.Center))
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                        .background(if (selectedFlightType == "multicity") PrimaryPurple else BackgroundGray)
                        .height(36.dp)
                        .weight(1f)
                        .clickable {
                            selectedFlightType = "multicity"
                        }
                ) {
                    Text("Multicity", color = if (selectedFlightType == "multicity") Color.White else TextGray, modifier = Modifier.align(Alignment.Center))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "From", color = Color.Black, modifier = Modifier
                .padding(horizontal = 17.dp)
                .fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.height(50.dp),
                shape = RoundedCornerShape(8.dp),
                value = text2,
                onValueChange = { text2 = it },
                placeholder = { Text("Choose Depature from") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = BackgroundGray,
                    focusedPlaceholderColor = TextGray,
                    unfocusedPlaceholderColor = TextGray,
                    focusedLabelColor = TextGray,
                    unfocusedLabelColor = TextGray,
                    focusedTextColor = Color.Black,
                    focusedBorderColor = StrokeGray,
                    unfocusedBorderColor = StrokeGray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = PrimaryPurple,
                    contentColor = Color.White,
                ),
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(painterResource(R.drawable.updown_arrow), contentDescription = null)
            }
            Text(text = "To", color = Color.Black, modifier = Modifier
                .padding(horizontal = 17.dp)
                .fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.height(50.dp),
                shape = RoundedCornerShape(8.dp),
                value = text3,
                onValueChange = { text3 = it },
                placeholder = { Text("Choose Arrival at") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = BackgroundGray,
                    focusedPlaceholderColor = TextGray,
                    unfocusedPlaceholderColor = TextGray,
                    focusedLabelColor = TextGray,
                    unfocusedLabelColor = TextGray,
                    focusedTextColor = Color.Black,
                    focusedBorderColor = StrokeGray,
                    unfocusedBorderColor = StrokeGray
                )
            )
            HorizontalDivider(color = DividerGray, thickness = 1.dp, modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth())
            Text(text = "Depature Date", color = Color.Black, modifier = Modifier
                .padding(horizontal = 17.dp)
                .fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    value = text4,
                    onValueChange = { text4 = it },
                    placeholder = { Text("Choose your Date") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = BackgroundGray,
                        focusedPlaceholderColor = TextGray,
                        unfocusedPlaceholderColor = TextGray,
                        focusedLabelColor = TextGray,
                        unfocusedLabelColor = TextGray,
                        focusedTextColor = Color.Black,
                        focusedBorderColor = StrokeGray,
                        unfocusedBorderColor = StrokeGray
                    )
                )
                Spacer(modifier = Modifier.width(25.dp))
                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = PrimaryPurple,
                        contentColor = Color.White,
                    ),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(PrimaryPurple)
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(painterResource(R.drawable.date), contentDescription = null)
                }
            }
            HorizontalDivider(color = DividerGray, thickness = 1.dp, modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
               Column(
                   horizontalAlignment = Alignment.Start
               ) {
                   Text(text = "Adult (12+)", color = Color.Black)
                   Spacer(modifier = Modifier.height(10.dp))
                   Row(
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       IconButton(
                           onClick = {
                               if (adults > 0) {
                                   adults--
                               }
                           },
                           colors = IconButtonDefaults.iconButtonColors(
                               containerColor = DividerGray,
                               contentColor = Color.Black,
                           ),
                           modifier = Modifier
                               .clip(RoundedCornerShape(8.dp))
                               .background(DividerGray)
                               .height(28.dp)
                               .width(28.dp)
                               .align(Alignment.CenterVertically)
                       ) {
                           Icon(painterResource(R.drawable.minus), contentDescription = null)
                       }
                       Spacer(modifier = Modifier.width(15.dp))
                       Card(
                           border = BorderStroke(1.dp, StrokeGray),
                           shape = RoundedCornerShape(8.dp),
                           colors = CardDefaults.cardColors(containerColor = BackgroundGray),
                           modifier = Modifier
                               .height(28.dp)
                               .width(36.dp),
                           onClick = {}
                       ) {
                           Box(
                               modifier = Modifier.fillMaxSize()
                           ) {
                               Text(
                                   text = "${if (adults < 10) 0 else ""}$adults",
                                   color = TextGray,
                                   modifier = Modifier.align(Alignment.Center)
                               )
                           }
                       }
                       Spacer(modifier = Modifier.width(15.dp))
                       IconButton(
                           onClick = {
                               adults++
                           },
                           colors = IconButtonDefaults.iconButtonColors(
                               containerColor = PrimaryPurple,
                               contentColor = Color.White,
                           ),
                           modifier = Modifier
                               .clip(RoundedCornerShape(8.dp))
                               .background(PrimaryPurple)
                               .height(28.dp)
                               .width(28.dp)
                               .align(Alignment.CenterVertically)
                       ) {
                           Icon(painterResource(R.drawable.plus), contentDescription = null)
                       }
                   }
               }
               Column(
                   horizontalAlignment = Alignment.Start
               ) {
                   Text(text = "Childs (2-12)", color = Color.Black)
                   Spacer(modifier = Modifier.height(10.dp))
                   Row(
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       IconButton(
                           onClick = {
                               if (childs > 0) {
                                   childs--
                               }
                           },
                           colors = IconButtonDefaults.iconButtonColors(
                               containerColor = DividerGray,
                               contentColor = Color.Black,
                           ),
                           modifier = Modifier
                               .clip(RoundedCornerShape(8.dp))
                               .background(DividerGray)
                               .height(28.dp)
                               .width(28.dp)
                               .align(Alignment.CenterVertically)
                       ) {
                           Icon(painterResource(R.drawable.minus), contentDescription = null)
                       }
                       Spacer(modifier = Modifier.width(15.dp))
                       Card(
                           border = BorderStroke(1.dp, StrokeGray),
                           shape = RoundedCornerShape(8.dp),
                           colors = CardDefaults.cardColors(containerColor = BackgroundGray),
                           modifier = Modifier
                               .height(28.dp)
                               .width(36.dp),
                           onClick = {}
                       ) {
                           Box(
                               modifier = Modifier.fillMaxSize()
                           ) {
                               Text(
                                   text = "${if (childs < 10) 0 else ""}$childs",
                                   color = TextGray,
                                   modifier = Modifier.align(Alignment.Center)
                               )
                           }
                       }
                       Spacer(modifier = Modifier.width(15.dp))
                       IconButton(
                           onClick = {
                               childs++
                           },
                           colors = IconButtonDefaults.iconButtonColors(
                               containerColor = PrimaryPurple,
                               contentColor = Color.White,
                           ),
                           modifier = Modifier
                               .clip(RoundedCornerShape(8.dp))
                               .background(PrimaryPurple)
                               .height(28.dp)
                               .width(28.dp)
                               .align(Alignment.CenterVertically)
                       ) {
                           Icon(painterResource(R.drawable.plus), contentDescription = null)
                       }
                   }
               }
            }
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedButton(
                modifier = Modifier
                    .padding(17.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, PrimaryPurple),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Search Flight", color = PrimaryPurple, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun TransportComponent(name: String, icon: Int, selectedItem: String, thisItem: String, onSelect: () -> Unit) {
    Column(
        modifier = Modifier.clickable(onClick = onSelect),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            border = BorderStroke(2.dp, if (selectedItem == thisItem) PrimaryPurple else Color.White),
            modifier = Modifier.size(70.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = if (selectedItem == thisItem) 10.dp else 0.dp)
        ) {
            Box(modifier = Modifier.size(70.dp)) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(text = name, color = if (selectedItem == thisItem) Color.Black else TextGray, fontWeight = if (selectedItem == thisItem) FontWeight.Bold else FontWeight.Normal)
    }
}