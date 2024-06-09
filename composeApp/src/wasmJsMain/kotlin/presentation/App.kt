package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.Menu
import domain.model.Menus
import utils.conditional
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.portfolio
import presentation.about.About

@Composable
fun App() {
    var showHomeScreen by remember { mutableStateOf(false) }
    var showAboutScreen by remember { mutableStateOf(false) }
    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White) // Background for the whole screen to make it stand out
        ) {
            Box(
                modifier = Modifier
                    .aspectRatio(9f / 19.5f) // Aspect ratio of an iPhone
                    .border(4.dp, Color.Red, shape = RoundedCornerShape(40.dp))
                    .border(15.dp, Color.Black, shape = RoundedCornerShape(40.dp))
                    .background(Color.White, shape = RoundedCornerShape(40.dp))
            ) {
                Image(
                    modifier = Modifier.fillMaxSize()
                        .conditional(showHomeScreen){
                            blur(radius = 10.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                        }
                        .clip(RoundedCornerShape(40.dp)),
                    painter = painterResource(
                        Res.drawable.portfolio
                    ),
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                    contentDescription = null,
                    )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Notch()
                    Spacer(modifier = Modifier.height(20.dp))
                    if (!showHomeScreen){
                        LockScreen(modifier = Modifier.fillMaxSize()) {
                            showHomeScreen = true
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        AppFooter()
                        Spacer(modifier = Modifier.height(20.dp))
                        HomeIndicator()
                    }

                    if (showHomeScreen) {
                        HomeScreen(
                            onClick = {menu ->
                                when(menu.appName){
                                    "Project" -> {

                                    }

                                    "About" -> {
                                        showAboutScreen = true
                                    }

                                    "Resume" -> {

                                    }

                                    "Blogs" -> {

                                    }

                                    "Experience" -> {

                                    }

                                    "Logout" -> {
                                        showHomeScreen = false
                                    }
                                }
                            },
                        )
                    }
                }
            }


            if (showAboutScreen){
                About{
                    showAboutScreen = false
                }
            }

        }
    }
}




@Composable
fun Notch() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .height(40.dp)
            .background(
                Color.Black,
                shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
            )
    )
}

@Composable
fun HomeIndicator() {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(5.dp)
            .background(Color.Gray, shape = RoundedCornerShape(50))
    )
}

@Composable
fun AppFooter(color: Color = Color.White) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Built using KMP with much love️", color = color, fontSize = 12.sp)
        Text(text = "© 2024 Ashutosh Wahane", color = color, fontSize = 12.sp)
    }
}
