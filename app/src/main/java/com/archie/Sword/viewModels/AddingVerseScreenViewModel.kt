package com.archie.Sword.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.archie.Sword.events.AddingVerseScreenEvents
import com.archie.Sword.repositories.database.DaoFunctions
import com.archie.Sword.repositories.database.DataBaseRepositoryImpl
import com.archie.Sword.repositories.database.Verse
import com.archie.Sword.states.AddingVerseScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddingVerseScreenViewModel @Inject constructor(

    private val daoFunctions: DataBaseRepositoryImpl

): ViewModel() {





    private val _state = MutableStateFlow(AddingVerseScreenStates())
    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AddingVerseScreenStates())


    private val eventsChannel = Channel<AddingVerseScreenEvents>()
    val eventFlow =  eventsChannel.receiveAsFlow()


    fun triggerSaveVerseEvent(){

        viewModelScope.launch {

            eventsChannel.send(AddingVerseScreenEvents.saveVerse)

        }

    }


    fun triggerShowingPopUpMenuEvent(){

        viewModelScope.launch {

            eventsChannel.send(AddingVerseScreenEvents.showPopUpMenu)

        }

    }





    fun triggerHidingPopUpMenuEvent(){

        viewModelScope.launch {

            eventsChannel.send(AddingVerseScreenEvents.hidePopUpMenu)

        }

    }







    fun saveVerse() {


        Log.d("ViewModel","About to Add ")

//        if (_state.value.bookName.isBlank() || _state.value.verse.isBlank() || _state.value.themeName.isBlank() || _state.value.photoFilePath.isBlank() || _state.value.note.isBlank())
//            return

        Log.d("ViewModel","Skipped Return")


        val verse =  Verse(
            bookName = _state.value.bookName,
            chapterAndVerseNumber = _state.value.chapterAndVerseNumber,
            verse = _state.value.verse,
            date = System.currentTimeMillis(),
            themeName = _state.value.themeName,
            bookPosition = _state.value.bookPosition,
            photoFilePath = _state.value.photoFilePath,


        ) // VERSE ENDS

        viewModelScope.launch {


            Log.d("Verse",verse.bookName)

            daoFunctions.addVerse(verse)

        } // SCOPE ENDS

        Log.d("ViewModel","VERSE ADDED ")

//        _state.update {
//
//            it.copy(
//
//                bookName = "",
//                chapterAndVerseNumber = "",
//                verse = "",
//                bookPosition = 0,
//
//                note = "",
//
//                themeName = "",
//                themeColour = "",
//
//                photoFilePath = "",
//
//            ) // COPY ENDS
//
//        } // UPDATE ENDS


        Log.d("ViewModel","STATE UPDATED ")





    }







    fun showPopUpMenu(){


        _state.update { it.copy(showingPopupMenu = true) }


    }

    fun hidePopUpMenu(){


        _state.update {    it.copy(showingPopupMenu = false)    }


    }



    fun setBookName(book: String){

        _state.update {    it.copy(bookName = book)     }


    }



    fun showBookSelectionDialog(){

        _state.update {    it.copy(isBookSelectionDialogShowing = true)     }
    }





    fun hideBookSelectionDialog(){

        _state.update {    it.copy(isBookSelectionDialogShowing = false)     }
    }







    fun showChapterSelectionDialog(){

        _state.update {    it.copy(isChapterSelectionDialogShowing = true)     }
    }





    fun hideChapterSelectionDialog(){

        _state.update {    it.copy(isChapterSelectionDialogShowing = false)     }
    }




    fun showVerseSelectionDialog(){

        _state.update {    it.copy(isVerseSelectionDialogShowing = true)     }
    }





    fun hideVerseSelectionDialog(){

        _state.update {    it.copy(isVerseSelectionDialogShowing = false)     }
    }






    fun setChapter(chapter: String){

        _state.update {    it.copy(chapter = chapter)     }

    }







    fun setVerseNumber(verseNumber: String){

        _state.update {    it.copy(verseNumber = verseNumber)     }

    }




    fun setChapterAndVerseNumber(chapterAndVerseNumber: String){

        _state.update {    it.copy(chapterAndVerseNumber =chapterAndVerseNumber)     }

    }






    fun setVerse(verse: String){

        _state.update {    it.copy(verse = verse)     }

    }


    fun setNote(note: String){

        _state.update {    it.copy(note = note)     }
    }


    fun setThemeName(themeName: String){

        _state.update {    it.copy(themeName = themeName)     }

    }


    fun setThemeColour(colour: String){

        _state.update {    it.copy(themeColour = colour)     }

    }


    fun setPhotoFilePath(path: String){

        _state.update {    it.copy(photoFilePath = path)     }

    }



    fun setConditionForThemeExistence(condition: Boolean){

        _state.update {    it.copy(doesThemeExist = condition)     }
    }


















}