package com.pandasby.pettest.ui.classes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pandasby.pettest.domain.entities.DnDClass

@Composable
fun DnDClassItem(dndClass: DnDClass, onClick: (DnDClass) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { onClick(dndClass) },
        shape = RoundedCornerShape(16.dp),
    ) {
        AsyncImage(
            model = dndClass.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter
        )

        Row(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color.LightGray,
                            Color.Transparent
                        ),
                    )
                )
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = dndClass.name)
                Text(
                    text = dndClass.dice,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .background(Color.Yellow, RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}