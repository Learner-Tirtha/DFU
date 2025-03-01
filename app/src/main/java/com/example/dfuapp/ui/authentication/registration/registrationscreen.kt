package com.example.dfuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.util.Patterns
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.compose.ui.modifier.ModifierLocalReadScope

@Composable
fun RegistrationScreen() {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var usernameError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F2F1))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Every step matters—\nwalk towards better health.",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Email Field
        CustomTextField(
            value = username,
            onValueChange = {
                username = it
                usernameError = null
            },
            placeholder = "Username/Email",
            errorMessage = usernameError
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password Field
        CustomTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = null
            },
            placeholder = "Password",
            isPassword = true,
            errorMessage = passwordError
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Confirm Password Field
        CustomTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                confirmPasswordError = null
            },
            placeholder = "Confirm Password",
            isPassword = true,
            errorMessage = confirmPasswordError
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val isValid = validateFields(
                    username, password, confirmPassword,
                    onUsernameError = { usernameError = it },
                    onPasswordError = { passwordError = it },
                    onConfirmPasswordError = { confirmPasswordError = it }
                )

                if (isValid) {
                    Toast.makeText(context, "Registration Successful!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA5D6A7))
        ) {
            Text(text = "Register", fontSize = 18.sp, color = Color.Black)
        }
    }
}

// ✅ Custom TextField with Error Handling
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    errorMessage: String? = null
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            placeholder = { Text(placeholder) }
        )
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
        }
    }
}

// ✅ Validation Logic
fun validateFields(
    username: String,
    password: String,
    confirmPassword: String,
    onUsernameError: (String?) -> Unit,
    onPasswordError: (String?) -> Unit,
    onConfirmPasswordError: (String?) -> Unit
): Boolean {
    var isValid = true

    // Email Validation
    if (username.isBlank()) {
        onUsernameError("Email cannot be empty")
        isValid = false
    } else if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
        onUsernameError("Invalid email format")
        isValid = false
    }

    // Password Validation
    if (password.isBlank()) {
        onPasswordError("Password cannot be empty")
        isValid = false
    } else if (!isStrongPassword(password)) {
        onPasswordError("Password must be 6+ characters, include an uppercase, a digit & a special character")
        isValid = false
    }

    // Confirm Password Validation
    if (confirmPassword.isBlank()) {
        onConfirmPasswordError("Confirm Password cannot be empty")
        isValid = false
    } else if (confirmPassword != password) {
        onConfirmPasswordError("Passwords do not match")
        isValid = false
    }

    return isValid
}

// ✅ Strong Password Check
fun isStrongPassword(password: String): Boolean {
    val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#\$%^&+=!]).{6,}$".toRegex()
    return password.matches(passwordPattern)
}

// ✅ Header
@Composable
fun HeaderRegistration() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF4AB19D), Color(0xFF1E847F))
                )
            ),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "DiaCare",
            color = Color.White,
            modifier = Modifier.padding(10.dp,15.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold

        )
    }
}

// ✅ Bottom Bar
@Composable
fun BottomRegistration() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF4AB19D), Color(0xFF1E847F))
                )
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {}
}

// ✅ Preview
@Preview(showSystemUi = true)
@Composable
fun PreviewPatientRegistrationScreen() {
    Scaffold(
        topBar = { HeaderRegistration() },
        bottomBar = { BottomRegistration() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            RegistrationScreen()
        }
    }
}
