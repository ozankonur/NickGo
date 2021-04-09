package com.okonur.nickgo.framework.home

class Validator {
    fun isNickNameValid(nickName : String) : Boolean{
        return nickName.length in 2..50
    }
}