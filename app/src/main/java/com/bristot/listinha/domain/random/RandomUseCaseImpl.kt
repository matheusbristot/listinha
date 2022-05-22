package com.bristot.listinha.domain.random

import java.util.UUID
import javax.inject.Inject

internal class RandomUseCaseImpl @Inject constructor() : RandomUseCase {

    override operator fun invoke(): String = UUID.randomUUID().toString()
}