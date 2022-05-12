package com.example.dagger2_example

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger2_example.models.User
import com.example.dagger2_example.network.CustomerServiceRepositoryImpl
import io.reactivex.Observer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val customerServiceRepository: CustomerServiceRepositoryImpl
) : ViewModel() {

    fun getUser(id: Int) {
        customerServiceRepository.getUser(id)
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<User> {

                override fun onNext(t: User) {
                    Log.d("onNext", t.emailAddress)
                    Log.d("onNext", t.userName)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }

                override fun onSubscribe(d: io.reactivex.disposables.Disposable?) {

                }

            })
    }

}