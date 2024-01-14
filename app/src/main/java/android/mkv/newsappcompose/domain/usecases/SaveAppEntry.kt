package android.mkv.newsappcompose.domain.usecases

import android.mkv.newsappcompose.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }


}