import com.zogik.core.utils.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline onFetchFailed: (Throwable) -> Unit = { },
    crossinline shouldFetch: (ResultType) -> Boolean = { true },
): Flow<Resource<ResultType>> = flow {
    emit(Resource.loading())
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        val flowContext = currentCoroutineContext()
        val loading: Job = coroutineScope {
            launch(flowContext) {
                query().map { Resource.loading(it) }
                    .collect { withContext(flowContext) { emit(it) } }
            }
        }

        try {
            val request = fetch()
            loading.cancel()
            saveFetchResult(request)
            query().map { Resource.success(it) }
        } catch (throwable: Throwable) {
            loading.cancel()
            onFetchFailed(throwable)
            query().map { Resource.error(throwable.message.orEmpty(), it) }
        }
    } else {
        query().map { Resource.success(it) }
    }

    emitAll(flow)
}
