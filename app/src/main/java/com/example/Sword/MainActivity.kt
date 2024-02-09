package com.example.Sword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.archie.Sword.events.BottomNavigationScreensSharedEvents
import com.archie.Sword.enums.SortType
import com.archie.Sword.screenViews.homeScreen.experimentalHomeScreen
import com.archie.Sword.screenViews.mainScreen

import com.archie.Sword.viewModels.BottomNavigationSharedViewModel
import com.example.Sword.ui.theme.SwordTheme

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: BottomNavigationSharedViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


         lifecycleScope.launch{



             viewModel.eventFlow.collect{ event->

                 when(event){

                     BottomNavigationScreensSharedEvents.ShowMenuSideBar ->  viewModel.showMenuSideBar()
                     is BottomNavigationScreensSharedEvents.ChangeSortTypeTo -> viewModel.changeSortTypeTo(
                         SortType.byDate)
                     BottomNavigationScreensSharedEvents.CollapseSearchBar -> viewModel.collapseSearchBar()
                     BottomNavigationScreensSharedEvents.ExpandSearchBar -> viewModel.expandSearchBar()
                     BottomNavigationScreensSharedEvents.HideAddingVerseFloatingButton -> viewModel.hideAddingVerseFloatingButton()
                     BottomNavigationScreensSharedEvents.HideMenuSideBar ->  viewModel.hideMenuSideBar()
                     BottomNavigationScreensSharedEvents.HidePopUpMenu -> viewModel.hidePopUpMenu()
                     BottomNavigationScreensSharedEvents.ShowAddingVerseFloatingButton -> viewModel.showAddingVerseFloatingButton()
                     BottomNavigationScreensSharedEvents.ShowPopUpMenu -> viewModel.showPopUpMenu()
                     is BottomNavigationScreensSharedEvents.UpdateUiThemeTo -> viewModel.updateUiThemeTo("")
                 }



             }
         }


        setContent {
//
//            val state = viewModel.state.collectAsStateWithLifecycle()
//            val pagingItems = viewModel.allVerses.flow.collectAsLazyPagingItems()
            val navController = rememberNavController()


//            mainScreen(context = this,navController = navController)
            experimentalHomeScreen()


        }
    }

}



@Composable
fun hi(){



    Text(text = "HI")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    SwordTheme {
     hi()
    }
}