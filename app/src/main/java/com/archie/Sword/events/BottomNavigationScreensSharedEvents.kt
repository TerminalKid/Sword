package com.archie.Sword.events

import androidx.compose.ui.unit.Dp
import com.archie.Sword.enums.SortType
import com.archie.Sword.repositories.database.Verse

sealed interface BottomNavigationScreensSharedEvents{

    data class UpdateUiThemeTo(val theme: String): BottomNavigationScreensSharedEvents

    object ShowPopUpMenu: BottomNavigationScreensSharedEvents
    data class TickOrUntickCheckBoxToMemoriseVerse(val verseTag: String, val isCheckBoxTicked: Boolean): BottomNavigationScreensSharedEvents

    data class SetVerse(val verse: Verse): BottomNavigationScreensSharedEvents



    object HidePopUpMenu: BottomNavigationScreensSharedEvents

    object ShowMenuSideBar: BottomNavigationScreensSharedEvents
    object HideMenuSideBar: BottomNavigationScreensSharedEvents

    object ExpandSearchBar: BottomNavigationScreensSharedEvents
    object CollapseSearchBar: BottomNavigationScreensSharedEvents

    object ShowAddingVerseFloatingButton: BottomNavigationScreensSharedEvents
    object HideAddingVerseFloatingButton: BottomNavigationScreensSharedEvents

    data class getContentPading(val topDp: Dp,val bottomDp: Dp): BottomNavigationScreensSharedEvents
    data class ChangeSortTypeTo(val sortType: SortType): BottomNavigationScreensSharedEvents

    data class UpdateVerse(val verse: Verse): BottomNavigationScreensSharedEvents

    data class IsPartOfFavorites(val isPartOfFavorites: Boolean): BottomNavigationScreensSharedEvents
//
//    //Fragments
//    object launchHome: BottomNavigationScreensSharedEvents
//    object launchCatchUp: BottomNavigationScreensSharedEvents
//    object launchFavourites: BottomNavigationScreensSharedEvents
//    object launchCurrentThemes: BottomNavigationScreensSharedEvents
//    object launchAllThemes: BottomNavigationScreensSharedEvents
//    object launchVerseView: BottomNavigationScreensSharedEvents
//
//
//    //Activities
//    object launchAddingVerse: BottomNavigationScreensSharedEvents
//    object launchSettings: BottomNavigationScreensSharedEvents
//    object launchTheme: BottomNavigationScreensSharedEvents


//    object saveVerse: BottomNavigationScreensSharedEvents
//    data class deleteVerse(val verse: Verse): BottomNavigationScreensSharedEvents
//    data class enterBook(val bookName: String): BottomNavigationScreensSharedEvents
//    data class enterVerse(val verse: String): BottomNavigationScreensSharedEvents
//    data class enterVerseNum(val chapterAndVerseNumber: String): BottomNavigationScreensSharedEvents
//    data class sortVerses(val sortType: SortType): BottomNavigationScreensSharedEvents
//    data class enterThemeName(val name: String): BottomNavigationScreensSharedEvents
//    data class enterThemeColour(val colorLevelValues: Int): BottomNavigationScreensSharedEvents



}