package com.archie.Sword.screenViews.homeScreenBottomNavigation

sealed class Screens(val route: String){

    object HomeScreen: Screens("home_screen")
    object ThemeScreen: Screens("notes_screen")
    object FavoritesScreen: Screens("favorites_screen")


}
