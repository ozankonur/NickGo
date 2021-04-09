package com.okonur.nickgo

import com.okonur.nickgo.framework.home.Validator
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.assertThat

@RunWith(JUnit4::class)
class ValidationUnitTest {
    @Test
    fun nickName_isCorrect() {
        assertThat(Validator().isNickNameValid("asd")).isTrue()
    }
}