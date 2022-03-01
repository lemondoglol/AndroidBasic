package com.example.roomdbexample

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MyViewModel(private val repository: UserRepository) : ViewModel() {

    var allUsers: LiveData<List<UserEntity>> = repository.allUsers.asLiveData()

    /**
     * use Transformations.switchMap to fetch data from DB with parameters
     * */
    private val searchLastName = MutableLiveData("")
    val usersWithGivenLastName: LiveData<List<UserEntity>>
        get() = this._usersWithGivenLastName
    private val _usersWithGivenLastName = Transformations.switchMap(searchLastName) {
        repository.getUsersWithLastName(it).asLiveData()
    }

    // required to run inside the IO scope
    fun insertNewUser(user: UserEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertUser(user)
    }

    // update LiveData's value, and it will Transformations.switchMap to update its value
    fun getUsersWithLastName(lastName: String) = searchLastName.postValue(lastName)
}

/**
 * similar for most part, only need to update the parameters that passed in
 * */
class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MyViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}