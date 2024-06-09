package presentation.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.about
import portfolio.composeapp.generated.resources.back
import portfolio.composeapp.generated.resources.profile5
import presentation.AppFooter
import presentation.HomeIndicator

@Composable
fun About(
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(20.dp)
            .aspectRatio(9f / 19.5f) // Aspect ratio of an iPhone
            .border(4.dp, Color.Red, shape = RoundedCornerShape(40.dp))
            .border(15.dp, Color.Black, shape = RoundedCornerShape(40.dp))
            .background(Color.White, shape = RoundedCornerShape(40.dp))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp)
                    .size(40.dp)
                    .clickable {
                        onBack.invoke()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "About",
                color = Color.Black,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 33.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(Res.drawable.profile5),
            contentDescription = "Profile pic",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(Res.string.about),
            color = Color.Black,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium
            ),
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(Res.string.about),
            color = Color.Black,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium
            ),
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        AppFooter(color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        HomeIndicator()
    }
}