package com.vijay.jetpacknews.domain.usecases.app_entry

import com.vijay.jetpacknews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }

}