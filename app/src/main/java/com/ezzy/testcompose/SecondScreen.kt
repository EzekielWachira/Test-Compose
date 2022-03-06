package com.ezzy.testcompose

import android.text.Html
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.ezzy.testcompose.ui.theme.CategoryBackgroundColor
import com.ezzy.testcompose.ui.theme.FoodBackgroundColor
import com.ezzy.testcompose.ui.theme.FoodColor
import com.ezzy.testcompose.ui.theme.ViewAllColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Preview(showBackground = true)
@Composable
fun SecondScreen() {

    val poppinsLight = Font(R.font.poppins_light)
    val poppinsBold = Font(R.font.poppins_bold)
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.White,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = "Location",
                            tint = FoodColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Pick Location",
                            fontFamily = FontFamily(poppinsBold),
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile",
                            tint = colorResource(id = R.color.gray)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_rocket),
                            contentDescription = "Rocket",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = RoundedCornerShape(50),
                modifier = Modifier.size(60.dp),
                backgroundColor = FoodColor
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home")
                    },
                    selectedContentColor = FoodColor,
                    unselectedContentColor = Color.LightGray
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorite"
                        )
                    },
                    selectedContentColor = FoodColor,
                    unselectedContentColor = Color.LightGray
                )
                Spacer(modifier = Modifier.weight(1f, true))
                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notifications"
                        )
                    },
                    selectedContentColor = FoodColor,
                    unselectedContentColor = Color.LightGray
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        BadgedBox(
                            badge = {
                                Text(
                                    text = "5",
                                    color = Color.White,
                                    fontFamily = FontFamily(poppinsLight)
                                )
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingCart,
                                contentDescription = "Cart"
                            )
                        }
                    },
                    selectedContentColor = FoodColor,
                    unselectedContentColor = Color.LightGray
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Card(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(end = 25.dp),
                backgroundColor = FoodBackgroundColor,
                shape = RoundedCornerShape(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 10.dp,
                            end = 10.dp,
                            start = 20.dp,
                            bottom = 10.dp
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.4f)
                            .fillMaxWidth()
                    ) {
                        AndroidView(factory = { context ->
                            TextView(context).apply {
                                text = Html
                                    .fromHtml("<string><big><b><span style = \"color:#000000\">The Fastest In Delivery </span><span style = \"color:#F54748\">Food</span></b></big></string>")
                            }
                        })
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { }, modifier = Modifier
                                .width(100.dp)
                                .clip(
                                    RoundedCornerShape(10.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(FoodColor)
                        ) {
                            Text(
                                text = "Order now",
                                fontFamily = FontFamily(poppinsBold),
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(0.6f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_delivery),
                            contentDescription = "Delivery Image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Categories",
                fontFamily = FontFamily(poppinsBold),
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(25.dp))
            LazyRow {
                items(10) { index ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(
                                if (index == 0) FoodColor else CategoryBackgroundColor
                            )
                            .wrapContentWidth()
                            .padding(end = 15.dp, start = 15.dp, top = 10.dp, bottom = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(
                                    id = when (index) {
                                        0 -> R.drawable.ic_burger
                                        1 -> R.drawable.ic_pizza
                                        else -> R.drawable.ic_burger
                                    }
                                ),
                                contentDescription = "Category Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = when (index) {
                                    0 -> "Burger"
                                    1 -> "Pizza"
                                    2 -> "Sandwich"
                                    else -> "Toast"
                                },
                                fontFamily = FontFamily(poppinsLight),
                                color = if (index == 0) Color.White else Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.padding(end = 25.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Popular Now",
                        fontFamily = FontFamily(poppinsBold),
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "View All",
                                fontFamily = FontFamily(poppinsLight),
                                color = ViewAllColor,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                imageVector = Icons.Outlined.ArrowCircleDown,
                                contentDescription = "View all image",
                                modifier = Modifier.size(20.dp),
                                colorFilter = ColorFilter.tint(ViewAllColor)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow {
                items(10) { index ->
                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .wrapContentHeight()
                            .padding(start = 5.dp),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 20.dp)
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (index % 2 == 0) {
                                        R.drawable.ic_burger
                                    } else {
                                        R.drawable.ic_resource_double
                                    }
                                ),
                                contentDescription = "Category Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(120.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = when (index) {
                                    0 -> "Beef Burger"
                                    1 -> "Double Burger"
                                    else -> "Cheese Burger"
                                },
                                fontFamily = FontFamily(poppinsBold),
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = when (index) {
                                        0 -> "Cheesy"
                                        1 -> "Beef"
                                        else -> "Chilli"
                                    },
                                    fontFamily = FontFamily(poppinsLight),
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Image(
                                    painter = painterResource(
                                        id = if (index % 2 == 0) {
                                            R.drawable.cheese
                                        } else {
                                            R.drawable.beef
                                        }
                                    ),
                                    contentDescription = "Category Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            AndroidView(
                                factory = { context ->
                                    TextView(context).apply {
                                        text = if (index % 2 == 0) {
                                            Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>14.10</big></big></span></b></string>")
                                        } else {
                                            Html.fromHtml("<string><b><span style = \"color:#F54748\"><big>$ </big></span><span style = \"color:#000000\"><big><big>8.35</big></big></span></b></string>")
                                        }
                                    }
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}