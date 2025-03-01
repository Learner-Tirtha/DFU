package com.example.diacare.ui.screen.Patient

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
import com.example.dfuapp.R


@Preview(showSystemUi = true)
@Composable
fun AdminBottomNav() {
    var selectedItem by remember { mutableStateOf(0) }

    val navItems = listOf(
        NavItem(R.drawable.home),
        NavItem(R.drawable.think),
        NavItem(R.drawable.heart)
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
                .padding(horizontal = 50.dp,8.dp)
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

// Data class without label
// Data class without label


