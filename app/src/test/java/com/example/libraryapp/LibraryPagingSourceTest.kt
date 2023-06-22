import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import com.example.domain.model.BookDomainModel
import com.example.domain.model.BooksListDomainModel
import com.example.domain.model.PersonDomainModel
import com.example.domain.repository.BooksRepository
import com.example.domain.useCase.BooksListUseCase
import com.example.libraryapp.list.LibraryPagingSource
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LibraryPagingSourceTest {

    @Mock
    private lateinit var mockBooksRepository: BooksRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `load returns Page data`() = runBlocking {
        val fakeCurrentPageNumber = "3"
        val fakeAuthor =
            PersonDomainModel(name = "Fake Author", lifeDuration = "Fake Life Duration")
        val fakeBooks = listOf(
            BookDomainModel(
                id = 1,
                title = "Book 1",
                author = fakeAuthor,
                subject = "Fake subject 1"
            ),
            BookDomainModel(
                id = 2,
                title = "Book 2",
                author = fakeAuthor,
                subject = "Fake subject 2"
            ),
            BookDomainModel(
                id = 3,
                title = "Book 3",
                author = fakeAuthor,
                subject = "Fake subject 3"
            )
        )
        val fakeNextPageNumber = "4"
        val fakeBooksListDomainModel = BooksListDomainModel(
            booksList = fakeBooks,
            nextPage = fakeNextPageNumber
        )
        val fakeFlow = flowOf(fakeBooksListDomainModel)

        val mockBooksListUseCase: BooksListUseCase = mockk()
        Mockito.`when`(mockBooksRepository.getBooksList(fakeCurrentPageNumber)).thenReturn(fakeFlow)

        val pagingSource = LibraryPagingSource(mockBooksListUseCase)
        val result = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                null,
                loadSize = 32,
                placeholdersEnabled = false
            )
        )

        // Assert
        val expectedPage = Page(data = fakeBooks, prevKey = null, nextKey = null)
        assertEquals(expectedPage, result)
    }
}