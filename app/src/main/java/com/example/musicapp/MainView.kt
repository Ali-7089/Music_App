package com.example.musicapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun mainView() {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    var viewModel: MainViewModel = viewModel();
    var controller: NavController = rememberNavController();
    val navBackStackEntry by controller.currentBackStackEntryAsState();
    val currenRoute = navBackStackEntry?.destination?.route
    val isDailogue = remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Home", style = TextStyle(
                            color = Color.White
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(modifier = Modifier.padding(20.dp)) {
                items(drawerInScreen) { item ->
                    drawerItem(selected = currenRoute == item.dRoute, item = item) {
                        scope.launch {
                            scaffoldState.drawerState.close()

                            if (item.dRoute == "add_account") {
                              isDailogue.value = true
                               controller.navigate(item.dRoute)
                            } else {
                                controller.navigate(item.dRoute)
                            }
                        }
                    }

                }
            }
        }
    ) {
        Navigation(navController = controller, viewModel = viewModel, pd = it)
        addAccount(isDailogue)
    }
}


@Composable
fun drawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onClickDrawer: () -> Unit
) {
    val background = if (selected) Color.Gray else Color.White
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(background)
            .clickable { onClickDrawer() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = item.icon), contentDescription = item.dTitle)
        Text(text = item.dTitle)
    }
}