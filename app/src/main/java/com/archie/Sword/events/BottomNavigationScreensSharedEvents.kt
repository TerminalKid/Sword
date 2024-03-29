package com.archie.Sword.events

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import com.archie.Sword.enums.SortType

sealed interface BottomNavigationScreensSharedEvents{

    data class UpdateUiThemeTo(val theme: String): BottomNavigationScreensSharedEvents

    object ShowPopUpMenu: BottomNavigationScreensSharedEvents
    data class TickOrUntickCheckBoxToMemoriseVerse(val isCheckBoxTicked: Boolean): BottomNavigationScreensSharedEvents

    object HidePopUpMenu: BottomNavigationScreensSharedEvents

    object ShowMenuSideBar: BottomNavigationScreensSharedEvents
    object HideMenuSideBar: BottomNavigationScreensSharedEvents

    object ExpandSearchBar: BottomNavigationScreensSharedEvents
    object CollapseSearchBar: BottomNavigationScreensSharedEvents

    object ShowAddingVerseFloatingButton: BottomNavigationScreensSharedEvents
    object HideAddingVerseFloatingButton: BottomNavigationScreensSharedEvents

    data class getContentPading(val topDp: Dp,val bottomDp: Dp): BottomNavigationScreensSharedEvents
    data class ChangeSortTypeTo(val sortType: SortType): BottomNavigationScreensSharedEvents

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