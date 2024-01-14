package android.mkv.newsappcompose.domain.usecases

import android.mkv.newsappcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }

}