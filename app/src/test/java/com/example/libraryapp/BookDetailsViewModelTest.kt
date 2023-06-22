package com.example.libraryapp

import com.example.domain.model.BookDomainModel
import com.example.domain.model.PersonDomainModel
import com.example.domain.repository.BooksRepository
import com.example.domain.useCase.BookDetailsUseCase
import com.example.libraryapp.details.BookDetailsViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class BookDetailsViewModelTest {

    @Mock
    private lateinit var mockBooksRepository: BooksRepository
    private lateinit var viewModel: BookDetailsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = TestCoroutineDispatcher()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = BookDetailsViewModel(BookDetailsUseCase(mockBooksRepository))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getBookDetails should update bookDetails with result`() = testDispatcher.runBlockingTest {
        val fakeBookId = 3
        val fakeBookDetails = BookDomainModel(
            id = 3,
            title = "Fake Book Title",
            author = PersonDomainModel(
                name = "Fake Author",
                lifeDuration = "Fake life duration"
            ),
            subject = "Fake subject"
        )
        val fakeFlow: Flow<BookDomainModel> = flowOf(fakeBookDetails)

        `when`(mockBooksRepository.getBookDetails(fakeBookId)).thenReturn(fakeFlow)

        viewModel.getBookDetails(fakeBookId)
        advanceUntilIdle()

        val result = viewModel.bookDetails.value
        assertEquals(fakeBookDetails, result)
    }
}
