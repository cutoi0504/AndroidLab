package com.example.login_registration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_registration.login.LoginScreen
import com.example.login_registration.signup.SignupScreen
import com.example.login_registration.ui.theme.Login_RegistrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp(){
    val navController = rememberNavController()
    Login_RegistrationTheme{
        NavHost(navController = navController, startDestination = "login"){

            composable("login"){
                LoginScreen(
                    openSignup = {
                        navController.navigate("sigup")
                    }
                )
            }
            composable("sigup"){
                SignupScreen(
                    openLogin = {
                        navController.navigate("login")
                    }
                )
            }
        }
    }
}
