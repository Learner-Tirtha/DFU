package com.example.dfuapp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diacare.DoctorRegistration
import com.example.diacare.ui.screen.Patient.AdminBottomNav


@Composable
fun AdminDashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Header()

        Spacer(modifier = Modifier.height(16.dp))

        // Patients Chart
        Text(text = "Patients Login", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFE0F7FA))
                .padding(8.dp)
        ) {
            Text(text = "📊 Chart Placeholder", fontSize = 16.sp, modifier = Modifier.align(Alignment.Center))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Doctors Chart
        Text(text = "Doctors Login", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFFFF3E0))
                .padding(8.dp)
        ) {
            Text(text = "📊 Chart Placeholder", fontSize = 16.sp, modifier = Modifier.align(Alignment.Center))
        }

        Spacer(modifier = Modifier.height(200.dp))

        AdminBottomNav()

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDoctorRegistrationScreen() {
    Scaffold(
        topBar = { HeaderRegistration() },
        bottomBar = { AdminBottomNav() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { DoctorRegistration()
        }
    }
}





