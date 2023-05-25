import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalData

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RepoFavorite
