package com.example.diacare.ui.screen.Patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dfuapp.R

@Preview(showSystemUi = true)
@Composable
fun PatientBottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }

    val navItems = listOf(
        NavItem(R.drawable.home),         // Removed "Home"
        NavItem(R.drawable.prescription), // Removed "Prescriptions"
        NavItem(R.drawable.schedule)      // Removed "Report"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(Color(0xFF66CCCC)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 8.dp)
                .clip(RoundedCornerShape(20.dp)),
            backgroundColor = Color(0xFF66CCCC)
        ) {
            navItems.forEachIndexed { index, item ->
                BottomNavItem(
                    icon = item.iconRes,
                    isSelected = selectedItem == index
                ) {
                    selectedItem = index
                }
            }
        }
    }
}

@Composable
fun BottomNavItem(icon: Int, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }

        if (isSelected) {
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height(3.dp)
                    .background(Color(0xFF008080))
            )
        }
    }
}

// **Fixed NavItem data class (no title)**
data class NavItem(val iconRes: Int)
