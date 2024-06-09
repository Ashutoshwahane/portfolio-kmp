package presentation

import domain.model.Menu
import domain.model.Menus
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
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

@Composable
fun HomeScreen(
    onClick: (Menu) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp),
            columns = GridCells.Fixed(4),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            items(Menus.menus) { menu ->
                Column(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clickable {
                            onClick.invoke(menu)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .background(color = Color.White, shape = CircleShape)
                            .padding(8.dp),
                        painter = painterResource(
                            menu.icon
                        ),
                        contentDescription = "App icon",
                    )
                    Text(
                        text = menu.appName,
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium
                        ),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.weight(1f))
        AppFooter()
        Spacer(modifier = Modifier.height(20.dp))
        HomeIndicator()
    }

}