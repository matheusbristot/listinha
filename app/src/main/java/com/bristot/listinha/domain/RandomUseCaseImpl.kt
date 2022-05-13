package com.bristot.listinha.domain

import java.util.UUID
import javax.inject.Inject

class RandomUseCaseImpl @Inject constructor() : RandomUseCase {

    override operator fun invoke(): String = UUID.randomUUID().toString()
}