package com.example.musicapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel(){
   private val _screen:MutableState<Screen.DrawerScreen> =
       mutableStateOf(Screen.DrawerScreen.AddAccount)

    //getting screen
   val screen:MutableState<Screen.DrawerScreen> = _screen

    //setting screen
    fun changeScren(screen: Screen.DrawerScreen){
        _screen.value = screen;
    }

}