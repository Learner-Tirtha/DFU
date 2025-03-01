import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dfuapp.BottomRegistration
import com.example.dfuapp.HeaderRegistration
import com.example.dfuapp.RegistrationScreen
import com.example.dfuapp.R


@Composable
fun LoginScreen() {
    var selectedUserType by remember { mutableStateOf("Patient") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F2F1)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Text("DiaCare", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("Patient", "Doctor", "Admin").forEach { userType ->
                Text(
                    text = userType,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (selectedUserType == userType) Color.White else Color(0xFF008080),
                    modifier = Modifier
                        .background(
                            if (selectedUserType == userType) Color(0xFF008080) else Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                        .clickable { selectedUserType = userType }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("UserName/Email") },
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(20.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(20.dp)

        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Forget Password?",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.clickable { /* Navigate to Forgot Password */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Button(
                onClick = { /* Handle Login */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008080)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text("Log In", color = Color.White)
            }

            Button(
                onClick = { /* Navigate to Sign Up */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008080)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text("Sign Up", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Divider(modifier = Modifier.fillMaxWidth(0.7f))

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.googl), // Replace with actual Google icon
            contentDescription = "Google Login",
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, shape = CircleShape)
                .clickable { /* Handle Google Sign-In */ }
        )
    }
}

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
            LoginScreen()
        }
    }
}
