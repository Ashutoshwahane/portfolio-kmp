package domain.model

import org.jetbrains.compose.resources.DrawableResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.about
import portfolio.composeapp.generated.resources.books
import portfolio.composeapp.generated.resources.experience
import portfolio.composeapp.generated.resources.logout
import portfolio.composeapp.generated.resources.projects
import portfolio.composeapp.generated.resources.resume

data class Menu(
    val appName: String,
    val icon: DrawableResource
)

object Menus {
    val menus = listOf(
        Menu("Project", Res.drawable.projects),
        Menu("About", Res.drawable.about),
        Menu("Resume", Res.drawable.resume),
        Menu("Blogs", Res.drawable.books),
        Menu("Experience", Res.drawable.experience),
        Menu("Logout", Res.drawable.logout)
    )
}

