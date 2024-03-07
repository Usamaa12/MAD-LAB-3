package com.example.lab3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class Task3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FriendsApp()
        }
    }

    data class Friend(
        val name: String,
        val imageId: Int,
        val rating: Float,
        val description: String
    )

    val friends = listOf(
        Friend("John", R.drawable.chandler, 4.5f, "Best friend ever"),
        Friend("Emma", R.drawable.joey, 3.5f, "Loves to travel"),
        Friend("Mike", R.drawable.monica, 4.0f, "Enjoys playing guitar"),
        Friend("Sophia", R.drawable.phoebe, 4.8f, "Amazing cook"),
        Friend("Daniel", R.drawable.rachel, 3.0f, "Loves coding"),
        Friend("Emily", R.drawable.ross, 4.2f, "Passionate about photography")
    )

    @Composable
    fun FriendsApp() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "friends") {
            composable("friends") {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Friends")
                    Spacer(modifier = Modifier.height(16.dp))
                    FriendsList(friends = friends, navController)
                }
            }
            composable("friendDetail/{name}") { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name")
                val friend = friends.find { it.name == name }
                if (friend != null) {
                    FriendDetailScreen(friend = friend)
                }
            }
        }
    }

    @Composable
    fun FriendsList(friends: List<Friend>, navController: NavHostController) {
        Column {
            for (friend in friends) {
                FriendItem(friend = friend, navController)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    @Composable
    fun FriendItem(friend: Friend, navController: NavController) {
        val context = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("friendDetail/${friend.name}")
                }
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = friend.imageId),
                    contentDescription = "Friend Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = friend.name)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Rating: ${friend.rating}", color = Color.Gray)
                }
            }
        }
    }

    @Composable
    fun FriendDetailScreen(friend: Friend) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = friend.name)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Rating: ${friend.rating}")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Description: ${friend.description}")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FriendsAppPreview() {
    Task3().FriendsApp()
}
