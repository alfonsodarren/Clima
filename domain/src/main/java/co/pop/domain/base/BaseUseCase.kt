package co.pop.domain.base

import co.pop.domain.model.Result

interface BaseUseCase<T : Any, R: Any> {
    suspend operator fun invoke(param: T): Result<R>
}