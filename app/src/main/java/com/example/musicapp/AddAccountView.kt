package com.example.musicapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun addAccount(isDailogue: MutableState<Boolean>) {
    if (isDailogue.value) {
        AlertDialog(onDismissRequest = { isDailogue.value = false },
            confirmButton = {
                Button(onClick = { isDailogue.value = false }) {
                    Text(text = "Submit")
                }
                Button(onClick = { isDailogue.value = false }) {
                    Text(text = "Cancel")
                }
            },
            title = { Text(text = "Add Account") },
            text = {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(value = "",
                        onValueChange = {},
                        label = { Text(text = "Email")},
                        modifier = Modifier.padding(8.dp)
                    )
                    TextField(value = "",
                        onValueChange = {},
                        label = { Text(text = "password")},
                        modifier = Modifier.padding(8.dp)
                    )
                }
            },
            properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true
            )
        )
    }
}