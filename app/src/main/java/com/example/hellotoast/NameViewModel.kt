package com.example.hellotoast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    // Create a LiveData with an Int initialized to 0
    val currentName: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    // Rest of the ViewModel...
}
