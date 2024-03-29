@file:OptIn(ExperimentalFoundationApi::class)

package com.archie.Sword.screenViews.favouritesScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.archie.Sword.events.BottomNavigationScreensSharedEvents
import com.archie.Sword.repositories.database.Verse
import com.archie.Sword.screenViews.homeScreen.list
import com.archie.Sword.screenViews.homeScreen.verseHolder
import com.archie.Sword.screenViews.homeScreenBottomNavigation.ThemeScreenTabRow
import com.archie.Sword.screenViews.homeScreenBottomNavigation.manageScreenTabItem
import com.archie.Sword.screenViews.homeScreenBottomNavigation.viewScreenTabItem
import com.archie.Sword.states.BottomNavigationSharedStates
import com.example.Sword.R
import kotlinx.coroutines.flow.flowOf

@ExperimentalMaterial3Api

data class FavoritesScreenScreenTabRow(

    val title: String = ""
)



@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun favoritesScreen(onEvent:(BottomNavigationScreensSharedEvents) -> Unit, state: BottomNavigationSharedStates, paddingValues: PaddingValues, pagingItems: LazyPagingItems<Verse>){


    val contentPadding = remember {

        paddingValues
    }



    val tabRowItems = remember {

        listOf(

            FavoritesScreenScreenTabRow(
                "Favorites"
            ),

            FavoritesScreenScreenTabRow(
                "Notes"
            ),

            FavoritesScreenScreenTabRow(
                "Practiced"
            ),

            )
    }



    var selectedTabIndex by  remember {

        mutableIntStateOf(0)
    }


    val pagerState =  rememberPagerState {

        tabRowItems.size
    }


    LaunchedEffect(selectedTabIndex){

        pagerState.animateScrollToPage(selectedTabIndex)
    }


    LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress){

        if(!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage

    }








    Column(

        modifier = Modifier.padding(contentPadding)
    ) {


        TabRow(
            selectedTabIndex = selectedTabIndex,
            divider = {


            }
        ) {

            tabRowItems.forEachIndexed { index, item ->


                Tab(
                    selected = index == selectedTabIndex,
                    text = { Text(
                        text = item.title,
                        color = Color.Black,
                    ) },
                    onClick = {

                        selectedTabIndex = index
                    } // ON CLICK ENDS
                ) // TAB ENDS

            } // FOR EACH INDEX ENDS


        } // TAB ROW ENDS



        HorizontalPager(
            state =  pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->



            val modifier = Modifier.fillMaxSize()

            when(index){

                0 -> {

                    favoritesTabItem(state = state, onEvent = onEvent, pagingItems = pagingItems , paddingValues = paddingValues )
                }
                //1 -> viewScreenTabItem(onEvent = onEvent, state = state, pagingItems = pagingItems)
            }

        } // HORIZONTAL PAGER ENDS









    } // COLUMN ENDS


}


@Composable
fun favoritesTabItem(state: BottomNavigationSharedStates, onEvent: (BottomNavigationScreensSharedEvents) -> Unit, pagingItems: LazyPagingItems<Verse>, paddingValues: PaddingValues ){


    val contentPadding  = remember {
        paddingValues
    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),

        modifier = Modifier
               .fillMaxSize(),

//            .overscroll(overscrollEffect)
//            .scrollable(
//                orientation = Orientation.Vertical,
//                reverseDirection = true,
//                state = listState,
//                overscrollEffect = overscrollEffect
//            ),
        contentPadding = contentPadding,

        content = {


            items(

//                    items =  pagingItems.itemSnapshotList,
//                    key = { verse ->
//
//                        verse?.id  ?: 0
//                    }

                list


            ) { verse->



                verseHolder(onEvent = onEvent, state = state , verse = verse)



            } // ITEMS ENDS

        } // CONTENT ENDS

    ) // LAZY COLUMN ENDS




}


@Composable
fun notesTabItem(){



}


@Composable
fun practiceTabItem(){





}


@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun previewThis(){

    favoritesScreen(onEvent = {}, state = BottomNavigationSharedStates(), paddingValues = PaddingValues() , pagingItems = flowOf(
        PagingData.from(emptyList<Verse>()))
        .collectAsLazyPagingItems())
}






