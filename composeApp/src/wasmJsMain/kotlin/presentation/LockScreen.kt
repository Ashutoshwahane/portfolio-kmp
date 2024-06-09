package presentation

import utils.UnlockSlider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform


@Composable
fun LockScreen(
    modifier: Modifier = Modifier,
    unlocked: () -> Unit
) {
    Box(modifier = modifier){
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "12:00",
                color = Color.White,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 33.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "Sunday",
                color = Color.White,
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "Welcome To my Portfolio",
                color = Color.White,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 28.sp,
                modifier = Modifier.padding(20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            UnlockSlider(
                modifier = Modifier.padding(20.dp),
                hintText = "Swipe to Unlock",
                endIcon = painterResource(resource = Res.drawable.compose_multiplatform),
                isLoading = false,
                completionColor = Color.Black,
                startIcon = painterResource(resource = Res.drawable.compose_multiplatform),
                onSwipeComplete = {
                    unlocked.invoke()
                    println("Swipe Complete")
                },
            )
        }
    }

}