package com.example.myapp

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen { email, password ->
                // Xử lý logic đăng nhập ở đây
                println("Email: $email, Password: $password")
            }
        }
    }
}

@Composable
fun LoginForm(onLoginClicked: (String, String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.picture2),
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(32.dp))

        val emailState = remember { mutableStateOf("") }
        TextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        val passwordState = remember { mutableStateOf("") }
        TextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onLoginClicked(emailState.value, passwordState.value) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun LoginScreen(onLoginClicked: (String, String) -> Unit) {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginForm(onLoginClicked)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen { _, _ -> }
}
