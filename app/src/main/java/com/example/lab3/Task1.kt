package com.example.lab3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
class Task1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task1()
    }
}

@Composable
fun Task1() {
    Column(){
        Text(text = "1.What call backs are called when app is first launched")
        Text(text = "onCreate()\n" +
                "onStart()\n" +
                "onResume()")
        Text(text = "2.What callbacks occur when home is pressed")
        Text(text = "onPause()\n" +
                "onStop()")
        Text(text = "3.what call backs occur when app is restarted from launcher")
        Text(text = "onRestart()\n" +
                "onStart()\n" +
                "onResume()")
        Text(text = "4.what call backs occur when the device is rotated")
        Text(text = "onPause()\n" +
                "onSaveInstanceState()\n" +
                "onStop()\n" +
                "onDestroy() (if configuration changes are not handled)\n" +
                "onCreate()\n" +
                "onStart()\n" +
                "onRestoreInstanceState()\n" +
                "onResume()")
    }
}

@Preview(showBackground = true, showSystemUi = true, widthDp = 200, heightDp = 300, name = "Task1")
@Composable
fun GreetingPreview() {
    Task1()
}
}