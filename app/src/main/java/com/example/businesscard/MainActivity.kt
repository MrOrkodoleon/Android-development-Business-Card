package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = getString(R.string.owner_name),
                        title = getString(R.string.owner_title),
                        "@LinkedInUserHandler",
                        "+1-218-678-4214",
                        "my@email.com",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SNSinfo(img: Painter, label: String) {
    Row {
        Image(
            painter = img,
            contentDescription = "Social Network",
            modifier = Modifier
                .size(50.dp)
                .padding(5.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Text(
            text = label,
            modifier = Modifier
                .padding(5.dp)
                .align(CenterVertically),
            color = Color.Black
        )
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    linkedInLabel: String = "@default",
    phoneNumber: String = "1-555-123-1234",
    email: String = "user@example.com",
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(118, 170, 173))
    ) {
        Spacer(modifier= Modifier.size(150.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Card's owner photo",
                alignment = AbsoluteAlignment.TopLeft,
                modifier = Modifier
                    .padding(6.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.align(CenterVertically)
            ) {
                Text(
                    name,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Text(
                    title,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.CenterHorizontally),
                    color = Color.Black
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.weight(1f).align(Alignment.CenterHorizontally)
        ) {
            SNSinfo(painterResource(R.drawable.in_logo), linkedInLabel)
            SNSinfo(painterResource(R.drawable.phone), phoneNumber)
            SNSinfo(painterResource(R.drawable.gmail), email)
            Spacer(modifier= Modifier.size(200.dp))
        }
    }
}

@Preview(showBackground = true, device = "id:OnePlus 8T")
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard("John Doe Third", "CEO of CEOing", modifier = Modifier)
    }
}