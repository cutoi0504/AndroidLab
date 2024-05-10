package com.example.login_registration.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(openSignup:()->Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 70.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "ĐĂNG NHẬP",
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(label = "Tên đăng nhập")
        Spacer(modifier = Modifier.height(16.dp))
        PasswordField(label = "Mật khẩu")
        Spacer(modifier = Modifier.height(16.dp))
        LoginButton()
        Spacer(modifier = Modifier.height(16.dp))
        ClickText(value = "Bạn chưa có tài khoản ? Đăng ký", openSignup)

    }
}

@Composable
fun TextField(label: String) {
    var name by remember { mutableStateOf("") }
    OutlinedTextField(
        value = name,
        onValueChange = { newValue -> name = newValue },
        label = { Text(text = label) },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
fun PasswordField(label: String) {
    var password by remember { mutableStateOf("") }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = label) },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),
        shape = RoundedCornerShape(16.dp),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "Đăng Nhập", fontWeight = FontWeight.Bold)
    }
}
@Composable
fun ClickText(value : String, openSignup: () -> Unit){
    val textOne = "Bạn chưa có tài khoản ? "
    val textTwo = "Đăng ký"
    val textString = buildAnnotatedString {
        append(textOne)
        withStyle(style = SpanStyle(color = Color.Red)){
            pushStringAnnotation(tag = textTwo , annotation = textTwo)
            append(textTwo)
        }
    }
    ClickableText(text = textString , onClick = {
        openSignup()
    })
}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LoginScreen(openProductDetail = )
//}