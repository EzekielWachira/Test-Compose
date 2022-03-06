package com.ezzy.testcompose

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ezzy.testcompose.ui.theme.TestComposeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                SecondScreen()
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    val messages = listOf(
//                        Message(
//                            title = "Sample title 1",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 2",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 3",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 4",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 5",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 6",
//                            subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
//                        ),
//                        Message(
//                            title = "Sample title 7",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 8",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 9",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                        Message(
//                            title = "Sample title 10",
//                            subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
//                        ),
//                        Message(
//                            title = "Sample title 11",
//                            subtitle = "Lorem ipsum dolor sit amet consectur"
//                        ),
//                    )
//                    MessageList(messages = messages)
//                }
            }
        }



    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@ExperimentalMaterialApi
@Composable
fun MessageCard(message: Message) {
    var count by remember { mutableStateOf(0) }
    var isExpanded by remember { mutableStateOf(false) }
    androidx.compose.material.Card(
        elevation = 5.dp,
        onClick = { isExpanded = !isExpanded },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                top = 5.dp,
                bottom = 5.dp,
                start = 10.dp,
                end = 10.dp
            )
            .animateContentSize()
            .padding(1.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .animateContentSize()
                .padding(1.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = "This is an image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, colorResource(id = R.color.orange), CircleShape)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = message.title,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.orange),
                    style = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = message.subtitle,
                    style = MaterialTheme.typography.caption,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    color = Color.Gray
                )
            }
//            Spacer(modifier = Modifier.width(3.dp))
//            Text(text = count.toString(), fontSize = 12.sp)
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val messages = listOf(
        Message(title = "Sample title 1", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(title = "Sample title 2", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(title = "Sample title 3", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(title = "Sample title 4", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(title = "Sample title 5", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(
            title = "Sample title 6",
            subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
        ),
        Message(title = "Sample title 7", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(title = "Sample title 8", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(title = "Sample title 9", subtitle = "Lorem ipsum dolor sit amet consectur"),
        Message(
            title = "Sample title 10",
            subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
        ),
        Message(title = "Sample title 11", subtitle = "Lorem ipsum dolor sit amet consectur"),
    )
    TestComposeTheme {
        Column {
            Toolbar()
            MessageList(messages = messages)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MessageList(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Toolbar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RectangleShape
            ),
        elevation = 5.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 5.dp,
                    end = 5.dp,
                    top = 3.dp,
                    bottom = 3.dp
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = "This is an image",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, colorResource(id = R.color.orange), CircleShape)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "John Doe",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Text(
                    text = "Last seen recently",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(
                    id = R.drawable.ic_baseline_mark_unread_chat_alt_24),
                    contentDescription = "",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(painter = painterResource(
                    id = R.drawable.ic_baseline_video_call_24),
                    contentDescription = "",
                    tint = Color.Gray
                )
            }
        }
    }
}

data class Message(
    val title: String,
    val subtitle: String
)