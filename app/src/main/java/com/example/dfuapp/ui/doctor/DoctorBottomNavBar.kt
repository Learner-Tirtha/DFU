package com.example.dfuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape


@Preview(showSystemUi = true)
@Composable
fun DoctorBottomNav() {
    var selectedItem by remember { mutableStateOf(0) }

    val navItems = listOf(
        NavItem(R.drawable.home),
        NavItem(R.drawable.task),
        NavItem(R.drawable.calender)
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

// BottomNavItem without label
@Composable
fun BottomNavItem(icon: Int, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(10.dp, 0.dp, 10.dp)
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

        // **Underline indicator when selected**
        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(width = 30.dp, height = 3.dp)
                    .background(Color(0xFF008080))
            )
        }
    }
}


// Data class without label
data class NavItem(val iconRes: Int)
