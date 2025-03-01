package com.example.dfuapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dfuapp.R
import com.example.diacare.ui.screen.Patient.AdminBottomNav


@Preview(showSystemUi = true)
@Composable
fun AdminRequestScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        Header()

        // List of Requests
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(5) {
                RequestItem()
            }
        }

        // Bottom Navigation Bar
        AdminBottomNav()
    }
}

@Composable
fun RequestItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for profile image
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // User info (replace with actual content)
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "User Name", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "Details about request", fontSize = 16.sp, color = Color.Gray)
            }

            // Accept & Reject Buttons
            Row {
                Image(
                painter = painterResource(id = R.drawable.accept),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
               Image(painter = painterResource(id = R.drawable.reject), contentDescription = null,modifier = Modifier.size(40.dp))
            }
        }
    }
}




